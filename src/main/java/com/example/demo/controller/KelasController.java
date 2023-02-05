package com.example.demo.controller;

import com.example.demo.controller.dto.KelasDto;
import com.example.demo.model.Guru;
import com.example.demo.model.Kelas;
import com.example.demo.repository.KelasRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/kelas")

public class KelasController {
    @Autowired
    KelasRepository kelasRepository;

    @GetMapping("/find-all")
    public Object findAll() {

        return kelasRepository.findAll();
    }

    @PostMapping("/")
    public Object create(@RequestBody KelasDto dto) {
        //convert to kelas model
        Kelas kelas = new Kelas();
        kelas.setNamaKelas(dto.getNamaKelas());
        // save and return
        return kelasRepository.save(kelas);
    }

    @PutMapping("/{id}")
    public Object update(@PathVariable("id") Integer id,
                         @RequestBody KelasDto dto) {
        Kelas kelas = kelasRepository.findById(id).orElse(null);
        if(kelas == null) {
            return ResponseEntity.badRequest().body("ID kelas tidak ditemukan");
        }
        kelas.setNamaKelas(dto.getNamaKelas());
        return kelasRepository.save(kelas);
    }

//    @DeleteMapping("/{id}")
//    public Object delete(@PathVariable("id") Integer id) {
//        Kelas kelas = kelasRepository.findById(id).orElse(null);
//        if(kelas == null) {
//            return ResponseEntity.badRequest().body("ID kelas tidak ditemukan");
//        }
//
//        kelasRepository.delete(kelas);
//        return null;
//    }

}
