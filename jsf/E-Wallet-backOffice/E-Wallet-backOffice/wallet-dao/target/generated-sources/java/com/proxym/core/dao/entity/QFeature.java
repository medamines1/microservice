package com.proxym.core.dao.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QFeature is a Querydsl query type for Feature
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QFeature extends EntityPathBase<Feature> {

    private static final long serialVersionUID = 1649607988L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QFeature feature = new QFeature("feature");

    public final ListPath<Action, QAction> actions = this.<Action, QAction>createList("actions", Action.class, QAction.class, PathInits.DIRECT2);

    public final ListPath<Feature, QFeature> childrenFeatures = this.<Feature, QFeature>createList("childrenFeatures", Feature.class, QFeature.class, PathInits.DIRECT2);

    public final StringPath code = createString("code");

    public final ListPath<FeatureRole, QFeatureRole> featureRole = this.<FeatureRole, QFeatureRole>createList("featureRole", FeatureRole.class, QFeatureRole.class, PathInits.DIRECT2);

    public final StringPath icon = createString("icon");

    public final StringPath name = createString("name");

    public final QFeature parentFeature;

    public final StringPath path = createString("path");

    public QFeature(String variable) {
        this(Feature.class, forVariable(variable), INITS);
    }

    public QFeature(Path<? extends Feature> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QFeature(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QFeature(PathMetadata metadata, PathInits inits) {
        this(Feature.class, metadata, inits);
    }

    public QFeature(Class<? extends Feature> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.parentFeature = inits.isInitialized("parentFeature") ? new QFeature(forProperty("parentFeature"), inits.get("parentFeature")) : null;
    }

}

