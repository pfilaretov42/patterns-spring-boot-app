package pro.filaretov.spring.patterns.blackdots.app.service;

import java.util.List;
import java.util.stream.Collectors;
import javax.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pro.filaretov.spring.patterns.blackdots.legacy.Instrument;
import pro.filaretov.spring.patterns.blackdots.legacy.InstrumentExpert;
import pro.filaretov.spring.patterns.blackdots.starter.autoconfigure.Legacy;

/**
 * Legacy instruments repair service.
 */
@Service
@Slf4j
public class LegacyInstrumentsService {

    // only @Legacy-marked experts will be injected here, so even though PianoExpert is InstrumentExpert,
    // it will not be injected.
    // Pattern: integrate legacy framework/code as spring beans.
    @Autowired
    @Legacy
    private List<InstrumentExpert> experts;

    @PostConstruct
    public void postConstruct() {
        log.info("LegacyInstrumentsService created with experts: {}",
            experts.stream().map(e -> e.getClass().getSimpleName()).collect(Collectors.joining(", ")));
    }

    public void adjustInstrument(Instrument instrument) {
        experts.forEach(expert -> expert.adjust(instrument));
    }
}
