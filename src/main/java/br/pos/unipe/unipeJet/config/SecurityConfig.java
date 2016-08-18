package br.pos.unipe.unipeJet.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Autowired
	DataSource dataSource;
	
	protected void configure(HttpSecurity http) throws Exception {
		
        http
            .authorizeRequests()
                .antMatchers("/usuario/novo").permitAll()
                .anyRequest().authenticated()
                .and()
            .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
            .logout()
                .permitAll();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
    	auth.jdbcAuthentication().dataSource(dataSource)
		.usersByUsernameQuery("select username,senha, enabled from user where username=?")
		.authoritiesByUsernameQuery("select r.user_id, r.role from unipejet.user_roles as r inner join unipejet.user as u on u.id = r.user_id where u.username=? ");
    }
}
