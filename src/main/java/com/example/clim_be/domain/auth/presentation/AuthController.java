package com.example.clim_be.domain.auth.presentation;

import com.example.clim_be.domain.admin.presentation.dto.request.SignupRequest;
import com.example.clim_be.domain.auth.application.AdminLoginService;
import com.example.clim_be.domain.auth.application.AdminSignupService;
import com.example.clim_be.domain.auth.application.ReissueService;
import com.example.clim_be.domain.auth.application.UserLoginService;
import com.example.clim_be.domain.auth.presentation.dto.request.LoginRequest;
import com.example.clim_be.domain.auth.presentation.dto.response.TokenResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {
    private final UserLoginService userLoginService;
    private final AdminLoginService adminLoginService;
    private final AdminSignupService adminSignupService;
    private final ReissueService reissueService;


    @PostMapping("/user")
    @ResponseStatus(HttpStatus.OK)
    public TokenResponse userLogin(@RequestBody @Valid LoginRequest request) {
        return userLoginService.login(request);
    }

    @PostMapping("/admin")
    @ResponseStatus(HttpStatus.OK)
    public TokenResponse adminLogin(@RequestBody @Valid LoginRequest request) {
        return adminLoginService.login(request);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void adminRegister(@RequestBody @Valid SignupRequest request) {
        adminSignupService.signup(request);
    }

    @PutMapping("/token")
    @ResponseStatus(HttpStatus.OK)
    public TokenResponse reissueToken(@RequestHeader(name = "x-refresh-token") String token) {
        return reissueService.reissueToken(token);
    }

}
