package pro.filaretov.spring.patterns.blackdots.app.service;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;
import javax.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pro.filaretov.spring.patterns.blackdots.app.domain.MusicInstrument;
import pro.filaretov.spring.patterns.blackdots.app.service.instrument.MusicInstrumentExpert;
import pro.filaretov.spring.patterns.blackdots.app.service.instrument.PianoExpert;
import pro.filaretov.spring.patterns.blackdots.app.service.instrument.WhateverExpert;
import pro.filaretov.spring.patterns.blackdots.app.service.instrument.parts.WoodExpert;
import pro.filaretov.spring.patterns.blackdots.starter.autoconfigure.InjectList;

@Service
@Slf4j
public class InstrumentsServiceImpl implements InstrumentsService {

    @InjectList({PianoExpert.class, WoodExpert.class})
    private List<MusicInstrumentExpert> experts;

    private final Map<String, MusicInstrumentExpert> expertMap = new ConcurrentHashMap<>();

    @PostConstruct
    public void postConstruct() {
        log.info("InstrumentsService created with experts: {}",
            experts.stream().map(e -> e.getClass().getSimpleName()).collect(Collectors.joining(", ")));
    }

    @Override
    public void registerExpert(String type, MusicInstrumentExpert expert) {
        expertMap.put(type, expert);
    }

    /**
     * Adjust music instrument using available experts.
     * <p><b>Pattern:</b> chain of responsibility, with custom list of beans injected.</p>
     *
     * @param musicInstrument music instrument
     */
    @Override
    public void adjust(MusicInstrument musicInstrument) {
        experts.forEach(expert -> expert.adjust(musicInstrument));
    }

    /**
     * Repair music instrument using one of the experts depending on the instrument type.
     * <p><b>Pattern:</b> strategy & command. Uses bean IDs which is easy but not really great.
     *
     * @param musicInstrument music instrument
     */
    @Override
    public void repair(MusicInstrument musicInstrument) {
        MusicInstrumentExpert expert = expertMap.getOrDefault(musicInstrument.getType(), new WhateverExpert());
        expert.repair(musicInstrument);
    }

}
