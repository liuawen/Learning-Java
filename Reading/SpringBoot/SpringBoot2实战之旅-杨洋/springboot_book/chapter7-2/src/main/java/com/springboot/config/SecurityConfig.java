package com.springboot.config;

import com.springboot.entity.Menu;
import com.springboot.entity.Role;
import com.springboot.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

import java.util.List;


@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private MyUserDetailsService myUserDetailsService;

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception{
        //配置资源文件 其中/css/**，/index可以任意访问，/select需要USER权限，/delete需要ADMIN权限
        httpSecurity
                .authorizeRequests()
                .antMatchers("/css/**", "/index").permitAll()
                .antMatchers("/select").hasRole("USER")
                .antMatchers("/delete").hasRole("ADMIN");
        //动态加载数据库中角色权限
        List<Role> roleList = roleRepository.findAll();
        for(Role role : roleList){
            List<Menu> menuList = role.getMenuList();
            for (Menu menu : menuList){
                //在SpringSecurity校验权限的时候，会自动将权限前面加ROLE_，所以我们需要 将我们数据库中配置的ROLE_截取掉。
                String roleName = role.getRoleName().replace("ROLE_","");
                String menuName = "/" + menu.getMenuName();
                httpSecurity
                        .authorizeRequests()
                        .antMatchers(menuName)
                        .hasRole(roleName);
            }
        }
        //配置登录请求/login 登录失败请求/login_error 登录成功请求/
        httpSecurity
                .formLogin()
                .loginPage("/login")
                .failureUrl("/login_error")
                .successForwardUrl("/");
        //登录异常，如权限不符合 请求/401
        httpSecurity
                .exceptionHandling().accessDeniedPage("/401");
        //注销登录 请求/logout
        httpSecurity
                .logout()
                .logoutSuccessUrl("/logout");
    }

    @Bean
    public static NoOpPasswordEncoder passwordEncoder() {
        return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
    }


    //根据用户名密码实现登录
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        authenticationManagerBuilder
                .inMemoryAuthentication()
                //.passwordEncoder(new BCryptPasswordEncoder())
                .withUser("test").password("123").roles("USER")
                .and()
                .withUser("admin").password("123").roles("ADMIN","USER");
        authenticationManagerBuilder.userDetailsService(myUserDetailsService);
    }
}
