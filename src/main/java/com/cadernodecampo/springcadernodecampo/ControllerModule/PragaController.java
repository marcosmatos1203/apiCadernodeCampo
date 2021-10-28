package com.cadernodecampo.springcadernodecampo.ControllerModule;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import com.cadernodecampo.springcadernodecampo.DTOmodule.PragaDTO;
import com.cadernodecampo.springcadernodecampo.DominioModule.Praga;
import com.cadernodecampo.springcadernodecampo.ServiceModule.PragaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@CrossOrigin
@RestController
@RequestMapping(value = "/praga")
public class PragaController {

    @Autowired
    private PragaService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Praga> findById(@PathVariable Integer id){
        Praga obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @GetMapping
    public ResponseEntity<List<PragaDTO>> findAll() {

        List<Praga> listaPraga = service.findAll();
        List<PragaDTO> listaPragaDTO = listaPraga.stream().map(obj -> new PragaDTO(obj))
                .collect(Collectors.toList());
                
        return ResponseEntity.ok().body(listaPragaDTO);
    }

    @PostMapping
    public ResponseEntity<Praga> create(@Valid @RequestBody Praga obj) {
        obj = service.create(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<PragaDTO> update(@Valid @PathVariable Integer id, @RequestBody PragaDTO objDTO) {
        Praga newObj = service.update(id, objDTO);

        return ResponseEntity.ok().body(new PragaDTO(newObj));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete (@PathVariable Integer id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
