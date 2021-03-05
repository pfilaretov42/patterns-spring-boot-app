package pro.filaretov.spring.patterns.blackdots.app.service.instrument;

import org.springframework.beans.factory.annotation.Autowired;
import pro.filaretov.spring.patterns.blackdots.app.domain.MusicInstrument;
import pro.filaretov.spring.patterns.blackdots.app.service.InstrumentsService;

/**
 * Music instrument expert.
 */
public interface MusicInstrumentExpert {

    String WOODY = "woody";
    String METAL = "metal";

    /**
     * Adjust music instrument.
     *
     * @param musicInstrument music instrument
     */
    void adjust(MusicInstrument musicInstrument);

    /**
     * Repair music instrument.
     *
     * @param musicInstrument music instrument
     */
    void repair(MusicInstrument musicInstrument);

    /**
     * The type of the expert, e.g. violin, piano, etc
     */
    String getType();

    /**
     * Starting from spring 4.3 injection works for interfaces also, not classes only.
     * So we are using setter injection to pass {@link InstrumentsService} so that every {@link MusicInstrumentExpert}
     * can register itself when context is starting.
     * <p><b>Pattern:</b> registry.</p>
     *
     * @param instrumentsService instruments service
     */
    @Autowired
    default void registerMe(InstrumentsService instrumentsService) {
        instrumentsService.registerExpert(getType(), this);
    }
}
