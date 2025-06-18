package com.example.clim_be.domain.cleaning.presentation;

import com.example.clim_be.domain.cleaning.application.InputCleaningService;
import com.example.clim_be.domain.cleaning.application.QueryDateCleaningService;
import com.example.clim_be.domain.cleaning.presentation.dto.request.CleaningRequest;
import com.example.clim_be.domain.cleaning.presentation.dto.response.CleaningResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/cleaning")
public class CleaningController {
    private final InputCleaningService inputCleaningService;
    private final QueryDateCleaningService queryDateCleaningService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void input(@RequestBody @Valid CleaningRequest request) {
        inputCleaningService.execute(request);
    }

    @GetMapping("/today")
    @ResponseStatus(HttpStatus.OK)
    public Optional<CleaningResponse> queryDateCleaningStatus() {
        return queryDateCleaningService.execute();
    }
}
