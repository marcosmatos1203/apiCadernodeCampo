package com.cadernodecampo.springcadernodecampo.ServiceModule;

import java.util.List;
import java.util.Optional;

import com.cadernodecampo.springcadernodecampo.DominioModule.Armadilha;
import com.cadernodecampo.springcadernodecampo.ExceptionsModule.DataIntegrityViolation;
import com.cadernodecampo.springcadernodecampo.ExceptionsModule.ObjectNotFoundException;
import com.cadernodecampo.springcadernodecampo.RepositoryModule.ArmadilhaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
public class ArmadilhaService {
    
    @Autowired
    private ArmadilhaRepository repository;
    @Autowired
    private QuadraService quadraService;

    public Armadilha findById(Integer id) {
        Optional<Armadilha> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + ", tipo: " + Armadilha.class.getName()));
    }

    public List<Armadilha> findAll(Integer idQuadra) {
        quadraService.findById(idQuadra);
        return repository.findAllByQuadra(idQuadra);
    }

    
    public Armadilha update(Integer id, Armadilha obj) {
        Armadilha newObj = findById(id);
        updateData(newObj, obj);
        return repository.save(newObj);
    }

    private void updateData(Armadilha newObj, Armadilha obj) {
        newObj.latitude = obj.latitude;
        newObj.localizacaoTexto = obj.localizacaoTexto;
        newObj.longitude = obj.longitude;
    }

    public Armadilha create(Armadilha obj) {
        obj.id = null;
        return repository.save(obj);
    }

    public void delete(Integer id) {
        this.findById(id);
        try {
            repository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityViolation("Armadilha não pode ser deletado! Possui quadras associadas.");
        }
    }
}
