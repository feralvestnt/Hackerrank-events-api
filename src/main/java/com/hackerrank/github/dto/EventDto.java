package com.hackerrank.github.dto;

import lombok.Data;

@Data
public class EventDto {

    private Long id;
    private String type;

    public EventDto(Long id, String type) {
        this.id = id;
        this.type = type;
    }
}
