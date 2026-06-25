# PetCareScript - Trabalho 6 de Construção de Compiladores

PetCareScript é uma DSL declarativa para descrever cuidados básicos de pets, como vacinas, remédios e rotinas diárias.

O compilador lê um arquivo `.pet`, realiza análise léxica, sintática e semântica, e gera como saída uma página HTML em formato de dashboard visual.

---

## Motivação

O controle de informações relacionadas a animais de estimação, como vacinas, medicamentos e rotinas diárias, normalmente é feito por meio de anotações informais, planilhas ou aplicativos genéricos.

Essas soluções nem sempre oferecem uma forma simples, padronizada e visual de organizar os dados do animal.

O PetCareScript foi desenvolvido como uma Linguagem Específica de Domínio (Domain Specific Language - DSL) para permitir que tutores descrevam informações de seus pets de maneira simples, legível e estruturada.

A partir de um arquivo escrito na linguagem, o compilador valida as informações fornecidas e gera automaticamente uma página HTML contendo um dashboard organizado dos animais cadastrados.

---

## Características

O PetCareScript possui as seguintes características:

- Linguagem declarativa e de fácil leitura;
- Suporte ao cadastro de múltiplos pets em um mesmo arquivo;
- Registro de informações básicas dos animais:
  - nome;
  - espécie;
  - idade;
  - tutor;
- Cadastro de vacinas;
- Cadastro de medicamentos;
- Cadastro de rotinas diárias;
- Verificações semânticas para garantir a consistência dos dados;
- Sistema de erros semânticos que bloqueiam a compilação;
- Sistema de warnings que avisam sobre possíveis problemas sem impedir a geração do HTML;
- Geração automática de uma página HTML com Bootstrap;
- Cards visuais para cada pet;
- Ícones diferentes dependendo da espécie;
- Vacinas separadas por ano;
- Marcação visual de vacinas fora do ano atual como `[VENCIDA]`.

---

## Objetivo da linguagem

A linguagem foi criada para permitir que tutores descrevam, de maneira simples e legível, informações importantes sobre seus animais de estimação.

Exemplo:

```txt
pet "Luna" {
  especie: cachorro
  idade: 16
  tutor: "Karen"

  vacina "Raiva" em 2024-07-10
  vacina "V10" em 2026-08-01

  remedio "Xarope" dose "2ml" por 5 dias

  rotina {
    08:00 -> "Dar comida"
    14:00 -> "Passeio curto"
    20:00 -> "Dar remedio"
  }
}
```

---

## Arquitetura do Compilador

O compilador foi implementado em Java utilizando ANTLR4 para geração do analisador léxico e sintático.

### 1. Análise Léxica

A análise léxica identifica os tokens da linguagem, como:

- palavras-chave: `pet`, `especie`, `idade`, `tutor`, `vacina`, `remedio`, `rotina`;
- strings;
- números;
- datas;
- horários;
- símbolos como `{`, `}`, `:`, `->`.

Essa etapa é realizada pelo lexer gerado automaticamente pelo ANTLR.

### 2. Análise Sintática

A análise sintática verifica se a estrutura do arquivo segue as regras da gramática.

Por exemplo, um programa válido deve possuir um ou mais blocos `pet`, e cada bloco pode conter campos como espécie, idade, vacinas, remédios e rotina.

### 3. Análise Semântica

Após a construção da árvore sintática, o compilador executa verificações adicionais de consistência.

Essas verificações não são apenas estruturais, mas relacionadas ao significado das informações fornecidas.

### 4. Geração de Código

Se não houver erros, o compilador gera um arquivo HTML com um dashboard visual contendo:

- cards dos pets;
- ícones por espécie;
- tabelas de vacinas;
- tabelas de remédios;
- tabela de rotina diária;
- painel de avisos semânticos;
- indicação visual de vacinas vencidas.

---

## Gramática

A gramática da linguagem está no arquivo:

```txt
src/main/antlr4/br/ufscar/dc/compiladores/petcare/PetCare.g4
```

---

## Análise semântica

O compilador implementa as seguintes verificações semânticas que geram **erros** e bloqueiam a geração do HTML:

1. Cada pet deve declarar exatamente uma espécie.
2. Cada pet deve declarar exatamente uma idade.
3. A idade deve estar entre 0 e 80.
4. Não pode haver vacina repetida para o mesmo pet.
5. Horários da rotina devem estar entre `00:00` e `23:59`.
6. Não pode haver dois itens de rotina no mesmo horário para o mesmo pet.
7. A duração de um remédio deve ser maior que zero.
8. Cada pet deve possuir pelo menos uma vacina, remédio ou rotina.
9. Datas de vacina devem representar datas reais.

Além dos erros, o compilador também implementa **warnings**, que não bloqueiam a compilação:

1. Se o pet tiver mais de 15 anos, o compilador gera um aviso recomendando checagem veterinária frequente.
2. Se uma vacina não estiver registrada no ano atual, o compilador gera um aviso e o HTML marca a vacina como `[VENCIDA]`.

---

## Geração de Código

Após as análises, o compilador gera uma página HTML contendo um dashboard visual utilizando Bootstrap via CDN no cabeçalho do HTML gerado.

O dashboard possui:

- barra superior com o nome da linguagem;
- painel de avisos semânticos;
- cards para cada pet;
- ícones por espécie:
  - cachorro: 🐶
  - gato: 🐱
  - pássaro: 🐦
  - peixe: 🐟
  - coelho: 🐰
  - outro: 🐾
- vacinas agrupadas por ano;
- selo `EM DIA` para vacinas do ano atual;
- selo `[VENCIDA]` para vacinas fora do ano atual;
- tabelas estilizadas para remédios e rotina diária.

---

## Como compilar

É necessário ter Java e Maven instalados.

```bash
mvn clean package
```

---

## Como executar

Execute o compilador passando o arquivo de entrada `.pet` e o arquivo HTML de saída.

```bash
java -jar target/PetCareScript.jar CasosDeTeste/validos/dashboard_alertas.pet dashboard_alertas.html
```

```bash
java -jar target/PetCareScript.jar CasosDeTeste/validos/luna.pet saida.html
```

Depois, abra o arquivo `dashboard_alertas.html` e `saida.html` no navegador.

---

## Casos de teste

Os casos de teste estão na pasta:

```txt
CasosDeTeste/
```

### Caso válido simples

```bash
java -jar target/PetCareScript.jar CasosDeTeste/validos/luna.pet saida.html
```

### Caso válido com dashboard e warnings

```bash
java -jar target/PetCareScript.jar CasosDeTeste/validos/dashboard_alertas.pet dashboard_alertas.html
```

### Erro: vacina repetida

```bash
java -jar target/PetCareScript.jar CasosDeTeste/invalidos/erro_vacina_repetida.pet saida_erro_vacina.txt
```

### Erro: horário inválido

```bash
java -jar target/PetCareScript.jar CasosDeTeste/invalidos/erro_horario.pet saida_erro_horario.txt
```

### Erro: duração inválida de remédio

```bash
java -jar target/PetCareScript.jar CasosDeTeste/invalidos/erro_remedio.pet saida_erro_remedio.txt 
```

### Erro: pet sem espécie

```bash
java -jar target/PetCareScript.jar CasosDeTeste/invalidos/erro_sem_especie.pet saida_erro_especie.txt 
```

### Erro: data inválida

```bash
java -jar target/PetCareScript.jar CasosDeTeste/invalidos/erro_data_invalida.pet saida_erro_data.txt
```

---

## Vídeo demonstrativo
