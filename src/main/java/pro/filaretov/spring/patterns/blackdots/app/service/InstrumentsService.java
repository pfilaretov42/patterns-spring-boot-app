package pro.filaretov.spring.patterns.blackdots.app.service;

import java.util.List;
import java.util.stream.Collectors;
import javax.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pro.filaretov.spring.patterns.blackdots.app.domain.MusicInstrument;
import pro.filaretov.spring.patterns.blackdots.app.service.instrument.MusicInstrumentExpert;

/**
 * Instruments repair scheduled service.
 */
@Service
@Slf4j
public class InstrumentsService {

    @Autowired
    private List<MusicInstrumentExpert> experts;

    @PostConstruct
    public void postConstruct() {
        log.info("InstrumentsService created with experts: {}",
            experts.stream().map(e -> e.getClass().getSimpleName()).collect(Collectors.joining(", ")));
    }

    public void adjustInstrument(MusicInstrument musicInstrument) {
        experts.forEach(expert -> expert.adjust(musicInstrument));
    }

}
