package com.cadernodecampo.springcadernodecampo.RepositoryModel;

import com.cadernodecampo.springcadernodecampo.DominioModel.Pomar;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PomarRepository extends JpaRepository<Pomar,Integer>{
    
}
