package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "mata_pelajaran")
public class MataPelajaran {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_mapel", length = 10, nullable = false)
    private Integer idMapel;

    @Column(name = "nama_mapel", nullable = false)
    private String namaMapel;
}
