package com.cadernodecampo.springcadernodecampo.ControllerModule;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import com.cadernodecampo.springcadernodecampo.DTOmodule.CultivarQuadraDTO;
import com.cadernodecampo.springcadernodecampo.DominioModule.CultivarQuadra;
import com.cadernodecampo.springcadernodecampo.ServiceModule.CultivarQuadraService;

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
@RequestMapping(value = "/cultivarQuadra")
public class CultivarQuadraController {
    
    @Autowired
    private CultivarQuadraService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<CultivarQuadra> findById(@PathVariable Integer id) {
        CultivarQuadra obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @GetMapping
    public ResponseEntity<List<CultivarQuadraDTO>> findAll(
            @RequestParam(value = "quadra", defaultValue = "0") Integer id_Quadra) {
        List<CultivarQuadra> listaCultivarQuadra = service.findAll(id_Quadra);
        List<CultivarQuadraDTO> listaCultivarQuadraDTO = listaCultivarQuadra.stream().map(obj -> new CultivarQuadraDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listaCultivarQuadraDTO);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<CultivarQuadra> update(@Valid @PathVariable Integer id, @RequestBody CultivarQuadra obj) {
        CultivarQuadra newObj = service.update(id, obj);
        return ResponseEntity.ok().body(newObj);
    }

    @PatchMapping(value = "/{id}")
    public ResponseEntity<CultivarQuadra> updatePatch(@Valid @PathVariable Integer id, @RequestBody CultivarQuadra obj) {
        CultivarQuadra newObj = service.update(id, obj);
        return ResponseEntity.ok().body(newObj);
    }


    @PostMapping
    public ResponseEntity<CultivarQuadra> create(@Valid @RequestBody CultivarQuadra obj) {
        obj = service.create(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.id, obj.cultivar, obj.quadra, obj.enxerto).toUri();
        return ResponseEntity.created(uri).body(obj);
    }
    
    //@PostMapping
    //public ResponseEntity<CultivarQuadra> create(@Valid @RequestParam(defaultValue = "0") Integer id_quadra, @RequestBody CultivarQuadra obj){
    //   CultivarQuadra newObj = service.create(id_quadra, obj);
    //    URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/cultivarQuadra/{id}").buildAndExpand(newObj.cultivar, newObj.quadra, newObj.enxerto).toUri();
     //   return ResponseEntity.created(uri).build();
    //}
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}