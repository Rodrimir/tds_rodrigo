package com.ifsul.tds_rodrigo.infra.exception;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.ConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class TratadorDeErros {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<ErroValidacaoDto>> tratarErroValidacao(MethodArgumentNotValidException ex) {
        var erros = ex.getFieldErrors().stream().map(ErroValidacaoDto::new).toList();
        return ResponseEntity.badRequest().body(erros);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ErroRespostaDto> tratarErroConstraint(ConstraintViolationException ex) {
        return ResponseEntity.badRequest().body(new ErroRespostaDto(HttpStatus.BAD_REQUEST.value(), ex.getMessage()));
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ErroRespostaDto> tratarErroCorpoInvalido() {
        return ResponseEntity.badRequest()
                .body(new ErroRespostaDto(HttpStatus.BAD_REQUEST.value(), "Corpo da requisicao invalido."));
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ErroRespostaDto> tratarErroNaoEncontrado() {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ErroRespostaDto(HttpStatus.NOT_FOUND.value(), "Registro nao encontrado."));
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ErroRespostaDto> tratarErroIntegridade() {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(new ErroRespostaDto(HttpStatus.CONFLICT.value(), "Dados violam uma restricao do banco."));
    }

    @ExceptionHandler({BadCredentialsException.class, UsernameNotFoundException.class})
    public ResponseEntity<ErroRespostaDto> tratarErroCredenciais() {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                .body(new ErroRespostaDto(HttpStatus.UNAUTHORIZED.value(), "Email ou senha invalidos."));
    }

    @ExceptionHandler(AuthenticationException.class)
    public ResponseEntity<ErroRespostaDto> tratarErroAutenticacao() {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                .body(new ErroRespostaDto(HttpStatus.UNAUTHORIZED.value(), "Falha na autenticacao."));
    }

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<ErroRespostaDto> tratarErroAcessoNegado() {
        return ResponseEntity.status(HttpStatus.FORBIDDEN)
                .body(new ErroRespostaDto(HttpStatus.FORBIDDEN.value(), "Acesso negado."));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErroRespostaDto> tratarErroInterno(Exception ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ErroRespostaDto(HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getMessage()));
    }
}
