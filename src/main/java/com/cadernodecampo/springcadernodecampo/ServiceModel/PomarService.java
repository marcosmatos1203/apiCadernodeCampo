package com.cadernodecampo.springcadernodecampo.ServiceModel;

import java.util.List;
import java.util.Optional;

import com.cadernodecampo.springcadernodecampo.DominioModel.Pomar;
import com.cadernodecampo.springcadernodecampo.DominioModel.Produtor;
import com.cadernodecampo.springcadernodecampo.Exceptions.ObjectNotFoundException;
import com.cadernodecampo.springcadernodecampo.RepositoryModel.PomarRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PomarService {

    @Autowired
    private PomarRepository repository;
    @Autowired
    private ProdutorService produtorService;

    public Pomar findById(Integer id_produtor) {
        Optional<Pomar> obj = repository.findById(id_produtor);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Pomar não encontrado! Id: " + id_produtor + ", tipo: " + Pomar.class.getName()));
    }

    public List<Pomar> findAll(Integer id_produtor) {
        produtorService.findById(id_produtor);
        return repository.findAllByProdutor(id_produtor);
    }

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

    public Pomar create(Integer id_produtor, Pomar obj) {
        obj.setId(null);
        Produtor produtor = produtorService.findById(id_produtor);
        obj.setProdutor(produtor);
        return repository.save(obj);
    }

    public void delete(Integer id) {
        Pomar obj = findById(id);
        repository.delete(obj);
    }
}
