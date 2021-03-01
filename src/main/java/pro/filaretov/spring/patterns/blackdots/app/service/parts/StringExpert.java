package pro.filaretov.spring.patterns.blackdots.app.service.parts;

import javax.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * Expert in music instruments' strings.
 */
@Service
@Slf4j
public class StringExpert {

    @PostConstruct
    public void postConstruct() {
        log.info("String expert is here");
    }
}
