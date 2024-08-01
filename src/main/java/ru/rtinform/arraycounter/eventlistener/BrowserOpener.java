package ru.rtinform.arraycounter.eventlistener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.context.ServletWebServerInitializedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class BrowserOpener implements ApplicationListener<ServletWebServerInitializedEvent> {
    private static final Logger logger = LoggerFactory.getLogger(BrowserOpener.class);

    @Value("${server.port:8080}")
    private int port;

    @Override
    public void onApplicationEvent(ServletWebServerInitializedEvent event) {
        String url = "http://localhost:" + port;
        String os = System.getProperty("os.name").toLowerCase();

        List<String> command = new ArrayList<>();

        if (os.contains("win")) {
            command.add("rundll32");
            command.add("url.dll,FileProtocolHandler");
        } else if (os.contains("mac")) {
            command.add("open");
        } else if (os.contains("nix") || os.contains("nux")) {
            command.add("xdg-open");
        } else {
            logger.warn("Система не поддерживается для автоматического запуска браузера");
            return;
        }
        command.add(url);

        ProcessBuilder pb = new ProcessBuilder(command);
        try {
            pb.start();
        } catch (IOException e) {
            logger.error("Ошибка запуска браузера", e);
        }
    }
}
