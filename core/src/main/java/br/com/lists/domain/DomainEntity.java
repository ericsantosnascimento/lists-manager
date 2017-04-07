package br.com.lists.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.UUID;

@MappedSuperclass
public class DomainEntity implements Serializable {

    @JsonIgnore
    private Timestamp createdAt;

    @JsonIgnore
    private Timestamp updatedAt;

    @PrePersist
    protected void preCreate() {
        this.createdAt = Timestamp.from(Instant.now());
    }

    @PreUpdate
    protected void preUpdate() {
        this.updatedAt = Timestamp.from(Instant.now());
    }
}