package com.example.demo.repository;

import com.example.demo.model.Guru;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GuruRepository extends JpaRepository<Guru, Integer> {
}
