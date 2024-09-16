package com.rc4.authorizationserver.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author raphael
 * @project oauth2
 * @package com.rc4.authorizationserver.controllers
 * @date 1/15/24 : 10:13 PM
 */

@RestController
public class ChangePasswordController {

    @GetMapping("change-password")
    public String cp(){
        System.out.println("je suis dans change password");
        return "CP";
    }
}
