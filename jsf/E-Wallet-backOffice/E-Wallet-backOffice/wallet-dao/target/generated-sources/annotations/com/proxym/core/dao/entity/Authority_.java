package com.proxym.core.dao.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Authority.class)
public abstract class Authority_ {

	public static volatile SingularAttribute<Authority, Role> role;
	public static volatile SingularAttribute<Authority, Long> id;
	public static volatile SingularAttribute<Authority, User> user;

}

