package fr.eni.Spring06TPPotager.dal;

import org.springframework.data.repository.CrudRepository;

import fr.eni.Spring06TPPotager.bo.Plante;

public interface PlanteDao extends CrudRepository<Plante, Integer> {

}
