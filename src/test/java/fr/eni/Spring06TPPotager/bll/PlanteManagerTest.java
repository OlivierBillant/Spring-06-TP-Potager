package fr.eni.Spring06TPPotager.bll;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.util.ArrayList;
import javax.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import fr.eni.Spring06TPPotager.bo.Plante;

@SpringBootTest
class PlanteManagerTest {

	@Autowired
	PlanteManager planteManager;

	@Transactional
	@Test
	void ajouterPlanteTest() throws PlanteException {
		Plante plante1 = new Plante("Citron Caviar", "fleur", "a piquant", "0,5");
		Plante plante2 = new Plante("lilas", "fleur", "douce", "0,3");
		planteManager.creerPlante(plante2);
		ArrayList<Plante> planteListsTest = (ArrayList<Plante>) planteManager.getPlantes();
		Plante planteTest = planteListsTest.get(planteListsTest.size() - 1);
//		Plante planteTest = plante1;
//		System.out.println(planteTest.getNom());
		assertNotNull(planteTest);
	}

	@Transactional
	@Test
	void ajouterVehiculeCtCapacite() {
		Plante plante1 = new Plante("Liere", "fleur", "Satan", "0,5");
		assertThrows(PlanteException.class, () -> {
			planteManager.creerPlante(plante1);
		});
	}

	@Transactional
	@Test
	void afficherToutPlanteTest() throws PlanteException {
		Plante plante1 = new Plante("Citron Caviar", "fleur", "a piquant", "0,5");
		planteManager.creerPlante(plante1);
		assertEquals(3, planteManager.getPlantes().size());
	}
}
