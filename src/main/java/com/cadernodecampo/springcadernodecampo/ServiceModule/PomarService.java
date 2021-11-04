package com.cadernodecampo.springcadernodecampo.ServiceModule;

import java.util.List;
import java.util.Optional;

import com.cadernodecampo.springcadernodecampo.DominioModule.Pomar;
import com.cadernodecampo.springcadernodecampo.DominioModule.Produtor;
import com.cadernodecampo.springcadernodecampo.ExceptionsModule.DataIntegrityViolation;
import com.cadernodecampo.springcadernodecampo.ExceptionsModule.ObjectNotFoundException;
import com.cadernodecampo.springcadernodecampo.RepositoryModule.PomarRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
public class PomarService {

    @Autowired
    private PomarRepository repository;
    @Autowired
    private ProdutorService produtorService;
    //@Autowired
    //private ResponsavelTecnicoService respTecnicoService;


    public Pomar findById(Integer id) {
        Optional<Pomar> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + ", tipo: " + Pomar.class.getName()));
    }

    public List<Pomar> findAll(Integer id_produtor) {
        produtorService.findById(id_produtor);
        return repository.findAllByProdutor(id_produtor);
    }

 //   public List<Pomar> findAllByRespTec(Integer id_respTecnico) {
   //     respTecnicoService.findById(id_respTecnico);
     //   return repository.findByRespTecnico(id_respTecnico);
  //  }

    public Pomar update(Integer id, Pomar obj) {
        Pomar newObj = findById(id);
        updateData(newObj, obj);
        return repository.save(newObj);
    }

    private void updateData(Pomar newObj, Pomar obj) {
        newObj.setNome(obj.getNome());
        newObj.setLogradouro(obj.getLogradouro());
        newObj.setBairro_localidade(obj.getBairro_localidade());
        newObj.setCidade(obj.getCidade());
        newObj.setEstado(obj.getEstado());
        newObj.setCep(obj.getCep());
        newObj.setProdutor(obj.getProdutor());
        newObj.setRespTecnico(obj.getRespTecnico());
    }

    public Pomar create(Pomar obj) {
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
            throw new DataIntegrityViolation("Pomar não pode ser deletado! Possui quadras associadas.");
        }
    }
}
