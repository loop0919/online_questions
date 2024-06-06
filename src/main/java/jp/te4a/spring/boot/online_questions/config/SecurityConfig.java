package jp.te4a.spring.boot.online_questions.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain login(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(authorize -> authorize
                .requestMatchers("/webjars/**", "/css/**").permitAll()
                .requestMatchers("/loginForm", "/users", "/users/create").permitAll()
                .anyRequest().authenticated()
        )
        .formLogin(form -> form
            .loginProcessingUrl("/login")
                .loginPage("/loginForm")
                .failureUrl("/loginForm?error")
                .defaultSuccessUrl("/problems", true)
                .usernameParameter("username")
                .passwordParameter("password")
        )
        .logout(form -> form.logoutSuccessUrl("/loginForm").permitAll());

        return http.build();
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return Pbkdf2PasswordEncoder.defaultsForSpringSecurity_v5_8();
    }
}