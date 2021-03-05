package pro.filaretov.spring.patterns.blackdots.app.service;

import pro.filaretov.spring.patterns.blackdots.app.domain.MusicInstrument;

/**
 * Instruments repair service.
 */
public interface InstrumentsService {

    void adjust(MusicInstrument musicInstrument);

    void repair(MusicInstrument musicInstrument);
}
