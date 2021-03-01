package pro.filaretov.spring.patterns.blackdots.app.domain;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import org.springframework.stereotype.Component;

/**
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Component
public @interface Expert {
    String value();
}
