package jp.te4a.spring.boot.online_questions.service.impl;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.stereotype.Service;

import jp.te4a.spring.boot.online_questions.bean.UserBean;
import jp.te4a.spring.boot.online_questions.exception.UserAlreadyExistsException;
import jp.te4a.spring.boot.online_questions.form.UserForm;
import jp.te4a.spring.boot.online_questions.repository.UserRepository;
import jp.te4a.spring.boot.online_questions.service.UserService;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserRepository userRepository;

    public UserForm create(UserForm userForm) {
        Optional<UserBean> existingUser = userRepository.findByUsername(userForm.getUsername());
        
        if (existingUser.isPresent()) {
            throw new UserAlreadyExistsException(null); // ユーザー名が既に存在する場合は空のOptionalを返す
        }

        var passwordEncoder = Pbkdf2PasswordEncoder.defaultsForSpringSecurity_v5_8();
        var encodedPassword = passwordEncoder.encode(userForm.getPassword());
        userForm.setPassword(encodedPassword);

        var userBean = new UserBean();
        BeanUtils.copyProperties(userForm, userBean);

        userRepository.save(userBean);
        return userForm;
    }
}
