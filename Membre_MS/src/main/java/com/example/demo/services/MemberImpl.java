package com.example.demo.services;

import com.example.demo.entities.EnseignantChercheur;
import com.example.demo.entities.Etudiant;
import com.example.demo.entities.Membre;
import com.example.demo.repositories.EnseignantChercheurRepository;
import com.example.demo.repositories.EtudiantRepository;
import com.example.demo.repositories.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberImpl implements IMemberService {

    @Autowired
    MemberRepository memberRepository;
    @Autowired
    EtudiantRepository etudiantRepository;
    @Autowired
    EnseignantChercheurRepository enseignantChercheurRepository ;

    @Override
    public Membre addMember(Membre m) {
        memberRepository.save(m);

        return m;
    }

    @Override
    public void deleteMember(Long id) {
        if(memberRepository.findById(id).get()!=null){
            memberRepository.deleteById(id);
        }
    }

    @Override
    public Membre updateMember(Membre m) {
        return memberRepository.saveAndFlush(m);
    }

    @Override
    public Membre findMember(Long id) {
        Membre m= (Membre)memberRepository.findById(id).get();
        return m;
    }

    @Override
    public List<Membre> findAll() {
        return memberRepository.findAll();
    }

    @Override
    public Membre findByCin(String cin) {
        return memberRepository.findByCin(cin);
    }

    @Override
    public Membre findByEmail(String email) {
        return memberRepository.findByEmail(email);
    }

    @Override
    public List<Membre> findByNom(String nom) {
        return memberRepository.findByNom(nom);
    }

    @Override
    public List<Etudiant> findByDiplome(String diplome) {
        return etudiantRepository.findByDiplome(diplome);
    }

    @Override
    public List<EnseignantChercheur> findByGrade(String grade) {
        return enseignantChercheurRepository.findByGrade(grade);
    }

    @Override
    public List<EnseignantChercheur> findByEtablissement(String etablissement) {
        return enseignantChercheurRepository.findByEtablissement(etablissement);
    }

    @Override
    public Etudiant affecterEtudianttoEnseignant(Long idetd, Long idens){
        Etudiant etd= etudiantRepository.findById(idetd).get();
        EnseignantChercheur ens = enseignantChercheurRepository.findById(idens).get();
        etd.setEncadrant(ens);
        return  etudiantRepository.save(etd);
    }

    @Override
    public List<Etudiant> findEtudiantByEncadrant(Long idens){
        EnseignantChercheur ens =enseignantChercheurRepository.findById(idens).get();
        return etudiantRepository.findByEncadrant(ens);
    }
}