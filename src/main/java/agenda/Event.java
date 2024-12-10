package agenda;

import java.time.*;
import java.util.ArrayList;
import java.util.List;
import java.lang.String;
import java.time.temporal.ChronoUnit;

public class Event {

    /**
     * The myTitle of this event
     */
    public String myTitle;

    /**
     * The starting time of the event
     */
    protected LocalDateTime myStart;

    /**
     * The duration of the event
     */
    private Duration myDuration;

    protected List<LocalDate> myExceptions;  // Liste des dates d'exception (quand l'événement ne se produit pas)

    private Repetition myRepetition;  // Répétition de l'événement

    /**
     * Constructs an event
     *
     * @param title the title of this event
     * @param start the start time of this event
     * @param duration the duration of this event
     */
    public Event(String title, LocalDateTime start, Duration duration) {
        this.myTitle = title;
        this.myStart = start;
        this.myDuration = duration;
        this.myExceptions = new ArrayList<>();
    }

    public void setRepetition(ChronoUnit frequency) {
        // Crée un objet Repetition avec un titre, une date de début et une durée
        myRepetition = new Repetition(myTitle, myStart, myDuration, frequency);
    }

    // Méthode pour ajouter une exception (date où l'événement ne doit pas avoir lieu)
    public void addException(LocalDate date) {
        if (!myExceptions.contains(date)) {
            myExceptions.add(date);  // Ajoute la date à la liste des exceptions si elle n'existe pas déjà
        }
    }

    public void setTermination(LocalDate terminationInclusive) {
        // TODO : implémenter cette méthode
        throw new UnsupportedOperationException("Pas encore implémenté");
    }

    public void setTermination(long numberOfOccurrences) {
        // TODO : implémenter cette méthode
        throw new UnsupportedOperationException("Pas encore implémenté");
    }

    public int getNumberOfOccurrences() {
        // TODO : implémenter cette méthode
        throw new UnsupportedOperationException("Pas encore implémenté");
    }

    public LocalDate getTerminationDate() {
        // TODO : implémenter cette méthode
        throw new UnsupportedOperationException("Pas encore implémenté");
    }



    /**
     * Tests if an event occurs on a given day
     *
     * @param aDay the day to test
     * @return true if the event occurs on that day, false otherwise
     */
    // Vérifie si l'événement a lieu un jour donné
    public boolean isInDay(LocalDate aDay) {
        // Si la date est dans les exceptions, retourne false
        if (myExceptions.contains(aDay)) return false;

        LocalDate eventStartDate = myStart.toLocalDate();

        // Si l'événement commence ce jour-là
        if (aDay.isEqual(eventStartDate)) {
            return true;
        }

        // Si l'événement se répète en fonction de la fréquence (par exemple, chaque jour, chaque semaine, etc.)
        if (myRepetition != null) {
            long daysBetween = ChronoUnit.DAYS.between(eventStartDate, aDay);
            if (daysBetween >= 0 && daysBetween % myRepetition.getFrequency().getDuration().toDays() == 0) {
                return true;  // L'événement se produit ce jour-là en fonction de la répétition
            }
        }

        return false;  // L'événement ne se produit pas ce jour-là
    }

    /**
     * @return the myTitle
     */
    public String getTitle() {
        return myTitle;
    }

    /**
     * @return the myStart
     */
    public LocalDateTime getStart() {
        return myStart;
    }


    /**
     * @return the myDuration
     */
    public Duration getDuration() {
        return myDuration;
    }

    @Override
    public String toString() {
        return "Event{title='%s', start=%s, duration=%s}".formatted(myTitle, myStart, myDuration);
    }
}
