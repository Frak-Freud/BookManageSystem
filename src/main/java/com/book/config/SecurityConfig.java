package com.book.config;

import com.book.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public PersistentTokenRepository tokenRepository(DataSource dataSource){
        JdbcTokenRepositoryImpl repository = new JdbcTokenRepositoryImpl();
        repository.setDataSource(dataSource);
        // repository.setCreateTableOnStartup(true);   // 第一次创建表后无须再创建
        return repository;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity,
                                           PersistentTokenRepository tokenRepo) throws Exception {
        return httpSecurity
                .authorizeHttpRequests(auth -> {
                    auth.requestMatchers("/static/**").permitAll();
                    auth.anyRequest().authenticated();
                })
                .formLogin(conf -> {
                    conf.loginPage("/login");
                    conf.loginProcessingUrl("/doLogin");
                    conf.defaultSuccessUrl("/");
                    conf.permitAll();
                })
                .logout(conf -> {
                    conf.logoutUrl("/doLogout");
                    conf.logoutSuccessUrl("/login");
                    conf.permitAll();
                })
                .rememberMe(conf -> {
                    conf.tokenRepository(tokenRepo);
                    conf.tokenValiditySeconds(3600 * 24 * 3);
                })
                .csrf(AbstractHttpConfigurer::disable)
                .build();
    }

}
