package fr.eni.Spring06TPPotager.bll;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlanteException extends Exception {
	private String message;

}
