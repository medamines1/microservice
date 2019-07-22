package com.proxym.core.dao.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QFeatureRole is a Querydsl query type for FeatureRole
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QFeatureRole extends EntityPathBase<FeatureRole> {

    private static final long serialVersionUID = 1246511050L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QFeatureRole featureRole = new QFeatureRole("featureRole");

    public final QFeature feature;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final QRole role;

    public QFeatureRole(String variable) {
        this(FeatureRole.class, forVariable(variable), INITS);
    }

    public QFeatureRole(Path<? extends FeatureRole> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QFeatureRole(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QFeatureRole(PathMetadata metadata, PathInits inits) {
        this(FeatureRole.class, metadata, inits);
    }

    public QFeatureRole(Class<? extends FeatureRole> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.feature = inits.isInitialized("feature") ? new QFeature(forProperty("feature"), inits.get("feature")) : null;
        this.role = inits.isInitialized("role") ? new QRole(forProperty("role")) : null;
    }

}

