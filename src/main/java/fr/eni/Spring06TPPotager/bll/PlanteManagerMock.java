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
	public void creerPlante(Plante plante) throws PlanteException {
		addOrModPlante(plante);
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

	private void addOrModPlante(Plante plante) throws PlanteException {
		if ("Liere".equals(plante.getNom())) {
			throw new PlanteException("On ne plante pas de lière espèce de malade");
		}
		planteDaoInst.save(plante);
	}

	@Override
	public void supprimerUnePlanteId(Integer id) {
		planteDaoInst.deleteById(id);		
	}

	@Override
	public Plante getPlante(Integer id) {
		return planteDaoInst.findById(id).orElse(null);
	}
	
	
}
