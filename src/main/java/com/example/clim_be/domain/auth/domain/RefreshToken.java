package com.example.clim_be.domain.auth.domain;

import com.example.clim_be.domain.auth.presentation.dto.AuthElementDto;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.TimeToLive;
import org.springframework.data.redis.core.index.Indexed;

@RedisHash
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RefreshToken {

    @Id
    private String id;
    private AuthElementDto.Role role;

    @Indexed
    private String accountId;

    @Indexed
    private String token;

    @TimeToLive
    private Long timeToLive;
}
