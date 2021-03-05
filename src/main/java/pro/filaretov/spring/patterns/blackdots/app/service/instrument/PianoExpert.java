package pro.filaretov.spring.patterns.blackdots.app.service.instrument;

import javax.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import pro.filaretov.spring.patterns.blackdots.app.domain.Expert;
import pro.filaretov.spring.patterns.blackdots.app.domain.MusicInstrument;
import pro.filaretov.spring.patterns.blackdots.app.service.instrument.parts.StringExpert;
import pro.filaretov.spring.patterns.blackdots.legacy.Instrument;
import pro.filaretov.spring.patterns.blackdots.legacy.InstrumentExpert;

/**
 * Expert in adjusting pianos.
 */
@Expert(type = MusicInstrumentExpert.WOODY)
@Slf4j
public class PianoExpert implements MusicInstrumentExpert, InstrumentExpert {

    @Autowired
    private StringExpert stringExpert;

    @PostConstruct
    public void postConstruct() {
        log.info("Piano expert is here");
    }

    @Override
    public void adjust(MusicInstrument musicInstrument) {
        adjust(musicInstrument.getType());
    }

    @Override
    public void adjust(Instrument instrument) {
        adjust(instrument.getType());
    }

    private void adjust(String type) {
        if (MusicInstrument.PIANO.equals(type)) {
            log.info("{} adjusted", type);
        } else {
            log.warn("Piano expert ignores everything but {}, especially {}", MusicInstrument.PIANO, type);
        }
    }

    @Override
    public void repair(MusicInstrument musicInstrument) {
        log.info("{} repaired", musicInstrument.getType());
    }

    @Override
    public String getType() {
        return MusicInstrument.PIANO;
    }
}
