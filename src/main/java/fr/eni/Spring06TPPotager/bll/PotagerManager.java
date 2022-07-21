package fr.eni.Spring06TPPotager.bll;

import java.util.ArrayList;

import fr.eni.Spring06TPPotager.bo.Potager;

public interface PotagerManager {
	public void creerPotager (Potager potager);
	public void listerPotagers ();
	public void trouverPotagerParVille ();
	
}
