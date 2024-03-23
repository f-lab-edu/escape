package com.project.escape.domain.theme;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;

@Getter
@Embeddable
public class ThemeInfo {
    @Column
    private int difficulty;
    @Column
    private int fear;
    @Column
    private int activity;
}
