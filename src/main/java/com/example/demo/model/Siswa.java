package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table (name = "siswa")

public class Siswa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_siswa", length = 10, nullable = false)
    private Integer idSiswa;
    @Column(name = "nis", length = 10, nullable = false)
    private String nis;
    @Column(name = "nama", length = 500, nullable = false)
    private String nama;
    @Column(name = "alamat", columnDefinition = "TEXT")
    private String alamat;
    @Column(name = "umur")
    private Integer umur;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_kelas", referencedColumnName = "id_kelas")
    private Kelas kelas;
}
