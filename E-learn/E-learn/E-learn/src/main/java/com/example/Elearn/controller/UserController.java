package com.example.Elearn.controller;
import com.example.Elearn.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/user-profiles")
public class UserController {
    private final UserProfileService userProfileService;

    public UserController(UserProfileService userProfileService) {
        this.userProfileService = userProfileService;
    }

    @PostMapping("/{username}")
    public User createUserProfile(@PathVariable String username) {
        return userProfileService.createUser(username);
    }
    @GetMapping("/{username}")
    public ResponseEntity<User> getUser(@PathVariable String username) {
        User user = userProfileService.getUser(username);

        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            // Kullanıcı profili bulunamadı durumu için 404 NOT_FOUND hatası döndürülebilir.
            return ResponseEntity.notFound().build();
        }
    }
}