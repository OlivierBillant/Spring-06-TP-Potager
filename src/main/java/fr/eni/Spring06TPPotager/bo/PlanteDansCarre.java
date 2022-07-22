package fr.eni.Spring06TPPotager.bo;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class PlanteDansCarre {
	@Id
	@GeneratedValue
	private Integer idPlanteDansCarre;

	@ManyToOne
	private Plante plante;

	@ManyToOne
	private Carre carre;

	private LocalDate datePlantation;
	private LocalDate dateRecolte;
	private Integer quantite;
	
	public PlanteDansCarre(LocalDate datePlantation, LocalDate dateRecolte, Integer quantite) {
		super();
		this.datePlantation = datePlantation;
		this.dateRecolte = dateRecolte;
		this.quantite = quantite;
	}
	
	

	
}
