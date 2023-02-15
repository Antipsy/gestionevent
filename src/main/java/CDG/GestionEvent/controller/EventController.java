package CDG.GestionEvent.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import CDG.GestionEvent.model.Event;

import CDG.GestionEvent.service.EventService;



@Controller
public class EventController {
	@Autowired
	private EventService eventService;
	
	
	@GetMapping("/listEvent")
	public String viewHomePage(Model model) {
		model.addAttribute("listEvents", eventService.getAllEvents());
		
		return "listEvent";
	}
	
	@GetMapping("/addEvent")
	public String addEvent(Model model) {
		Event event = new Event();
		model.addAttribute("event", event);
		return "addEvent";
	}
	@RequestMapping(value={"/saveEvent"},method = RequestMethod.POST)
	public String saveEvent(@ModelAttribute("event") Event event) {
		
		eventService.saveEvent(event);
		return "redirect:/listEvent";
	}
	@GetMapping("/updateEvent/{id}")
	public String updateEvent(@PathVariable (value = "id") long id, Model model) {
		Event event = eventService.getEventById(id);
		
		model.addAttribute("event", event);
		
		
		return "updateEvent";
	}
	@GetMapping("/deleteEvent/{id}")
	public String deleteEvent(@PathVariable (value = "id") long id) {
		this.eventService.deleteEventById(id);
		return "redirect:/listEvent";
	}
}
