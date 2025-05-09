package com.example.clim_be.domain.cleaning.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QCleaning is a Querydsl query type for Cleaning
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QCleaning extends EntityPathBase<Cleaning> {

    private static final long serialVersionUID = 943382414L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QCleaning cleaning = new QCleaning("cleaning");

    public final com.example.clim_be.global.base.QBaseIdEntity _super = new com.example.clim_be.global.base.QBaseIdEntity(this);

    public final DatePath<java.time.LocalDate> date = createDate("date", java.time.LocalDate.class);

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final StringPath reason = createString("reason");

    public final EnumPath<com.example.clim_be.domain.cleaning.domain.enums.CleaningStatus> status = createEnum("status", com.example.clim_be.domain.cleaning.domain.enums.CleaningStatus.class);

    public final com.example.clim_be.domain.user.domain.QUser user;

    public QCleaning(String variable) {
        this(Cleaning.class, forVariable(variable), INITS);
    }

    public QCleaning(Path<? extends Cleaning> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QCleaning(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QCleaning(PathMetadata metadata, PathInits inits) {
        this(Cleaning.class, metadata, inits);
    }

    public QCleaning(Class<? extends Cleaning> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.user = inits.isInitialized("user") ? new com.example.clim_be.domain.user.domain.QUser(forProperty("user"), inits.get("user")) : null;
    }

}

