package com.myBuddy.backend.myBuddyBackEND.controllers;

import com.myBuddy.backend.myBuddyBackEND.dto.LoginRequest;
import com.myBuddy.backend.myBuddyBackEND.model.AppUsers;
import com.myBuddy.backend.myBuddyBackEND.repository.AppUsersRepository;
import com.myBuddy.backend.myBuddyBackEND.services.AppUsersService;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


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
            return null;
        } else {
            return appUsersService.insert(request);
        }
    }

    @GetMapping("/email/{email}")
    AppUsers get(HttpServletResponse response, @PathVariable String email) {
        return usersRepository.findByEmail(email).orElse(null);
    }

/*    @GetMapping("/{email}/{password}")
    AppUsers getMe(HttpServletResponse response, @PathVariable String email, @PathVariable String password) {
        return usersRepository.findByEmailAndPassword(email, password).orElse(null);
    }*/


    @PostMapping("/login")
    AppUsers getMe(HttpServletResponse response, @RequestBody LoginRequest request) {
        AppUsers appUsers=new AppUsers();
        appUsers= usersRepository.findByEmailAndPassword(request.email, request.password).orElse(null);
        if(appUsers==null){
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }else{

        }
        return appUsers;
    }

    @GetMapping("/{area}")
    List<AppUsers> getArea(HttpServletResponse response, @PathVariable String area) {
        List<AppUsers> allAvailUsers = new ArrayList<>();
        allAvailUsers= usersRepository.findByCanDonate(1);
        List<AppUsers> allAreaUsers=new ArrayList<>();
        if(allAvailUsers!=null){
            for(AppUsers elm: allAvailUsers){
                String []str= elm.getArea();
                for(int i=0; i<str.length;i++){
                    if(str[i].toLowerCase().equals(area.toLowerCase())){
                        allAreaUsers.add(elm);
                        break;
                    }
                }
            }
        }
        return allAreaUsers;
    }
}
