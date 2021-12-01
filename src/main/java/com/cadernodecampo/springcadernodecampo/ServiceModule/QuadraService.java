package com.cadernodecampo.springcadernodecampo.ServiceModule;

import java.util.List;
import java.util.Optional;

import com.cadernodecampo.springcadernodecampo.DTOmodule.QuadraDTO;
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
    //@Autowired
    //private ResponsavelTecnicoService respTecnicoService;


    public Quadra findById(Integer id) {
        Optional<Quadra> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + ", tipo: " + Quadra.class.getName()));
    }

    public List<Quadra> findAll(Integer id_pomar) {
        return repository.findAllByPomar(id_pomar);
    }

 //   public List<Pomar> findAllByRespTec(Integer id_respTecnico) {
   //     respTecnicoService.findById(id_respTecnico);
     //   return repository.findByRespTecnico(id_respTecnico);
  //  }

    public Quadra update(Integer id, QuadraDTO obj) {

        Quadra newObj = findById(id);

        newObj.setAnoPlantio(obj.getAnoPlantio());
        newObj.setDistanciaFilas(obj.getDistanciaFilas());
        newObj.setDistanciaPlantas(obj.getDistanciaPlantas());
        //newObj.setPomar(obj.getId_pomar());
        newObj.setQuantidadeColmeias(obj.getQuantidadeColmeias());

        return repository.save(newObj);
    }

    public Quadra create(Quadra obj) {
        obj.setId(null);
       // Produtor produtor = produtorService.findById(obj.getProdutor().getId());
       // obj.setProdutor(produtor);
        return repository.save(obj);
    }

    public void delete(Integer id) {
        this.findById(id);
        try {
            repository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityViolation("Quadra não pode ser deletado! Possui quadras associadas.");
        }
    }
}
