package sk.neser.base.configuration;

import org.apache.catalina.filters.CorsFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.firewall.HttpFirewall;
import org.springframework.security.web.firewall.StrictHttpFirewall;
import sk.neser.base.filters.SimpleCorsFilter;

@EnableWebSecurity
public class WebSecurityConfig  {

    @Configuration
    @Order(1)
    public static class Basics extends WebSecurityConfigurerAdapter {

        //private final SimpleCorsFilter simpleCorsFilter;

//        @Autowired
//        public Basics(SimpleCorsFilter simpleCorsFilter) {
//            this.simpleCorsFilter = simpleCorsFilter;
//        }

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http
                    .authorizeRequests().antMatchers("/*").permitAll()
                    .and()
                    .csrf().disable();
                    //.addFilterBefore(simpleCorsFilter, CorsFilter.class);
                    //.addFilter(simpleCorsFilter);
        }

        @Bean( name="authenticationManager")
        @Override
        public AuthenticationManager authenticationManagerBean() throws Exception {
            return super.authenticationManagerBean();
        }

        @Bean
        public UserDetailsService userDetailsService() {
            InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
            manager.createUser(
                    User.withUsername("admin")
                            .password(passwordEncoder().encode("admin"))
                            .authorities("USER", "ADMIN")
                            .build());
            manager.createUser(
                    User.withUsername("customer")
                            .password(passwordEncoder().encode("customer"))
                            .authorities("USER", "ADMIN")
                            .build());
            return manager;
        }
    }

    @Bean
    public static BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    //TODO Add Wicket Issue - problem with semicolon in wicket websocket url. Allow semicolon.
    public HttpFirewall allowUrlEncodedSlashHttpFirewall() {
        StrictHttpFirewall fw = new StrictHttpFirewall();
        fw.setAllowSemicolon(true);
        return fw;
    }

}
