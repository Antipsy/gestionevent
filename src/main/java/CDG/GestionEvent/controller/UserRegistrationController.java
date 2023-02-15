package CDG.GestionEvent.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import CDG.GestionEvent.dto.UserRegistrationDto;
import CDG.GestionEvent.service.GroupeService;
import CDG.GestionEvent.service.UserService;


@Controller
@RequestMapping("/registration")
public class UserRegistrationController {
	@Autowired
	private UserService userService;
	
	@Autowired
	private GroupeService groupeService;
	public UserRegistrationController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	@ModelAttribute("user")
    public UserRegistrationDto userRegistrationDto() {
        return new UserRegistrationDto();
    }
	
	@GetMapping
	public String showRegistrationForm(Model model) {
		model.addAttribute("listGroupes", groupeService.getAllGroupes());
		return "registration";
	}
	
	@PostMapping
	public String registerUserAccount(@ModelAttribute("user") UserRegistrationDto registrationDto) {
		userService.save(registrationDto);
		return "redirect:/registration?success";
	}
}