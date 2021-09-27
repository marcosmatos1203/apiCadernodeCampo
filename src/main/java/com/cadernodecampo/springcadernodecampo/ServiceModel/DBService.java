package com.cadernodecampo.springcadernodecampo.ServiceModel;

import java.util.Arrays;

import com.cadernodecampo.springcadernodecampo.DominioModel.Pomar;
import com.cadernodecampo.springcadernodecampo.DominioModel.Produtor;
import com.cadernodecampo.springcadernodecampo.DominioModel.ResponsavelTecnico;
import com.cadernodecampo.springcadernodecampo.RepositoryModel.PomarRepository;
import com.cadernodecampo.springcadernodecampo.RepositoryModel.ProdutorRepository;
import com.cadernodecampo.springcadernodecampo.RepositoryModel.ResponsavelTecnicoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DBService {

    @Autowired
    private ProdutorRepository produtorRepository;
    @Autowired
    private PomarRepository pomarRepository;

    @Autowired
    private ResponsavelTecnicoRepository responsavelTecnicoRepository;

    public void InstanciaBaseDeDados() {

        Produtor produtor1 = new Produtor((Integer) null, "Matheus", "Av das torres", "Guaruja", "Lages",
                "Santa Catarina", "88500000", "matheus@gmail.com", "32235678", "999235678");
        Produtor produtor2 = new Produtor((Integer) null, "Matheus", "Av das torres", "Guaruja", "Lages",
                "Santa Catarina", "88500000", "matheus@gmail.com", "32235678", "999235678");

        ResponsavelTecnico respTecnico1 = new ResponsavelTecnico((Integer) null, "Marcos", "Av Alvaro Neri dos Santos",
                "Bom Jesus", "Lages", "Santa Catarina", "88503397", "marcos@gmail.com", "322345128", "999231425");

        ResponsavelTecnico respTecnico2 = new ResponsavelTecnico((Integer) null, "Marcos", "Av Alvaro Neri dos Santos",
                "Bom Jesus", "Lages", "Santa Catarina", "88503397", "marcos@gmail.com", "322345128", "999231425");

        Pomar pomar1 = new Pomar((Integer) null, "pomar-01", "InicialPomar", "Guaruja", "São Joaquim", "Santa Catarina",
                "88500000", produtor1, respTecnico1);
        Pomar pomar3 = new Pomar((Integer) null, "pomar-03", "TerceiroPomar", "Guaruja", "São Joaquim", "Santa Catarina",
                "88500000", produtor2, respTecnico1);
        Pomar pomar4 = new Pomar((Integer) null, "pomar-04", "QuartoPomar", "Guaruja", "São Joaquim", "Santa Catarina",
                "88500000", produtor2, respTecnico2);
        Pomar pomar5 = new Pomar((Integer) null, "pomar-05", "QuintoPomar", "Guaruja", "São Joaquim", "Santa Catarina",
                "88500000", produtor1, respTecnico2);
        Pomar pomar2 = new Pomar((Integer) null, "pomar-02", "SegundoPomar", "Guaruja", "São Joaquim", "Santa Catarina",
                "88500000", produtor2, respTecnico1);

        produtor1.getPomares().addAll(Arrays.asList(pomar1));
        respTecnico1.getPomares().addAll(Arrays.asList(pomar1));

        this.produtorRepository.saveAll(Arrays.asList(produtor1, produtor2));
        this.responsavelTecnicoRepository.saveAll(Arrays.asList(respTecnico1, respTecnico2));
        this.pomarRepository.saveAll(Arrays.asList(pomar1,pomar2,pomar3,pomar4,pomar5));
    }

}