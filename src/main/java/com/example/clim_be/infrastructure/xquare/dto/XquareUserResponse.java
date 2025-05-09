package com.example.clim_be.infrastructure.xquare.dto;

import com.example.clim_be.domain.auth.presentation.dto.AuthElementDto;
import com.example.clim_be.domain.user.domain.enums.RoomAlphabet;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class XquareUserResponse {
    private UUID id;
    private String accountId;
    private String password;
    private String name;
    private Integer grade;
    private Integer classNum;
    private Integer num;
    private AuthElementDto.Role role;
    private LocalDate birth_day;
    private String profileImgUrl;
    private RoomAlphabet roomAlphabet;
    private Integer roomNumber;
}
