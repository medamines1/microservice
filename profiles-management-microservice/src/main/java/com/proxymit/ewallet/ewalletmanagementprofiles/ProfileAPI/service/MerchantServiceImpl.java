package com.proxymit.ewallet.ewalletmanagementprofiles.ProfileAPI.service;

import com.proxymit.ewallet.ewalletmanagementprofiles.ProfileAPI.dao.MerchantRepository;
import com.proxymit.ewallet.ewalletmanagementprofiles.ProfileAPI.entities.Merchant;
import com.proxymit.ewallet.ewalletmanagementprofiles.ProfileAPI.entities.MerchantForm;
import com.proxymit.ewallet.ewalletmanagementprofiles.ProfileAPI.entities.MerchantRessource;
import com.proxymit.ewallet.ewalletmanagementprofiles.ProfileAPI.entities.ProfilStatus;
import com.proxymit.ewallet.ewalletmanagementprofiles.ProfileAPI.mapper.MerchantMapper;
import com.proxymit.ewallet.ewalletmanagementprofiles.ReqNResp.ResponseModel;
import com.proxymit.ewallet.ewalletmanagementprofiles.ReqNResp.response_status;
import com.proxymit.ewallet.ewalletmanagementprofiles.feigns.WalletFeign;
import com.proxymit.ewallet.ewalletmanagementprofiles.keycloak.KeycloakRegistrationService;
import com.proxymit.ewallet.ewalletmanagementprofiles.keycloak.KeycloakUserCreated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class MerchantServiceImpl implements MerchantService {

    @Autowired
    private MerchantRepository merchantRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private  KeycloakRegistrationService keycloakRegistrationService;


    @Autowired
    WalletFeign walletFeign;

    @Override
    public List<MerchantRessource> getAllMerchant() {

        List<MerchantRessource> merchantRessources = new ArrayList<>();
        List<Merchant> merchants = merchantRepository.findAll();
        for (Merchant merchant : merchants) {
            merchantRessources.add(MerchantMapper.merchantoRessource(merchant));
        }
        return merchantRessources;
    }

    @Override
    public MerchantRessource getMerchant(String id) {
        Optional<Merchant> merchant = merchantRepository.findById(id);
        if (!merchant.isPresent())
            throw new RuntimeException("merchant not found");
        return MerchantMapper.merchantoRessource(merchant.get());
    }

    @Override
    public MerchantRessource getMerchantByPhoneNumber(String phoneNumber) {
        Merchant merchant = merchantRepository.findByPhoneNumber(phoneNumber);
        if (merchant == null)
            throw new RuntimeException("merchant doesn't exist");
        return MerchantMapper.merchantoRessource(merchant);
    }

    @Override
    public MerchantRessource createMerchant(MerchantForm merchantForm) throws Exception {
        Merchant merchantTest = merchantRepository.findByPhoneNumber(merchantForm.getPhoneNumber());
        if (merchantTest != null)
            throw new RuntimeException("merchant already exist");
        Merchant merchant = MerchantMapper.merchantFormToMerchant(merchantForm);
        merchant.setPassword(bCryptPasswordEncoder.encode(merchantForm.getPassword()));
        merchant.setCreatedOn(LocalDateTime.now());

        KeycloakUserCreated keyUserCreated = keycloakRegistrationService.addMerchant(merchantForm);
        merchant.setId(keyUserCreated.getId());
        merchantRepository.save(merchant);
        System.out.println(merchant);


        ResponseModel rs = walletFeign.createWallet(merchant.getId());
        if (rs.getStatus().equals(response_status.fail))
            throw  new Exception("fail to create wallet due to " + rs.getErr());



        return MerchantMapper.merchantoRessource(merchant);
    }

    @Override
    public MerchantRessource updateMerchant(String id, MerchantForm merchantForm) {
        Optional<Merchant> existingMerchant = merchantRepository.findById(id);
        if (!existingMerchant.isPresent())
            throw new RuntimeException("Merchant doesn't exist");
        if (!(merchantForm.getPhoneNumber().equals("")) && ! (merchantForm.getPhoneNumber() == null))
            existingMerchant.get().setPhoneNumber(merchantForm.getPhoneNumber());
        if (!(merchantForm.getName().equals("")) && ! (merchantForm.getName() == null))
            existingMerchant.get().setName(merchantForm.getName());
        if (!(merchantForm.getEmail().equals("")) && ! (merchantForm.getEmail() == null))
            existingMerchant.get().setEmail(merchantForm.getEmail());
        if (!(merchantForm.getPassword().equals("")) && ! (merchantForm.getPassword() == null))
            existingMerchant.get().setPassword(bCryptPasswordEncoder.encode(merchantForm.getPassword()));
        if (!(merchantForm.getImage().equals("")) && ! (merchantForm.getImage() == null))
            existingMerchant.get().setImage(merchantForm.getImage());
        if (!(merchantForm.getTradeRegister().equals("")) && ! (merchantForm.getTradeRegister() == null))
            existingMerchant.get().setTradeRegister(merchantForm.getTradeRegister());
        if (!(merchantForm.getRib().equals("")) && ! (merchantForm.getRib() == null))
            existingMerchant.get().setRib(merchantForm.getRib());

        keycloakRegistrationService.updateMerchant(merchantForm,id);
        merchantRepository.saveAndFlush(existingMerchant.get());
        return MerchantMapper.merchantoRessource(existingMerchant.get());
    }

    @Override
    public MerchantRessource deleteMerchant(String id) throws Exception {
        Optional<Merchant> existingMerchant = merchantRepository.findById(id);
        if (!existingMerchant.isPresent())
            throw new RuntimeException("Merchant doesn't exist");
        keycloakRegistrationService.deleteMerchant(id);
        merchantRepository.delete(existingMerchant.get());

        ResponseModel rs = walletFeign.deleteWallet(id);
        if (rs.getStatus().equals(response_status.fail))
            throw  new Exception("fail to delete wallet due to " + rs.getErr());

        return MerchantMapper.merchantoRessource(existingMerchant.get());
    }

    @Override
    public MerchantRessource switchStatusOfMerchant(String id, String profilStatus) {
        Optional<Merchant> existingMerchant = merchantRepository.findById(id);
        if (!existingMerchant.isPresent())
            throw new RuntimeException("Merchant doesn't exist");
        String status = profilStatus.toUpperCase();
        if (ProfilStatus.valueOf(status) == null)
            throw new RuntimeException("status doesn't exist");
        existingMerchant.get().setStatus(ProfilStatus.valueOf(status));
        merchantRepository.saveAndFlush(existingMerchant.get());
        return MerchantMapper.merchantoRessource(existingMerchant.get());
    }

    @Override
    public MerchantRessource affectSuperviseeToSupervisor(String idSupervisee, String idSupervisor) {
        Optional<Merchant> supervisee = merchantRepository.findById(idSupervisee);
        Optional<Merchant> supervisor = merchantRepository.findById(idSupervisor);
        if (!supervisee.isPresent() || !supervisor.isPresent())
            throw new RuntimeException("Merchant doesn't exist");
        if (supervisee.get().getSupervisor() != null)
            throw new RuntimeException("you can't this supervisee has already an supervisor");

        supervisor.get().getSupervisees().add(supervisee.get());
        supervisee.get().setSupervisor(supervisor.get());
        merchantRepository.saveAndFlush(supervisee.get());
        merchantRepository.saveAndFlush(supervisor.get());
        return MerchantMapper.merchantoRessource(supervisee.get());
    }

    @Override
    public MerchantRessource removeSuperviseeFromSupervisor(String idSupervisee, String idSupervisor) {
        Optional<Merchant> supervisee = merchantRepository.findById(idSupervisee);
        Optional<Merchant> supervisor = merchantRepository.findById(idSupervisor);
        if (!supervisee.isPresent() || !supervisor.isPresent())
            throw new RuntimeException("Merchant doesn't exist");
        if (supervisee.get().getSupervisor() == null)
            throw new RuntimeException("you can't this supervisee hasn't an supervisor");
        supervisee.get().setSupervisor(null);
        supervisor.get().removeSupervisees(supervisee.get());
        merchantRepository.saveAndFlush(supervisee.get());
        merchantRepository.saveAndFlush(supervisor.get());
        return MerchantMapper.merchantoRessource(supervisee.get());
    }

    @Override
    public List<MerchantRessource> getAllSuperviseesOfMerchant(String idSupervisor) {

        Optional<Merchant> supervisor = merchantRepository.findById(idSupervisor);
        if (!supervisor.isPresent())
            throw new RuntimeException("Merchant doesn't exist");
        List<MerchantRessource> superviseesRessources = new ArrayList<>();
        List<Merchant> supervisees = supervisor.get().getSupervisees();
        for (Merchant supervisee : supervisees) {
            superviseesRessources.add(MerchantMapper.merchantoRessource(supervisee));
        }
        return superviseesRessources;
    }

    @Override
    public MerchantRessource getSupervisorOfMerchant(String idSupervisee) {

        Optional<Merchant> supervisee = merchantRepository.findById(idSupervisee);
        if (!supervisee.isPresent())
            throw new RuntimeException("Merchant doesn't exist");
        return MerchantMapper.merchantoRessource(supervisee.get().getSupervisor());
    }


}
