package com.example.clim_be.domain.cleaning.presentation;

import com.example.clim_be.domain.cleaning.application.InputCleaningService;
import com.example.clim_be.domain.cleaning.presentation.dto.request.CleaningRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/cleaning")
public class CleaningController {
    private final InputCleaningService inputCleaningService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void input(@RequestBody @Valid CleaningRequest request) {
        inputCleaningService.input(request);
    }
}
