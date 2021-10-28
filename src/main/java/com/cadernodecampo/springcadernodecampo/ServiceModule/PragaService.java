package com.cadernodecampo.springcadernodecampo.ServiceModule;

import java.util.List;
import java.util.Optional;

import com.cadernodecampo.springcadernodecampo.DTOmodule.PragaDTO;
import com.cadernodecampo.springcadernodecampo.DominioModule.Praga;
import com.cadernodecampo.springcadernodecampo.ExceptionsModule.DataIntegrityViolation;
import com.cadernodecampo.springcadernodecampo.ExceptionsModule.ObjectNotFoundException;
import com.cadernodecampo.springcadernodecampo.RepositoryModule.PragaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
public class PragaService {
    
    @Autowired
    private PragaRepository repository;

    public Praga findById(Integer id) {
        Optional<Praga> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + ", tipo: " + Praga.class.getName()));
    }

    public List<Praga> findAll() {
        return repository.findAll();
    }

    public Praga create (Praga obj){
        obj.setId(null);
        return repository.save(obj);
    }

    public Praga update(Integer id, PragaDTO objDTO){

        Praga obj = findById(id);

        obj.setNome(objDTO.getNome());

        return repository.save(obj);
    }

    public void delete(Integer id) {
        this.findById(id);
        try {
            repository.deleteById(id); 
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityViolation("Praga não pode ser deletada!");
        }
    }
}
