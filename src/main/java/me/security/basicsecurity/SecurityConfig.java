package me.security.basicsecurity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    // 10. 세션 제어 필터 : SessionManagementFilter, ConcurrentSessionFilter
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .anyRequest().authenticated();
        http
                .formLogin()
            .and()
                .sessionManagement()
                .maximumSessions(1)
                .maxSessionsPreventsLogin(true)
            ;
    }
    /*
    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http.sessionManagement() : 세션 관리 기능 작동
//        .sessionFixation().changeSessionId() // 세션 고정 보호 (사용자의 세션, 쿠키 아이디가 매번 변경되도록 설정을 통해 가능)
        http
                .authorizeRequests()
                .anyRequest().authenticated();
        http
                .formLogin();

        http
                .sessionManagement()
                .sessionFixation().none();

//        http
//                .sessionManagement()
//                .sessionFixation().changeSessionId();
//
//        http
//                .sessionManagement()
//                .sessionFixation().migrateSession();
//
//        http
//                .sessionManagement()
//                .sessionFixation().newSession();
    }
     */

    /*
    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http.sessionManagement() : 세션 관리 기능 작동
//        http.sessionManagement()
//                .maximumSession(1) // 최대 허용 가능 세션 수, -1 : 무제한 로그인 세션 허용
//                .maxSessionPreventsLogin(true) // 동시 로그인 차단, false : 기존 세션 만료(default)
//                .invalidSessionUrl("/invalid") // 세션이 유효하지 않을 때 이동 할 페이지
//                .expiredUrl("/expired") // 세션 만료 후 이동할 페이지
        // .sessionFixation().changeSessionId() // 세션 고정 보호 (사용자의 세션, 쿠키 아이디가 매번 변경되도록 설정을 통해 가)

        http
                .authorizeRequests()
                .anyRequest().authenticated();
        http
                .formLogin();
        http
                .sessionManagement()
                .maximumSessions(1)
                .maxSessionsPreventsLogin(false);
    }
     */

    /*
    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .anyRequest().authenticated();
        http
                .formLogin();
        http
                .rememberMe()
                .userDetailsService(userDetailsService);
        }
     */

        /*
        @Override
        protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .anyRequest()
                .authenticated();

        http.formLogin();

        http.logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/login")
                .addLogoutHandler(new LogoutHandler() {
                    @Override
                    public void logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {

                    }
                })
                .logoutSuccessHandler(new LogoutSuccessHandler() {
                    @Override
                    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
                        response.sendRedirect("/login");
                    }
                })
                .deleteCookies("remember-me");
        }
         */

        /*
        @Override
        protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .anyRequest().authenticated();

        http
                .formLogin()
//                .loginPage("/loginPage")
                .defaultSuccessUrl("/")
                .failureUrl("/login")
                .usernameParameter("userId")
                .passwordParameter("passWd")
                .loginProcessingUrl("/login_proc")
                .successHandler(new AuthenticationSuccessHandler() {
                    @Override
                    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
                        System.out.println("authentication : " + authentication.getName());
                        response.sendRedirect("/");
                    }
                })
                .failureHandler(new AuthenticationFailureHandler() {
                    @Override
                    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
                        System.out.println("exception : " + exception.getMessage());
                        response.sendRedirect("/login");
                    }
                })
                .permitAll(); // "/loginPage" url은 모두 허용
            }
         */

}
