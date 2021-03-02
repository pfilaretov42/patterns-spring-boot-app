package pro.filaretov.spring.patterns.blackdots.app.domain;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Meta-annotation to specify an expert
 */
@Retention(RetentionPolicy.RUNTIME)
@Component
@Qualifier
@Autowired
public @interface Expert {

    /**
     * type value is set as bean Qualifier
     */
    String type();
}
