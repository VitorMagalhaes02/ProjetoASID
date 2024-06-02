package com.iStudent.microservicos.town.repository;

import com.iStudent.microservicos.town.model.Town;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TownRepository extends JpaRepository<Town, Long> {

    Optional<Town> findByName(String townName);
}
