
package com.cadernodecampo.springcadernodecampo.RepositoryModule;

import com.cadernodecampo.springcadernodecampo.DominioModule.PortaEnxerto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PortaEnxertoRepository extends JpaRepository<PortaEnxerto,Integer>{
    
}
