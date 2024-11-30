package com.example.demo.repository;

import com.example.demo.entity.Local;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class LocalRepositoryTest {
    //Inyectar el repositorio a probar
    @Autowired
    private LocalRepository localRepository;
    //Inyectar el test
    @Autowired
    TestEntityManager entityManager;

    @BeforeEach
    void setUp() {
        //Se ejecuta antes de las pruebas unitarias
        Local local =
                Local.builder()
                        .name("SuperMarket")
                        .floor("Thrid")
                        .code("abc-123")
                        .build();
        entityManager.persist(local);
    }

    @Test
    public void findBynameIgnoreCaseFound() {
        Optional<Local> local = localRepository.findBynameIgnoreCase("supermarket");
        assertEquals(local.get().getName(), "SuperMarket");
    }

    @Test
    public void findBynameIgnoreCaseNotFound() {
        Optional<Local> local = localRepository.findBynameIgnoreCase("Caso");
        assertEquals(local, Optional.empty());
    }
}