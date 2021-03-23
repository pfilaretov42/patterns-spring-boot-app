package pro.filaretov.spring.patterns.blackdots.app.service;

import org.springframework.boot.SpringBootConfiguration;

/**
 * <p>A trick configuration to stop the scan process that {@code @SpringBootTest} annotation starts.
 * {@code @SpringBootTest} scan works as follows:</p>
 * <ul>
 *     <li>
 * if you give a {@code @Configuration} to {@code @SpringBootTest} then it will not scan anything:
 * "this is a real Configuration, so I'll just load it and that's it"
 *     </li>
 *     <li>
 * if you give a {@code @TestConfiguration} to {@code @SpringBootTest} then it will load it and start scanning
 * (see below): "this is a test Configuration, so it's probably contains a couple of mocks, I'll load it and go load
 * everything else as well"
 *     </li>
 *     <li>
 * if you give neither {@code @Configuration} nor {@code @TestConfiguration} to {@code @SpringBootTest} then it will
 * start scanning (see below).
 *     </li>
 * </ul>
 * <p/>
 *  <p>{@code @SpringBootTest} <b>scans classes UP</b> to find {@code @SpringBootConfiguration}. And once it is found,
 *  it will do everything it declares. So, in our case, if there were no {@link StopConfiguration} class, then
 *  {@code @SpringBootTest} will go up until it finds the main {@code BlackDotsApplication} class annotated with
 *  {@code @SpringBootApplication} which in turn has {@code @SpringBootConfiguration}. However, besides
 *  {@code @SpringBootConfiguration}, {@code @SpringBootApplication} has {@code @EnableAutoConfiguration},
 *  {@code @ComponentScan}, etc, which would be executed as well! This may result in
 *  {@code BeanDefinitionOverrideException} if beans of the same type are to be created with both
 *  {@code @ComponentScan} and {@code @(Test)Configuration}.
 *  </p>
 */
@SpringBootConfiguration
public class StopConfiguration {

}
