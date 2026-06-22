grammar PetCare;

// REGRAS SINTÁTICAS

// Um programa é composto por um ou mais pets
programa
    : pet+ EOF
    ;

// Pet é composto pela palavra chave, o nome do pet (STRING) e seu bloco de dados ({})
pet
    : 'pet' STRING '{' campoPet* '}'
    ;

// Campos válidos dentro do bloco de dados do pet
campoPet
    : especie
    | idade
    | tutor
    | vacina
    | remedio
    | rotina
    ;

// Espécie do pet
especie
    : 'especie' ':' ESPECIE
    ;

// Idade (em anos) do pet
idade
    : 'idade' ':' NUM
    ;

// Tutor/dono do pet
tutor
    : 'tutor' ':' STRING
    ;

// Registro de uma vacina aplicada no pet e data de aplicação
vacina
    : 'vacina' STRING 'em' DATA
    ;

// Registro de um remédio com dosagem pela duração de dias
remedio
    : 'remedio' STRING 'dose' STRING 'por' NUM 'dias'
    ;

// Bloco da rotina diária do pet com itens (ações) e horários
rotina
    : 'rotina' '{' itemRotina* '}'
    ;

// Uma ação da rotina com horário específico
itemRotina
    : HORA '->' STRING
    ;

// REGRAS LÉXICAS

// Espécies registradas de pets
ESPECIE
    : 'cachorro'
    | 'gato'
    | 'passaro'
    | 'peixe'
    | 'coelho'
    | 'outro'
    ;

// Formatação da data (YYYY-MM-DD)
DATA
    : DIGITO DIGITO DIGITO DIGITO '-' DIGITO DIGITO '-' DIGITO DIGITO
    ;

// Formatação da hora (HH:MM)
HORA
    : DIGITO DIGITO ':' DIGITO DIGITO
    ;

// Numeros inteiros
NUM
    : DIGITO+
    ;

// Texto entre aspas duplas, para permitir aspas internas
STRING
    : '"' ( ~["\\\r\n] | '\\' . )* '"'
    ;

// Ignora comentários no código fonte que começam com '#'
COMENTARIO
    : '#' ~[\r\n]* -> skip
    ;

// Ignora espaços em branco, tubulaçoes e quebras de linha
WS
    : [ \t\r\n]+ -> skip
    ;

// Considera qualquer outro caracter não reconhecido como erro
ERRO
    : .
    ;

// Fragmento para ajudar na formação de outras regras léxicas
fragment DIGITO
    : [0-9]
    ;
