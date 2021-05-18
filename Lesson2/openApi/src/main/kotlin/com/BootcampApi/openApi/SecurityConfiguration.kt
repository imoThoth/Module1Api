import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.security.servlet.PathRequest
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder


@EnableWebSecurity
@Configuration
class WebSecurityConfig : WebSecurityConfigurerAdapter() {

    @Bean
    @Throws(Exception::class)
    override fun configure(auth: AuthenticationManagerBuilder) {
        auth
            .inMemoryAuthentication()
            .withUser("tosin")
            .password(passwordEncoder().encode("password"))
            .roles("admin")
    }

    @Throws(Exception::class)
    @Bean
    override fun configure(http: HttpSecurity) {
        http

            .authorizeRequests()
            .antMatchers("/airports/{id}").access("hasRole('ROLE_MASTER')")
            .and()
            .httpBasic()
            .and()
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
    }
}

@Bean
fun passwordEncoder(): PasswordEncoder {
    return BCryptPasswordEncoder()
}
