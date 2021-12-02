package com.cadernodecampo.springcadernodecampo.ControllerModule;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import com.cadernodecampo.springcadernodecampo.DTOmodule.ArmadilhaDTO;
import com.cadernodecampo.springcadernodecampo.DominioModule.Armadilha;
import com.cadernodecampo.springcadernodecampo.ServiceModule.ArmadilhaService;

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
@RequestMapping(value = "/armadilha")
public class ArmadilhaController {
    
    @Autowired
    private ArmadilhaService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Armadilha> findById(@PathVariable Integer id) {
        Armadilha obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @GetMapping
    public ResponseEntity<List<ArmadilhaDTO>> findAll(
            @RequestParam(value = "quadra", defaultValue = "0") Integer id_produtor) {
        List<Armadilha> listaArmadilha = service.findAll(id_produtor);
        List<ArmadilhaDTO> listaArmadilhaDTO = listaArmadilha.stream().map(obj -> new ArmadilhaDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listaArmadilhaDTO);
    }

    @PutMapping(value = "/id")
    public ResponseEntity<Armadilha> update(@Valid @PathVariable Integer id, @RequestBody Armadilha obj) {
        Armadilha newObj = service.update(id, obj);
        return ResponseEntity.ok().body(newObj);
    }

    @PatchMapping(value = "/id")
    public ResponseEntity<Armadilha> updatePatch(@Valid @PathVariable Integer id, @RequestBody Armadilha obj) {
        Armadilha newObj = service.update(id, obj);
        return ResponseEntity.ok().body(newObj);
    }

    @PostMapping
    public ResponseEntity<Armadilha> create(@Valid @RequestBody Armadilha obj){
        Armadilha newObj = service.create(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/armadilha/{id}").buildAndExpand(newObj.id).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
