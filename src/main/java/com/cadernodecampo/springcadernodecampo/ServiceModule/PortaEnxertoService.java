package com.cadernodecampo.springcadernodecampo.ServiceModule;

import java.util.List;
import java.util.Optional;

import com.cadernodecampo.springcadernodecampo.DTOmodule.PortaEnxertoDTO;
import com.cadernodecampo.springcadernodecampo.DominioModule.PortaEnxerto;
import com.cadernodecampo.springcadernodecampo.ExceptionsModule.DataIntegrityViolation;
import com.cadernodecampo.springcadernodecampo.ExceptionsModule.ObjectNotFoundException;
import com.cadernodecampo.springcadernodecampo.RepositoryModule.PortaEnxertoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
public class PortaEnxertoService {
    
    @Autowired
    private PortaEnxertoRepository repository;

    public PortaEnxerto findById(Integer id){
        Optional<PortaEnxerto> obj = repository.findById(id);
        return obj.orElseThrow(()-> new ObjectNotFoundException("Objeto não encontrado! Id: " +id+", tipo: "+ PortaEnxerto.class.getName()));
    }

    public List<PortaEnxerto> findAll(){
        return repository.findAll();
    }

    public PortaEnxerto create (PortaEnxerto obj){
        obj.id = null;
        return repository.save(obj);
    }

    public PortaEnxerto update(Integer id, PortaEnxertoDTO objDTO){

        PortaEnxerto obj = findById(id);

        obj.nome = objDTO.nome;
        return repository.save(obj);
    }

    public void delete(Integer id) {
        this.findById(id);
        try {
            repository.deleteById(id); 
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityViolation("Porta enxerto não pode ser deletado! Possui pomares associados.");
        }
        
    }
}
