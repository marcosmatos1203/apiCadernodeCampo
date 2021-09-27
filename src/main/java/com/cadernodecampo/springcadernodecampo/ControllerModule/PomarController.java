package com.cadernodecampo.springcadernodecampo.ControllerModule;

import java.util.List;
import java.util.stream.Collectors;

import com.cadernodecampo.springcadernodecampo.DTO.PomarDTO;
import com.cadernodecampo.springcadernodecampo.DominioModel.Pomar;
import com.cadernodecampo.springcadernodecampo.ServiceModel.PomarService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
            @RequestParam(value = "produtor", defaultValue = "0") Integer idprod) {
        List<Pomar> listaPomar = service.findAll(idprod);
        List<PomarDTO> listaPomarDTO = listaPomar.stream().map(obj -> new PomarDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listaPomarDTO);
    }

    @PutMapping(value = "/id")
    public ResponseEntity<Pomar> update(@PathVariable Integer id, @RequestBody Pomar obj) {
        Pomar newObj = service.update(id, obj);
        return ResponseEntity.ok().body(newObj);
    }
    @PatchMapping(value = "/id")
    public ResponseEntity<Pomar> updatePatch(@PathVariable Integer id, @RequestBody Pomar obj) {
        Pomar newObj = service.update(id, obj);
        return ResponseEntity.ok().body(newObj);
    }
}
