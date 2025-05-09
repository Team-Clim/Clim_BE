package com.example.clim_be.domain.user.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QUser_ClassInfo is a Querydsl query type for ClassInfo
 */
@Generated("com.querydsl.codegen.DefaultEmbeddableSerializer")
public class QUser_ClassInfo extends BeanPath<User.ClassInfo> {

    private static final long serialVersionUID = 1901428714L;

    public static final QUser_ClassInfo classInfo = new QUser_ClassInfo("classInfo");

    public final NumberPath<Integer> classNumber = createNumber("classNumber", Integer.class);

    public final NumberPath<Integer> grade = createNumber("grade", Integer.class);

    public final NumberPath<Integer> number = createNumber("number", Integer.class);

    public final StringPath schoolNumber = createString("schoolNumber");

    public QUser_ClassInfo(String variable) {
        super(User.ClassInfo.class, forVariable(variable));
    }

    public QUser_ClassInfo(Path<? extends User.ClassInfo> path) {
        super(path.getType(), path.getMetadata());
    }

    public QUser_ClassInfo(PathMetadata metadata) {
        super(User.ClassInfo.class, metadata);
    }

}

