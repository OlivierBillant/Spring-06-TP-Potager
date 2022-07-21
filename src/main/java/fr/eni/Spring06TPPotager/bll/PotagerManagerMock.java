package fr.eni.Spring06TPPotager.bll;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.eni.Spring06TPPotager.bo.Potager;
import fr.eni.Spring06TPPotager.dal.PotagerDao;
@Component
public class PotagerManagerMock implements PotagerManager {

	@Autowired
	private PotagerDao potagerDao;
	
	@Override
	public void creerPotager(Potager potager) {
		potagerDao.save(potager);
	}

	@Override
	public void listerPotagers() {
		
		// OneLiner foreach()
		potagerDao.findAll().forEach(System.out::println);

//		ArrayList<Potager> listePotagers = (ArrayList<Potager>) potagerDao.findAll();
////		Foreach() classique
//		// for (Potager potagerTemp : listePotagers) {
//			System.out.println(potagerTemp);
//		}
//		
////		For loop
//		for (int i = 0; i < listePotagers.size();i++) {
//			Potager potagerTemp = listePotagers.get(i);
//			System.out.println(potagerTemp);
	}

	@Override
	public void trouverPotagerParVille() {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
