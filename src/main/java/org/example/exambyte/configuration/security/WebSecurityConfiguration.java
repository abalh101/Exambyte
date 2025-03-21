package org.example.exambyte.configuration.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class WebSecurityConfiguration {
  //client_id = Ov23li8ARAzYhKfNDtOg
  //client_secret = 259cef77cd944688b32a4894da05bfc3d6f18d19

  @Bean
  public SecurityFilterChain configure(HttpSecurity chainBuilder) throws Exception {
    chainBuilder.authorizeHttpRequests(
            c -> c.requestMatchers("/","/index","/error", "/css/*", "/img/**")
                .permitAll().anyRequest().authenticated()
        ).logout(l -> l.logoutSuccessUrl("/").permitAll())
        .oauth2Login(o -> o.defaultSuccessUrl("/redirect", true));

    return chainBuilder.build();
  }

}
