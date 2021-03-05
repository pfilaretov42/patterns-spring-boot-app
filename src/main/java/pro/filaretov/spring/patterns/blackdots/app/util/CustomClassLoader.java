package pro.filaretov.spring.patterns.blackdots.app.util;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;

/**
 * Custom class loader to load a class at runtime.
 */
@Component
public class CustomClassLoader extends ClassLoader {

    @SneakyThrows
    @Override
    public Class<?> findClass(String className) {
        String classPath = "target/classes/" + className.replace('.', File.separatorChar) + ".class";

        byte[] bytecode = Files.newInputStream(Path.of(classPath)).readAllBytes();
        return defineClass(className, bytecode, 0, bytecode.length);
    }
}
