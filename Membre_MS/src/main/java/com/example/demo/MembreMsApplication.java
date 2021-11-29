package com.example.demo;

import com.example.demo.entities.EnseignantChercheur;
import com.example.demo.entities.Etudiant;
import com.example.demo.entities.Membre;
import com.example.demo.repositories.MemberRepository;
import com.example.demo.services.IMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MembreMsApplication implements CommandLineRunner {
	@Autowired
	MemberRepository memberRepository;
	@Autowired
	IMemberService memberService;

	public static void main(String[] args) {
		SpringApplication.run(MembreMsApplication.class, args);

	}
	@Override
	public void run(String... args) throws Exception {
		Membre ens1 = new EnseignantChercheur();

		ens1.setNom("fricasse");ens1.setPrenom("habiba");ens1.setCin("14521562");
		memberRepository.save(ens1);

		Membre ens2 = new EnseignantChercheur();
		ens2.setNom("ma9roudh");ens2.setPrenom("samir");ens2.setCin("06251874");
		memberRepository.save(ens2);

		Membre etd1 = new Etudiant();
		etd1.setNom("bsisa");etd1.setPrenom("afchraf");etd1.setCin("14521621");
		memberService.affecterEtudianttoEnseignant(3L,1L);
		memberRepository.save(etd1);
		Membre etd2 = new Etudiant();
		etd2.setNom("mlewi");etd2.setPrenom("achraf");etd2.setCin("15422145");
		memberRepository.save(etd2);

	}

}
