package com.example.clim_be.domain.cleaning.domain.repository;

import com.example.clim_be.domain.cleaning.domain.QCleaning;
import com.example.clim_be.domain.cleaning.presentation.dto.response.CleaningResponse;
import com.example.clim_be.domain.user.domain.QUser;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.util.Optional;

import static com.example.clim_be.domain.cleaning.domain.QCleaning.cleaning;
import static com.example.clim_be.domain.user.domain.QUser.user;

@RequiredArgsConstructor
public class CleaningRepositoryCustomImpl implements CleaningRepositoryCustom{
    private final JPAQueryFactory jpaQueryFactory;
    private final QCleaning qCleaning = cleaning;
    private final QUser qUser = user;

    @Override
    public Optional<CleaningResponse> findCleaningStatusByDate(String userName, LocalDate date) {
        CleaningResponse response = jpaQueryFactory
                .select(Projections.constructor(
                        CleaningResponse.class,
                        user.userName,
                        user.roomNumber,
                        cleaning.date,
                        cleaning.status,
                        cleaning.reason
                ))
                .from(cleaning)
                .join(cleaning.user, user)
                .where(
                        cleaning.date.eq(date),
                        user.userName.eq(userName)
                )
                .fetchOne();

        return Optional.ofNullable(response);
    }




}
