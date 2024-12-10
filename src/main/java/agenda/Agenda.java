package agenda;

import java.time.LocalDate;
import java.util.*;

/**
 * Description : An agenda that stores events
 */
public class Agenda {
    // Liste des événements dans l'agenda
    private List<Event> events;

    // Constructeur : initialise la liste des événements
    public Agenda() {
        this.events = new ArrayList<>();
    }

    /**
     * Adds an event to this agenda
     *
     * @param e the event to add
     */
    public void addEvent(Event e) {
        events.add(e);  // Ajoute l'événement à la liste des événements
    }

    /**
     * Computes the events that occur on a given day
     *
     * @param day the day to test
     * @return a list of events that occur on that day
     */
    public List<Event> eventsInDay(LocalDate day) {
        List<Event> eventsOnDay = new ArrayList<>();
        for (Event e : events) {
            if (e.isInDay(day)) {  // Vérifie si l'événement a lieu ce jour-là
                eventsOnDay.add(e);
            }
        }
        return eventsOnDay;  // Retourne la liste des événements qui ont lieu ce jour-là
    }
}
