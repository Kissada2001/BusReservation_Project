package com.ra.busBooking.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.ldap.EmbeddedLdapServerContextSourceFactoryBean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.ra.busBooking.service.DefaultUserServiceImpl;


@Configuration
public class SpringSecurityConfig{

	@Autowired
	private DefaultUserServiceImpl customUserDetailsService;
	
	@Autowired
	private AuthenticationSuccessHandler successHandler;
	
	@Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
	
	@Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
        auth.setUserDetailsService(customUserDetailsService);
        auth.setPasswordEncoder(passwordEncoder());
        return auth;
    }
	
	public  EmbeddedLdapServerContextSourceFactoryBean contextSourceFactoryBean() {
		EmbeddedLdapServerContextSourceFactoryBean contextSourceFactoryBean =
	            EmbeddedLdapServerContextSourceFactoryBean.fromEmbeddedLdapServer();
	        contextSourceFactoryBean.setPort(0);
	        return contextSourceFactoryBean;
    }
	
	@Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/registration").permitAll().anyRequest()
                .authenticated().and().formLogin().loginPage("/login").successHandler(successHandler).
                                              permitAll().and().logout()
                .invalidateHttpSession(true).clearAuthentication(true)
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout")).
                                       logoutSuccessUrl("/login?logout")
                .permitAll();
		return http.build() ;

    }
}
