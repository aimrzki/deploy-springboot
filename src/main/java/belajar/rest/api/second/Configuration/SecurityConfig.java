package belajar.rest.api.second.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorizeRequests ->
                        authorizeRequests
                                //.requestMatchers("/employees", "/students/**").authenticated() // Autentikasi untuk /employees dan /students
                                .anyRequest().authenticated() // Ijinkan semua request lainnya tanpa autentikasi
                )
                .httpBasic(Customizer.withDefaults()) // Menggunakan Basic Authentication dengan cara baru
                .csrf(csrf -> csrf.disable()); // Nonaktifkan CSRF untuk pengembangan (gunakan dengan hati-hati di produksi)

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        // Membuat pengguna dalam memori untuk tujuan pengujian
        UserDetails user = User.withUsername("user")
                .password(passwordEncoder().encode("password"))
                .roles("USER")
                .build();
        return new InMemoryUserDetailsManager(user);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}