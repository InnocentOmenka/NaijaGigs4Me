package com.naijagis4me.v1.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

//This is for testing purposes not the main code. Not to be integrated.
@RestController
@RequiredArgsConstructor
public class TestController {

    @GetMapping("/")
    public String getHomepage() {
        return "This is the homepage. Free to everyone!";
    }

    @GetMapping("/homepage")
    public String home(Principal principal) {
        return principal == null ? "Hello, Guest" : "Welcome, " + principal.getName();
    }

//    @PreAuthorize("hasRole('SUPERADMIN')")
    @GetMapping("/api/v1/super-admin")
    public String getSuperAdminPage() {
        return "This is the Super admin page!";
    }

    @GetMapping("/api/v1/admin")
    public String getAdminPage() {
        return "This is the admin page!";
    }

    @GetMapping("/api/v1/auth/admin")
    public String adminAuth() {
        return "This is the auth page for admin";
    }

    @GetMapping("/ap1/v1/auth/user/")
    public String userAuth() {
        return "This is the user auth page";
    }

    @GetMapping("/api/v1/user")
    public String getClientPage() {
        return "This is the client page!";
    }

    @GetMapping("/api/v1/user/client")
    public String getArtisanPage() {
        return "This is the user/client page!";
    }
}
