package vttp.ssf.assessment.eventmanagement.services;

import java.io.StringReader;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;
import jakarta.json.JsonValue;
import jakarta.validation.Path;
import vttp.ssf.assessment.eventmanagement.models.Event;

@Service
public class DatabaseService {
    
    // TODO: Task 1

    public List<Event> readFile(String fileName) {
        List<Event> events = new LinkedList<>();

        try {
            Path path = Path.get(getClass().getClassLoader().getResource("events.json").toURI());

        } catch (Exception e) {
            e.printStackTrace();
        }

        String fileDir = "/Users/ruthie/Desktop/codes/vttp2023-batch4-ssf-assessment";

        // cast json array to string
        String JsonString = ;

        // reader to read json string
        JsonReader reader = Json.createReader(new StringReader(fileDir));

        for(JsonValue val : reader.readArray()) {
            JsonObject obj = val.asJsonObject();
            Integer id = val.getInteger("eventId");
            String name = val.getString("eventName");
            Integer size = val.getInteger("eventSize");
            Integer date = val.getInteger("eventDate");
            Integer participants = val.getInteger("participants");

            events.add(new Event(id, name, size, date, participants));
        }

    

            events.size();

        return events;
    }
}
