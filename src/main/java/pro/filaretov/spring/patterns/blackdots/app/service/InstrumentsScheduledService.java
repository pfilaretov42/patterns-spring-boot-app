package pro.filaretov.spring.patterns.blackdots.app.service;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import pro.filaretov.spring.patterns.blackdots.app.domain.MusicInstrument;
import pro.filaretov.spring.patterns.blackdots.app.service.instrument.PianoExpert;
import pro.filaretov.spring.patterns.blackdots.app.service.instrument.TriangleExpert;

/**
 * Instruments repair scheduled service.
 */
@Service
// This also works fine instead of implicit constructor.
//@RequiredArgsConstructor(onConstructor_={@Lazy})
public class InstrumentsScheduledService {

    private final PianoExpert pianoExpert;
    private final TriangleExpert triangleExpert;

    public InstrumentsScheduledService(PianoExpert pianoExpert, @Lazy TriangleExpert triangleExpert) {
        this.pianoExpert = pianoExpert;
        this.triangleExpert = triangleExpert;
    }

    private int instrumentsAdjusted = 0;

    // uncomment to see lazy initialisation in action
    //@Scheduled(fixedRate = 1000)
    public void adjust() {
        if (instrumentsAdjusted < 5) {
            pianoExpert.adjust(new MusicInstrument(MusicInstrument.PIANO));
            instrumentsAdjusted++;
        } else {
            triangleExpert.adjust(new MusicInstrument(MusicInstrument.TRIANGLE));
            instrumentsAdjusted = 0;
        }
    }

}
