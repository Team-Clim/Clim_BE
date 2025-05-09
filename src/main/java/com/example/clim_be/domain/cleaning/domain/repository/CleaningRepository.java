package com.example.clim_be.domain.cleaning.domain.repository;

import com.example.clim_be.domain.cleaning.domain.Cleaning;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CleaningRepository extends CrudRepository<Cleaning, Long> {
}
