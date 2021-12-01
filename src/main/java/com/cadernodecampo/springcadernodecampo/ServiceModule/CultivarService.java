package com.cadernodecampo.springcadernodecampo.ServiceModule;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import com.cadernodecampo.springcadernodecampo.DTOmodule.CultivarDTO;
import com.cadernodecampo.springcadernodecampo.DominioModule.Cultivar;
import com.cadernodecampo.springcadernodecampo.ExceptionsModule.DataIntegrityViolation;
import com.cadernodecampo.springcadernodecampo.ExceptionsModule.ObjectNotFoundException;
import com.cadernodecampo.springcadernodecampo.RepositoryModule.CultivarRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
public class CultivarService {
    
    @Autowired
    private CultivarRepository repository;

    public Cultivar findById(Integer id){
        Optional<Cultivar> obj = repository.findById(id);
        return obj.orElseThrow(()-> new ObjectNotFoundException("Objeto não encontrado! Id: " +id+", tipo: "+ Cultivar.class.getName()));
    }

    public List<Cultivar> findAll(){
        List<Cultivar> lista = new ArrayList<>(repository.findAll());
        lista.sort(new Comparator<Cultivar>() {
            @Override
            public int compare(Cultivar o1, Cultivar o2) {
                return o1.nome.compareTo(o2.nome);
            }
        });
 
        return lista;
    }

    public Cultivar create (Cultivar obj){
        obj.id = null;
        return repository.save(obj);
    }

    public Cultivar update(Integer id, CultivarDTO objDTO){

        Cultivar obj = findById(id);

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
