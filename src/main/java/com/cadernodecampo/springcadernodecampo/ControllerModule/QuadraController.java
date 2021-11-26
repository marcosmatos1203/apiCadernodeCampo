package com.cadernodecampo.springcadernodecampo.ControllerModule;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import com.cadernodecampo.springcadernodecampo.DTOmodule.QuadraDTO;
import com.cadernodecampo.springcadernodecampo.DominioModule.Quadra;
import com.cadernodecampo.springcadernodecampo.ServiceModule.QuadraService;

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
@RequestMapping(value = "/quadra")
public class QuadraController {
    @Autowired
    private QuadraService service;

 /*   @GetMapping(value = "/{id}")
    public ResponseEntity<Quadra> findById(@PathVariable Integer id) {
        Quadra obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @GetMapping
    public ResponseEntity<List<QuadraDTO>> findAll(
            @RequestParam(value = "pomar", defaultValue = "0") Integer pomar) {
        List<Quadra> listaQuadra = service.findAll(pomar);
        List<QuadraDTO> listaQuadraDTO = listaQuadra.stream().map(obj -> new QuadraDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listaQuadraDTO);

        
    }

    @PutMapping(value = "/id")
    public ResponseEntity<Quadra> update(@Valid @PathVariable Integer id, @RequestBody Quadra obj) {
        Quadra newObj = service.update(id, obj);
        return ResponseEntity.ok().body(newObj);
    }
    @PatchMapping(value = "/id")
    public ResponseEntity<Quadra> updatePatch(@Valid @PathVariable Integer id, @RequestBody Quadra obj) {
        Quadra newObj = service.update(id, obj);
        return ResponseEntity.ok().body(newObj);
    }
    //@PostMapping
  //  public ResponseEntity<Quadra> create(@Valid @RequestParam(defaultValue = "0") Integer id_pomar, @RequestBody Quadra obj){
    //    Quadra newObj = service.create(id_pomar, obj);
   //     URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/quadra/{id}").buildAndExpand(newObj.getId()).toUri();
    //    return ResponseEntity.created(uri).build();
  //  }
  @PostMapping
    public ResponseEntity<Quadra> create(@Valid @RequestBody Quadra obj){
        Quadra newObj = service.create(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/quadra/{id}").buildAndExpand(newObj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }*/


    @GetMapping(value = "/{id}")
    public ResponseEntity<Quadra> findById(@PathVariable Integer id) {
        Quadra obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @GetMapping
    public ResponseEntity<List<QuadraDTO>> findAll(
            @RequestParam(value = "pomar", defaultValue = "0") Integer id_pomar) {
        List<Quadra> listaQuadra = service.findAll(id_pomar);
        List<QuadraDTO> listaQuadraDTO = listaQuadra.stream().map(obj -> new QuadraDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listaQuadraDTO);
    }
    

    @PutMapping(value = "/{id}")
    public ResponseEntity<Quadra> update(@Valid @PathVariable Integer id, @RequestBody QuadraDTO obj) {
        Quadra newObj = service.update(id, obj);
        return ResponseEntity.ok().body(newObj);
    }

    @PatchMapping(value = "/id")
    public ResponseEntity<Quadra> updatePatch(@Valid @PathVariable Integer id, @RequestBody QuadraDTO obj) {
        Quadra newObj = service.update(id, obj);
        return ResponseEntity.ok().body(newObj);
    }

    @PostMapping
    public ResponseEntity<Quadra> create(@Valid @RequestBody Quadra obj){
        Quadra newObj = service.create(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/quadra/{id}").buildAndExpand(newObj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
