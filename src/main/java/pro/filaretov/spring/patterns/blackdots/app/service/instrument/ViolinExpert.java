package pro.filaretov.spring.patterns.blackdots.app.service.instrument;

import javax.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import pro.filaretov.spring.patterns.blackdots.app.domain.Expert;
import pro.filaretov.spring.patterns.blackdots.app.domain.MusicInstrument;
import pro.filaretov.spring.patterns.blackdots.app.service.instrument.parts.StringExpert;
import pro.filaretov.spring.patterns.blackdots.app.service.instrument.parts.WoodExpert;

/**
 * Expert in adjusting violins.
 */
@Expert(type = MusicInstrumentExpert.WOODY)
@Slf4j
public class ViolinExpert implements MusicInstrumentExpert {

    @Autowired
    private StringExpert stringExpert;
    @Autowired
    private WoodExpert woodExpert;

    @Value("${black.dots.expert.string.strings.type}")
    private String stringsType;

    @PostConstruct
    public void postConstruct() {
        log.info("Violin expert is here, I'm using {} strings today", stringsType);
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

    @Override
    public String getType() {
        return MusicInstrument.VIOLIN;
    }

    public String getStringsType() {
        return stringsType;
    }
}
