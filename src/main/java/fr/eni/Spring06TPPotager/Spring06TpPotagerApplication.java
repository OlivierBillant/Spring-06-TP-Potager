package fr.eni.Spring06TPPotager;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fr.eni.Spring06TPPotager.bll.CarreManager;
import fr.eni.Spring06TPPotager.bll.PlanteManager;
import fr.eni.Spring06TPPotager.bll.PotagerManager;
import fr.eni.Spring06TPPotager.bo.Carre;
import fr.eni.Spring06TPPotager.bo.Plante;
import fr.eni.Spring06TPPotager.bo.Potager;

@SpringBootApplication
public class Spring06TpPotagerApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Spring06TpPotagerApplication.class, args);
	}

	@Autowired
	private PotagerManager potagerManager;
	@Autowired
	private CarreManager carreManagerInst;
	@Autowired
	private PlanteManager planteManager;

	@Override
	public void run(String... args) throws Exception {

//		Création de potagers		
		Potager romainPotager = new Potager("ergue-armel", "Romain", 9, "Quimper");
		Potager phileasPotager = new Potager("Lesquidic", "Perron", 10, "Gouesnach");
//		Création de carrés
		Carre carre1 = new Carre("potagerPhileas", 1, "argileux", "ombre");
		Carre carre2 = new Carre("potagerPhileas", 1, "argileux", "ombre");
		Carre carre3 = new Carre("potagerPhileas", 1, "argileux", "ombre");
//		Création de plantes
		Plante plante1 = new Plante("rose", "fleur", "a piquant", "0,5");
		Plante plante2 = new Plante("lilas", "fleur", "douce", "0,3");
//		Vérification des BO
		System.out.println("-----------------------------------------------------");
		System.out.println("---------------VERIFICATION DES BO-------------------");
		System.out.println("-----------------------------------------------------");
		System.out.println(romainPotager);
		System.out.println(carre1);
		System.out.println(plante1);

//		Ajout en base de données Potager
		potagerManager.creerPotager(romainPotager);
		potagerManager.creerPotager(phileasPotager);
		System.out.println("");

//		Ajout en base de données Carrés
		carreManagerInst.creerCarre(carre1);
		carreManagerInst.creerCarre(carre2);
		carreManagerInst.creerCarre(carre3);
		System.out.println("");

//		Ajout en base de données Plante	
		planteManager.creerPlante(plante1);
		planteManager.creerPlante(plante2);

//  	Trouver et afficher la liste des potagers en base de données
		System.out.println("-----------------------------------------------------");
		System.out.println("----------Affichage des potagers en  BDD--------------");
		System.out.println("-----------------------------------------------------");
		potagerManager.listerPotagers();

//		Trouver et afficher la liste des carrés en base de données
		System.out.println("-----------------------------------------------------");
		System.out.println("------------Affichage des carres en BDD--------------");
		System.out.println("-----------------------------------------------------");
		carreManagerInst.listerCarre();

//		Trouver et afficher la liste des plantes en base de données
		System.out.println("-----------------------------------------------------");
		System.out.println("-----------Affichage des plantes en BDD--------------");
		System.out.println("-----------------------------------------------------");
		planteManager.listerPlante();
	}
}
