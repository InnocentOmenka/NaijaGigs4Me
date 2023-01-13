package com.naijagis4me.v1.config.userDetails;

import com.naijagis4me.v1.models.Person;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AppUserDetails implements UserDetails {
    private Person person;

    @Override
        public Collection<? extends GrantedAuthority> getAuthorities() {
            return person.getRole().getGrantedAuthorities();
        }

        @Override
        public String getPassword() {
            return person.getPassword();
        }

        @Override
        public String getUsername() {
            return person.getEmail();
        }

        @Override
        public boolean isAccountNonExpired() {
            return true;
        }

        @Override
        public boolean isAccountNonLocked() {
            return true;
        }

        @Override
        public boolean isCredentialsNonExpired() {
            return true;
        }

        @Override
        public boolean isEnabled() {
            return true;
        }

    }
