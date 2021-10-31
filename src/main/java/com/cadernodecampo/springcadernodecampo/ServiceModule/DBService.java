package com.cadernodecampo.springcadernodecampo.ServiceModule;

import java.util.Arrays;

import com.cadernodecampo.springcadernodecampo.DominioModule.Armadilha;
import com.cadernodecampo.springcadernodecampo.DominioModule.Cultivar;
import com.cadernodecampo.springcadernodecampo.DominioModule.CultivarQuadra;
import com.cadernodecampo.springcadernodecampo.DominioModule.Pomar;
import com.cadernodecampo.springcadernodecampo.DominioModule.PortaEnxerto;
import com.cadernodecampo.springcadernodecampo.DominioModule.Praga;
import com.cadernodecampo.springcadernodecampo.DominioModule.Produtor;
import com.cadernodecampo.springcadernodecampo.DominioModule.Quadra;
import com.cadernodecampo.springcadernodecampo.DominioModule.ResponsavelTecnico;
import com.cadernodecampo.springcadernodecampo.RepositoryModule.ArmadilhaRepository;
import com.cadernodecampo.springcadernodecampo.RepositoryModule.CultivarQuadraRepository;
import com.cadernodecampo.springcadernodecampo.RepositoryModule.CultivarRepository;
import com.cadernodecampo.springcadernodecampo.RepositoryModule.PomarRepository;
import com.cadernodecampo.springcadernodecampo.RepositoryModule.PortaEnxertoRepository;
import com.cadernodecampo.springcadernodecampo.RepositoryModule.PragaRepository;
import com.cadernodecampo.springcadernodecampo.RepositoryModule.ProdutorRepository;
import com.cadernodecampo.springcadernodecampo.RepositoryModule.QuadraRepository;
import com.cadernodecampo.springcadernodecampo.RepositoryModule.ResponsavelTecnicoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DBService {

        @Autowired
        private ProdutorRepository produtorRepository;

        @Autowired
        private PragaRepository pragaRepository;

        @Autowired
        private QuadraRepository quadraRepository;

        @Autowired
        private PomarRepository pomarRepository;

        @Autowired
        private ResponsavelTecnicoRepository responsavelTecnicoRepository;

        @Autowired
        private PortaEnxertoRepository portaEnxertoRepository;

        @Autowired
        private CultivarRepository cultivarRepository;

        @Autowired
        private CultivarQuadraRepository cultivarQuadraRepository;

        @Autowired
        private ArmadilhaRepository armadilhaRepository;
        
        public void InstanciaBaseDeDados() {

                Produtor produtor1 = new Produtor((Integer) null, "Matheus", "Av das torres", "Guaruja", "Lages",
                                "Santa Catarina", "88500000", "matheus@gmail.com", "32235678", "999235678");
                Produtor produtor2 = new Produtor((Integer) null, "Matheus", "Av das torres", "Guaruja", "Lages",
                                "Santa Catarina", "88500000", "matheus@gmail.com", "32235678", "999235678");

                ResponsavelTecnico respTecnico1 = new ResponsavelTecnico((Integer) null, "Marcos",
                                "Av Alvaro Neri dos Santos", "Bom Jesus", "Lages", "Santa Catarina", "88503397",
                                "marcos@gmail.com", "322345128", "999231425", "231213");

                ResponsavelTecnico respTecnico2 = new ResponsavelTecnico((Integer) null, "Marcos",
                                "Av Alvaro Neri dos Santos", "Bom Jesus", "Lages", "Santa Catarina", "88503397",
                                "marcos@gmail.com", "322345128", "999231425", "2131312");

                Pomar pomar1 = new Pomar((Integer) null, "pomar-01", "InicialPomar", "Guaruja", "São Joaquim",
                                "Santa Catarina", "88500000", produtor1, respTecnico1);
                Pomar pomar3 = new Pomar((Integer) null, "pomar-03", "TerceiroPomar", "Guaruja", "São Joaquim",
                                "Santa Catarina", "88500000", produtor2, respTecnico1);
                Pomar pomar4 = new Pomar((Integer) null, "pomar-04", "QuartoPomar", "Guaruja", "São Joaquim",
                                "Santa Catarina", "88500000", produtor2, respTecnico2);
                Pomar pomar5 = new Pomar((Integer) null, "pomar-05", "QuintoPomar", "Guaruja", "São Joaquim",
                                "Santa Catarina", "88500000", produtor1, respTecnico2);
                Pomar pomar2 = new Pomar((Integer) null, "pomar-02", "SegundoPomar", "Guaruja", "São Joaquim",
                                "Santa Catarina", "88500000", produtor2, respTecnico1);

                Quadra quadra1 = new Quadra((Integer)null,2021,2,1,5,pomar1);

                PortaEnxerto portaE = new PortaEnxerto((Integer)null, "porta enxerto 1");
                PortaEnxerto portaE2 = new PortaEnxerto((Integer)null, "porta enxerto 2");

                Cultivar cultivar = new Cultivar((Integer)null, "cultivar 1");
                
                CultivarQuadra cultivarQuadra = new CultivarQuadra((Integer)null, portaE, quadra1, cultivar, 2);
                CultivarQuadra cultivarQuadra2 = new CultivarQuadra((Integer)null, portaE2, quadra1, cultivar, 25);

                Praga praga1 = new Praga((Integer)null, "praga1");
                
                Armadilha armadilha1 = new Armadilha((Integer)null, 2.0, 2.1, "teste", quadra1);

                quadra1.cultivaresQuadra.addAll(Arrays.asList(cultivarQuadra));

                this.produtorRepository.saveAll(Arrays.asList(produtor1, produtor2));
                this.responsavelTecnicoRepository.saveAll(Arrays.asList(respTecnico1, respTecnico2));
                this.pomarRepository.saveAll(Arrays.asList(pomar1, pomar2, pomar3, pomar4, pomar5));
                this.quadraRepository.saveAll(Arrays.asList(quadra1));
                this.portaEnxertoRepository.saveAll(Arrays.asList(portaE, portaE2));
                this.cultivarRepository.saveAll(Arrays.asList(cultivar));
                this.cultivarQuadraRepository.saveAll(Arrays.asList(cultivarQuadra));
                this.cultivarQuadraRepository.saveAll(Arrays.asList(cultivarQuadra2));
                this.pragaRepository.saveAll(Arrays.asList(praga1));
                this.armadilhaRepository.saveAll(Arrays.asList(armadilha1));
        }
}
