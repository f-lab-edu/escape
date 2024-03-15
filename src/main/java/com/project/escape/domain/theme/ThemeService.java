package com.project.escape.domain.theme;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ThemeService {
    private final ThemeRepository themeRepository;

    public List<ThemeResponse> findAll() {
        return themeRepository.findAll()
                .stream()
                .map(ThemeResponse::of)
                .toList();
    }

    public ThemeResponse findById(Long id) {
        return themeRepository.findById(id)
                .map(ThemeResponse::of)
                .orElseThrow();
    }
}
