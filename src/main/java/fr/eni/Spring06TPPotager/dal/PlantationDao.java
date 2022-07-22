package fr.eni.Spring06TPPotager.dal;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import fr.eni.Spring06TPPotager.bo.Plantation;
import fr.eni.Spring06TPPotager.bo.Plante;
import fr.eni.Spring06TPPotager.bo.Potager;

public interface PlantationDao extends CrudRepository<Plantation, Integer>{

	@Query("SELECT p.plante FROM Plantation p WHERE p.carre.potager= :potager")
	ArrayList<Plante> plantesOfPotager(@Param("potager") Potager potager);
	
}
