package com.ifsul.tds_rodrigo.usuarios;

import com.ifsul.tds_rodrigo.habito.Habito;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jspecify.annotations.Nullable;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "usuarios")
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class Usuario implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "usu_id", length = 36, nullable = false, updatable = false)
    private UUID id;

    @Column(name = "usu_nome", length = 150, nullable = false)
    private String nome;

    @Column(name = "usu_email", length = 255, nullable = false, unique = true)
    private String email;

    @Column(name = "usu_senha_hash", length = 255, nullable = false)
    private String senhaHash;

    @Column(name = "usu_fuso_horario", length = 64)
    private String fusoHorario;

    @Column(name = "usu_preferencia_idioma", length = 10)
    private String preferenciaIdioma;

    @Column(name = "usu_criado_em", insertable = false, updatable = false)
    private OffsetDateTime criadoEm;

    //implementar o habito one to many para que no ORM crue a tabela pra ele também
    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Habito> habitos = new ArrayList<>();

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public @Nullable String getPassword() {
        return "";
    }

    @Override
    public String getUsername() {
        return "";
    }

    @Override
    public boolean isAccountNonExpired() {
        return UserDetails.super.isAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return UserDetails.super.isAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return UserDetails.super.isCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() {
        return UserDetails.super.isEnabled();
    }

        public static void main(String[] args) {
        BCryptPasswordEncoder enconder = new BCryptPasswordEncoder();
        String senha = enconder.encode("senha");
        System.out.println(senha);
    }
}
