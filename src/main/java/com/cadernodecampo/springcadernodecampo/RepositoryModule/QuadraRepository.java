package com.cadernodecampo.springcadernodecampo.RepositoryModule;

import java.util.List;

import com.cadernodecampo.springcadernodecampo.DominioModule.Quadra;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface QuadraRepository extends JpaRepository<Quadra,Integer>{
    @Query("select obj from Quadra obj where obj.pomar.id = :id_pomar")
    List<Quadra> findAllByProdutor(@Param(value =  "id_pomar") Integer id_pomar);
}
