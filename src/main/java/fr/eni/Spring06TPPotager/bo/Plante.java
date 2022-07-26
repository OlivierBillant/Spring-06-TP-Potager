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
public class Plante {
	@Id
	@GeneratedValue
	private Integer idPlante;
	private String nom;
	private String type;
	private String variete;
	private String surfaceOccuppee;
	public Plante(String nom, String type, String variete, String surfaceOccuppee) {
		super();
		this.nom = nom;
		this.type = type;
		this.variete = variete;
		this.surfaceOccuppee = surfaceOccuppee;
	}
	@Override
	public String toString() {
		return "Plante [nom=" + nom + ", type=" + type + ", variete=" + variete + ", surfaceOccuppee=" + surfaceOccuppee
				+ "]";
	}
	
	
	
}
