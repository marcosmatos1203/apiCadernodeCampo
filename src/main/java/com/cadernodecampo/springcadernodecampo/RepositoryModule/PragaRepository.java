package com.cadernodecampo.springcadernodecampo.RepositoryModule;

import com.cadernodecampo.springcadernodecampo.DominioModule.Praga;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PragaRepository extends JpaRepository<Praga,Integer>{
    
}
