package com.example.clim_be.domain.user.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QUser is a Querydsl query type for User
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QUser extends EntityPathBase<User> {

    private static final long serialVersionUID = 1526774962L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QUser user = new QUser("user");

    public final com.example.clim_be.global.base.QBaseIdEntity _super = new com.example.clim_be.global.base.QBaseIdEntity(this);

    public final StringPath accountId = createString("accountId");

    public final EnumPath<com.example.clim_be.domain.user.domain.enums.RoomAlphabet> alphabet = createEnum("alphabet", com.example.clim_be.domain.user.domain.enums.RoomAlphabet.class);

    public final QUser_ClassInfo classInfo;

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final StringPath password = createString("password");

    public final EnumPath<com.example.clim_be.domain.auth.presentation.dto.AuthElementDto.Role> role = createEnum("role", com.example.clim_be.domain.auth.presentation.dto.AuthElementDto.Role.class);

    public final NumberPath<Integer> roomNumber = createNumber("roomNumber", Integer.class);

    public final StringPath userName = createString("userName");

    public QUser(String variable) {
        this(User.class, forVariable(variable), INITS);
    }

    public QUser(Path<? extends User> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QUser(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QUser(PathMetadata metadata, PathInits inits) {
        this(User.class, metadata, inits);
    }

    public QUser(Class<? extends User> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.classInfo = inits.isInitialized("classInfo") ? new QUser_ClassInfo(forProperty("classInfo")) : null;
    }

}

