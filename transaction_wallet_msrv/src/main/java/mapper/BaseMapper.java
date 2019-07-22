package mapper;




import models.Transaction;
import models.TransactionDto;

import models.Wallet;
import models.WalletDto;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;


public class BaseMapper {

    public static WalletDto WalletToDto(Wallet wallet){
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(wallet, WalletDto.class);
    }

    public static List<WalletDto> WalletToDto(List<Wallet> wallets){
        ModelMapper modelMapper = new ModelMapper();
        List<WalletDto> tmp = new ArrayList<>();
        for (Wallet e : wallets)
            tmp.add(modelMapper.map(e, WalletDto.class));
        return tmp;
    }

    public static Wallet DtoToWallet(WalletDto walletDto){
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(walletDto, Wallet.class);
    }



    public static TransactionDto DevicetToDto(Transaction transaction){
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(transaction, TransactionDto.class);
    }


    public static List<TransactionDto> DevicetToDto(List<Transaction> transactions){
        ModelMapper modelMapper = new ModelMapper();
        List<TransactionDto> tmp = new ArrayList<>();
        for (Transaction e : transactions)
            tmp.add(modelMapper.map(e, TransactionDto.class));
        return tmp;
    }



    public static Transaction DtoToWallet(TransactionDto deviceDto){
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(deviceDto, Transaction.class);
    }
}