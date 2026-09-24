
---

## Correções aplicadas depois da implementação

**1. `AutenticacaoService` devolvia `null` (causava loop infinito).**
O código do professor é `return rep.findByEmail(username);`. Quando o e-mail não existe, o `findByEmail` devolve `null`, e o contrato do `UserDetailsService` proíbe retornar `null` — o Spring lança `InternalAuthenticationServiceException`, que vira **HTTP 500** em vez de 401. O Tomcat encaminha o 500 para `/error`, que também exige autenticação, falha do mesmo jeito, e o navegador reenvia: loop infinito (medido: 6937 voltas, 1 milhão de linhas de log). Disparado por uma credencial que o Chrome tinha salva para `localhost` de outro projeto.
Correção: lançar `UsernameNotFoundException` quando o usuário não for encontrado. Agora um e-mail inexistente devolve 401 limpo e o navegador mostra o popup.

**2. `fetch = EAGER` nas coleções `@OneToMany` (N+1).**
Como o Basic Auth reautentica a cada requisição HTTP, todo request carregava o grafo inteiro `Usuario → habitos → historicoExecucoes → statusHabito → usuario`. Abrir o Swagger (10 requisições) gerava 54 queries.
Correção: remover o `fetch = EAGER` das duas coleções, deixando o padrão do JPA (LAZY) — que além de mais rápido é menos código. `perfis` continua `EAGER`, obrigatório porque `getAuthorities()` é lido fora da sessão do Hibernate. Resultado: 54 → 20 queries (2 por requisição).
