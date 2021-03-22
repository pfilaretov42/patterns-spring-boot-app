package pro.filaretov.spring.patterns.blackdots.app.service.instrument;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import pro.filaretov.spring.patterns.blackdots.app.domain.MusicInstrument;

@ContextHierarchy(
    {
        @ContextConfiguration(classes = ExpertCommonConf.class),
        @ContextConfiguration(classes = PianoExpertTestConfig.class)
    }
)
class PianoExpertTest extends AbstractExpertTest {

    @Autowired
    private PianoExpert pianoExpert;

    @Test
    void getType() {
        assertEquals(MusicInstrument.PIANO, pianoExpert.getType());
    }
}

