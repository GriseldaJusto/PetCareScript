grammar PetCare;

programa
    : pet+ EOF
    ;

pet
    : 'pet' STRING '{' campoPet* '}'
    ;

campoPet
    : especie
    | idade
    | tutor
    | vacina
    | remedio
    | rotina
    ;

especie
    : 'especie' ':' ESPECIE
    ;

idade
    : 'idade' ':' NUM
    ;

tutor
    : 'tutor' ':' STRING
    ;

vacina
    : 'vacina' STRING 'em' DATA
    ;

remedio
    : 'remedio' STRING 'dose' STRING 'por' NUM 'dias'
    ;

rotina
    : 'rotina' '{' itemRotina* '}'
    ;

itemRotina
    : HORA '->' STRING
    ;

ESPECIE
    : 'cachorro'
    | 'gato'
    | 'passaro'
    | 'peixe'
    | 'coelho'
    | 'outro'
    ;

DATA
    : DIGITO DIGITO DIGITO DIGITO '-' DIGITO DIGITO '-' DIGITO DIGITO
    ;

HORA
    : DIGITO DIGITO ':' DIGITO DIGITO
    ;

NUM
    : DIGITO+
    ;

STRING
    : '"' ( ~["\\\r\n] | '\\' . )* '"'
    ;

COMENTARIO
    : '#' ~[\r\n]* -> skip
    ;

WS
    : [ \t\r\n]+ -> skip
    ;

ERRO
    : .
    ;

fragment DIGITO
    : [0-9]
    ;
