package fr.eni.Spring06TPPotager;

import java.util.ArrayList;

import org.omg.CORBA.PRIVATE_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fr.eni.Spring06TPPotager.bll.PotagerManager;
import fr.eni.Spring06TPPotager.bo.Carre;
import fr.eni.Spring06TPPotager.bo.Potager;
import fr.eni.Spring06TPPotager.dal.PotagerDao;

@SpringBootApplication
public class Spring06TpPotagerApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Spring06TpPotagerApplication.class, args);
	}

	@Autowired
	private PotagerManager potagerManager;

	@Override
	public void run(String... args) throws Exception {

//		Création de potagers		
		Potager romainPotager = new Potager("ergue-armel", "Romain", 9, "Quimper");
		Potager phileasPotager = new Potager("Lesquidic", "Perron", 10, "Gouesnach");
//		Création de carrés
		Carre carre1 = new Carre ("potagerPhileas", 1, "argileux", "ombre");
		
//		Vérification des BO
		System.out.println(romainPotager);
		System.out.println(carre1);

//		Ajout en base de données
		potagerManager.creerPotager(romainPotager);
		potagerManager.creerPotager(phileasPotager);
		System.out.println("");

//  	Trouver et afficher la liste des potagers en base de données
		System.out.println("Affichage FindAll");
		potagerManager.listerPotagers();

	
		
	}
}
