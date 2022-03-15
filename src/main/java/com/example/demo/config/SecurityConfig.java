package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.example.demo.service.impl.UserDetailsServiceImpl;
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	@Autowired
	UserDetailsServiceImpl userDetailsService;
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	@Override
	protected AuthenticationManager authenticationManager() throws Exception {
		return super.authenticationManager();
	}
	
	@Bean
	public AuthTokenFilter authenticationJwtTokenFilter() {
	return new AuthTokenFilter();
	}
	
	@Override
	public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
		authenticationManagerBuilder.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder builder) throws Exception {
		builder.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable()
		    .authorizeRequests()
		        .antMatchers("/register").permitAll()
		        .antMatchers("/").permitAll()
				.antMatchers("/admin").hasRole("ADMIN")
				.antMatchers("/shipper").hasRole("SHIPPER")
			    .and()
			.formLogin()
			    .loginPage("/login")
			    .usernameParameter("email")
				.passwordParameter("password")
				//.successHandler(successHandler)
				.failureUrl("/login?error")
			    .and()
			 .logout()
			    .logoutUrl("/logout")
			    .logoutSuccessUrl("/login?logout")
			    .and()
	         .rememberMe().key("uniqueAndSecret").rememberMeParameter("remember-me")
	            .and()
			.exceptionHandling().accessDeniedPage("/login?accessDenied");
	}
	
	
	
//	@Autowired
//	private AuthEntryPointJwt unauthorizedHandler;

//	@Autowired
//	private AuthenticationSuccessHandler successHandler;
//	@Bean
//	public AuthenticationSuccessHandler successHandler() {
//		return new AuthenticationSuccessHandler() {
//			
//			@Override
//			public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
//					Authentication authentication) throws IOException, ServletException {
//				UserDetailsServiceImpl userDetails = (UserDetailsServiceImpl) authentication.getPrincipal();
//	            //String username = userDetails.getUsername();
//	             
//	            System.out.println("The user " + username + " has logged in.");
//	             
//	            response.sendRedirect(request.getContextPath());
//				
//			}
//		};
//	}
//	

//	@Bean
//	@Override
//	public AuthenticationManager authenticationManagerBean() throws Exception {
//		return super.authenticationManagerBean();
//	}
	
	
//	@Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//            .antMatchers("/api/**").hasAnyAuthority("SHIPPER", "ADMIN", "MEMBER")
//            .antMatchers("/admin/**").hasAnyAuthority("ADMIN")
//            .antMatchers("/shipper/**").hasAnyAuthority("SHIPPER")
//            .antMatchers("/member/**").hasAuthority("MEMBER")
//            .anyRequest().authenticated()
//            .and()
//            .formLogin().permitAll()
//            .and()
//            .logout().permitAll()
//            .and()
//            .exceptionHandling().accessDeniedPage("/403")
//            ;
//    }

//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http.csrf().disable()
//			.authorizeRequests().antMatchers("/api/**").permitAll()
//			.antMatchers("/css/**").permitAll()
//            .antMatchers("/error").permitAll()
////			.antMatchers("/admin/**").hasAnyRole("ADMIN")
////			.antMatchers("/member/**").hasAnyRole("MEMBER")
////			.antMatchers("/shipper/**").hasAnyRole("SHIPPER")
//			.and()
//			.formLogin()
//            .loginPage("/api/login")
//             .permitAll()
//             .and()
//             .logout()
//             .permitAll();
	

//	@Override
//	@Bean
//	public AuthenticationManager authenticationManagerBean() throws Exception {
//	    return super.authenticationManagerBean();
//	}
//	@Override
//	protected AuthenticationManager authenticationManager() throws Exception {
//		return super.authenticationManager();
//	}
//	
	
}

//	@Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.parentAuthenticationManager(authenticationManagerBean())
//                .userDetailsService(userDetailsService);
//    }



