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
                .antMatchers("/api/**").permitAll()
                .antMatchers("/item/update/**").hasAnyAuthority("STAFF_GUDANG")
                .antMatchers("/request/daftar-request").hasAnyAuthority("STAFF_GUDANG", "STAFF_OPERASIONAL")
                .antMatchers("/request/updateItemByRequest/**").hasAnyAuthority("STAFF_GUDANG")
                .antMatchers("/item/propose-item").hasAnyAuthority("FACTORY_MANAGER")
                .antMatchers("/delivery/assign-kurir/**").hasAnyAuthority("STAFF_OPERASIONAL")
                .antMatchers("/delivery/daftar-delivery").hasAnyAuthority("STAFF_OPERASIONAL","STAFF_KURIR")
                .antMatchers("/pegawai/add-pegawai").hasAnyAuthority("ADMIN")
                .antMatchers("/pegawai/daftar-pegawai").hasAnyAuthority("ADMIN", "FACTORY_MANAGER")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login").permitAll()
                .defaultSuccessUrl("/", true)
                .and()
                .logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/login").permitAll()
                .and()
                .cors()
                .and()
                .csrf()
                .disable();
    }

    @Bean
    public BCryptPasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(encoder());
    }

}
