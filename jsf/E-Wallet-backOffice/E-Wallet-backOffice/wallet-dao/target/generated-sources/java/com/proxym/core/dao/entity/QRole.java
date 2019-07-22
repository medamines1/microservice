package com.proxym.core.dao.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QRole is a Querydsl query type for Role
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QRole extends EntityPathBase<Role> {

    private static final long serialVersionUID = -1694150920L;

    public static final QRole role = new QRole("role");

    public final ListPath<Authority, QAuthority> autorities = this.<Authority, QAuthority>createList("autorities", Authority.class, QAuthority.class, PathInits.DIRECT2);

    public final StringPath designation = createString("designation");

    public final ListPath<FeatureRole, QFeatureRole> featureRole = this.<FeatureRole, QFeatureRole>createList("featureRole", FeatureRole.class, QFeatureRole.class, PathInits.DIRECT2);

    public final StringPath name = createString("name");

    public QRole(String variable) {
        super(Role.class, forVariable(variable));
    }

    public QRole(Path<? extends Role> path) {
        super(path.getType(), path.getMetadata());
    }

    public QRole(PathMetadata metadata) {
        super(Role.class, metadata);
    }

}

