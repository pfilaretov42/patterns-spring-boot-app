package pro.filaretov.spring.patterns.blackdots.app.service.instrument;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 * Abstract class that can be extended by test classes, so that every class receives the same active profile and the
 * same set of {@code SpringBootTest.properties}.
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest
@ActiveProfiles("test_experts")
abstract class AbstractExpertTest {

}
