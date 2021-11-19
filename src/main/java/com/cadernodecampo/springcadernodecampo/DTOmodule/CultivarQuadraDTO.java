package com.cadernodecampo.springcadernodecampo.DTOmodule;

import java.io.Serializable;

import com.cadernodecampo.springcadernodecampo.DominioModule.Cultivar;
import com.cadernodecampo.springcadernodecampo.DominioModule.CultivarQuadra;
import com.cadernodecampo.springcadernodecampo.DominioModule.PortaEnxerto;
import com.cadernodecampo.springcadernodecampo.DominioModule.Quadra;

public class CultivarQuadraDTO implements Serializable {
    
    private static final long serialVersionUID = 1L;

    private Integer id;

    public PortaEnxerto enxerto;

    private Quadra quadra;

    public Cultivar cultivar;

    public Integer quantidade;

    public CultivarQuadraDTO(CultivarQuadra obj) {
        this.id = obj.id;
        this.cultivar = obj.cultivar;
        this.enxerto = obj.enxerto;
        this.quadra = obj.quadra;
        this.quantidade = obj.quantidade;
    }

}
