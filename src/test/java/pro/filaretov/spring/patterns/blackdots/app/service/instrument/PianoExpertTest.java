package pro.filaretov.spring.patterns.blackdots.app.service.instrument;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import pro.filaretov.spring.patterns.blackdots.app.domain.MusicInstrument;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@ContextHierarchy(
    {
        @ContextConfiguration(classes = ExpertCommonConf.class),
        @ContextConfiguration(classes = PianoExpertTestConfig.class)
    }
)
@ActiveProfiles("test_experts")
class PianoExpertTest {

    @Autowired
    private PianoExpert pianoExpert;

    @Test
    void getType() {
        assertEquals(MusicInstrument.PIANO, pianoExpert.getType());
    }
}

