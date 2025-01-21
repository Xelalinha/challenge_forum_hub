package com.one.forumhub.Challenge.ForumHub.domain.usuario;

import jakarta.validation.constraints.NotBlank;

public record CadastroUsuarioDTO(
        @NotBlank
        String email,

        @NotBlank
        String nome,

        @NotBlank
        String senha
) {
}
