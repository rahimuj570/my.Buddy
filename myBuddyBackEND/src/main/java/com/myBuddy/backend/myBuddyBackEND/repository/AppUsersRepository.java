package com.myBuddy.backend.myBuddyBackEND.repository;

import com.myBuddy.backend.myBuddyBackEND.model.AppUsers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Optional;

@Repository
public interface AppUsersRepository extends JpaRepository<AppUsers, Long> {
    public Optional<AppUsers> findByEmail(String email);
    public Optional<AppUsers>findByEmailAndPassword(String email,String password);
    Optional<AppUsers> findById(Long id);

    ArrayList<AppUsers>findByCanDonate(int flag);
}
