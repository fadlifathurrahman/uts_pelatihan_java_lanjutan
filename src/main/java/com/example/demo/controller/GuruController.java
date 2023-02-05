package com.example.demo.controller;

import com.example.demo.controller.dto.GuruDto;
import com.example.demo.model.Guru;
import com.example.demo.repository.GuruRepository;

import com.example.demo.repository.KelasRepository;
import com.example.demo.repository.MapelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/guru")

public class GuruController {
    GuruRepository guruRepository;
    KelasRepository kelasRepository;
    MapelRepository mapelRepository;

    @Autowired
    public GuruController(GuruRepository guruRepository, KelasRepository kelasRepository, MapelRepository mapelRepository) {
        this.guruRepository = guruRepository;
        this.kelasRepository = kelasRepository;
        this.mapelRepository = mapelRepository;
    }

    @GetMapping("/find-all")
    public Object findAll() {

        return guruRepository.findAll();
    }

    @PostMapping("/")
    public Object create(@RequestBody GuruDto dto) {
        //convert to guru model
        Guru guru = new Guru();
        guru.setNip(dto.getNip());
        guru.setNamaGuru(dto.getNamaGuru());
        guru.setNoTelepon(dto.getNoTelepon());
        guru.setMataPelajaran(mapelRepository.findById(dto.getIdMapel()).orElse(null));
        guru.setKelas(kelasRepository.findById(dto.getIdKelas()).orElse(null));
        // save and return
        return guruRepository.save(guru);
    }

    @PutMapping("/{id}")
    public Object update(@PathVariable("id") Integer id,
                         @RequestBody GuruDto guruDto) {
        Guru guru = guruRepository.findById(id).orElse(null);
        if(guru == null) {
            return ResponseEntity.badRequest().body("ID guru tidak ditemukan");
        }
        guru.setNip(guruDto.getNip());
        guru.setNamaGuru(guruDto.getNamaGuru());
        guru.setNoTelepon(guruDto.getNoTelepon());
        guru.setMataPelajaran(mapelRepository.findById(guruDto.getIdMapel()).orElse(null));
        guru.setKelas(kelasRepository.findById(guruDto.getIdKelas()).orElse(null));
        return guruRepository.save(guru);
    }

    @DeleteMapping("/{id}")
    public Object delete(@PathVariable("id") Integer id) {
        // check if id exist
        Guru guru = guruRepository.findById(id).orElse(null);
        if(guru == null) {
            return ResponseEntity.badRequest().body("ID guru tidak ditemukan");
        }

        guruRepository.delete(guru);
        return null;
    }
}
