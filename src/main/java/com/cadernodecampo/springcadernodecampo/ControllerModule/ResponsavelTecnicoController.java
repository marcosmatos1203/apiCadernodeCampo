package com.cadernodecampo.springcadernodecampo.ControllerModule;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import com.cadernodecampo.springcadernodecampo.DTO.ResponsavelTecnicoDTO;
import com.cadernodecampo.springcadernodecampo.DominioModel.ResponsavelTecnico;
import com.cadernodecampo.springcadernodecampo.ServiceModel.ResponsavelTecnicoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping(value = "/respTecnico")
public class ResponsavelTecnicoController {

    @Autowired
    private ResponsavelTecnicoService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<ResponsavelTecnico> findById(@PathVariable Integer id){
        ResponsavelTecnico obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }
    @GetMapping
    public ResponseEntity<List<ResponsavelTecnicoDTO>> findAll() {

        List<ResponsavelTecnico> listaResponsavelTecnico = service.findAll();
        List<ResponsavelTecnicoDTO> listaResponsavelTecnicoDTO = listaResponsavelTecnico.stream().map(obj -> new ResponsavelTecnicoDTO(obj))
                .collect(Collectors.toList());
                
        return ResponseEntity.ok().body(listaResponsavelTecnicoDTO);
    }
    @PostMapping
    public ResponseEntity<ResponsavelTecnico> create(@Valid @RequestBody ResponsavelTecnico obj) {
        obj = service.create(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<ResponsavelTecnicoDTO> update(@Valid @PathVariable Integer id, @RequestBody ResponsavelTecnicoDTO objDTO) {
        ResponsavelTecnico newObj = service.update(id, objDTO);

        return ResponseEntity.ok().body(new ResponsavelTecnicoDTO(newObj));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete (@PathVariable Integer id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
