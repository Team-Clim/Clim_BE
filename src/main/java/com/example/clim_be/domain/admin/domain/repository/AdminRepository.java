package com.example.clim_be.domain.admin.domain.repository;

import com.example.clim_be.domain.admin.domain.Admin;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdminRepository extends CrudRepository<Admin, Long> {

    Boolean existsByAccountId(String accountId);

    Optional<Admin> findByAccountId(String accountId);
}
