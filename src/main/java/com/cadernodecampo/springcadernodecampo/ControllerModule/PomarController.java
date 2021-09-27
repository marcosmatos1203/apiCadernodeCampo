package com.cadernodecampo.springcadernodecampo.ControllerModule;

import com.cadernodecampo.springcadernodecampo.DominioModel.Pomar;
import com.cadernodecampo.springcadernodecampo.ServiceModel.PomarService;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/pomares")
public class PomarController {

    @Autowired
    private PomarService service;
    
    public ResponseEntity<Pomar> findById(@PathVariable Integer id){
        Pomar obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }
}
