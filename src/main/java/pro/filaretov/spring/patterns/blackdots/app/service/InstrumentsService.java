package pro.filaretov.spring.patterns.blackdots.app.service;

import java.util.List;
import java.util.stream.Collectors;
import javax.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pro.filaretov.spring.patterns.blackdots.app.domain.MusicInstrument;
import pro.filaretov.spring.patterns.blackdots.app.service.instrument.MusicInstrumentExpert;
import pro.filaretov.spring.patterns.blackdots.app.service.instrument.PianoExpert;
import pro.filaretov.spring.patterns.blackdots.app.service.instrument.TriangleExpert;
import pro.filaretov.spring.patterns.blackdots.app.service.instrument.ViolinExpert;
import pro.filaretov.spring.patterns.blackdots.app.service.instrument.WhateverExpert;
import pro.filaretov.spring.patterns.blackdots.app.service.instrument.parts.WoodExpert;
import pro.filaretov.spring.patterns.blackdots.starter.autoconfigure.InjectList;

/**
 * Instruments repair service.
 */
@Service
@Slf4j
public class InstrumentsService {

    @InjectList({PianoExpert.class, WoodExpert.class})
    private List<MusicInstrumentExpert> experts;

    @Autowired
    private PianoExpert pianoExpert;
    @Autowired
    private ViolinExpert violinExpert;
    @Autowired
    private TriangleExpert triangleExpert;
    @Autowired
    private WhateverExpert whateverExpert;

    @PostConstruct
    public void postConstruct() {
        log.info("InstrumentsService created with experts: {}",
            experts.stream().map(e -> e.getClass().getSimpleName()).collect(Collectors.joining(", ")));
    }

    /**
     * Adjust music instrument using available experts.
     * <p><b>Pattern:</b> chain of responsibility, with custom list of beans injected.</p>
     *
     * @param musicInstrument music instrument
     */
    public void adjust(MusicInstrument musicInstrument) {
        experts.forEach(expert -> expert.adjust(musicInstrument));
    }

    /**
     * Repair music instrument using one of the experts depending on the instrument type.
     * <p><b>Anti-pattern:</b> switch.
     *
     * @param musicInstrument music instrument
     */
    public void repair(MusicInstrument musicInstrument) {
        switch (musicInstrument.getType()) {
            case MusicInstrument.PIANO -> pianoExpert.repair(musicInstrument);
            case MusicInstrument.VIOLIN -> violinExpert.repair(musicInstrument);
            case MusicInstrument.TRIANGLE -> triangleExpert.repair(musicInstrument);
            default -> whateverExpert.repair(musicInstrument);
        }
    }

}
