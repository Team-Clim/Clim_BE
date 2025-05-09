package com.example.clim_be.domain.user.domain;

import com.example.clim_be.domain.auth.presentation.dto.AuthElementDto;
import com.example.clim_be.domain.user.domain.enums.RoomAlphabet;
import com.example.clim_be.global.base.BaseIdEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User extends BaseIdEntity {

    @Column(nullable = false, length = 50)
    private String userName;

    @Column(nullable = false)
    private String accountId;

    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private AuthElementDto.Role role;

    private Integer roomNumber;

    @Enumerated(EnumType.STRING)
    private RoomAlphabet alphabet;

    @Embedded
    private ClassInfo classInfo;

    public User(String accountId, String password, String userName, AuthElementDto.Role role, Integer grade, Integer classNum, Integer num) {
        this.accountId = accountId;
        this.password = password;
        this.userName = userName;
        this.role = AuthElementDto.Role.BASIC;
        this.classInfo = new ClassInfo(grade, classNum, num, String.format("%1d%1d%02d", grade, classNum, num));
    }

    @Getter
    @AllArgsConstructor
    @Embeddable 
    public static class ClassInfo {
        private Integer grade;
        private Integer classNumber;
        private Integer number;
        private String schoolNumber;
        
        protected ClassInfo() {
        }
    }

    public void updateInfo(Integer roomNumber, RoomAlphabet alphabet) {
        this.roomNumber = roomNumber;
        this.alphabet = alphabet;
    }

}
