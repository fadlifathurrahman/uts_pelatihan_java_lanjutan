package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ekskul")

public class Ekskul {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ekskul", length = 10, nullable = false)
    private Integer idEkskul;

    @Column(name = "nama_ekskul",nullable = false)
    private String namaEkskul;

}
