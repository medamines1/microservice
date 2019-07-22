package com.proxym.core.dao.entity;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(User.class)
public abstract class User_ {

	public static volatile SingularAttribute<User, String> password;
	public static volatile SingularAttribute<User, String> firstname;
	public static volatile ListAttribute<User, Authority> autorities;
	public static volatile SingularAttribute<User, Date> lastConnected;
	public static volatile SingularAttribute<User, String> userName;
	public static volatile SingularAttribute<User, Date> createdOn;
	public static volatile SingularAttribute<User, Boolean> enabled;
	public static volatile SingularAttribute<User, String> email;
	public static volatile SingularAttribute<User, String> lastname;

}

