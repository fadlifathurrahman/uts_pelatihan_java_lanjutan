package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ekskul_siswa")

public class EkskulSiswa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ekskul_siswa_id", nullable = false)
    private Integer ekskulSiswaId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ekskul_id", referencedColumnName = "id_ekskul")
    private Ekskul ekskul;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "siswa_id", referencedColumnName = "id_siswa")
    private Siswa siswa;
}
