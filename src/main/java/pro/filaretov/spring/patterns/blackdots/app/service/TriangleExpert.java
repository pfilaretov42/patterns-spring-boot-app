package pro.filaretov.spring.patterns.blackdots.app.service;

import javax.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

/**
 * Expert in adjusting triangles. Triangles are rare, so it is VERY expensive, and we want it to be lazy instantiated.
 */
@Service
@Lazy
@Slf4j
public class TriangleExpert {

    @PostConstruct
    public void postConstruct() {
        log.info("Triangle expert is here");
    }

    public void adjust() {
        log.info("triangle adjusted");
    }
}
