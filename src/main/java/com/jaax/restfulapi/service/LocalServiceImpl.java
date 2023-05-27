package com.jaax.restfulapi.service;

import com.jaax.restfulapi.entity.Local;
import com.jaax.restfulapi.error.LocalNotFoundException;
import com.jaax.restfulapi.repository.LocalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class LocalServiceImpl implements LocalService {

    @Autowired
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
        Local localDb = localRepository.findById(id).get();
        if(Objects.nonNull(localDb.getCode()) && !"".equalsIgnoreCase(localDb.getCode())){
            localDb.setCode(local.getCode());
        }
        if(Objects.nonNull(localDb.getFloor()) && !"".equalsIgnoreCase(localDb.getFloor())){
            localDb.setFloor(local.getFloor());
        }
        if(Objects.nonNull(localDb.getName()) && !"".equalsIgnoreCase(localDb.getName())){
            localDb.setName(local.getName());
        }
        return localRepository.save(localDb);
    }

    @Override
    public void deleteLocal(Long id) {
        localRepository.deleteById(id);
    }

    @Override
    public Optional<Local> findByNameWithJPQL(String name) {
        return localRepository.findByNameWithJPQL(name);
    }

    @Override
    public Optional<Local> findByName(String name) {
        return localRepository.findByName(name);
    }

        @Override
        public Optional<Local> findByNameIgnoreCase(String name) {
            return localRepository.findByNameIgnoreCase(name);
    }

    @Override
    public Local findLocalById(Long id) throws LocalNotFoundException {
        Optional<Local> local = localRepository.findById(id);
        if(!local.isPresent()){
            throw new LocalNotFoundException("Local is not avariable");
        }
        return local.get();
    }

}
