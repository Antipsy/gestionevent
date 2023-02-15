package CDG.GestionEvent.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import CDG.GestionEvent.model.Groupe;
import CDG.GestionEvent.model.User;
import CDG.GestionEvent.service.GroupeService;
import CDG.GestionEvent.service.UserService;

@Controller
public class GroupeController{
	@Autowired
	private GroupeService groupeService;
	@Autowired
	private UserService userService;
	
	@GetMapping("/listGroupe")
	public String viewHomePage(Model model) {
		model.addAttribute("listGroupes", groupeService.getAllGroupes());
		model.addAttribute("listEmploye", userService.getUsersG());
		return "listGroupe";
	}
	
	@GetMapping("/addGroupe")
	public String addGroupe(Model model) {
		Groupe groupe = new Groupe();
		model.addAttribute("groupe", groupe);
		return "addGroupe";
	}
	@RequestMapping(value={"/saveGroupe"},method = RequestMethod.POST)
	public String saveGroupe(@ModelAttribute("groupe") Groupe groupe) {
		
		
		
		groupeService.saveGroupe(groupe);
		return "redirect:/listGroupe";
	}
	
	@GetMapping("/updateGroupe/{id}")
	public String updateGroupe(@PathVariable (value = "id") long id, Model model) {
		Groupe groupe = groupeService.getGroupeById(id);
		//model.addAttribute("listUsers", groupeService.getGroupeUsers(id));
		model.addAttribute("groupe", groupe);
	
		
		
		return "updateGroupe";
	}
	@GetMapping("/deleteGroupe/{id}")
	public String deleteGroupe(@PathVariable (value = "id") long id) {
		this.groupeService.deleteGroupeById(id);
		return "redirect:/";
	}
}
