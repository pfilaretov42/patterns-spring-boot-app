package pro.filaretov.spring.patterns.blackdots.app.service.instrument;

import javax.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import pro.filaretov.spring.patterns.blackdots.app.domain.MusicInstrument;

/**
 * Expert in adjusting and repairing guitars.
 *
 * If you want to try and register this bean at runtime, leave it as is.
 * If you want the bean to be available in the context when the context is started,
 * uncomment {@link Component} annotation on the class.
 */
//@Component
@Slf4j
public class GuitarExpert implements MusicInstrumentExpert {

    @PostConstruct
    public void postConstruct() {
        log.info("Guitar expert is here");
    }

    @Override
    public void adjust(MusicInstrument musicInstrument) {
        log.info("{} adjusted", musicInstrument.getType());
    }

    @Override
    public void repair(MusicInstrument musicInstrument) {
        log.info("{} repaired", musicInstrument.getType());
    }

    @Override
    public String getType() {
        return "Guitar";
    }
}
