package com.lwh.learn.security.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lwh.learn.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.hierarchicalroles.RoleHierarchy;
import org.springframework.security.access.hierarchicalroles.RoleHierarchyImpl;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.expression.DefaultWebSecurityExpressionHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.sql.DataSource;
import java.io.PrintWriter;

/**
 * @author lwh
 * @date 2023-11-07 23:55:17
 * @describe --
 */
//@EnableWebSecurity
//@Configuration
public class SecurityConfig {

    @Autowired
    private UserService userService;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        AuthenticationManagerBuilder authenticationManagerBuilder = http.getSharedObject(AuthenticationManagerBuilder.class);
//        authenticationManagerBuilder.userDetailsService(userService);
//        AuthenticationManager authenticationManager = authenticationManagerBuilder.build();
        http.authorizeHttpRequests((authz) -> authz
                        .requestMatchers("/admin/**").hasRole("admin")
                        .requestMatchers("/user/**").hasRole("user")
                        .anyRequest()
                        .authenticated())
                .formLogin(Customizer.withDefaults())
                .rememberMe(httpSecurityRememberMeConfigurer -> httpSecurityRememberMeConfigurer.key("lwh"))
                .csrf(AbstractHttpConfigurer::disable);
//                .authenticationManager(authenticationManager)
//                .rememberMe(Customizer.withDefaults())
//                .formLogin(login -> login
//                        .loginPage("/login.html")
//                        .loginProcessingUrl("/doLogin")
//                        .successForwardUrl("/index")
//                        .successHandler(((request, response, authentication) -> {
//                            Object principal = authentication.getPrincipal();
//                            response.setContentType("application/json;charset=utf-8");
//                            PrintWriter out = response.getWriter();
//                            out.write(new ObjectMapper().writeValueAsString(principal));
//                            out.flush();
//                            out.close();
//                        }))
//                        .failureHandler(((request, response, exception) -> {
//                            response.setContentType("application/json;charset=utf-8");
//                            PrintWriter out = response.getWriter();
//                            out.write(exception.getMessage());
//                            out.flush();
//                            out.close();
//                        }))
//                        .permitAll())
//                .logout(out -> out
//                        .logoutUrl("/logout") // 和下面的二选一即可
//                        .logoutRequestMatcher(new AntPathRequestMatcher("/logout", "POST"))
//                        .logoutSuccessUrl("/index")
//                        .logoutSuccessHandler((request, response, authentication) -> {
//                            response.setContentType("application/json;charset=utf-8");
//                            PrintWriter writer = response.getWriter();
//                            writer.write("注销成功");
//                            writer.flush();
//                            writer.close();
//                        })
//                        .deleteCookies()
//                        .clearAuthentication(true)
//                        .invalidateHttpSession(true)
//                        .permitAll()
//                )
//                .csrf(AbstractHttpConfigurer::disable)
//                .httpBasic(Customizer.withDefaults());
//                // 设置未登录访问接口的行为
//                .exceptionHandling()
//                .authenticationEntryPoint(((request, response, authException) -> {
//                    response.setContentType("application/json;charset=utf-8");
//                    PrintWriter out = response.getWriter();
//                    out.write("尚未登录，请先登录");
//                    out.flush();
//                    out.close();
//                }));
        return http.build();
    }


//    @Bean
//    public WebSecurityCustomizer webSecurityCustomizer() {
//        return (web) -> web.ignoring().requestMatchers("/js/**", "/css/**", "/images/**");
//    }

//    @Bean
//    public InMemoryUserDetailsManager userDetailsManager() {
//        UserDetails user = User
//                .withUsername("lwh")
//                .password("123456")
//                .roles("admin")
//                .build();
//        UserDetails user1 = User
//                .withUsername("hwl")
//                .password("123456")
//                .roles("user")
//                .build();
//        return new InMemoryUserDetailsManager(user, user1);
//    }

//        /**
//     * 和上述的任选其一
//     */
//    @Bean
//    public UserDetailsService userDetailsService() {
//        UserDetails user = User
//                .withUsername("lwh")
//                .password("123456")
//                .roles("admin")
//                .build();
//        UserDetails user1 = User
//                .withUsername("hwl")
//                .password("123456")
//                .roles("user")
//                .build();
//        return new InMemoryUserDetailsManager(user, user1);
//    }

//    @Autowired
//    private DataSource dataSource;
//
//    @Bean
//    public UserDetailsManager userDetailsManager() {
//        JdbcUserDetailsManager manager = new JdbcUserDetailsManager(dataSource);
//        if (!manager.userExists("lwh")) {
//            manager.createUser(User.withUsername("lwh").password("123456").roles("admin").build());
//        }
//        if (!manager.userExists("hwl")) {
//            manager.createUser(User.withUsername("hwl").password("123456").roles("admin").build());
//        }
//        return manager;
//    }
//
//    @Bean
//    public RoleHierarchy roleHierarchy() {
//        RoleHierarchyImpl roleHierarchy = new RoleHierarchyImpl();
//        String hierarchy = "ROLE_admin > ROLE_user";
//        roleHierarchy.setHierarchy(hierarchy);
//        return roleHierarchy;
//    }
//
//    @Bean
//    public DefaultWebSecurityExpressionHandler customWebSecurityExpressionHandler() {
//        DefaultWebSecurityExpressionHandler expressionHandler = new DefaultWebSecurityExpressionHandler();
//        expressionHandler.setRoleHierarchy(roleHierarchy());
//        return expressionHandler;
//    }
}
