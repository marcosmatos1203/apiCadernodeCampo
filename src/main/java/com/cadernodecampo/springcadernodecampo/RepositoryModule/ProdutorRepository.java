package com.cadernodecampo.springcadernodecampo.RepositoryModule;

import com.cadernodecampo.springcadernodecampo.DominioModule.Produtor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutorRepository extends JpaRepository<Produtor,Integer>{
    
}
