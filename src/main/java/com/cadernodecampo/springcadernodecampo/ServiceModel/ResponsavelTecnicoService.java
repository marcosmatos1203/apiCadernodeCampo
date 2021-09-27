package com.cadernodecampo.springcadernodecampo.ServiceModel;

import java.util.List;
import java.util.Optional;

import com.cadernodecampo.springcadernodecampo.DominioModel.ResponsavelTecnico;
import com.cadernodecampo.springcadernodecampo.Exceptions.ObjectNotFoundException;
import com.cadernodecampo.springcadernodecampo.RepositoryModel.ResponsavelTecnicoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResponsavelTecnicoService {

    @Autowired
    private ResponsavelTecnicoRepository repository;

    public ResponsavelTecnico findById(Integer id){
        Optional<ResponsavelTecnico> obj = repository.findById(id);
        return obj.orElseThrow(()-> new ObjectNotFoundException("Responsável Técnico não encontrado! Id: " +id+", tipo: "+ ResponsavelTecnico.class.getName()));
    }
    public List<ResponsavelTecnico> findAll(){
        return repository.findAll();
    }
    
}
