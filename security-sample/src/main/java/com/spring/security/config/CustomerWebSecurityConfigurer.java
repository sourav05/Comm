package com.spring.security.config;

import java.util.Collection;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@EnableWebSecurity
public class CustomerWebSecurityConfigurer implements WebMvcConfigurer {

	
	public UserDetailsService createUserDetailsService() throws Exception{
		InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
		manager.createUser(new UserDetails() {
			
			private static final long serialVersionUID = 1L;

			public boolean isEnabled() {
				return true;
			}
			public boolean isCredentialsNonExpired() {
				return true;
			}
			public boolean isAccountNonLocked() {
				return true;
			}
			public boolean isAccountNonExpired() {
				return true;
			}
			public String getUsername() {
				return "some-user";
			}
			public String getPassword() {
				return "someuser123";
			}
			public Collection<? extends GrantedAuthority> getAuthorities() {
				return null;
			}
		});
		
		return manager;
	}
	
	protected void configure(HttpSecurity http) throws Exception{
		http.antMatcher("/")
		.authorizeRequests()
				.anyRequest()
				.hasRole("ADMIN")
			.and()
		.httpBasic();
	}
}
