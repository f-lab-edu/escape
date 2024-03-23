package com.project.escape.domain.theme;

import com.project.escape.global.utils.ResponseFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
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
                .orElseThrow(ResponseFactory::notFound);
    }
}
