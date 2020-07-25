package com.springboot.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private MyUserDetailsService myUserDetailsService;

    /**
     * 权限设定
     * 分为四种角色：
     * USER(拥有首页，文章管理，标签管理权限)
     * ADMIN(拥有首页，文章管理，标签管理权限，友情连接管理，用户管理，消息管理权限)
     * SYSADMIN(拥有首页，系统管理权限)
     * SUPERADMIN(拥有全部权限)
     * 后期可以修改问动态获取
     */
    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .csrf().disable()//关闭scrf
                .authorizeRequests()
                .antMatchers("/static/**").permitAll()
                .antMatchers("/").hasAnyRole("USER","ADMIN","SYSTEMADMIN","SUPERADMIN")
                .antMatchers("/index/**").hasAnyRole("USER","ADMIN","SYSTEMADMIN","SUPERADMIN")
                .antMatchers("/article/**").hasAnyRole("USER","ADMIN","SUPERADMIN")
                .antMatchers("/tag/**").hasAnyRole("USER","ADMIN","SUPERADMIN")
                .antMatchers("/link/**").hasAnyRole("ADMIN","SUPERADMIN")
                .antMatchers("/user/**").hasAnyRole("ADMIN","SUPERADMIN")
                .antMatchers("/message/**").hasAnyRole("ADMIN","SUPERADMIN")
                .antMatchers("/system/**").hasAnyRole("SYSTEMADMIN","SUPERADMIN")
                .and()
                .formLogin().loginPage("/login").failureUrl("/login_error").successForwardUrl("/")
                .and()
                .logout().logoutUrl("/logout").logoutSuccessUrl("/login").deleteCookies("JSESSIONID")
                .and()
                .exceptionHandling().accessDeniedPage("/login");
    }

    @Bean
    public static NoOpPasswordEncoder passwordEncoder() {
        return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
    }

    //根据用户名密码实现登录
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        authenticationManagerBuilder.userDetailsService(myUserDetailsService);
    }
}
