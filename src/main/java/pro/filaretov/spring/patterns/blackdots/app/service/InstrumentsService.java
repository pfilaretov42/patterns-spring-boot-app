package pro.filaretov.spring.patterns.blackdots.app.service;

import javax.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pro.filaretov.spring.patterns.blackdots.app.service.instrument.MusicInstrumentExpert;

/**
 * Instruments repair scheduled service.
 */
@Service
@Slf4j
public class InstrumentsService {

    @Autowired
    private MusicInstrumentExpert pianoExpert;

    @PostConstruct
    public void postConstruct() {
        log.info("InstrumentsService created with an expert: {}", pianoExpert.getClass().getSimpleName());
    }
}
