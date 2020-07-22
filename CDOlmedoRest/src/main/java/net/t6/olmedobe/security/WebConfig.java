package net.t6.olmedobe.security;

import org.springframework.context.annotation.*;
import org.springframework.security.authentication.dao.*;
import org.springframework.security.config.annotation.authentication.builders.*;
import org.springframework.security.config.annotation.web.builders.*;
import org.springframework.security.config.annotation.web.configuration.*;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import net.t6.olmedobe.services.LoginService;

@Configuration
@EnableWebSecurity
public class WebConfig extends WebSecurityConfigurerAdapter {
	@Bean
    public UserDetailsService userDetailsService() {
        return new LoginService();
    }
     
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
     
    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());
         
        return authProvider;
    }
 
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }
 
    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	//http.authorizeRequests().antMatchers("/api/usuario").permitAll();
    	/*http.authorizeRequests()
            .antMatchers("/api/usuario").hasAnyAuthority("hincha")
            .anyRequest().authenticated()
            .and()
            .formLogin().permitAll()//loginProcessingUrl("localhost:8000/index.html")
            .and()
            .logout().permitAll()
            .and()
            .exceptionHandling().accessDeniedPage("/403")
            ;*/
    	http.cors();
		http.csrf().disable();
		  //http.authorizeRequests().antMatchers("/**").fullyAuthenticated().and
		http.authorizeRequests().antMatchers("/api/rol").hasAnyAuthority("hincha").and
		 ().httpBasic(); 
    }
    @Override
    public void configure(WebSecurity web) throws Exception {
    	      //other configure params.
       getHttp().csrf().disable();
    }

}
