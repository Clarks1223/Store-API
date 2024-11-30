package com.example.demo.controller;

import com.example.demo.entity.Local;
import com.example.demo.error.LocalNotFoundException;
import com.example.demo.service.LocalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class LocalController {
    //Se inyecta el servicio
    @Autowired
    LocalService localService;

    @GetMapping("/locals")
    public List<Local> findAllLocals() {
        return localService.findAllLocals();
    }

    @GetMapping("/local/{id}")
    public Local findById(@PathVariable Long id) throws LocalNotFoundException {
        return localService.findById(id);
    }

    @GetMapping("/findbyname/{name}")
    public Optional<Local> findLocalByName(@PathVariable String name) {
        return localService.findByName(name);
    }

    @GetMapping("/findbynamecase/{name}")
    public Optional<Local> findLocalByNameIgnore(@PathVariable String name) {
        return localService.findBynameIgnoreCase(name);
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
