package fr.eni.Spring06TPPotager.ihm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.eni.Spring06TPPotager.bll.PlanteManager;

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
}
