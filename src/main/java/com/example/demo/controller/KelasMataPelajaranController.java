package com.example.demo.controller;

import com.example.demo.controller.dto.GuruDto;
import com.example.demo.controller.dto.KelasMataPelajaranDto;
import com.example.demo.model.*;
import com.example.demo.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/kelas-mata-pelajaran")

public class KelasMataPelajaranController {

    KelasMataPelajaranRepository kelasMataPelajaranRepository;
    KelasRepository kelasRepository;
    MapelRepository mapelRepository;
    @Autowired
    public KelasMataPelajaranController(KelasMataPelajaranRepository kelasMataPelajaranRepository, KelasRepository kelasRepository, MapelRepository mapelRepository) {
        this.kelasMataPelajaranRepository = kelasMataPelajaranRepository;
        this.kelasRepository = kelasRepository;
        this.mapelRepository = mapelRepository;
    }

    @GetMapping("/find-all")
    public Object findAll() {
        return kelasMataPelajaranRepository.findAll();
    }

    @PostMapping("/")
    public Object create(@RequestBody KelasMataPelajaranDto dto){
        //check kelas
        Kelas kelas = kelasRepository.findById(dto.getIdKelas()).orElse(null);
        if(kelas == null) {
            return ResponseEntity.badRequest().body("ID kelas tidak ditemukan");
        }
        //check mata mata pelajaran
        MataPelajaran mataPelajaran = mapelRepository.findById(dto.getIdMapel()).orElse(null);
        if(mataPelajaran == null) {
            return ResponseEntity.badRequest().body("ID mata pelajaran tidak ditemukan");
        }
        KelasMataPelajaran kelasMataPelajaran = new KelasMataPelajaran();
        kelasMataPelajaran.setKelas(kelas);
        kelasMataPelajaran.setMataPelajaran(mataPelajaran);
        return kelasMataPelajaranRepository.save(kelasMataPelajaran);
    }

    @PutMapping("/{id}")
    public Object update(@PathVariable("id") Integer id,
                         @RequestBody KelasMataPelajaranDto dto) {
        KelasMataPelajaran kelasMataPelajaran = kelasMataPelajaranRepository.findById(id).orElse(null);
        if(kelasMataPelajaran == null) {
            return ResponseEntity.badRequest().body("ID kelas-mata pelajaran tidak ditemukan");
        }
        Kelas kelas = kelasRepository.findById(dto.getIdKelas()).orElse(null);
        if(kelas == null) {
            return ResponseEntity.badRequest().body("ID kelas tidak ditemukan");
        }
        //check mata mata pelajaran
        MataPelajaran mataPelajaran = mapelRepository.findById(dto.getIdMapel()).orElse(null);
        if(mataPelajaran == null) {
            return ResponseEntity.badRequest().body("ID mata pelajaran tidak ditemukan");
        }
        kelasMataPelajaran.setKelas(kelas);
        kelasMataPelajaran.setMataPelajaran(mataPelajaran);
        return kelasMataPelajaranRepository.save(kelasMataPelajaran);
    }

    @DeleteMapping("/{id}")
    public Object delete(@PathVariable("id") Integer id) {
        KelasMataPelajaran kelasMataPelajaran = kelasMataPelajaranRepository.findById(id).orElse(null);
        if(kelasMataPelajaran == null) {
            return ResponseEntity.badRequest().body("ID kelas-mata pelajaran tidak ditemukan");
        }
        kelasMataPelajaranRepository.delete(kelasMataPelajaran);

        return null;
    }

}
