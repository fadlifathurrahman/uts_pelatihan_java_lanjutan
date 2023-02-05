package com.example.demo.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class SiswaDto {

    private String alamat;
    private String nama;
    private String nis;
    private Integer umur;
    private Integer idKelas;

}
