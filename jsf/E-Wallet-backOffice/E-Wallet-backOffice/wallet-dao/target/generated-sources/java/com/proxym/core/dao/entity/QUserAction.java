package com.proxym.core.dao.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QUserAction is a Querydsl query type for UserAction
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QUserAction extends EntityPathBase<UserAction> {

    private static final long serialVersionUID = 1667725027L;

    public static final QUserAction userAction = new QUserAction("userAction");

    public final EnumPath<com.proxym.bo.enumerations.FeaturesEnum> action = createEnum("action", com.proxym.bo.enumerations.FeaturesEnum.class);

    public final StringPath actionData = createString("actionData");

    public final DateTimePath<java.util.Date> actionDate = createDateTime("actionDate", java.util.Date.class);

    public final StringPath exceptionData = createString("exceptionData");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final BooleanPath isSuccess = createBoolean("isSuccess");

    public final StringPath username = createString("username");

    public QUserAction(String variable) {
        super(UserAction.class, forVariable(variable));
    }

    public QUserAction(Path<? extends UserAction> path) {
        super(path.getType(), path.getMetadata());
    }

    public QUserAction(PathMetadata metadata) {
        super(UserAction.class, metadata);
    }

}

