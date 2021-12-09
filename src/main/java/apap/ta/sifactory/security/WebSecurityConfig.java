package apap.ta.sifactory.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/css/**").permitAll()
                .antMatchers("/js/**").permitAll()
//                .antMatchers("/pegawai/add-pegawai").hasAnyAuthority("ADMIN")
//                .antMatchers("/factorymanager").hasAuthority("FACTORY_MANAGER")
//                .antMatchers("/gudang").hasAuthority("STAFF_ GUDANG")
//                .antMatchers("/kurir").hasAuthority("STAFF_KURIR")
//                .antMatchers("/operasional").hasAuthority("STAFF_OPERASIONAL")
                .antMatchers("/api/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login").permitAll()
                .and()
                .logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/login").permitAll();
    }

    @Bean
    public BCryptPasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .passwordEncoder(encoder())
                .withUser("admin-si").password(encoder().encode("adminsifactory"))
                .roles("ADMIN");
//        auth.inMemoryAuthentication()
//                .passwordEncoder(encoder())
//                .withUser("factory-manager-si").password(encoder().encode("factorymanager"))
//                .roles("FACTORY_MANAGER");
//        auth.inMemoryAuthentication()
//                .passwordEncoder(encoder())
//                .withUser("staff-gudang-si").password(encoder().encode("staffgudang"))
//                .roles("STAFF_GUDANG");
//        auth.inMemoryAuthentication()
//                .passwordEncoder(encoder())
//                .withUser("staff-kurir-si").password(encoder().encode("staffkurir"))
//                .roles("STAFF_KURIR");
//        auth.inMemoryAuthentication()
//                .passwordEncoder(encoder())
//                .withUser("staff-operasional-si").password(encoder().encode("staffoperasional"))
//                .roles("STAFF_OPERASIONAL");

    }

//    @Autowired
//    private UserDetailsService userDetailsService;

//    @Autowired
//    public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(userDetailsService).passwordEncoder(encoder());
//    }

//    @Autowired
//    public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception{
//        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//        auth.userDetailsService(userDetailsService).passwordEncoder(encoder);
//
//        System.out.println(encoder.encode("habehabe1!"));
//    }
}
