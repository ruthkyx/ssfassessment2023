package vttp.ssf.assessment.eventmanagement.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import vttp.ssf.assessment.eventmanagement.models.Event;
import vttp.ssf.assessment.eventmanagement.repositories.RedisRepository;

@Controller
@RequestMapping
public class EventController {

	//TODO: Task 5

	@Autowired 
	private RedisRepository redisRepo;

	@GetMapping({"event", "/"})
	public String displayEvents(Model model){

		return "view0";
	}

	@PostMapping("/event")
	public String registerEvent(@RequestParam("eventId") Integer eventId, Model model) {
		model.addAttribute("event", redisRepo.getEvent(eventId.intValue()));

		return "view1";
	}

}
