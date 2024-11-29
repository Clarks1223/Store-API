package com.example.demo.controller;

import com.example.demo.entity.Local;
import com.example.demo.service.LocalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LocalController {
    //Se inyecta el servicio
    @Autowired
    LocalService localService;

    @GetMapping("/locals")
    public List<Local> findAllLocals() {
        return localService.findAllLocals();
    }

    @PostMapping("/local")
    public Local savelocal(@RequestBody Local local) {
        return localService.saveLocal(local);
    }

    @PutMapping("/local/{id}")
    public Local updateLocal(@PathVariable long id, @RequestBody Local local) {
        return localService.updateLocal(id, local);
    }

    @DeleteMapping("/local/{id}")
    public void deleteLocal(@PathVariable long id) {
        localService.deleteLocal(id);
    }
}
