package com.cadernodecampo.springcadernodecampo.RepositoryModule;
import com.cadernodecampo.springcadernodecampo.DominioModule.MonitoramentoPraga;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MonitoramentoPragaRepository extends JpaRepository<MonitoramentoPraga,Integer>{
    
}
