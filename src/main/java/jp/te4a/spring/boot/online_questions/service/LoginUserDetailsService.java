package jp.te4a.spring.boot.online_questions.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import jp.te4a.spring.boot.online_questions.bean.UserBean;
import jp.te4a.spring.boot.online_questions.repository.UserRepository;
import jp.te4a.spring.boot.online_questions.security.LoginUserDetails;

@Service
public class LoginUserDetailsService implements LoginUserDetailsServiceI {
    @Autowired
    UserRepository userRepository;

    @Override
    public LoginUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserBean user = userRepository.findByUsername(username)
                .orElseThrow(() ->
                    new UsernameNotFoundException("The requested user is not found.")
                );
        return new LoginUserDetails(user);
    }
}
