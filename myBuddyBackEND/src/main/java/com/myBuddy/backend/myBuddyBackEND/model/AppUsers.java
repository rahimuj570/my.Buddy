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
    private String gender;
    private int canDonate;
    private String[] area;

    public AppUsers() {
    }

    public AppUsers(Long id) {
        super(id);
    }
}


/*
    DELIMITER $$
    CREATE EVENT update_last_donation
        ON SCHEDULE EVERY 24 HOUR
        STARTS CURRENT_TIMESTAMP
        DO BEGIN
        UPDATE app_users SET last_donation = last_donation - 1 WHERE last_donation > 0;
        UPDATE app_users set able= false where last_donation>0;
        UPDATE app_users set able= true where last_donation=0;
        END
*/
