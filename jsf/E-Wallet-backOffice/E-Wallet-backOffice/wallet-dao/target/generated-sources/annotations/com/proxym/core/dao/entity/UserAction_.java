package com.proxym.core.dao.entity;

import com.proxym.bo.enumerations.FeaturesEnum;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(UserAction.class)
public abstract class UserAction_ {

	public static volatile SingularAttribute<UserAction, String> exceptionData;
	public static volatile SingularAttribute<UserAction, FeaturesEnum> action;
	public static volatile SingularAttribute<UserAction, String> actionData;
	public static volatile SingularAttribute<UserAction, Long> id;
	public static volatile SingularAttribute<UserAction, Date> actionDate;
	public static volatile SingularAttribute<UserAction, String> username;
	public static volatile SingularAttribute<UserAction, Boolean> isSuccess;

}

