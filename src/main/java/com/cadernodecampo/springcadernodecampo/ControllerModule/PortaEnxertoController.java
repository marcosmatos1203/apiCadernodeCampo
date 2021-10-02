package com.cadernodecampo.springcadernodecampo.ControllerModule;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import com.cadernodecampo.springcadernodecampo.DTOmodule.PortaEnxertoDTO;
import com.cadernodecampo.springcadernodecampo.DominioModule.PortaEnxerto;
import com.cadernodecampo.springcadernodecampo.ServiceModule.PortaEnxertoService;

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
@RequestMapping(value = "/portaEnxerto")
public class PortaEnxertoController {

    @Autowired
    private PortaEnxertoService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<PortaEnxerto> findById(@PathVariable Integer id){
        PortaEnxerto obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @GetMapping
    public ResponseEntity<List<PortaEnxertoDTO>> findAll() {

        List<PortaEnxerto> listaResponsavelTecnico = service.findAll();
        List<PortaEnxertoDTO> listaResponsavelTecnicoDTO = listaResponsavelTecnico.stream().map(obj -> new PortaEnxertoDTO(obj))
                .collect(Collectors.toList());
                
        return ResponseEntity.ok().body(listaResponsavelTecnicoDTO);
    }

    @PostMapping
    public ResponseEntity<PortaEnxerto> create(@Valid @RequestBody PortaEnxerto obj) {
        obj = service.create(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.id).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<PortaEnxertoDTO> update(@Valid @PathVariable Integer id, @RequestBody PortaEnxertoDTO objDTO) {
        PortaEnxerto newObj = service.update(id, objDTO);

        return ResponseEntity.ok().body(new PortaEnxertoDTO(newObj));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete (@PathVariable Integer id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
