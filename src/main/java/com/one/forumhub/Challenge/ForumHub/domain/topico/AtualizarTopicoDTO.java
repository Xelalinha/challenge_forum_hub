package com.one.forumhub.Challenge.ForumHub.domain.topico;

import jakarta.validation.constraints.NotNull;

public record AtualizarTopicoDTO(
    @NotNull
    Long id,

    String titulo,
    String mensagem,
    String curso
) {
}
