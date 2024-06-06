package jp.te4a.spring.boot.online_questions.bean;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

import de.huxhorn.sulky.ulid.ULID;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserBean {
    @Id
    @Column(name="user_id")
    String userId;

    @Column(name="user_name", nullable=false, unique=true)
    String username;

    @JsonIgnore
    @Column(name="password")
    String password;

    @Column(name="profile")
    String profile;

    @PrePersist
    protected void onCreate() {
        if (Objects.isNull(this.userId)) {
            this.userId = new ULID().nextULID();
        }
    }
}
