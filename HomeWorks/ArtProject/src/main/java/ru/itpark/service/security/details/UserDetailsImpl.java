package ru.itpark.service.security.details;

import ru.itpark.service.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import ru.itpark.service.repositories.UsersRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class UserDetailsImpl implements UserDetails {

    @Autowired
    private UsersRepository usersRepository;

    private Long id;
    private String login;
    private String hashPassword;
    private String state;
    private List<SimpleGrantedAuthority> authorities;

    public UserDetailsImpl(User user) {
        this.id= user.getId();
        this.login = user.getLogin();
        this.hashPassword = user.getHashPassword();
        this.state = user.getState().toString();
        this.authorities = new ArrayList<SimpleGrantedAuthority>();
        for(String stringAuthorities: user.getAuthorities()){
            this.authorities.add(new SimpleGrantedAuthority((stringAuthorities)));
        }
    }

    public Long getId() {return id;}
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return hashPassword;
    }

    @Override
    public String getUsername() {
        return login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !state.equals("BANNED");
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return this.state.equals("ACTIVE");
    }
}
