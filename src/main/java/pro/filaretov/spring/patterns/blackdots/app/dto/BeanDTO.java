package pro.filaretov.spring.patterns.blackdots.app.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * DTO to pass bean info.
 */
@NoArgsConstructor
@Setter
@Getter
public class BeanDTO {

    private String beanName;
    private String className;
}
