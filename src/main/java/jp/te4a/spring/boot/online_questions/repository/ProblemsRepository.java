package jp.te4a.spring.boot.online_questions.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import jp.te4a.spring.boot.online_questions.bean.ProblemBean;

public interface ProblemsRepository extends JpaRepository<ProblemBean, String> {}
