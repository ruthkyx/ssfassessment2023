package vttp.ssf.assessment.eventmanagement.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import vttp.ssf.assessment.eventmanagement.repositories.RedisRepository;

@Controller
@RequestMapping("/")
public class EventController {

	//TODO: Task 5

	@Autowired 
	private RedisRepository redisRepo;

	@GetMapping
	public String displayEvents(){
		
		return "view0";
	}

}
