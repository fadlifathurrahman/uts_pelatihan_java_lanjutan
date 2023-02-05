package com.example.demo.controller;

import com.example.demo.controller.dto.EkskulSiswaDto;
import com.example.demo.controller.dto.KelasMataPelajaranDto;
import com.example.demo.model.*;
import com.example.demo.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ekskul-siswa")

public class EkskulSiswaController {

    EkskulSiswaRepository ekskulSiswaRepository;
    EkskulRepository ekskulRepository;
    SiswaRepository siswaRepository;
    @Autowired
    public EkskulSiswaController(EkskulSiswaRepository ekskulSiswaRepository, EkskulRepository ekskulRepository, SiswaRepository siswaRepository) {
        this.ekskulSiswaRepository = ekskulSiswaRepository;
        this.ekskulRepository = ekskulRepository;
        this.siswaRepository = siswaRepository;
    }

    @GetMapping("/find-all")
    public Object findAll() {
        return ekskulSiswaRepository.findAll();
    }

    @PostMapping("/")
    public Object create(@RequestBody EkskulSiswaDto dto){
        //check ekskul
        Ekskul ekskul = ekskulRepository.findById(dto.getIdEkskul()).orElse(null);
        if(ekskul == null) {
            return ResponseEntity.badRequest().body("ID ekskul tidak ditemukan");
        }
        Siswa siswa = siswaRepository.findById(dto.getIdSiswa()).orElse(null);
        if(siswa == null) {
            return ResponseEntity.badRequest().body("ID siswa tidak ditemukan");
        }
        EkskulSiswa ekskulSiswa = new EkskulSiswa();
        ekskulSiswa.setEkskul(ekskul);
        ekskulSiswa.setSiswa(siswa);
        return ekskulSiswaRepository.save(ekskulSiswa);
    }

    @PutMapping("/{id}")
    public Object update(@PathVariable("id") Integer id,
                         @RequestBody EkskulSiswaDto dto) {
        EkskulSiswa ekskulSiswa = ekskulSiswaRepository.findById(id).orElse(null);
        if(ekskulSiswa == null) {
            return ResponseEntity.badRequest().body("ID ekskul-siswa pelajaran tidak ditemukan");
        }
        Ekskul ekskul = ekskulRepository.findById(dto.getIdEkskul()).orElse(null);
        if(ekskul == null) {
            return ResponseEntity.badRequest().body("ID ekskul tidak ditemukan");
        }
        Siswa siswa = siswaRepository.findById(dto.getIdSiswa()).orElse(null);
        if(siswa == null) {
            return ResponseEntity.badRequest().body("ID siswa tidak ditemukan");
        }
        ekskulSiswa.setEkskul(ekskul);
        ekskulSiswa.setSiswa(siswa);

        return ekskulSiswaRepository.save(ekskulSiswa);
    }

    @DeleteMapping("/{id}")
    public Object delete(@PathVariable("id") Integer id) {
        EkskulSiswa ekskulSiswa = ekskulSiswaRepository.findById(id).orElse(null);
        if(ekskulSiswa == null) {
            return ResponseEntity.badRequest().body("ID ekskul-siswa pelajaran tidak ditemukan");
        }
        ekskulSiswaRepository.delete(ekskulSiswa);

        return null;
    }
}
