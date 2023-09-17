package com.myBuddy.backend.myBuddyBackEND.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "app_users")
@Data
@EqualsAndHashCode(callSuper = true)
@Builder
@AllArgsConstructor
public class AppUsers extends AbstractEntityId {
    private String name;
    private String email;
    private String password;
    private String bloodGroup;
    private int totalDonation;
    private String lastDonation;
    private String[] area;

    public AppUsers() {
    }

    public AppUsers(Long id) {
        super(id);
    }
}
