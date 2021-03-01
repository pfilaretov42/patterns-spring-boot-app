package pro.filaretov.spring.patterns.blackdots.app.service.instrument;

import javax.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pro.filaretov.spring.patterns.blackdots.app.service.parts.WoodExpert;

/**
 * Expert in adjusting violins.
 */
@Service
@Slf4j
public class ViolinExpert implements MusicInstrumentExpert {

    private WoodExpert woodExpert;

    @PostConstruct
    public void postConstruct() {
        log.info("Violin expert is here");
    }

    @Override
    public void adjust() {
        log.info("violin adjusted");
    }
}
