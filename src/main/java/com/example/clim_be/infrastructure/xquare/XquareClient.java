package com.example.clim_be.infrastructure.xquare;

import com.example.clim_be.domain.auth.presentation.dto.request.LoginRequest;
import com.example.clim_be.infrastructure.xquare.dto.XquareUserResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "xquare-client", url = "${key.login-api-url}", configuration = XquareRetryConfiguration.class)
public interface XquareClient {
    @PostMapping("/user-data")
    XquareUserResponse xquareUser(@RequestBody LoginRequest request);

    @PatchMapping("/modify-profile")
    void modifyProfile(@RequestParam("account_id") String account_id, @RequestParam("profile_img_url") String profileImgUrl);
}

