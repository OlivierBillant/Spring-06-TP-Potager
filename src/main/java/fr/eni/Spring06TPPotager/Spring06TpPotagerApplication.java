package fr.eni.Spring06TPPotager;

import java.util.ArrayList;

import org.omg.CORBA.PRIVATE_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fr.eni.Spring06TPPotager.bo.Potager;
import fr.eni.Spring06TPPotager.dal.PotagerDao;

@SpringBootApplication
public class Spring06TpPotagerApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Spring06TpPotagerApplication.class, args);
	}

	@Autowired
	private PotagerDao potagerDao;

	@Override
	public void run(String... args) throws Exception {
		Potager romainPotager = new Potager("ergue-armel", "Romain", 9, "Quimper");
		Potager phileasPotager = new Potager("Lesquidic", "Perron", 10, "Gouesnach");

		System.out.println(romainPotager);

//		Ajout en base de données
		potagerDao.save(romainPotager);
		potagerDao.save(phileasPotager);
		System.out.println("");
		System.out.println("Affichage" + " FindAll");
		
//		OneLiner foreach()
		potagerDao.findAll().forEach(System.out::println);

		ArrayList<Potager> listePotagers = (ArrayList<Potager>) potagerDao.findAll();
//		Foreach() classique
		for (Potager potagerTemp : listePotagers) {
			System.out.println(potagerTemp);
		}
		
//		For loop
		for (int i = 0; i < listePotagers.size();i++) {
			Potager potagerTemp = listePotagers.get(i);
			System.out.println(potagerTemp);
		}
	}

}
