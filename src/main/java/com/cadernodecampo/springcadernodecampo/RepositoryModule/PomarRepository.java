package com.cadernodecampo.springcadernodecampo.RepositoryModule;

import java.util.List;

import com.cadernodecampo.springcadernodecampo.DominioModule.Pomar;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PomarRepository extends JpaRepository<Pomar,Integer>{

    @Query("select obj from Pomar obj where obj.produtor.id = :id_produtor order by nome")
    List<Pomar> findAllByProdutor(@Param(value =  "id_produtor") Integer id_produtor);
    

   // @Query("select obj from Pomar obj where obj.respTecnico.id = :id_respTecnico order by nome")
   // List<Pomar> findByRespTecnico(@Param(value =  "id_respTecnico") Integer id_respTecnico);
}
