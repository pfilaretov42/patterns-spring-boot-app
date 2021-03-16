package pro.filaretov.spring.patterns.blackdots.app.service;

import javax.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import pro.filaretov.spring.patterns.blackdots.app.domain.MusicInstrument;
import pro.filaretov.spring.patterns.blackdots.app.service.instrument.MusicInstrumentExpert;
import pro.filaretov.spring.patterns.blackdots.app.util.ProfileConst;

/**
 * Service to repair digital instruments
 */
@Profile(ProfileConst.DIGITAL)
@Service
@Slf4j
public class DigitalInstrumentsService implements InstrumentsService {

    @PostConstruct
    public void init() {
        log.info("DigitalInstrumentsService created");
    }

    @Override
    public void adjust(MusicInstrument musicInstrument) {
        log.info("no adjustment needed");
    }

    @Override
    public void repair(MusicInstrument musicInstrument) {
        log.info("{} repaired", musicInstrument.getType());
    }

    @Override
    public void registerExpert(String type, MusicInstrumentExpert expert) {
        // no experts needed here
    }
}
