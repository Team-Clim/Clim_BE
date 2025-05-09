package com.example.clim_be.domain.admin.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QAdmin is a Querydsl query type for Admin
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QAdmin extends EntityPathBase<Admin> {

    private static final long serialVersionUID = 660727108L;

    public static final QAdmin admin = new QAdmin("admin");

    public final com.example.clim_be.global.base.QBaseIdEntity _super = new com.example.clim_be.global.base.QBaseIdEntity(this);

    public final StringPath accountId = createString("accountId");

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final StringPath password = createString("password");

    public final EnumPath<com.example.clim_be.domain.auth.presentation.dto.AuthElementDto.Role> role = createEnum("role", com.example.clim_be.domain.auth.presentation.dto.AuthElementDto.Role.class);

    public final StringPath userName = createString("userName");

    public QAdmin(String variable) {
        super(Admin.class, forVariable(variable));
    }

    public QAdmin(Path<? extends Admin> path) {
        super(path.getType(), path.getMetadata());
    }

    public QAdmin(PathMetadata metadata) {
        super(Admin.class, metadata);
    }

}

