package vttp.ssf.assessment.eventmanagement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import vttp.ssf.assessment.eventmanagement.models.Event;
import vttp.ssf.assessment.eventmanagement.services.DatabaseService;

@SpringBootApplication
public class EventmanagementApplication implements CommandLineRunner{

	// TODO: Task 1

	@Autowired
	private DatabaseService databaseSvc;

	String fileDir = "/Users/ruthie/Desktop/codes/vttp2023-batch4-ssf-assessment";

	public static void main(String[] args) {
		SpringApplication.run(EventmanagementApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		List<Event> events = databaseSvc.readFile(fileDir);
		System.out.printf("events: %s\n", events);
	}


}
