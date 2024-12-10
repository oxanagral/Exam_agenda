package agenda;

import java.time.LocalDate;
import java.time.Duration;
import java.time.temporal.ChronoUnit;

public class Termination extends Repetition {

    private LocalDate terminationDateInclusive;  // La date de fin d'un événement
    private long numberOfOccurrences;  // Le nombre d'occurrences

    /**
     * Constructs a fixed termination event ending at a given date
     * @param title the title of this event
     * @param start the start time of this event
     * @param duration the duration of this event
     * @param frequency one of :
     * <UL>
     * <LI>ChronoUnit.DAYS for daily repetitions</LI>
     * <LI>ChronoUnit.WEEKS for weekly repetitions</LI>
     * <LI>ChronoUnit.MONTHS for monthly repetitions</LI>
     * </UL>
     * @param terminationInclusive the date when this event ends
     */
    public Termination(String title, LocalDate start, Duration duration, ChronoUnit frequency, LocalDate terminationInclusive) {
        super(title, start.atStartOfDay(), duration, frequency);  // Appelle le constructeur de la classe Repetition
        this.terminationDateInclusive = terminationInclusive;
    }

    /**
     * Constructs a fixed termination event ending after a number of iterations
     * @param title the title of this event
     * @param start the start time of this event
     * @param duration the duration of this event
     * @param frequency one of :
     * <UL>
     * <LI>ChronoUnit.DAYS for daily repetitions</LI>
     * <LI>ChronoUnit.WEEKS for weekly repetitions</LI>
     * <LI>ChronoUnit.MONTHS for monthly repetitions</LI>
     * </UL>
     * @param numberOfOccurrences the number of occurrences of this repetitive event
     */
    public Termination(String title, LocalDate start, Duration duration, ChronoUnit frequency, long numberOfOccurrences) {
        super(title, start.atStartOfDay(), duration, frequency);  // Appelle le constructeur de la classe Repetition
        this.numberOfOccurrences = numberOfOccurrences;
    }

    /**
     * Returns the termination date (inclusive)
     * @return the termination date
     */
    public LocalDate terminationDateInclusive() {
        return terminationDateInclusive;
    }

    /**
     * Returns the number of occurrences
     * @return the number of occurrences
     */
    public long numberOfOccurrences() {
        return numberOfOccurrences;
    }
}
