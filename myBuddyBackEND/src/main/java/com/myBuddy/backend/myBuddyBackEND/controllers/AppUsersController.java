package com.myBuddy.backend.myBuddyBackEND.controllers;

import com.myBuddy.backend.myBuddyBackEND.model.AppUsers;
import com.myBuddy.backend.myBuddyBackEND.repository.AppUsersRepository;
import com.myBuddy.backend.myBuddyBackEND.services.AppUsersService;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/users")
public class AppUsersController {
    Logger logger = LoggerFactory.getLogger(AppUsersController.class);
    private @Resource AppUsersRepository usersRepository;
    private @Resource AppUsersService appUsersService;

    @PostMapping("/signup")
    AppUsers insert(HttpServletResponse response, @RequestBody AppUsers request) {
        if (usersRepository.findByEmail(request.getEmail()).isPresent()) {
            logger.info("Duplicate Email Not Acceptable!");
            response.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
            return new AppUsers();
        } else {
            return appUsersService.insert(request);
        }
    }

    @GetMapping("/{id}")
    AppUsers get(HttpServletResponse response, @PathVariable Long id) {
        return usersRepository.findById(id).orElse(null);
    }
}
