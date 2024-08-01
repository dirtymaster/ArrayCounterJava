plugins {
    java
    id("org.springframework.boot") version "3.3.2"
    id("io.spring.dependency-management") version "1.1.6"
}

group = "ru.rtinform"
version = "0.0.1-SNAPSHOT"

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(22)
    }
}

repositories {
    mavenCentral()
}

dependencies {
    dependencies {
        implementation("org.springframework.boot:spring-boot-starter-thymeleaf") {
            because("Нужен шаблонизатор для веб-приложения")
        }
        implementation("org.springframework.boot:spring-boot-starter-web") {
            because("Нужен веб сервер")
        }
        compileOnly("org.projectlombok:lombok") {
            because("Нужен инструмент для уменьшения boilerplate кода")
        }
        annotationProcessor("org.projectlombok:lombok") {
            because("Нужен процессор аннотаций для Lombok")
        }
        testImplementation("org.springframework.boot:spring-boot-starter-test") {
            because("Нужны инструменты для тестрования")
        }
        testImplementation("org.junit.platform:junit-platform-suite") {
            because("Нужно создавать наборы тестов JUnit")
        }
        testImplementation("io.cucumber:cucumber-java:7.18.0") {
            because("Нужна интеграция Cucumber с Java")
        }
        testImplementation("io.cucumber:cucumber-spring:7.18.0") {
            because("Нужна интеграция Cucumber со Spring")
        }
        testImplementation("io.cucumber:cucumber-junit-platform-engine:7.18.0") {
            because("Нужен движок для запуска Cucumber тестов на JUnit Platform")
        }
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}
