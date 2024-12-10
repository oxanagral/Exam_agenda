package agenda;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class Repetition extends Event {

    /**
     * Stores the frequency of this repetition, one of :
     * <UL>
     * <LI>ChronoUnit.DAYS for daily repetitions</LI>
     * <LI>ChronoUnit.WEEKS for weekly repetitions</LI>
     * <LI>ChronoUnit.MONTHS for monthly repetitions</LI>
     * </UL>
     */
    private ChronoUnit myFrequency;

    public Repetition(String title, LocalDateTime start, Duration duration, ChronoUnit frequency) {
        super(title, start, duration);  // Passe les paramètres au constructeur de Event
        this.myFrequency = frequency;
    }

    public ChronoUnit getFrequency() {
        return myFrequency;
    }


    /**
     * Les exceptions à la répétition
     * @param date une date à laquelle l'événement ne doit pas se répéter
     */
    @Override
    public void addException(LocalDate date) {
        super.addException(date);  // Add the exception date to the event's list of exceptions
    }

    @Override
    public boolean isInDay(LocalDate aDay) {
        if (myExceptions.contains(aDay)) return false;  // If the date is in the exceptions, return false

        LocalDate eventStartDate = myStart.toLocalDate();
        long daysBetween = ChronoUnit.DAYS.between(eventStartDate, aDay);

        // Fixing the frequency check: check based on the repetition frequency
        if (aDay.isEqual(eventStartDate)) {
            return true;  // The event occurs if the day is equal to the start day
        }

        // Handle the repetition based on frequency
        if (myFrequency == ChronoUnit.DAYS && daysBetween % 1 == 0) {
            return true;  // Daily repetition
        } else if (myFrequency == ChronoUnit.WEEKS && daysBetween % 7 == 0) {
            return true;  // Weekly repetition
        } else if (myFrequency == ChronoUnit.MONTHS && eventStartDate.getMonthValue() == aDay.getMonthValue()) {
            return true;  // Monthly repetition (basic, can be improved to check exact month logic)
        }

        return false;
    }

    /**
     * La terminaison d'une répétition (optionnelle)
     * @param termination la terminaison de la répétition
     */
    public void setTermination(Termination termination) {
        // TODO : implémenter cette méthode
        throw new UnsupportedOperationException("Pas encore implémenté");
    }
}
