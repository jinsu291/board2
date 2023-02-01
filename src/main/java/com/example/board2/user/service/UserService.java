package com.example.board2.user.service;

import com.example.board2.article.exception.DataNotFoundException;
import com.example.board2.user.entity.SiteUser;
import com.example.board2.user.repository.UserRepository;

import java.util.Optional;

public class UserService {
    private UserRepository userRepository;

    public SiteUser getUser(String username) {
        Optional<SiteUser> siteUser = this.userRepository.findByusername(username);
        if (siteUser.isPresent()) {
            return siteUser.get();
        } else {
            throw new DataNotFoundException("siteuser not found");
        }
    }
}
