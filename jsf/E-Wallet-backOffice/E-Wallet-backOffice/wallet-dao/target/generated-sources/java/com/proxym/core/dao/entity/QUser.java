package com.proxym.core.dao.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QUser is a Querydsl query type for User
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QUser extends EntityPathBase<User> {

    private static final long serialVersionUID = -1694057907L;

    public static final QUser user = new QUser("user");

    public final ListPath<Authority, QAuthority> autorities = this.<Authority, QAuthority>createList("autorities", Authority.class, QAuthority.class, PathInits.DIRECT2);

    public final DateTimePath<java.util.Date> createdOn = createDateTime("createdOn", java.util.Date.class);

    public final StringPath email = createString("email");

    public final BooleanPath enabled = createBoolean("enabled");

    public final StringPath firstname = createString("firstname");

    public final DateTimePath<java.util.Date> lastConnected = createDateTime("lastConnected", java.util.Date.class);

    public final StringPath lastname = createString("lastname");

    public final StringPath password = createString("password");

    public final StringPath userName = createString("userName");

    public QUser(String variable) {
        super(User.class, forVariable(variable));
    }

    public QUser(Path<? extends User> path) {
        super(path.getType(), path.getMetadata());
    }

    public QUser(PathMetadata metadata) {
        super(User.class, metadata);
    }

}

