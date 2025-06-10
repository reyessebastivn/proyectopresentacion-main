package com.example.api_perfume.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.api_perfume.models.Perfume;


public interface PerfumeRepository extends JpaRepository<Perfume, Long> {
    List<Perfume> findByIdUsuario(Long idUsuario);
}

