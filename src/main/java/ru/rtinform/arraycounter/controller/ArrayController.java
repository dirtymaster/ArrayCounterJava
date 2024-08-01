package ru.rtinform.arraycounter.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.rtinform.arraycounter.service.ArrayService;

import java.util.Map;

@Controller
@RequiredArgsConstructor
public class ArrayController {
    private final ArrayService arrayService;

    @GetMapping("/")
    public String showForm() {
        return "form";
    }

    @PostMapping("/count")
    public String countElements(@RequestParam("numbers") String numbers, Model model) {
        Map<String, Long> result = arrayService.countElements(numbers);
        model.addAttribute("result", result);
        return "result";
    }
}
