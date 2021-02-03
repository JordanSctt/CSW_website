package fr.csw.java;


import fr.csw.java.admin.SpringUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
public class WebSecurityConfigurer extends WebSecurityConfigurerAdapter {


    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private SpringUserDetailsService userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(userDetailsService)
                .passwordEncoder(bCryptPasswordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/devis/admin/**")
                .authenticated()
                .antMatchers("/accueil")
                .permitAll()
                .antMatchers("/devis/get/new")
                .permitAll()
                .antMatchers("/devis/post/new")
                .permitAll()
                .antMatchers("/devis/export")
                .permitAll()
                .antMatchers("/admin/login")
                .permitAll()
                .and()
                .csrf().disable()
                .formLogin()
                .loginPage("/admin/login")
                .defaultSuccessUrl("/devis/admin/list", true)
                .failureUrl("/admin/login?error=connection")
                .usernameParameter("login")
                .passwordParameter("password")
                .and()
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/accueil");
    }

	@Override
	public void configure(WebSecurity web) throws Exception {
		web
				.ignoring()
				.antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/images/**", "/fonts/**");
	}

}
