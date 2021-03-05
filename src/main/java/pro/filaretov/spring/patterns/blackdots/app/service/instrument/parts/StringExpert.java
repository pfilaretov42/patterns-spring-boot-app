package pro.filaretov.spring.patterns.blackdots.app.service.instrument.parts;

import javax.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pro.filaretov.spring.patterns.blackdots.app.domain.Expert;
import pro.filaretov.spring.patterns.blackdots.app.domain.MusicInstrument;
import pro.filaretov.spring.patterns.blackdots.app.service.instrument.MusicInstrumentExpert;

/**
 * Expert in music instruments' strings.
 */
@Expert(type = MusicInstrumentExpert.METAL)
@Slf4j
public class StringExpert implements MusicInstrumentExpert {

    @PostConstruct
    public void postConstruct() {
        log.info("String expert is here");
    }

    @Override
    public void adjust(MusicInstrument musicInstrument) {
        log.info("{}'s strings adjusted", musicInstrument.getType());
    }

    @Override
    public void repair(MusicInstrument musicInstrument) {
        log.info("{}'s strings repaired", musicInstrument.getType());
    }

    @Override
    public String getType() {
        return "strings";
    }
}
