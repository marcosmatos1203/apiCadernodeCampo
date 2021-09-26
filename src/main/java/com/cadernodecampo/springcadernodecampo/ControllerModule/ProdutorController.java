package com.cadernodecampo.springcadernodecampo.ControllerModule;

import com.cadernodecampo.springcadernodecampo.DominioModel.Produtor;
import com.cadernodecampo.springcadernodecampo.RepositoryModel.ProdutorRepository;
import com.cadernodecampo.springcadernodecampo.ServiceModel.ProdutorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/produtores")
public class ProdutorController {

    @Autowired
    private ProdutorService produtorService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Produtor> findById(@PathVariable Integer id) {
        Produtor obj = produtorService.findById(id);
        return ResponseEntity.ok().body(obj);
    }
}
