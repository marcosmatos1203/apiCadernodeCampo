package com.cadernodecampo.springcadernodecampo.ControllerModule;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import com.cadernodecampo.springcadernodecampo.DTOmodule.CultivarDTO;
import com.cadernodecampo.springcadernodecampo.DominioModule.Cultivar;
import com.cadernodecampo.springcadernodecampo.ServiceModule.CultivarService;

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
@RequestMapping(value = "/cultivar")
public class CultivarController {
    
    @Autowired
    private CultivarService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Cultivar> findById(@PathVariable Integer id){
        Cultivar obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @GetMapping
    public ResponseEntity<List<CultivarDTO>> findAll() {

        List<Cultivar> listaResponsavelTecnico = service.findAll();
        List<CultivarDTO> listaResponsavelTecnicoDTO = listaResponsavelTecnico.stream().map(obj -> new CultivarDTO(obj))
                .collect(Collectors.toList());
                
        return ResponseEntity.ok().body(listaResponsavelTecnicoDTO);
    }

    @PostMapping
    public ResponseEntity<Cultivar> create(@Valid @RequestBody Cultivar obj) {
        obj = service.create(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.id).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<CultivarDTO> update(@Valid @PathVariable Integer id, @RequestBody CultivarDTO objDTO) {
        Cultivar newObj = service.update(id, objDTO);

        return ResponseEntity.ok().body(new CultivarDTO(newObj));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete (@PathVariable Integer id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
