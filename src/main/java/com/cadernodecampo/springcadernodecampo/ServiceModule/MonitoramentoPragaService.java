package com.cadernodecampo.springcadernodecampo.ServiceModule;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import com.cadernodecampo.springcadernodecampo.DTOmodule.MonitoramentoPragaDTO;
import com.cadernodecampo.springcadernodecampo.DominioModule.Cultivar;
import com.cadernodecampo.springcadernodecampo.DominioModule.MonitoramentoPraga;
import com.cadernodecampo.springcadernodecampo.ExceptionsModule.DataIntegrityViolation;
import com.cadernodecampo.springcadernodecampo.ExceptionsModule.ObjectNotFoundException;
import com.cadernodecampo.springcadernodecampo.RepositoryModule.MonitoramentoPragaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
public class MonitoramentoPragaService {
    
    @Autowired
    private MonitoramentoPragaRepository repository;

    public MonitoramentoPraga findById(Integer id){
        Optional<MonitoramentoPraga> obj = repository.findById(id);
        return obj.orElseThrow(()-> new ObjectNotFoundException("Objeto não encontrado! Id: " +id+", tipo: "+ Cultivar.class.getName()));
    }

    public List<MonitoramentoPraga> findAll(){
        List<MonitoramentoPraga> lista = new ArrayList<>(repository.findAll());
        lista.sort(new Comparator<MonitoramentoPraga>() {
            @Override
            public int compare(MonitoramentoPraga o1, MonitoramentoPraga o2) {
                return o1.data.compareTo(o2.data);
            }
        });
 
        return lista;
    }

    public MonitoramentoPraga create (MonitoramentoPraga obj){
        obj.id = null;
        return repository.save(obj);
    }

    public MonitoramentoPraga update(Integer id, MonitoramentoPragaDTO objDTO){

        MonitoramentoPraga obj = findById(id);

        obj.data = objDTO.data;
        return repository.save(obj);
    }

    public void delete(Integer id) {
        this.findById(id);
        try {
            repository.deleteById(id); 
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityViolation("Monitoramento Praga não pode ser deletado! Possui pomares associados.");
        }
    }
}
