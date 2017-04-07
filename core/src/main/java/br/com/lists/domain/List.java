package br.com.lists.domain;

import javax.persistence.Entity;

/**
 * Created by eric-nasc on 06/04/17.
 */
@Entity
public class List extends DomainEntity {

    private String name;
    private Boolean removed;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getRemoved() {
        return removed;
    }

    public void setRemoved(Boolean removed) {
        this.removed = removed;
    }
}
