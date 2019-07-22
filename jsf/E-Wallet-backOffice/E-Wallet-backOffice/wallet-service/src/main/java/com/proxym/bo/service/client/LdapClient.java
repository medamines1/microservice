/**
 * created by med-amine.ben-ahmed on Feb 9, 2017
 */
package com.proxym.bo.service.client;

import java.util.List;

import com.proxym.bo.model.LdapUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.ldap.core.DirContextOperations;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.ldap.core.support.AbstractContextMapper;
import org.springframework.ldap.query.LdapQuery;
import org.springframework.ldap.query.LdapQueryBuilder;


/**
 * @author med-amine.ben-ahmed
 *
 */
//@Component
public class LdapClient {

    private static final Logger LOGGER = LoggerFactory.getLogger(LdapClient.class);

    private static final String LDAP_KEY_CLASS = "objectclass";
    private static final String LDAP_KEY_PERSON = "person";
    private static final String LDAP_KEY_USERNAME = "sAMAccountName";

    private LdapTemplate ldapTemplate;

    @Autowired
    public LdapClient(LdapTemplate ldapTemplate) {
        this.ldapTemplate = ldapTemplate;
    }

    public LdapUser getUserByUserName(String username){
    	LdapUser ldapUser = null;
        try{
            LOGGER.info("Getting LDAP entry for user {}", username);
            LdapQuery query = LdapQueryBuilder.query()
                .where(LDAP_KEY_USERNAME).is(username);
            ldapUser= (LdapUser)ldapTemplate.searchForObject(query, new PersonContextMapper());
        }catch (EmptyResultDataAccessException e){
           // throw new DataNotFoundInLdapException(LDAP_KEY_USERNAME, username);
        	LOGGER.error("User doesn't exist in LDAP");
        	e.printStackTrace();
        }
        return ldapUser;
    }
    
    public List<LdapUser> getAllUsers(){
    	List<LdapUser> users = null;
    	try {
    	        LdapQuery query = LdapQueryBuilder.query()
    	        .where(LDAP_KEY_CLASS)
    	        .is(LDAP_KEY_PERSON);  
    	        users = ldapTemplate.search(query, new PersonContextMapper());
		} catch (Exception e) {
			e.printStackTrace();
		}
    	return users;
    }
    
    
    
    
    private static class PersonContextMapper extends AbstractContextMapper {
        public Object doMapFromContext(DirContextOperations context) {
            LdapUser ldapUser = new LdapUser(context.getStringAttribute(LDAP_KEY_USERNAME), null, null);
            return ldapUser;
        }
    }
}
