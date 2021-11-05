package com.cadernodecampo.springcadernodecampo.ControllerModule;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import com.cadernodecampo.springcadernodecampo.DTOmodule.PomarDTO;
import com.cadernodecampo.springcadernodecampo.DominioModule.Pomar;
import com.cadernodecampo.springcadernodecampo.ServiceModule.PomarService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@CrossOrigin
@RestController
@RequestMapping(value = "/pomar")
public class PomarController {

    @Autowired
    private PomarService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Pomar> findById(@PathVariable Integer id) {
        Pomar obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @GetMapping
    public ResponseEntity<List<PomarDTO>> findAll(
            @RequestParam(value = "produtor", defaultValue = "0") Integer id_produtor) {
        List<Pomar> listaPomar = service.findAll(id_produtor);
        List<PomarDTO> listaPomarDTO = listaPomar.stream().map(obj -> new PomarDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listaPomarDTO);
    }
    
/*
    @GetMapping
    public ResponseEntity<List<PomarDTO>> findAllByRespTecnico(
            @RequestParam(value = "respTecnico", defaultValue = "0") Integer id_respTecnico) {
        List<Pomar> listaPomar = service.findAllByRespTec(id_respTecnico);
        List<PomarDTO> listaPomarDTO = listaPomar.stream().map(obj -> new PomarDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listaPomarDTO);
    }*/

    @PutMapping(value = "/{id}")
    public ResponseEntity<Pomar> update(@Valid @PathVariable Integer id, @RequestBody PomarDTO obj) {
        Pomar newObj = service.update(id, obj);
        return ResponseEntity.ok().body(newObj);
    }
    @PatchMapping(value = "/id")
    public ResponseEntity<Pomar> updatePatch(@Valid @PathVariable Integer id, @RequestBody PomarDTO obj) {
        Pomar newObj = service.update(id, obj);
        return ResponseEntity.ok().body(newObj);
    }
  /*  @PostMapping
    public ResponseEntity<Pomar> create(@Valid @RequestParam(defaultValue = "0") Integer id_produtor, @RequestBody Pomar obj){
        Pomar newObj = service.create(id_produtor, obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/pomar/{id}").buildAndExpand(newObj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }*/

    @PostMapping
    public ResponseEntity<Pomar> create(@Valid @RequestBody Pomar obj){
        Pomar newObj = service.create(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/pomar/{id}").buildAndExpand(newObj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
