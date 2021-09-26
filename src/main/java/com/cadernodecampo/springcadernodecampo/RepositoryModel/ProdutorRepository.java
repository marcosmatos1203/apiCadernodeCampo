package com.cadernodecampo.springcadernodecampo.RepositoryModel;

import com.cadernodecampo.springcadernodecampo.DominioModel.Produtor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutorRepository extends JpaRepository<Produtor,Integer>{
    
}
