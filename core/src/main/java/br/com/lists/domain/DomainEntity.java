package br.com.lists.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;

@MappedSuperclass
public class DomainEntity implements Serializable {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    private String id;

    @JsonIgnore
    private Instant createdAt;

    @JsonIgnore
    private Instant updatedAt;

    @PrePersist
    protected void preCreate() {
        this.createdAt = Instant.now();
    }

    @PreUpdate
    protected void preUpdate() {
        this.updatedAt = Instant.now();
    }
}