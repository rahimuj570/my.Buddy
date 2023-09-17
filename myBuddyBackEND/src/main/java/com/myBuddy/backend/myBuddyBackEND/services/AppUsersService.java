package com.myBuddy.backend.myBuddyBackEND.services;

import com.myBuddy.backend.myBuddyBackEND.model.AppUsers;
import org.springframework.stereotype.Service;

public interface AppUsersService {
    AppUsers insert(AppUsers request);
}
