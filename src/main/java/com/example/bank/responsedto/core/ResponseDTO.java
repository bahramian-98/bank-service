package com.example.bank.responsedto.core;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
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


    protected ResponseDTO(final ResponseDTO.ResponseDTOBuilder<?, ?> b) {
        this.id = b.id;
        this.created = b.created;
        this.createdById = b.createdById;
        this.createdByName = b.createdByName;
        this.updated = b.updated;
        this.updatedById = b.updatedById;
        this.updatedByName = b.updatedByName;
        this.fullTitle = b.fullTitle;
        this.active = b.active;
    }


    public abstract static class ResponseDTOBuilder<C extends ResponseDTO, B extends ResponseDTO.ResponseDTOBuilder<C, B>> {
        private Long id;
        private LocalDateTime created;
        private Long createdById;
        private String createdByName;
        private LocalDateTime updated;
        private Long updatedById;
        private String updatedByName;
        private String fullTitle;
        private Boolean active;

        public ResponseDTOBuilder() {
        }

        protected abstract B self();

        public abstract C build();

        public B id(final Long id) {
            this.id = id;
            return this.self();
        }

        public B created(final LocalDateTime created) {
            this.created = created;
            return this.self();
        }

        public B createdById(final Long createdById) {
            this.createdById = createdById;
            return this.self();
        }

        public B createdByName(final String createdByName) {
            this.createdByName = createdByName;
            return this.self();
        }

        public B updated(final LocalDateTime updated) {
            this.updated = updated;
            return this.self();
        }

        public B updatedById(final Long updatedById) {
            this.updatedById = updatedById;
            return this.self();
        }

        public B updatedByName(final String updatedByName) {
            this.updatedByName = updatedByName;
            return this.self();
        }

        public B fullTitle(final String fullTitle) {
            this.fullTitle = fullTitle;
            return this.self();
        }

        public B active(final Boolean active) {
            this.active = active;
            return this.self();
        }

        public String toString() {
            return "ResponseDTO.ResponseDTOBuilder(id=" + this.id + ", created=" + this.created + ", createdById=" + this.createdById + ", createdByName=" + this.createdByName + ", updated=" + this.updated + ", updatedById=" + this.updatedById + ", updatedByName=" + this.updatedByName + ", fullTitle=" + this.fullTitle + ", active=" + this.active + ")";
        }
    }

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
