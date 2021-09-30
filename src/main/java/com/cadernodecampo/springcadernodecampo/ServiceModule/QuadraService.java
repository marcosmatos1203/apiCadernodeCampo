package com.cadernodecampo.springcadernodecampo.ServiceModule;

import java.util.List;
import java.util.Optional;

import com.cadernodecampo.springcadernodecampo.DominioModule.Pomar;
import com.cadernodecampo.springcadernodecampo.DominioModule.Quadra;
import com.cadernodecampo.springcadernodecampo.ExceptionsModule.DataIntegrityViolation;
import com.cadernodecampo.springcadernodecampo.ExceptionsModule.ObjectNotFoundException;
import com.cadernodecampo.springcadernodecampo.RepositoryModule.QuadraRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
public class QuadraService {

    @Autowired
    private QuadraRepository repository;
    @Autowired
    private PomarService pomarService;

    public Quadra findById(Integer id) {
        Optional<Quadra> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + ", tipo: " + Quadra.class.getName()));
    }

    public List<Quadra> findAll(Integer id_pomar) {
        pomarService.findById(id_pomar);
        return repository.findAllByProdutor(id_pomar);
    }

    public Quadra update(Integer id, Quadra obj) {
        Quadra newObj = findById(id);
        updateData(newObj, obj);
        return repository.save(newObj);
    }

    private void updateData(Quadra newObj, Quadra obj) {
        newObj.setAnoPlantio(obj.getAnoPlantio());
        newObj.setDistanciaFilas(obj.getDistanciaFilas());
        newObj.setDistanciaPlantas(obj.getDistanciaPlantas());
        newObj.setQuantidadeColmeias(obj.getQuantidadeColmeias());
        newObj.setPomar(obj.getPomar());
    }

    public Quadra create(Integer id_pomar, Quadra obj) {
        obj.setId(null);
        Pomar pomar = pomarService.findById(id_pomar);
        obj.setPomar(pomar);
        return repository.save(obj);
    }

    public void delete(Integer id) {
        this.findById(id);
        try {
            repository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityViolation("Quadra não pode ser deletada! Possui armadilha ou cultivo associadas.");
        }
    }
}
