package com.jaax.restfulapi.controller;

import com.jaax.restfulapi.entity.Local;
import com.jaax.restfulapi.error.LocalNotFoundException;
import com.jaax.restfulapi.service.LocalServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class LocalController {

    @Autowired
    LocalServiceImpl localService;

    @GetMapping("/findAllLocals")
    public List<Local> findAllLocals(){
        return localService.findAllLocals();
    }
    @GetMapping("/findLocalById/{id}")
    public Local findLocalById(@PathVariable Long id) throws LocalNotFoundException {
        return localService.findLocalById(id);
    }

    @GetMapping("/findByNameWithJPQL/{name}")
    public Optional<Local> findByNameWithJPQL(@PathVariable String name){
        return localService.findByNameWithJPQL(name);
    }
    @GetMapping("/findByName/{name}")
    public Optional<Local> findByName(@PathVariable String name){
        return localService.findByName(name);
    }
    @GetMapping("/findByNameIgnoreCase/{name}")
    public Optional<Local> findByNameIgnoreCase(@PathVariable String name){
        return localService.findByNameIgnoreCase(name);
    }

    @PostMapping("/saveLocal")
    public Local saveLocal(@Valid @RequestBody Local local){
        return localService.saveLocal(local);
    }

    @PutMapping("/updateLocal")
    public Local updateLocal(@RequestParam(value = "id") Long id, @RequestBody Local local){
        return localService.updateLocal(id, local);
    }
    @DeleteMapping("/deleteLocal/{id}")
    public String  deleteLocal(@PathVariable Long id){
        localService.deleteLocal(id);
        return "deleted local with id : " + id;
    }
}
