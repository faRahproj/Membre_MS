package com.example.demo.services;

import com.example.demo.entities.EnseignantChercheur;
import com.example.demo.entities.Etudiant;
import com.example.demo.entities.Membre;

import java.util.List;

public interface IMemberService {
    //Crud sur les membres
    public Membre addMember(Membre m);

    public void deleteMember(Long id);

    public Membre updateMember(Membre p);

    public Membre findMember(Long id);

    public List<Membre> findAll();

    //Filtrage par propriété
    public Membre findByCin(String cin);

    public Membre findByEmail(String email);

    public List<Membre> findByNom(String nom);

    //recherche spécifique des étudiants
    public List<Etudiant> findByDiplome(String diplome);

    //recherche spécifique des enseignants
    public List<EnseignantChercheur> findByGrade(String grade);

    public List<EnseignantChercheur> findByEtablissement(String etablissement);

    public Etudiant affecterEtudianttoEnseignant(Long idetd, Long idens);

    List<Etudiant> findEtudiantByEncadrant(Long idens);

//other ...
}