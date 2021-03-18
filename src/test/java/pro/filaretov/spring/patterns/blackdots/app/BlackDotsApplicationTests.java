package pro.filaretov.spring.patterns.blackdots.app;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pro.filaretov.spring.patterns.blackdots.app.domain.MusicInstrument;
import pro.filaretov.spring.patterns.blackdots.app.service.instrument.PianoExpert;
import pro.filaretov.spring.patterns.blackdots.app.service.instrument.TriangleExpert;

/**
 * {@link TestEnvConfig} has {@code lazyInit = true} applied to {@code @ComponentScan}, so only beans that are required
 * for this test (with their dependencies) will be created, i.e. {@code pianoExpert} and {@code triangleExpert} will be
 * created and {@code violinExpert} will not be created.
 */
@SpringBootTest(classes = TestEnvConfig.class)
class BlackDotsApplicationTests {

    @Autowired
    private PianoExpert pianoExpert;
    @Autowired
    private TriangleExpert triangleExpert;

    @Test
    void contextLoads() {
        assertDoesNotThrow(() -> pianoExpert.adjust(new MusicInstrument(MusicInstrument.PIANO)));
        assertDoesNotThrow(() -> triangleExpert.adjust(new MusicInstrument(MusicInstrument.TRIANGLE)));
    }

}
