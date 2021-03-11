package pro.filaretov.spring.patterns.blackdots.app.controller;

import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pro.filaretov.spring.patterns.blackdots.app.domain.MusicInstrument;
import pro.filaretov.spring.patterns.blackdots.app.dto.InstrumentsDTO;
import pro.filaretov.spring.patterns.blackdots.app.service.InstrumentsService;
import pro.filaretov.spring.patterns.blackdots.app.service.LegacyInstrumentsService;
import pro.filaretov.spring.patterns.blackdots.legacy.Instrument;

/**
 * Instruments' endpoints.
 */
@RestController
@RequestMapping("/api/v1/instruments")
public class InstrumentsController {

    @Autowired
    private InstrumentsService instrumentsService;

    @Autowired
    private LegacyInstrumentsService legacyInstrumentsService;

    @PostMapping("/adjust")
    public void adjust(@RequestBody MusicInstrument musicInstrument) {
        instrumentsService.adjust(musicInstrument);
    }

    @PostMapping("/adjust/legacy")
    public void adjust(@RequestBody Instrument instrument) {
        legacyInstrumentsService.adjustInstrument(instrument);
    }

    @PostMapping("/repair")
    public void repair(@RequestBody MusicInstrument musicInstrument) {
        instrumentsService.repair(musicInstrument);
    }

    @GetMapping
    public InstrumentsDTO getAll() {
        List<MusicInstrument> musicInstruments = List.of(
            new MusicInstrument(MusicInstrument.PIANO),
            new MusicInstrument(MusicInstrument.VIOLIN),
            new MusicInstrument(MusicInstrument.TRIANGLE)
        );
        return new InstrumentsDTO(UUID.randomUUID().toString(), musicInstruments);
    }


}
