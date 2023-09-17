package com.myBuddy.backend.myBuddyBackEND.services.impl;

import com.myBuddy.backend.myBuddyBackEND.model.AppUsers;
import com.myBuddy.backend.myBuddyBackEND.repository.AppUsersRepository;
import com.myBuddy.backend.myBuddyBackEND.services.AppUsersService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class AppUsersServiceImpl implements AppUsersService {
    private  @Resource AppUsersRepository appUsersRepository;
    @Override
    public AppUsers insert(AppUsers request) {
        return appUsersRepository.save(request);
    }
}
