package com.example.bank.model.core;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Getter
@SuperBuilder
public abstract class ResponseDTO {

    private Long id;
    private LocalDateTime created;
    private Long createdById;
    private String createdByName;
    private LocalDateTime updated;
    private Long updatedById;
    private String updatedByName;
    protected String fullTitle;
    private Boolean active;

    public void setId(final Long id) {
        this.id = id;
    }

    public void setCreated(final LocalDateTime created) {
        this.created = created;
    }

    public void setCreatedById(final Long createdById) {
        this.createdById = createdById;
    }

    public void setCreatedByName(final String createdByName) {
        this.createdByName = createdByName;
    }

    public void setUpdated(final LocalDateTime updated) {
        this.updated = updated;
    }

    public void setUpdatedById(final Long updatedById) {
        this.updatedById = updatedById;
    }

    public void setUpdatedByName(final String updatedByName) {
        this.updatedByName = updatedByName;
    }

    public void setFullTitle(final String fullTitle) {
        this.fullTitle = fullTitle;
    }

    public void setActive(final Boolean active) {
        this.active = active;
    }
}
