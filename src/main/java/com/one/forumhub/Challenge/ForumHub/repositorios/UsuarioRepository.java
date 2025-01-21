package com.one.forumhub.Challenge.ForumHub.repositorios;

import com.one.forumhub.Challenge.ForumHub.models.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    UserDetails findByEmail(String email);
}
