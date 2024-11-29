package com.example.demo.service;

import com.example.demo.entity.Local;

import java.util.List;

public interface LocalService {

    List<Local> findAllLocals();

    Local saveLocal(Local local);

    Local updateLocal(Long id, Local local);

    void deleteLocal(Long id);
}
