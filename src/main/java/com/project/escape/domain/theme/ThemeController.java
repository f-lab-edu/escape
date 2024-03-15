package com.project.escape.domain.theme;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/theme")
public class ThemeController {
    private final ThemeService themeService;
    @GetMapping
    public List<ThemeResponse> findAll() {
        return themeService.findAll();
    }

    @GetMapping("/{id}")
    public ThemeResponse findById(@PathVariable Long id) {
        return themeService.findById(id);
    }
}
