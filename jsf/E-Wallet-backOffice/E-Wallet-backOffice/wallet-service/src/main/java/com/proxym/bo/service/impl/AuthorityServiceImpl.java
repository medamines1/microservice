package com.proxym.bo.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proxym.bo.mapper.AuthorityMapper;
import com.proxym.bo.model.AuthorityModel;
import com.proxym.bo.service.AuthorityService;
import com.proxym.core.dao.AuthorityDao;
import com.proxym.core.dao.RoleDao;
import com.proxym.core.dao.UserDao;

import javax.transaction.Transactional;

/**
 * @author med-amine.ben-ahmed
 */
@Service
public class AuthorityServiceImpl implements AuthorityService {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthorityServiceImpl.class);
    private final AuthorityDao authorityDao;
    private final UserDao userDao;
    private final RoleDao roleDao;

    @Autowired
    public AuthorityServiceImpl(AuthorityDao authorityDao, UserDao userDao,
                                RoleDao roleDao) {
        this.authorityDao = authorityDao;
        this.userDao = userDao;
        this.roleDao = roleDao;
    }

    public void save(List<AuthorityModel> authoritiesModel) {
        LOGGER.info("[AuthorityServiceImpl] save");
        authorityDao.save(AuthorityMapper.listAuthorityModelToListAuthorityEntity(authoritiesModel));
    }

    @Override
    public List<AuthorityModel> getAuthorities() {
        LOGGER.info("[AuthorityServiceImpl] getAuthorities");
        return AuthorityMapper.listAuthorityEntityToListAuthorityModel(authorityDao.getAuthorities());
    }

    @Override
    public void updateAuthority(String userName, String roleName) {
        LOGGER.info(
                "[AuthorityServiceImpl] updateAuthority userName {}, new role {}",
                userName, roleName);
        User userEntity = userDao.findOneByUserName(userName);
        Role roleEntity = roleDao.findOneByName(roleName);
        authorityDao.updateAuthority(userEntity, roleEntity);
    }

    @Override
    public void deleteAuthority(String userName) {
        LOGGER.info("[AuthorityServiceImpl] deleteAuthority userName {}", userName);
        User userEntity = userDao.findOneByUserName(userName);

        authorityDao.deleteAuthorityByUser(userEntity);
//		userDao.delete(userEntity);
    }

    @Override
    public List<AuthorityModel> getAuthorityByRoleName(String roleName) {
        Role roleEntity = roleDao.findOneByName(roleName);
        return AuthorityMapper.listAuthorityEntityToListAuthorityModel(authorityDao.getAuthorityByRole(roleEntity));
    }

    @Override
    public AuthorityModel getAuthorityByUserName(String userName) {
        User userEntity = userDao.findOneByUserName(userName);
        return AuthorityMapper.authorityEntityToAuthorityModel(authorityDao.getAuthorityByUser(userEntity));
    }

    @Override
    @Transactional
    public void update(String userName, List<Authority> authorities) {
        deleteAuthority(userName);
        authorityDao.update(authorities);
    }
}
