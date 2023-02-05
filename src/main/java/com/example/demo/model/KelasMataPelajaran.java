package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "kelas_mata_pelajaran")

public class KelasMataPelajaran {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "kelas_mapel_id", nullable = false)
    private Integer kelasMapelId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_kelas", referencedColumnName = "id_kelas")
    private Kelas kelas;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_mapel", referencedColumnName = "id_mapel")
    private MataPelajaran mataPelajaran;
}
