package com.example.demo.controller;

import com.example.demo.controller.dto.SiswaDto;
import com.example.demo.model.Siswa;
import com.example.demo.repository.KelasRepository;
import com.example.demo.repository.SiswaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/siswa")

public class SiswaController {
    SiswaRepository siswaRepository;
    KelasRepository kelasRepository;

    @Autowired
    public SiswaController(SiswaRepository siswaRepository, KelasRepository kelasRepository) {
        this.siswaRepository = siswaRepository;
        this.kelasRepository = kelasRepository;
    }
    @GetMapping("/find-all")
    public Object findAll() {

        return siswaRepository.findAll();
    }

    @PostMapping("/")
    public Object create(@RequestBody SiswaDto siswaDto) {
        //convert to siswa model
        Siswa siswa = new Siswa();
        siswa.setAlamat(siswaDto.getAlamat());
        siswa.setNama(siswaDto.getNama());
        siswa.setNis(siswaDto.getNis());
        siswa.setUmur(siswaDto.getUmur());
        siswa.setKelas(kelasRepository.findById(siswaDto.getIdKelas()).orElse(null));

        // save and return
        return siswaRepository.save(siswa);
    }

    @PutMapping("/{id}")
    public Object update(@PathVariable("id") Integer id,
                         @RequestBody SiswaDto siswaDto) {
        Siswa siswa = siswaRepository.findById(id).orElse(null);
        if(siswa == null) {
            return ResponseEntity.badRequest().body("ID siswa tidak ditemukan");
        }
        siswa.setAlamat(siswaDto.getAlamat());
        siswa.setNama(siswaDto.getNama());
        siswa.setNis(siswaDto.getNis());
        siswa.setUmur(siswaDto.getUmur());
        siswa.setKelas(kelasRepository.findById(siswaDto.getIdKelas()).orElse(null));

        return ResponseEntity.ok(siswaRepository.save(siswa));
    }

    @DeleteMapping("/{id}")
    public Object delete(@PathVariable("id") Integer id) {
        // check if id exist
        Siswa siswa = siswaRepository.findById(id).orElse(null);
        if(siswa == null) {
            return ResponseEntity.badRequest().body("ID siswa tidak ditemukan");
        }

        siswaRepository.delete(siswa);
        return null;
    }

}
