package com.example.clim_be.domain.cleaning.domain.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CleaningRepositoryCustomImpl {
    private final JPAQueryFactory jpaQueryFactory;
}
