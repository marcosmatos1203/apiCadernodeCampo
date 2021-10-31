package com.cadernodecampo.springcadernodecampo.RepositoryModule;

import java.util.List;

import com.cadernodecampo.springcadernodecampo.DominioModule.Armadilha;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ArmadilhaRepository extends JpaRepository<Armadilha,Integer>{

    @Query("select obj from Armadilha obj where obj.quadra.id = :idQuadra order by latitude")
    List<Armadilha> findAllByProdutor(@Param(value =  "idQuadra") Integer idQuadra);
    
}
