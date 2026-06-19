# PetCareScript - Trabalho 6 de Construção de Compiladores

PetCareScript é uma DSL declarativa para descrever cuidados básicos de pets, como vacinas, remédios e rotinas diárias.

O compilador lê um arquivo `.pet`, realiza análise léxica, sintática e semântica, e gera como saída uma página HTML com um relatório organizado.

## Objetivo da linguagem

A linguagem foi criada para permitir que tutores descrevam, de maneira simples e legível, informações importantes sobre seus animais de estimação.

Exemplo:

```txt
pet "Luna" {
  especie: cachorro
  idade: 13
  tutor: "Karen"

  vacina "Raiva" em 2026-07-10
  remedio "Xarope" dose "2ml" por 5 dias

  rotina {
    08:00 -> "Dar comida"
    20:00 -> "Dar remedio"
  }
}
```

## Estrutura da linguagem

Um programa PetCareScript possui um ou mais blocos `pet`.

Cada pet pode conter:

- `especie`
- `idade`
- `tutor`
- `vacina`
- `remedio`
- `rotina`

## Análise léxica e sintática

A análise léxica e sintática é feita com ANTLR 4.

A gramática está em:

```txt
src/main/antlr4/br/ufscar/dc/compiladores/petcare/PetCare.g4
```

## Análise semântica

O compilador implementa as seguintes verificações semânticas:

1. Cada pet deve declarar exatamente uma espécie.
2. Cada pet deve declarar exatamente uma idade.
3. A idade deve estar entre 0 e 80.
4. Não pode haver vacina repetida para o mesmo pet.
5. Horários da rotina devem estar entre 00:00 e 23:59.
6. Não pode haver dois itens de rotina no mesmo horário para o mesmo pet.
7. A duração de um remédio deve ser maior que zero.
8. Cada pet deve possuir pelo menos uma vacina, remédio ou rotina.

## Geração de código

Após as análises, o compilador gera uma página HTML contendo:

- ficha do pet;
- tabela de vacinas;
- tabela de remédios;
- tabela de rotina.

## Como compilar

É necessário ter Java e Maven instalados.

```bash
mvn clean package
```

## Como executar

```bash
java -jar target/PetCareScript.jar exemplos/validos/luna.pet saida.html
```

Depois, abra o arquivo `saida.html` no navegador.

## Casos de teste

### Caso válido

```bash
java -jar target/PetCareScript.jar exemplos/validos/luna.pet saida.html
```

### Erro: vacina repetida

```bash
java -jar target/PetCareScript.jar exemplos/invalidos/erro_vacina_repetida.pet saida.txt
```

### Erro: horário inválido

```bash
java -jar target/PetCareScript.jar exemplos/invalidos/erro_horario.pet saida.txt
```

### Erro: duração inválida de remédio

```bash
java -jar target/PetCareScript.jar exemplos/invalidos/erro_remedio.pet saida.txt
```

### Erro: pet sem espécie

```bash
java -jar target/PetCareScript.jar exemplos/invalidos/erro_sem_especie.pet saida.txt
```

## Vídeo demonstrativo

