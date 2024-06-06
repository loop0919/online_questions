package jp.te4a.spring.boot.online_questions.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jp.te4a.spring.boot.online_questions.bean.ProblemBean;

@Repository
public interface ProblemsRepository extends JpaRepository<ProblemBean, String> {}
