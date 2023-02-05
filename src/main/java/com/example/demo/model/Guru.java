package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "guru")

public class Guru {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_guru", length = 10, nullable = false)
    private Integer idGuru;
    @Column(name = "nip", length = 12,  nullable = false)
    private String nip;
    @Column(name = "nama_guru",nullable = false)
    private String namaGuru;
    @Column(name = "no_telepon",  length = 15)
    private String noTelepon;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_mapel", referencedColumnName = "id_mapel")
    private MataPelajaran mataPelajaran;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_kelas", referencedColumnName = "id_kelas")
    private Kelas kelas;


}
