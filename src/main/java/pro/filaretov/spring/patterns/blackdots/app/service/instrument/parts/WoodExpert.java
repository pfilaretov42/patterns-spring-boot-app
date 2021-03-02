package pro.filaretov.spring.patterns.blackdots.app.service.instrument.parts;

import javax.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pro.filaretov.spring.patterns.blackdots.app.domain.Expert;
import pro.filaretov.spring.patterns.blackdots.app.domain.MusicInstrument;
import pro.filaretov.spring.patterns.blackdots.app.service.instrument.MusicInstrumentExpert;

/**
 * Expert in music instruments' wood.
 */
@Expert(type = MusicInstrumentExpert.WOODY)
@Slf4j
public class WoodExpert implements MusicInstrumentExpert {

    @PostConstruct
    public void postConstruct() {
        log.info("Wood expert is here");
    }

    @Override
    public void adjust(MusicInstrument musicInstrument) {
        log.info("{}'s wood adjusted", musicInstrument.getType());
    }
}
