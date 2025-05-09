package com.example.clim_be.domain.auth.application.facade;

import com.example.clim_be.domain.admin.domain.Admin;
import com.example.clim_be.domain.admin.domain.repository.AdminRepository;
import com.example.clim_be.domain.admin.exception.AdminNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AdminFacade {
    private final AdminRepository adminRepository;

    public Admin currentAdmin() {
        String accountId = SecurityContextHolder.getContext().getAuthentication().getName();

        return adminRepository.findByAccountId(accountId)
                .orElseThrow(() -> AdminNotFoundException.EXCEPTION);
    }
}
