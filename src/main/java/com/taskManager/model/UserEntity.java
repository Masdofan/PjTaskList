package com.taskManager.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Cascade;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity(name = "Users")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserEntity implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ToString.Exclude
    private Integer id;

    @Column(unique = true)
    private String username;

    private String firstName;

    private String lastName;

    @ToString.Exclude
    private String password;

    @ToString.Exclude
    @OneToMany(mappedBy = "executor", cascade = CascadeType.ALL)
    private List<TaskEntity> tasks;

    @ToString.Exclude
    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    @Cascade(value = org.hibernate.annotations.CascadeType.DELETE)
    private List<CommentEntity> comments;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
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
