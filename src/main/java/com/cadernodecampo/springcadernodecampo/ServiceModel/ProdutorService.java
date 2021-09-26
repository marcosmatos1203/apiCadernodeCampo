package com.cadernodecampo.springcadernodecampo.ServiceModel;

import java.util.Optional;

import com.cadernodecampo.springcadernodecampo.DominioModel.Produtor;
import com.cadernodecampo.springcadernodecampo.Exceptions.ObjectNotFoundException;
import com.cadernodecampo.springcadernodecampo.RepositoryModel.ProdutorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutorService {

    @Autowired
    private ProdutorRepository produtorRepository;
    
    public Produtor findById(Integer id){
        Optional<Produtor> obj = produtorRepository.findById(id);
        return obj.orElseThrow(()-> new ObjectNotFoundException("Produtor não encontrado! Id: "+id+", tipo: "+Produtor.class.getName()));
    }
}
