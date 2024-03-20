package com.project.escape.domain.theme;

import com.project.escape.global.common.GeneralDataResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.project.escape.global.utils.ResponseFactory.ok;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/theme")
public class ThemeController {
    private final ThemeService themeService;

    @GetMapping
    public GeneralDataResponse<List<ThemeResponse>> findAll() {
        return ok(themeService.findAll());
    }

    @GetMapping("/{id}")
    public GeneralDataResponse<ThemeResponse> findById(@PathVariable Long id) {
        return ok(themeService.findById(id));
    }
}
