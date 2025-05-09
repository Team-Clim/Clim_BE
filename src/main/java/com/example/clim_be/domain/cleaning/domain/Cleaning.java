package com.example.clim_be.domain.cleaning.domain;

import com.example.clim_be.domain.cleaning.domain.enums.CleaningStatus;
import com.example.clim_be.domain.user.domain.User;
import com.example.clim_be.global.base.BaseIdEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Getter
@NoArgsConstructor
public class Cleaning extends BaseIdEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private CleaningStatus status;

    @Column(nullable = false, length = 50)
    private String reason;

    @Column(nullable = false)
    private LocalDate date;
}
