package jp.te4a.spring.boot.online_questions.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import jp.te4a.spring.boot.online_questions.bean.UserBean;

public interface UserRepository extends JpaRepository<UserBean, String> {
    Optional<UserBean> findByUsername(String username);
}
