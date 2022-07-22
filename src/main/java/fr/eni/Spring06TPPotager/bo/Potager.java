package fr.eni.Spring06TPPotager.bo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
//@AllArgsConstructor
@Entity
public class Potager {
	@Id
	@GeneratedValue
	private Integer idPotager;
	private String localisation;
	private String nom;
	private Integer surface;
	private String ville;

//	@OneToMany(mappedBy = "potager")
//	private Set<Carre> listeCarre = new HashSet<Carre>();
	
	public Potager(String localisation, String nom, Integer surface, String ville) {
		super();
		this.localisation = localisation;
		this.nom = nom;
		this.surface = surface;
		this.ville = ville;
	}

	@Override
	public String toString() {
		return "Potager [localisation=" + localisation + ", nom=" + nom + ", surface=" + surface + ", ville=" + ville
				+ "]";
	}

}
