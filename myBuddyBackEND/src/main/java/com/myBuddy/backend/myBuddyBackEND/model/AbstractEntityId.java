package com.myBuddy.backend.myBuddyBackEND.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;

@MappedSuperclass
@Data
public abstract class AbstractEntityId {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    protected Long id;

    public AbstractEntityId() {
    }

    public AbstractEntityId(Long id) {
        this.id = id;
    }

}
