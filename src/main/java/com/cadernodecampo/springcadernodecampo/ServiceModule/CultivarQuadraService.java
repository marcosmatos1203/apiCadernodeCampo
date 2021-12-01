package com.cadernodecampo.springcadernodecampo.ServiceModule;

import java.util.List;
import java.util.Optional;

import com.cadernodecampo.springcadernodecampo.DominioModule.CultivarQuadra;
import com.cadernodecampo.springcadernodecampo.ExceptionsModule.DataIntegrityViolation;
import com.cadernodecampo.springcadernodecampo.ExceptionsModule.ObjectNotFoundException;
import com.cadernodecampo.springcadernodecampo.RepositoryModule.CultivarQuadraRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
public class CultivarQuadraService {
    @Autowired
    private CultivarQuadraRepository repository;
    @Autowired
    private QuadraService quadraService;

    public CultivarQuadra findById(Integer id) {
        Optional<CultivarQuadra> obj = repository.findByIdCultivarQuadra(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + ", tipo: " + CultivarQuadra.class.getName()));
    }

    public List<CultivarQuadra> findAll(Integer id_quadra) {
        quadraService.findById(id_quadra);
        return repository.findAllByQuadra(id_quadra);
    }

    public CultivarQuadra update(Integer id, CultivarQuadra obj) {
        CultivarQuadra newObj = findById(id);
        updateData(newObj, obj);
        return repository.save(newObj);
    }

    private void updateData(CultivarQuadra newObj, CultivarQuadra obj) {
        newObj.cultivar = obj.cultivar;
        newObj.enxerto = obj.enxerto;
        newObj.quadra = obj.quadra;
        newObj.quantidade = obj.quantidade;
    }

    public CultivarQuadra create(CultivarQuadra obj) {
        obj.id = null;
        return repository.save(obj);
    }

    public void delete(Integer id) {
        this.findById(id);
        try {
            repository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityViolation("Cultivar da quadra não pode ser deletada! Possui quadras associadas.");
        }
    }
}
