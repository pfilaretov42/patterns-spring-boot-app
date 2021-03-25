package pro.filaretov.spring.patterns.blackdots.app.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import pro.filaretov.spring.patterns.blackdots.app.dto.BeanDTO;
import pro.filaretov.spring.patterns.blackdots.app.service.StopConfiguration;

/**
 * {@code @WebMvcTest} annotation's behaviour is similar to {@code @SpringBootTest} (see {@link StopConfiguration}
 * for details), but instead of creating all the beans, it creates {@code @Controller}, {@code @ControllerAdvice}, etc
 * beans, but not {@code @Service}, {@code @Repository}, etc.
 */
@ExtendWith(SpringExtension.class)
@WebMvcTest
@ContextConfiguration(classes = ControllerTestConfig.class)
class BeanRegisterControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void register() throws Exception {
        BeanDTO beanDTO = new BeanDTO("myBean", "MyBean");

        mockMvc
            .perform(post("/api/v1/beans/register")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(beanDTO))
            )
            .andExpect(status().isOk())
            .andExpect(content().string("registered"));
    }
}