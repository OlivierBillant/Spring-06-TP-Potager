package fr.eni.Spring06TPPotager.bll;

import java.util.ArrayList;

import fr.eni.Spring06TPPotager.bo.Carre;
import fr.eni.Spring06TPPotager.bo.Plante;

public interface PlanteManager {
	public void creerPlante (Plante plante) throws PlanteException;
	public void listerPlante ();
	public ArrayList<Plante> getPlantes();
	public void supprimerUnePlanteId(Integer id);
	public Plante getPlante(Integer id);
}
