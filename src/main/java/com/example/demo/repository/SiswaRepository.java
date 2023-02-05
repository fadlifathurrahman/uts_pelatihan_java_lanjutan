package com.example.demo.repository;

import com.example.demo.model.Siswa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SiswaRepository extends JpaRepository<Siswa, Integer> {
}
