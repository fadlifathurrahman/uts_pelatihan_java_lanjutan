package com.example.demo.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class GuruDto {
    private String nip;
    private String namaGuru;
    private String noTelepon;
    private Integer idKelas;
    private Integer idMapel;
}
