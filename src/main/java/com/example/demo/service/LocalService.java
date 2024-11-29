package com.example.demo.service;

import com.example.demo.entity.Local;

import java.util.List;
import java.util.Optional;

public interface LocalService {

    List<Local> findAllLocals();

    Local saveLocal(Local local);

    Local updateLocal(Long id, Local local);

    void deleteLocal(Long id);

    Optional<Local> findByName(String name);

    Optional<Local> findBynameIgnoreCase(String name);

}
