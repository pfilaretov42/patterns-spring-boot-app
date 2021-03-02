package pro.filaretov.spring.patterns.blackdots.app.service.instrument;

import javax.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import pro.filaretov.spring.patterns.blackdots.app.domain.Expert;
import pro.filaretov.spring.patterns.blackdots.app.domain.MusicInstrument;
import pro.filaretov.spring.patterns.blackdots.app.service.instrument.parts.StringExpert;

/**
 * Expert in adjusting pianos.
 */
@Expert(type = MusicInstrumentExpert.WOODY)
@Slf4j
public class PianoExpert implements MusicInstrumentExpert {

    @Autowired
    private StringExpert stringExpert;

    @PostConstruct
    public void postConstruct() {
        log.info("Piano expert is here");
    }

    @Override
    public void adjust(MusicInstrument musicInstrument) {
        if (MusicInstrument.PIANO.equals(musicInstrument.getType())) {
            log.info("{} adjusted", musicInstrument.getType());
        } else {
            log.warn("Piano expert ignores everything but {}, especially {}", MusicInstrument.PIANO, musicInstrument);
        }
    }
}
