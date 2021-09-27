package com.cadernodecampo.springcadernodecampo.ServiceModel;

import java.util.List;
import java.util.Optional;

import com.cadernodecampo.springcadernodecampo.DTO.ProdutorDTO;
import com.cadernodecampo.springcadernodecampo.DominioModel.Produtor;
import com.cadernodecampo.springcadernodecampo.Exceptions.DataIntegrityViolation;
import com.cadernodecampo.springcadernodecampo.Exceptions.ObjectNotFoundException;
import com.cadernodecampo.springcadernodecampo.RepositoryModel.ProdutorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
public class ProdutorService {

    @Autowired
    private ProdutorRepository produtorRepository;
    
    public Produtor findById(Integer id){
        Optional<Produtor> obj = produtorRepository.findById(id);
        return obj.orElseThrow(()-> new ObjectNotFoundException("Produtor não encontrado! Id: "+id+", tipo: "+Produtor.class.getName()));
    }

    public List<Produtor> findAll(){
        return produtorRepository.findAll();
    }

    public Produtor create (Produtor obj){
        obj.setId(null);
        return produtorRepository.save(obj);

    }
    public Produtor update(Integer id, ProdutorDTO objDTO){

        Produtor obj = findById(id);

        obj.setNome(objDTO.getNome());
        obj.setLogradouro(objDTO.getLogradouro());
        obj.setBairro_localidade(objDTO.getBairro_localidade());
        obj.setCidade(objDTO.getCidade());
        obj.setEstado(objDTO.getEstado());
        obj.setCep(objDTO.getCep());
        obj.setEmail(objDTO.getEmail());
        obj.setTelefone1(objDTO.getTelefone1());
        obj.setTelefone2(obj.getTelefone2());

        return produtorRepository.save(obj);
    }

    public void delete(Integer id) {
        this.findById(id);
        try {
            produtorRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityViolation("Produtor não pode ser deletado! Possui pomares associados.")
        }
        
    }
}
