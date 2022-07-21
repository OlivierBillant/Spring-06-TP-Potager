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
public class Carre {
	@Id
	@GeneratedValue
	private Integer idCarre;
	private String potager;
	private Integer surface;
	private String typeDeSol;
	private	String typeDexposition;
	
	public Carre(String potager, Integer surface, String typeDeSol, String typeDexposition) {
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
