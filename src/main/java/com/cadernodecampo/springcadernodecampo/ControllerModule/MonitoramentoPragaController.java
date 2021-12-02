package com.cadernodecampo.springcadernodecampo.ControllerModule;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;
import com.cadernodecampo.springcadernodecampo.DTOmodule.MonitoramentoPragaDTO;
import com.cadernodecampo.springcadernodecampo.DominioModule.MonitoramentoPraga;
import com.cadernodecampo.springcadernodecampo.ServiceModule.MonitoramentoPragaService;

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
@RequestMapping(value = "/monitoramentoPraga")
public class MonitoramentoPragaController {
    
    @Autowired
    private MonitoramentoPragaService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<MonitoramentoPraga> findById(@PathVariable Integer id){
        MonitoramentoPraga obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @GetMapping
    public ResponseEntity<List<MonitoramentoPragaDTO>> findAll() {

        List<MonitoramentoPraga> lista = service.findAll();
        List<MonitoramentoPragaDTO> listaDTO = lista.stream().map(obj -> new MonitoramentoPragaDTO(obj))
                .collect(Collectors.toList());
                
        return ResponseEntity.ok().body(listaDTO);
    }

    @PostMapping
    public ResponseEntity<MonitoramentoPraga> create(@Valid @RequestBody MonitoramentoPraga obj) {
        obj = service.create(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.id).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<MonitoramentoPragaDTO> update(@Valid @PathVariable Integer id, @RequestBody MonitoramentoPragaDTO objDTO) {
        MonitoramentoPraga newObj = service.update(id, objDTO);

        return ResponseEntity.ok().body(new MonitoramentoPragaDTO(newObj));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete (@PathVariable Integer id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
