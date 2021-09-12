package com.dominiks.demo.repository;

import com.dominiks.demo.dto.HomeDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PreferencesRepository extends JpaRepository<HomeDto, Long> {
}
