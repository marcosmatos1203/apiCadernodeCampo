package com.cadernodecampo.springcadernodecampo.ServiceModule;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import com.cadernodecampo.springcadernodecampo.DTOmodule.ResponsavelTecnicoDTO;
import com.cadernodecampo.springcadernodecampo.DominioModule.ResponsavelTecnico;
import com.cadernodecampo.springcadernodecampo.ExceptionsModule.DataIntegrityViolation;
import com.cadernodecampo.springcadernodecampo.ExceptionsModule.ObjectNotFoundException;
import com.cadernodecampo.springcadernodecampo.RepositoryModule.ResponsavelTecnicoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
public class ResponsavelTecnicoService {

    @Autowired
    private ResponsavelTecnicoRepository repository;

    public ResponsavelTecnico findById(Integer id){
        Optional<ResponsavelTecnico> obj = repository.findById(id);
        return obj.orElseThrow(()-> new ObjectNotFoundException("Objeto não encontrado! Id: " +id+", tipo: "+ ResponsavelTecnico.class.getName()));
    }

    public List<ResponsavelTecnico> findAll(){
        //return repository.findAll();
        
        //ordenando por nome
        List<ResponsavelTecnico> lista = new ArrayList<>(repository.findAll());
        lista.sort(new Comparator<ResponsavelTecnico>() {
            @Override
            public int compare(ResponsavelTecnico o1, ResponsavelTecnico o2) {
                return o1.getNome().compareTo(o2.getNome());
            }
        });

        return lista;
    }
    
    public ResponsavelTecnico create (ResponsavelTecnico obj){
        obj.setId(null);
        return repository.save(obj);

    }
    
    public ResponsavelTecnico update(Integer id, ResponsavelTecnicoDTO objDTO){

        ResponsavelTecnico obj = findById(id);

        obj.setNome(objDTO.getNome());
        obj.setLogradouro(objDTO.getLogradouro());
        obj.setBairro_localidade(objDTO.getBairro_localidade());
        obj.setCidade(objDTO.getCidade());
        obj.setEstado(objDTO.getEstado());
        obj.setCep(objDTO.getCep());
        obj.setEmail(objDTO.getEmail());
        obj.setTelefone1(objDTO.getTelefone1());
        obj.setTelefone2(objDTO.getTelefone2());
        obj.setCrea(objDTO.getCrea());

        return repository.save(obj);
    }

    public void delete(Integer id) {
        this.findById(id);
        try {
            repository.deleteById(id); 
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityViolation("Responsável técnico não pode ser deletado! Possui pomares associados.");
        }
    }
}
