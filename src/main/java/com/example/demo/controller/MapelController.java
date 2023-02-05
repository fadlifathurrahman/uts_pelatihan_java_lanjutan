package com.example.demo.controller;

import com.example.demo.controller.dto.MataPelajaranDto;
import com.example.demo.model.MataPelajaran;
import com.example.demo.repository.MapelRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mata-pelajaran")

public class MapelController {
    @Autowired
    MapelRepository mapelRepository;

    @GetMapping("/find-all")
    public Object findAll() {

        return mapelRepository.findAll();
    }

    @PostMapping("/")
    public Object create(@RequestBody MataPelajaranDto dto) {
        //convert to mapel model
        MataPelajaran mataPelajaran = new MataPelajaran();
        mataPelajaran.setNamaMapel(dto.getNamaMapel());
        // save and return
        return mapelRepository.save(mataPelajaran);
    }

    @PutMapping("/{id}")
    public Object update(@PathVariable("id") Integer id,
                         @RequestBody MataPelajaranDto dto) {
        MataPelajaran mataPelajaran = mapelRepository.findById(id).orElse(null);
        if(mataPelajaran == null) {
            return ResponseEntity.badRequest().body("ID pelajaran tidak ditemukan");
        }
        mataPelajaran.setNamaMapel(dto.getNamaMapel());
        return mapelRepository.save(mataPelajaran);
    }

//    @DeleteMapping("/{id}")
//    public Object delete(@PathVariable("id") Integer id) {
//        MataPelajaran mataPelajaran = mapelRepository.findById(id).orElse(null);
//        if(mataPelajaran == null) {
//            return ResponseEntity.badRequest().body("ID pelajaran tidak ditemukan");
//        }
//
//        mapelRepository.delete(mataPelajaran);
//        return null;
//    }
}
