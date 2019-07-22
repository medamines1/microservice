package com.proxym.core.dao.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Feature.class)
public abstract class Feature_ {

	public static volatile SingularAttribute<Feature, String> path;
	public static volatile SingularAttribute<Feature, Feature> parentFeature;
	public static volatile SingularAttribute<Feature, String> code;
	public static volatile ListAttribute<Feature, Feature> childrenFeatures;
	public static volatile SingularAttribute<Feature, String> name;
	public static volatile SingularAttribute<Feature, String> icon;
	public static volatile ListAttribute<Feature, FeatureRole> featureRole;
	public static volatile ListAttribute<Feature, Action> actions;

}

