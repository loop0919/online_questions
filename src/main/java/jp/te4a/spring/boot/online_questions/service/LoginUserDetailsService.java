package jp.te4a.spring.boot.online_questions.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import jp.te4a.spring.boot.online_questions.security.LoginUserDetails;

public interface LoginUserDetailsService extends UserDetailsService {
    public LoginUserDetails loadUserByUsername(String username) throws UsernameNotFoundException;
}
