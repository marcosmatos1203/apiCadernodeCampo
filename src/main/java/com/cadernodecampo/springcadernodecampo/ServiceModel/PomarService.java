package com.cadernodecampo.springcadernodecampo.ServiceModel;

import java.util.Optional;

import com.cadernodecampo.springcadernodecampo.DominioModel.Pomar;
import com.cadernodecampo.springcadernodecampo.Exceptions.ObjectNotFoundException;
import com.cadernodecampo.springcadernodecampo.RepositoryModel.PomarRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PomarService {

    @Autowired
    private PomarRepository repository;

    public Pomar findById(Integer id){
        Optional<Pomar> obj = repository.findById(id);
        return obj.orElseThrow(()-> new ObjectNotFoundException("Pomar não encontrado! Id: "+id+", tipo: "+Pomar.class.getName()));
    }
}
