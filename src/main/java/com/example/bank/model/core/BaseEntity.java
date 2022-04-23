package com.example.bank.model.core;

import com.example.bank.model.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@MappedSuperclass
public abstract class BaseEntity {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "CREATED", nullable = false, updatable = false)
    private LocalDateTime created;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CREATED_BY", nullable = false, updatable = false)
    private User createdBy;

    @Column(name = "UPDATED", nullable = false)
    private LocalDateTime updated;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "UPDATED_BY", nullable = false)
    private User updatedBy;

    @Column(name = "IS_ACTIVE", length = 1)
    private Boolean active;

    @Column(name = "IS_DELETED")
    private Long deleted;

    @Column(name = "FULL_TITLE")
    private  String fullTitle;

    private Long systemUserId = 1L;

    @PrePersist
    public void prePersist(){
        this.createdBy = this.createdBy == null ? new User(systemUserId) : this.createdBy;
        this.created = LocalDateTime.now();
        this.updatedBy = this.updatedBy == null ?new User(systemUserId) : this.updatedBy;
        this.updated = LocalDateTime.now();
        this.active = this.active == null || this.active;
        this.deleted = 0L;
    }

    @PreUpdate
    public void preUpdate() {
        this.updatedBy = this.updatedBy == null ?new User(systemUserId) : this.updatedBy;
        this.updated = LocalDateTime.now();
    }



}
