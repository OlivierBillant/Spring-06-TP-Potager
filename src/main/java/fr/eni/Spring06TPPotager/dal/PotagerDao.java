package fr.eni.Spring06TPPotager.dal;

import org.springframework.data.repository.CrudRepository;

import fr.eni.Spring06TPPotager.bo.Potager;

public interface PotagerDao extends CrudRepository<Potager, Integer>  {

}
