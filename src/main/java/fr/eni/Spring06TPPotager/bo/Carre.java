package fr.eni.Spring06TPPotager.bo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
//@AllArgsConstructor
@Entity
public class Carre {
	@Id
	@GeneratedValue
	private Integer idCarre;
	private Integer surface;
	private String typeDeSol;
	private String typeDexposition;
	@ManyToOne
	private Potager potager;

	@ManyToMany
	private Set<Plante> listePlantes = new HashSet<Plante>();

	public Carre(Potager potager, Integer surface, String typeDeSol, String typeDexposition) {
		super();
		this.potager = potager;
		this.surface = surface;
		this.typeDeSol = typeDeSol;
		this.typeDexposition = typeDexposition;
	}

	@Override
	public String toString() {
		return "Carre [potager=" + potager + ", surface=" + surface + ", typeDeSol=" + typeDeSol + ", typeDexposition="
				+ typeDexposition + "]";
	}

}
