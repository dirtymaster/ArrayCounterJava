package ru.rtinform.arraycounter.cucumber;

import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import ru.rtinform.arraycounter.ArrayCounterApplication;

@CucumberContextConfiguration
@SpringBootTest(classes = ArrayCounterApplication.class)
public class CucumberSpringConfiguration {
}