package jp.te4a.spring.boot.online_questions.security;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

import jp.te4a.spring.boot.online_questions.bean.UserBean;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
public class LoginUserDetails extends User {
    private final UserBean user;
    
    public LoginUserDetails(UserBean userBean) {
        super(userBean.getUsername(), userBean.getPassword(), AuthorityUtils.createAuthorityList("ROLE_CONTESTANT"));
        this.user = userBean;
    }
}