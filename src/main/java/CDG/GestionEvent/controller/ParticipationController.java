package CDG.GestionEvent.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import CDG.GestionEvent.model.Participation;

import CDG.GestionEvent.service.ParticipationService;


@Controller
public class ParticipationController {
	
	@Autowired
	private ParticipationService participationService;
	@GetMapping("/listUserParticipation/{id}")
	public String viewHomePage(@PathVariable (value = "id") long id,Model model) {
		model.addAttribute("listParticipations", participationService.getParticipationById(id));
		
		return "listUserParticipation";
	}
	
	@GetMapping("/addParticipation")
	public String addParticipation(Model model) {
		Participation participation = new Participation();
		model.addAttribute("participation", participation);
		return "addParticipation";
	}
	@RequestMapping(value={"/saveParticipation"},method = RequestMethod.POST)
	public String saveParticipation(@ModelAttribute("participation") Participation participation) {
		
		participationService.saveParticipation(participation);
		return "redirect:/";
	}
	
	@GetMapping("/deleteParticipation/{id}")
	public String deleteParticipation(@PathVariable (value = "id") long id) {
		this.participationService.deleteParticipationById(id);
		return "redirect:/";
	}
}
