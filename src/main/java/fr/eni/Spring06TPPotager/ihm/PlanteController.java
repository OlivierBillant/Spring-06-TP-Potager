package fr.eni.Spring06TPPotager.ihm;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import fr.eni.Spring06TPPotager.bll.PlanteException;
import fr.eni.Spring06TPPotager.bll.PlanteManager;
import fr.eni.Spring06TPPotager.bo.Plante;

@Controller
@RequestMapping("/plante")
public class PlanteController {

	@Autowired
	private PlanteManager planteManager;

	@GetMapping("")
	public String index(Model model) {
		model.addAttribute("list",planteManager.getPlantes());
		return "index";
	}
	
	@GetMapping("/add")
	public String iniAddForm(Plante plante, Model model) {
		return "add";
	}
	
	@PostMapping("/add")
	public String validAddForm(@Valid Plante plante, BindingResult errors, Model model) {
		if(errors.hasErrors()) {
			return "add";
		}
		try {
			planteManager.creerPlante(plante);
		} catch (PlanteException e) {
			errors.addError(new FieldError("plante","nom",e.getMessage()));
			return "add";
		}
		return "redirect:/plante";
	}
	
	@GetMapping("/del/{id}")
	public String delPlante(@PathVariable("id") Integer id, Model model) {
		planteManager.supprimerUnePlanteId(id);
		return "redirect:/plante";
	}
	
	@GetMapping("/mod/{id}")
	public String modPlante(@PathVariable("id") Integer id, Model model) {
		Plante plante = planteManager.getPlante(id);
		model.addAttribute("plante",plante);
		return "mod";
	}
	
	@PostMapping("/mod/{id}") 
	public String modeValidPlante(@PathVariable("id") Integer id,@Valid Plante plante, BindingResult errors, Model model) {
		if(errors.hasErrors()) {
			return "mod";
		}
		plante.setIdPlante(id);
		try {
			planteManager.creerPlante(plante);
		} catch (PlanteException e) {
			errors.addError(new FieldError("plante","nom",e.getMessage()));
			return "add";
		}
		return "redirect:/plante";
	}
}
