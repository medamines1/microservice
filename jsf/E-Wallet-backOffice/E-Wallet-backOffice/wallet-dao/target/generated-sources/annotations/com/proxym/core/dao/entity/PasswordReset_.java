package com.proxym.core.dao.entity;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(PasswordReset.class)
public abstract class PasswordReset_ {

	public static volatile SingularAttribute<PasswordReset, Date> expiryDate;
	public static volatile SingularAttribute<PasswordReset, Long> id;
	public static volatile SingularAttribute<PasswordReset, User> user;
	public static volatile SingularAttribute<PasswordReset, String> token;

}

