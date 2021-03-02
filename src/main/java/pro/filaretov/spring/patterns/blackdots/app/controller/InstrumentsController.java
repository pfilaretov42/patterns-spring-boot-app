package pro.filaretov.spring.patterns.blackdots.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pro.filaretov.spring.patterns.blackdots.app.domain.MusicInstrument;
import pro.filaretov.spring.patterns.blackdots.app.service.InstrumentsService;

/**
 * Instruments' endpoints.
 */
@RestController
@RequestMapping("/api/v1/instruments")
public class InstrumentsController {

    @Autowired
    private InstrumentsService instrumentsService;

    @PostMapping("/adjust")
    public void adjust(@RequestBody MusicInstrument musicInstrument) {
        instrumentsService.adjustInstrument(musicInstrument);
    }

}
