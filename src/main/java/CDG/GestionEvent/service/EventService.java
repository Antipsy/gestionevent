package CDG.GestionEvent.service;

import java.util.List;

import CDG.GestionEvent.model.Event;


public interface EventService {
	Event getEventById(long id);
	List<Event> getAllEvents();
	void saveEvent(Event event);
	void deleteEventById(long id);
}
