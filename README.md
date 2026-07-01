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
- Cadastro global de vacinas, permitindo definir:
  - espécie à qual a vacina se aplica;
  - idade recomendada para aplicação;
  - período de validade;
- Cadastro de medicamentos;
- Cadastro de rotinas diárias;
- Verificações semânticas para garantir a consistência dos dados, incluindo:
  - validação de vacinas previamente cadastradas;
  - verificação de compatibilidade entre vacina e espécie do pet;
  - detecção de vacinas duplicadas;
  - validação de horários, datas e duração de medicamentos;
- Sistema de erros semânticos que bloqueiam a compilação;
- Sistema de warnings que avisam sobre possíveis problemas sem impedir a geração do HTML;
- Cálculo automático da próxima dose das vacinas;
- Identificação de vacinas pendentes para cada pet;
- Geração automática de uma página HTML com Bootstrap;
- Dashboard visual com cards para cada pet;
- Ícones específicos para cada espécie;
- Vacinas agrupadas por ano;
- Marcação visual de vacinas vencidas como `VENCIDA`.

---

## Objetivo da linguagem

A linguagem foi criada para permitir que tutores descrevam, de maneira simples e legível, informações importantes sobre seus animais de estimação.

Inicialmente são cadastradas as vacinas disponíveis, informando para qual espécie elas se aplicam, a idade recomendada para aplicação e sua validade. Em seguida, são cadastrados os pets e os cuidados relacionados a cada um deles.

Exemplo:

```txt
vacina "Raiva" {
  especie: cachorro
  idade: 2 anos
  validade: 1 anos
}

vacina "V10" {
  especie: cachorro
  idade: 2 meses
  validade: 1 anos
}

vacina "Raiva" {
  especie: gato
  idade: 2 meses
  validade: 1 anos
}

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

Além das validações básicas, a linguagem mantém um cadastro global de vacinas, permitindo verificar automaticamente se uma vacina aplicada foi previamente declarada, se é compatível com a espécie do pet e se está dentro das regras definidas pela linguagem.

### 4. Geração de Código

Se não forem encontrados erros semânticos, o compilador gera automaticamente um arquivo HTML em formato de dashboard contendo:

- cards individuais para cada pet;
- ícones representativos de acordo com a espécie;
- tabelas organizadas com as vacinas aplicadas;
- tabelas com os medicamentos cadastrados;
- tabela da rotina diária;
- painel com os avisos (warnings) gerados durante a compilação;
- indicação visual de vacinas vencidas;
- cálculo automático da próxima dose de cada vacina;
- exibição das vacinas pendentes para cada pet;
- status das vacinas com base na validade declarada.

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
10. Toda vacina aplicada deve estar previamente cadastrada na seção de definição de vacinas.
11. A vacina aplicada deve ser compatível com a espécie do pet.
12. Não pode haver duas definições da mesma vacina para uma mesma espécie.

Além dos erros, o compilador também implementa **warnings**, que não bloqueiam a compilação:

1. Se o pet tiver mais de 15 anos, o compilador gera um aviso recomendando checagem veterinária frequente.
2. O dashboard informa visualmente quando uma vacina está vencida e apresenta informações sobre a próxima dose e vacinas pendentes, com base nas regras cadastradas para cada vacina.

---

## Geração de Código

Após as análises léxica, sintática e semântica, o compilador gera automaticamente uma página HTML em formato de dashboard utilizando Bootstrap via CDN.

O dashboard apresenta, de forma organizada e intuitiva, todas as informações cadastradas sobre os pets, além dos resultados das verificações realizadas durante a compilação.

O HTML gerado possui:

- barra superior com o nome da linguagem;
- painel de avisos semânticos (warnings);
- cards individuais para cada pet;
- ícones específicos para cada espécie:
  - cachorro: 🐶
  - gato: 🐱
  - outro: 🐾
- informações do pet (nome, espécie, idade e tutor);
- vacinas agrupadas por ano;
- cálculo automático da próxima dose de cada vacina;
- indicação de vacinas pendentes de acordo com as regras cadastradas;
- selo `EM DIA` para vacinas válidas;
- selo `VENCIDA` para vacinas fora do período de validade;
- tabelas estilizadas para medicamentos;
- tabela organizada para a rotina diária.
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
java -jar target/PetCareScript.jar CasosDeTeste/validos/dashboard_completo.pet dashboard_completo.html
```

Depois, abra o arquivo `dashboard_completo.html` no navegador.

---

## Casos de teste

Os casos de teste estão na pasta:

```txt
CasosDeTeste/
```

O projeto disponibiliza diversos casos de teste para demonstrar o funcionamento da linguagem e validar as verificações implementadas pelo compilador.

| Caso de teste | Objetivo |
|---------------|----------|
| `luna.pet` | Exemplo da linguagem sem erros semânticos |
| `dashboard_alertas.pet` | Demonstra o dashboard visual, alertas, vacinas pendentes e vacinas vencidas |
| `dashboard_completo.pet` | Demonstra o dashboard final com múltiplas espécies, vacinas pendentes, vencidas, em dia, cálculo da próxima dose, warnings, remédios e rotina completa |
| `erro_vacina_repetida.pet` | Detecta vacinas duplicadas para um mesmo pet |
| `erro_horario.pet` | Detecta horários inválidos na rotina diária |
| `erro_remedio.pet` | Detecta duração inválida de um medicamento |
| `erro_sem_especie.pet` | Detecta ausência da espécie do pet |
| `erro_data_invalida.pet` | Detecta datas inválidas de vacinação |
| `erro_vacina_nao_registrada.pet` | Detecta o uso de uma vacina que não foi previamente cadastrada |
| `erro_vacina_especie_incompativel.pet` | Detecta o uso de uma vacina incompatível com a espécie do pet |

Após a compilação do projeto, os casos de teste podem ser executados utilizando os comandos apresentados abaixo.

### Caso válido simples

```bash
java -jar target/PetCareScript.jar CasosDeTeste/validos/luna.pet saida.html
```

### Caso válido com dashboard e warnings

```bash
java -jar target/PetCareScript.jar CasosDeTeste/validos/dashboard_alertas.pet dashboard_alertas.html
```

### Caso válido com dashboard completo

```bash
java -jar target/PetCareScript.jar CasosDeTeste/validos/dashboard_completo.pet dashboard_completo.html
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

### Vacina não registrada:

```bash
java -jar target/PetCareScript.jar CasosDeTeste/invalidos/erro_vacina_nao_registrada.pet saida_erro_vacina_nao_registrada.txt
```

### Vacina incompatível com a espécie:

```bash
java -jar target/PetCareScript.jar CasosDeTeste/invalidos/erro_vacina_especie_incompativel.pet saida_erro_especie_incompativel.txt
```

---

## Vídeo demonstrativo
