package com.example.demo.controller;

import com.example.demo.controller.dto.EkskulDto;
import com.example.demo.controller.dto.KelasDto;
import com.example.demo.model.Ekskul;
import com.example.demo.model.Kelas;
import com.example.demo.repository.EkskulRepository;
import com.example.demo.repository.KelasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ekskul")

public class EkskulController {
    @Autowired
    EkskulRepository ekskulRepository;

    @GetMapping("/find-all")
    public Object findAll() {

        return ekskulRepository.findAll();
    }

    @PostMapping("/")
    public Object create(@RequestBody EkskulDto dto) {
        //convert to ekskul model
        Ekskul ekskul = new Ekskul();
        ekskul.setNamaEkskul(dto.getNamaEkskul());
        // save and return
        return ekskulRepository.save(ekskul);
    }

    @PutMapping("/{id}")
    public Object update(@PathVariable("id") Integer id,
                         @RequestBody EkskulDto dto) {
        Ekskul ekskul = ekskulRepository.findById(id).orElse(null);
        if(ekskul == null) {
            return ResponseEntity.badRequest().body("ID ekskul tidak ditemukan");
        }
        ekskul.setNamaEkskul(dto.getNamaEkskul());
        return ekskulRepository.save(ekskul);
    }

//    @DeleteMapping("/{id}")
//    public Object delete(@PathVariable("id") Integer id) {
//        Ekskul ekskul = ekskulRepository.findById(id).orElse(null);
//        if(ekskul == null) {
//            return ResponseEntity.badRequest().body("ID ekskul tidak ditemukan");
//        }
//
//        ekskulRepository.delete(ekskul);
//        return null;
//    }
}
