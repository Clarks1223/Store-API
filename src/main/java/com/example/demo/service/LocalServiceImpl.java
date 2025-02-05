package com.example.demo.service;

import com.example.demo.entity.Local;
import com.example.demo.error.LocalNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.repository.LocalRepository;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class LocalServiceImpl implements LocalService {
    @Autowired//inyecto el repositorio
    LocalRepository localRepository;

    @Override
    public List<Local> findAllLocals() {
        return localRepository.findAll();
    }

    @Override
    public Local saveLocal(Local local) {
        return localRepository.save(local);
    }

    @Override
    public Local updateLocal(Long id, Local local) {
        Local localBD = localRepository.findById(id).get();
        if (Objects.nonNull(local.getCode()) && !"".equalsIgnoreCase(local.getCode())) {
            localBD.setCode(local.getCode());
        }
        if (Objects.nonNull(local.getFloor()) && !"".equalsIgnoreCase(local.getFloor())) {
            localBD.setFloor(local.getFloor());
        }
        if (Objects.nonNull(local.getName()) && !"".equalsIgnoreCase(local.getName())) {
            localBD.setName(local.getName());
        }
        return localRepository.save(localBD);
    }

    @Override
    public void deleteLocal(Long id) {
        localRepository.deleteById(id);
    }

    @Override
    public Optional<Local> findByName(String name) {
        return localRepository.findByName(name);
    }

    @Override
    public Optional<Local> findBynameIgnoreCase(String name) {
        return localRepository.findBynameIgnoreCase(name);
    }

    @Override
    public Local findById(Long id) throws LocalNotFoundException {
        Optional<Local> localBD = localRepository.findById(id);
        if (!localBD.isPresent()) {
            throw new LocalNotFoundException("Local is not available");
        }
        return localRepository.findById(id).get();
    }

}
