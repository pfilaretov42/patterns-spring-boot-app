package pro.filaretov.spring.patterns.blackdots.app.service;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * Instruments repair service.
 */
@Service
// This also works fine instead of implicit constructor.
//@RequiredArgsConstructor(onConstructor_={@Lazy})
public class InstrumentsService {

    private final PianoExpert pianoExpert;
    private final TriangleExpert triangleExpert;

    public InstrumentsService(PianoExpert pianoExpert, @Lazy TriangleExpert triangleExpert) {
        this.pianoExpert = pianoExpert;
        this.triangleExpert = triangleExpert;
    }

    private int instrumentsAdjusted = 0;

    @Scheduled(fixedRate = 1000)
    public void adjust() {
        if (instrumentsAdjusted < 5) {
            pianoExpert.adjust();
            instrumentsAdjusted++;
        } else {
            triangleExpert.adjust();
            instrumentsAdjusted = 0;
        }
    }

}
