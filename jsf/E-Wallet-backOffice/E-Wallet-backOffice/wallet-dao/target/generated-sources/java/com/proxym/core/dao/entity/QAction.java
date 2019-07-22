package com.proxym.core.dao.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QAction is a Querydsl query type for Action
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QAction extends EntityPathBase<Action> {

    private static final long serialVersionUID = -783961032L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QAction action = new QAction("action");

    public final StringPath actionName = createString("actionName");

    public final StringPath controllerName = createString("controllerName");

    public final QFeature feature;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public QAction(String variable) {
        this(Action.class, forVariable(variable), INITS);
    }

    public QAction(Path<? extends Action> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QAction(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QAction(PathMetadata metadata, PathInits inits) {
        this(Action.class, metadata, inits);
    }

    public QAction(Class<? extends Action> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.feature = inits.isInitialized("feature") ? new QFeature(forProperty("feature"), inits.get("feature")) : null;
    }

}

