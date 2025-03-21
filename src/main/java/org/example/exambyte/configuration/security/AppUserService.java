package org.example.exambyte.configuration.security;


import java.util.HashSet;
import java.util.Set;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

@Service
public class AppUserService implements OAuth2UserService <OAuth2UserRequest, OAuth2User> {

  private final DefaultOAuth2UserService defaultService = new DefaultOAuth2UserService();

  @Value("${exambyte.rollen.student}")
  private Set<String> students;

  @Value("${exambyte.rollen.organisator}")
  private Set<String> organisatoren;

  @Value("${exambyte.rollen.korrektor}")
  private Set<String> korrektoren;


  @Override
  public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
    OAuth2User originalUser = defaultService.loadUser(userRequest);
    Set<GrantedAuthority> authorities = new HashSet<>(originalUser.getAuthorities());
    String login = originalUser.<String>getAttribute("login");
    if (students.contains(login)) {
      System.out.printf("GRANTING STUDENT PRIVILEGES TO USER %s%n", login);
      authorities.add(new SimpleGrantedAuthority("ROLE_STUDENT"));
    } else {
      System.out.printf("DENYING STUDENT PRIVILEGES TO USER %s%n", login);
    }

    if (organisatoren.contains(login)) {
      System.out.printf("GRANTING ORGANISATOR PRIVILEGES TO USER %s%n", login);
      authorities.add(new SimpleGrantedAuthority("ROLE_ORGANISATOR"));
    } else {
      System.out.printf("DENYING ORGANISATOR PRIVILEGES TO USER %s%n", login);
    }

    if (korrektoren.contains(login)) {
      System.out.printf("GRANTING KORREKTOR PRIVILEGES TO USER %s%n", login);
      authorities.add(new SimpleGrantedAuthority("ROLE_KORREKTOR"));
    } else {
      System.out.printf("DENYING KORREKTOR PRIVILEGES TO USER %s%n", login);
    }

    return new DefaultOAuth2User(authorities, originalUser.getAttributes(), "login");
  }
}
