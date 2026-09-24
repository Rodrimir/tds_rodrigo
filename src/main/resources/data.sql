insert into perfis(id, nome) values (1, 'ROLE_ADMIN');
insert into perfis(id, nome) values (2, 'ROLE_USER');

insert into usuarios(id, nome, email, senha, fuso_horario, preferencia_idioma, criado_em)
values (1, 'Admin do Sistema', 'teste@gmail.com', '$2a$10$sgwa1qGxcP0UwggB4Hgkv.qkijQ96O8E9cmooZOAFhNMf43/4zYMq', 'America/Sao_Paulo', 'pt-BR', '2026-09-24');
insert into usuarios(id, nome, email, senha, fuso_horario, preferencia_idioma, criado_em)
values (2, 'Usuario do Sistema', 'user@email.com', '$2a$10$owFx7pNfnQaneYk9H2I9NuMrni30y98VBCm6Rz.i68sx2PZrYytVe', 'America/Sao_Paulo', 'pt-BR', '2026-09-24');

insert into usuarios_perfis(usuarios_id, perfis_id) values (1, 1);
insert into usuarios_perfis(usuarios_id, perfis_id) values (2, 2);

insert into habitos(id, titulo, categoria, tipo_medida, gatilho_ancora, modalidade, meta_base, meta_maxima, incremento, dias_incremento, frequencia_semanal, ativo, criado_em, usuario_id)
values (1, 'Ler', 'Estudo', 'PAGINAS', 'Depois do cafe', 'DIARIO', 10, 30, 1, 10, '1111111', true, '2026-09-24', 2),
       (2, 'Correr', 'Saude', 'MINUTOS', 'Ao acordar', 'DIARIO', 20, 60, 5, 10, '1010100', true, '2026-09-24', 2),
       (3, 'Meditar', 'Bem-estar', 'MINUTOS', 'Antes de dormir', 'DIARIO', 5, 20, 1, 15, '1111100', true, '2026-09-24', 1);

insert into biblioteca_textos(id, categoria, idioma, texto_pre_tarefa, texto_sucesso_padrao, texto_sucesso_extra, texto_aviso_urgencia)
values (1, 'Estudo', 'pt-BR', 'Hora de comecar.', 'Mandou bem!', 'Voce superou a meta!', 'O prazo esta acabando.'),
       (2, 'Saude', 'pt-BR', 'Bora se mexer.', 'Missao cumprida!', 'Foi alem do combinado!', 'Ainda da tempo hoje.');
