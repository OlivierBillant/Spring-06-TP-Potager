package fr.eni.Spring06TPPotager.bll;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.eni.Spring06TPPotager.bo.Carre;
import fr.eni.Spring06TPPotager.bo.Potager;
import fr.eni.Spring06TPPotager.dal.CarreDao;
@Component
public class CarreManagerMock implements CarreManager {
	@Autowired
	private CarreDao carreDaoInst;

	@Override
	public void creerCarre(Carre carre) {
		carreDaoInst.save(carre);
	}

	@Override
	public void listerCarre() {
//		Création de liste de carrés
		ArrayList<Carre> listeCarre = new ArrayList<Carre>();
		listeCarre = (ArrayList<Carre>) carreDaoInst.findAll();

//		Boucle pour afficher liste de carrés
		for (int i = 0; i < listeCarre.size(); i++) {
			Carre carreTemp = listeCarre.get(i);
			System.out.println(carreTemp);
		}
		
	}

	@Override
	public void trouverCarreParPotager() {
		// TODO Auto-generated method stub

	}
}
