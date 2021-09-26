package com.cadernodecampo.springcadernodecampo;

import java.util.Arrays;

import com.cadernodecampo.springcadernodecampo.DominioModel.Pomar;
import com.cadernodecampo.springcadernodecampo.DominioModel.Produtor;
import com.cadernodecampo.springcadernodecampo.DominioModel.ResponsavelTecnico;
import com.cadernodecampo.springcadernodecampo.RepositoryModel.PomarRepository;
import com.cadernodecampo.springcadernodecampo.RepositoryModel.ProdutorRepository;
import com.cadernodecampo.springcadernodecampo.RepositoryModel.ResponsavelTecnicoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringcadernodecampoApplication implements CommandLineRunner {

	@Autowired
	private ProdutorRepository produtorRepository;
	@Autowired
	private PomarRepository pomarRepository;

	@Autowired
	private ResponsavelTecnicoRepository responsavelTecnicoRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringcadernodecampoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Produtor produtor1 = new Produtor((Integer) null, "Matheus", "Av das torres", "Guaruja", "Lages",
				"Santa Catarina", "88500000", "matheus@gmail.com", "32235678", "999235678");

		ResponsavelTecnico respTecnico1 = new ResponsavelTecnico((Integer) null,"Marcos", "Av Alvaro Neri dos Santos", "Bom Jesus",
				"Lages", "Santa Catarina", "88503397", "marcos@gmail.com", "322345128", "999231425");

		Pomar pomar1 = new Pomar((Integer) null,"pomar-01", "InicialPomar", "Guaruja", "São Joaquim", "Santa Catarina", "88500000",
				produtor1, respTecnico1);

		produtor1.getPomares().addAll(Arrays.asList(pomar1));
		respTecnico1.getPomares().addAll(Arrays.asList(pomar1));

		this.produtorRepository.saveAll(Arrays.asList(produtor1));
		this.responsavelTecnicoRepository.saveAll(Arrays.asList(respTecnico1));
		this.pomarRepository.saveAll(Arrays.asList(pomar1));

	}

}
