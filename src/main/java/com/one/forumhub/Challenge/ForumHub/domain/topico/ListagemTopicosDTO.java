package com.one.forumhub.Challenge.ForumHub.domain.topico;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.one.forumhub.Challenge.ForumHub.models.entities.Topico;
import com.one.forumhub.Challenge.ForumHub.models.status.Status;

import java.time.LocalDateTime;

public record ListagemTopicosDTO(
        Long id,
        String titulo,
        String mensagem,
        @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
        LocalDateTime dataCriacao,
        Status status,
        String autor,
        String curso
) {
    public ListagemTopicosDTO(Topico topico) {
        this(
                topico.getId(),
                topico.getTitulo(),
                topico.getMensagem(),
                topico.getDataCriacao(),
                topico.getStatus(),
                topico.getAutor().getNome(),
                topico.getCurso()
        );
    }
}
