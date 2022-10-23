package kaurami.me.t.springdemo.tacos.security;

import kaurami.me.t.springdemo.repository.UserRepository;
import kaurami.me.t.springdemo.tacos.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.AbstractRequestMatcherRegistry;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.AbstractInterceptUrlConfigurer;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Configuration
//@EnableGlobalMethodSecurity
public class SecurityConfig{

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService(UserRepository userRepository){
        return username -> {
            User user = userRepository.findByUsername(username);
            if (user!=null){
                return user;
            }
            throw new UsernameNotFoundException("User '"+username+"' not found");
        };
    }

/*
    @Bean
    public UserDetailsService userDetailsService(PasswordEncoder encoder){
        ArrayList<UserDetails> userDetails = new ArrayList<>(Arrays.asList(
                new org.springframework.security.core.userdetails.User("user",
                        encoder.encode("user"),
                        Arrays.asList(new SimpleGrantedAuthority("ROLE_USER")))));
        return new InMemoryUserDetailsManager(userDetails);
    }
*/

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{
        return httpSecurity.authorizeRequests().antMatchers("/design", "/orders").hasRole("USER")
                .antMatchers("/").permitAll()
                .and().formLogin().loginPage("/login").defaultSuccessUrl("/design")
                .and().build();
    }

}