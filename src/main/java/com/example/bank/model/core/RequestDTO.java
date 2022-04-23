package com.example.bank.model.core;

import lombok.Getter;

@Getter
public abstract class RequestDTO {

    private Long id;
    private Boolean active;

    public void setId(final Long id) {
        this.id = id;
    }
    public void setActive(final Boolean active) {
        this.active = active;
    }
}
