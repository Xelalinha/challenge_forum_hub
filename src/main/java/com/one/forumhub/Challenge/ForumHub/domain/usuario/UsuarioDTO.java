package com.one.forumhub.Challenge.ForumHub.domain.usuario;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UsuarioDTO(
        @NotNull
        Long id,

        @NotBlank
        String nome,

        @NotBlank
        String email,

        @NotBlank
        String senha) {

}
