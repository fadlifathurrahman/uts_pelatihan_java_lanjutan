package com.example.demo.repository;

import com.example.demo.model.MataPelajaran;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MapelRepository extends JpaRepository<MataPelajaran, Integer>  {
}
