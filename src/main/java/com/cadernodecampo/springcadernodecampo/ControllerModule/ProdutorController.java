package com.cadernodecampo.springcadernodecampo.ControllerModule;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import com.cadernodecampo.springcadernodecampo.DTO.ProdutorDTO;
import com.cadernodecampo.springcadernodecampo.DominioModel.Produtor;
import com.cadernodecampo.springcadernodecampo.ServiceModel.ProdutorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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

    @GetMapping
    public ResponseEntity<List<ProdutorDTO>> findAll() {
        List<Produtor> listaProdutor = produtorService.findAll();
        List<ProdutorDTO> listaProdutorDTO = listaProdutor.stream().map(obj -> new ProdutorDTO(obj))
                .collect(Collectors.toList());
        return ResponseEntity.ok().body(listaProdutorDTO);
    }

    @PostMapping
    public ResponseEntity<Produtor> create(@RequestBody Produtor obj) {
        obj = produtorService.create(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
}
