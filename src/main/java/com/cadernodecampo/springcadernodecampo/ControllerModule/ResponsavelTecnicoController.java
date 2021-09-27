package com.cadernodecampo.springcadernodecampo.ControllerModule;
import com.cadernodecampo.springcadernodecampo.DominioModel.ResponsavelTecnico;
import com.cadernodecampo.springcadernodecampo.ServiceModel.ResponsavelTecnicoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    
}
