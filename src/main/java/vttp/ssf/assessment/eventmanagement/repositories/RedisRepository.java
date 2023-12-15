package vttp.ssf.assessment.eventmanagement.repositories;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;

import vttp.ssf.assessment.eventmanagement.models.Event;

@Repository
public class RedisRepository {

	@Autowired @Qualifier("myredis")
	private RedisTemplate <String, String> template;
	private ValueOperations<String, Event> valueOperations;

	// for event date 
	// DateFormat df = new SimpleDateFormat("dd-MM-yyyy");

	// TODO: Task 2

	public void saveRecord(Event event) {
        ListOperations<String, String> list = template.opsForList();
        String formattedString = "%d,%s".formatted(event.getEventId(), event.getEventName());
        list.rightPush("events", formattedString);
    }

	// TODO: Task 3

	public long getNumberOfEvents() {
		ListOperations<String, String> list = template.opsForList();
		return list.size("eventName");
	}
	

	// TODO: Task 4

		public void getEvent(Integer index) {
			ListOperations<String, String> list = template.opsForList();
			List<String> eventList = list.range("events", 0, -1);
			if (index >= 0 && index < eventList.size()) {
				String event = eventList.get(index);
				System.out.println(event);
			}
			// return 

			
			
		}
}
