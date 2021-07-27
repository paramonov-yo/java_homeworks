package com.JavaDevSpring.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests().antMatchers("/login", "/home_page", "/books_page", "/authors_page", "/genres_page"/*, "/comment_page"*/).permitAll()
                .and()
                .authorizeRequests().antMatchers("/add_comment").hasAnyRole( "USER", "MANAGER")
                .and()
                .authorizeRequests().antMatchers("/add_books", "/add_authors", "/add_genres" /*,"/add_comments"*/).hasAnyRole("ADMIN", "MANAGER")
                .and()
                .authorizeRequests().antMatchers("/delete_books", "/delete_authors", "/delete_genres" /*,"/delete_comments"*/).hasRole( "ADMIN" )
                .and()
                .authorizeRequests().antMatchers("/update_books", "/update_authors", "/update_genres").hasAnyRole("ADMIN")
                .and().formLogin()
                .defaultSuccessUrl("/")
                .and()
                .logout().logoutUrl("/logout");
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new PasswordEncoder() {
            @Override
            public String encode(CharSequence charSequence) {
                return charSequence.toString();
            }

            @Override
            public boolean matches(CharSequence charSequence, String s) {
                return charSequence.toString().equals(s);
            }
        };
    }

    @Autowired
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("admin").password("admin").roles("ADMIN")
                .and()
                .withUser("user").password("user").roles("USER")
                .and()
                .withUser("manager").password("manager").roles("MANAGER", "USER");
    }
}

