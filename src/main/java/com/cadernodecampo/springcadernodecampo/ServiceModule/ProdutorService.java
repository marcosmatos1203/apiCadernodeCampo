package com.cadernodecampo.springcadernodecampo.ServiceModule;

import java.util.List;
import java.util.Optional;

import com.cadernodecampo.springcadernodecampo.DTOmodule.ProdutorDTO;
import com.cadernodecampo.springcadernodecampo.DominioModule.Produtor;
import com.cadernodecampo.springcadernodecampo.ExceptionsModule.DataIntegrityViolation;
import com.cadernodecampo.springcadernodecampo.ExceptionsModule.ObjectNotFoundException;
import com.cadernodecampo.springcadernodecampo.RepositoryModule.ProdutorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
public class ProdutorService {

    @Autowired
    private ProdutorRepository produtorRepository;
    
    public Produtor findById(Integer id){
        Optional<Produtor> obj = produtorRepository.findById(id);
        return obj.orElseThrow(()-> new ObjectNotFoundException("Objeto não encontrado! Id: "+id+", tipo: "+Produtor.class.getName()));
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
            throw new DataIntegrityViolation("Produtor não pode ser deletado! Possui pomares associados.");
        }
        
    }
}
