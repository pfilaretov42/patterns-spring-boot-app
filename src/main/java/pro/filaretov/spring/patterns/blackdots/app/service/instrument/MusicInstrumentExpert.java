package pro.filaretov.spring.patterns.blackdots.app.service.instrument;

import pro.filaretov.spring.patterns.blackdots.app.domain.MusicInstrument;

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
}
