package jp.te4a.spring.boot.online_questions.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.stereotype.Service;

import jp.te4a.spring.boot.online_questions.bean.UserBean;
import jp.te4a.spring.boot.online_questions.form.UserForm;
import jp.te4a.spring.boot.online_questions.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public UserForm create(UserForm userForm) {
        var passwordEncoder = Pbkdf2PasswordEncoder.defaultsForSpringSecurity_v5_8();
        var encodedPassword = passwordEncoder.encode(userForm.getPassword());
        userForm.setPassword(encodedPassword);

        var userBean = new UserBean();
        BeanUtils.copyProperties(userForm, userBean);

        userRepository.save(userBean);
        return userForm;
    }
}