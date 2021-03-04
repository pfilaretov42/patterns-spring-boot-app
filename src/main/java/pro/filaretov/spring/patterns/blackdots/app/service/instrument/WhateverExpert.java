package pro.filaretov.spring.patterns.blackdots.app.service.instrument;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import pro.filaretov.spring.patterns.blackdots.app.domain.MusicInstrument;

/**
 * Expert in any music instrument.
 */
@Component
@Slf4j
public class WhateverExpert implements MusicInstrumentExpert {

    @Override
    public void adjust(MusicInstrument musicInstrument) {
        log.info("{} is fine as is, nothing to adjust", musicInstrument.getType());
    }

    @Override
    public void repair(MusicInstrument musicInstrument) {
        log.info("{} is fine as is, nothing to repair", musicInstrument.getType());
    }
}
