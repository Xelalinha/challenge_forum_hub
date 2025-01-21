package com.one.forumhub.Challenge.ForumHub.repositorios;

import com.one.forumhub.Challenge.ForumHub.models.entities.Topico;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TopicoRepository extends JpaRepository<Topico, Long> {
    Optional<Topico> findByTituloAndMensagem(String titulo, String mensagem);
}
