package com.example.clim_be.domain.user.presentation;

import com.example.clim_be.domain.user.application.UserInfoService;
import com.example.clim_be.domain.user.presentation.dto.request.InfoRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserInfoService userInfoService;

    @PatchMapping
    @ResponseStatus(HttpStatus.OK)
    public void inputInfo(@RequestBody @Valid InfoRequest request) {
        userInfoService.info(request);
    }
}
