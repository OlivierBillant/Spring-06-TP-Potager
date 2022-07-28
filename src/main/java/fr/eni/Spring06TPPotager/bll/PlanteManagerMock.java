package fr.eni.Spring06TPPotager.bll;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.eni.Spring06TPPotager.bo.Plante;
import fr.eni.Spring06TPPotager.dal.PlanteDao;

@Component
public class PlanteManagerMock implements PlanteManager {
	@Autowired
	private PlanteDao planteDaoInst;

	@Override
	public void creerPlante(Plante plante) {
		planteDaoInst.save(plante);
	}

	@Override
	public void listerPlante() {
//		Création de liste de plantes
		ArrayList<Plante> listePlante = new ArrayList<Plante>();
		listePlante = (ArrayList<Plante>) planteDaoInst.findAll();
		for (int i = 0; i < listePlante.size(); i++) {
			Plante planteTemp = listePlante.get(i);
			System.out.println(planteTemp);
		}
	}

	@Override
	public ArrayList<Plante> getPlantes() {
		return (ArrayList<Plante>) planteDaoInst.findAll();
	}
}
