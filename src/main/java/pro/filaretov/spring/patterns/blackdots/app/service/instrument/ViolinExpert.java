package pro.filaretov.spring.patterns.blackdots.app.service.instrument;

import javax.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import pro.filaretov.spring.patterns.blackdots.app.domain.MusicInstrument;
import pro.filaretov.spring.patterns.blackdots.app.service.instrument.parts.WoodExpert;

/**
 * Expert in adjusting violins.
 */
@Component(MusicInstrument.VIOLIN)
@Slf4j
public class ViolinExpert implements MusicInstrumentExpert {

    private WoodExpert woodExpert;

    @PostConstruct
    public void postConstruct() {
        log.info("Violin expert is here");
    }

    @Override
    public void adjust(MusicInstrument musicInstrument) {
        if (MusicInstrument.VIOLIN.equals(musicInstrument.getType())) {
            log.info("{} adjusted", musicInstrument.getType());
        } else {
            log.warn("Violin expert ignores everything but {}, especially {}", MusicInstrument.VIOLIN, musicInstrument);
        }
    }

    @Override
    public void repair(MusicInstrument musicInstrument) {
        log.info("{} repaired", musicInstrument.getType());
    }
}
