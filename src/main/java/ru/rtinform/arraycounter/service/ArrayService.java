package ru.rtinform.arraycounter.service;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ArrayService {
    public Map<String, Long> countElements(String input) {
        if (input == null || input.isEmpty()) {
            return Map.of();
        }
        return Arrays.stream(input.split(","))
                .map(String::trim)
                .filter(s -> !s.isEmpty())
                .collect(Collectors.groupingBy(
                        s -> s,
                        Collectors.counting()
                ));
    }
}
