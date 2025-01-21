package com.one.forumhub.Challenge.ForumHub.controller;

import com.one.forumhub.Challenge.ForumHub.domain.topico.AtualizarTopicoDTO;
import com.one.forumhub.Challenge.ForumHub.domain.topico.CadastroTopicoDTO;
import com.one.forumhub.Challenge.ForumHub.domain.topico.DetalhesTopicoDTO;
import com.one.forumhub.Challenge.ForumHub.domain.topico.ListagemTopicosDTO;
import com.one.forumhub.Challenge.ForumHub.models.entities.Topico;
import com.one.forumhub.Challenge.ForumHub.repositorios.TopicoRepository;
import com.one.forumhub.Challenge.ForumHub.repositorios.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository repository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrarTopico(@RequestBody @Valid CadastroTopicoDTO dados, UriComponentsBuilder builder) {
        var topico = new Topico(dados, usuarioRepository);
        repository.save(topico);

        var uri = builder.path("/topicos/{id}")
                .buildAndExpand(topico.getId()).toUri();

        return ResponseEntity.created(uri).body(new DetalhesTopicoDTO(topico));
    }

    @GetMapping
    public ResponseEntity<Page<ListagemTopicosDTO>> listarTopicos(Pageable paginacao) {
        var page = repository.findAll(paginacao)
                .map(ListagemTopicosDTO::new);

        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity detalharTopico(@PathVariable Long id) {
        var topico = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Id do tópico não existe"));

        return ResponseEntity.ok(new DetalhesTopicoDTO(topico));
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizarTopico(@RequestBody @Valid AtualizarTopicoDTO dados) {
        var topico = repository.getReferenceById(dados.id());
        topico.atualizarInfo(dados);

        return ResponseEntity.ok(new DetalhesTopicoDTO(topico));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluirTopico(@PathVariable Long id) {
        if (!repository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Id do tópico não existe");
        }

        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}