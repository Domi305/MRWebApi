package com.dominiks.demo.repository;

import com.dominiks.demo.dto.HomeDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PreferencesRepository extends JpaRepository<HomeDto, Long> {
    //below code commented out is a reference how to create custom queries
    //@Query("select dto from HomeDto dto where userId =:userId")
    HomeDto findByUserId(Long userId);
}
