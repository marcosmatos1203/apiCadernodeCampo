package com.cadernodecampo.springcadernodecampo.RepositoryModule;

import java.util.List;
import java.util.Optional;

import com.cadernodecampo.springcadernodecampo.DominioModule.CultivarQuadra;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CultivarQuadraRepository extends JpaRepository<CultivarQuadra, Integer>{
    @Query("select obj from CultivarQuadra obj where obj.quadra.id = :id_quadra")
    List<CultivarQuadra> findAllByQuadra(@Param(value =  "id_quadra") Integer id_quadra);

    @Query("select obj from CultivarQuadra obj where obj.id = :id")
    Optional<CultivarQuadra> findByIdCultivarQuadra(@Param(value =  "id") Integer id);
}
