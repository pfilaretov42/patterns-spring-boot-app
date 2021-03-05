package pro.filaretov.spring.patterns.blackdots.app.service;

import pro.filaretov.spring.patterns.blackdots.app.domain.MusicInstrument;
import pro.filaretov.spring.patterns.blackdots.app.service.instrument.MusicInstrumentExpert;

/**
 * Instruments repair service.
 */
public interface InstrumentsService {

    void adjust(MusicInstrument musicInstrument);

    void repair(MusicInstrument musicInstrument);

    void registerExpert(String type, MusicInstrumentExpert expert);
}
