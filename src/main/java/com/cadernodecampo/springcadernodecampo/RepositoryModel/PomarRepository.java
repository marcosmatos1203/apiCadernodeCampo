package com.cadernodecampo.springcadernodecampo.RepositoryModel;

import java.util.List;

import com.cadernodecampo.springcadernodecampo.DominioModel.Pomar;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PomarRepository extends JpaRepository<Pomar,Integer>{

    @Query("select obj from Pomar obj where obj.produtor.id = :id_produtor order by nome")
    List<Pomar> findAllByProdutor(@Param(value =  "id_produtor") Integer id_produtor);
    
}
