package vttp.ssf.assessment.eventmanagement.services;

import java.io.StringReader;
import java.util.List;

import org.springframework.stereotype.Service;

import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonReader;

import vttp.ssf.assessment.eventmanagement.models.Event;

@Service
public class DatabaseService {
    
    // TODO: Task 1

    public List<Event> readFile(String fileName) {
        
        String fileDir = "/Users/ruthie/Desktop/codes/vttp2023-batch4-ssf-assessment";
        JsonReader reader = Json.createReader(new StringReader(fileDir));
        JsonArray events = reader.readArray();

        return events.stream()
            .map(obj -> obj.asJsonObject())
            .map(val -> {
                Integer id = val.getInt("eventId");
                String name = val.getString("eventName");
                Integer size = val.getInt("eventSize");
                Integer date = val.getInt("eventDate");
                Integer participants = val.getInt("participants");
                return new Event(id, name, size, date, participants);
            })
            .toList();
            // events.size();
    }
}
