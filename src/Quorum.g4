grammar Quorum;

//channels { WHITESPACE_CHANNEL, COMMENT_CHANNEL }

start
    : (OUTPUT
    | ON
    | CREATE
    | CONSTANT
    | ELSE_IF
    | ME
    | UNTIL
    | PUBLIC
    | PRIVATE
    | ALERT
    | DETECT
    | ALWAYS
    | CHECK
    | PARENT
    | BLUEPRINT
    | NATIVE
    | INHERITS
    | CAST
    | INPUT
    | SAY
    | NOW
    | WHILE
    | PACKAGE_NAME
    | TIMES
    | REPEAT
    | ELSE
    | RETURNS
    | RETURN
    | AND
    | OR
    | NULL
    | STATIC
    | ACTION
    | COLON
    | INTEGER_KEYWORD
    | NUMBER_KEYWORD
    | TEXT
    | BOOLEAN_KEYWORD
    | USE
    | NOT
    | NOTEQUALS
    | PERIOD
    | COMMA
    | EQUALITY
    | GREATER
    | GREATER_EQUAL
    | LESS
    | LESS_EQUAL
    | PLUS
    | MINUS
    | MULTIPLY
    | DIVIDE
    | MODULO
    | LEFT_SQR_BRACE
    | RIGHT_SQR_BRACE
    | LEFT_PAREN
    | RIGHT_PAREN
    | DOUBLE_QUOTE
    | IF
    | END
    | CLASS
    | BOOLEAN
    | INT
    | DECIMAL
    | ID
    )* EOF
    ;

OUTPUT	:	'output';
ON	    :	'on';
CREATE	:	'create';
CONSTANT:	'constant';
ELSE_IF :	'elseif';
ME	    :	'me';
UNTIL	:	'until';
PUBLIC	:	'public';
PRIVATE	:	'private';
ALERT	:	'alert';
DETECT	:	'detect';
ALWAYS	:	'always';
CHECK	:	'check';
PARENT	:	'parent';
BLUEPRINT:	'blueprint';
NATIVE  :	'system';
INHERITS:	'is';
CAST	:	'cast';
INPUT	:	'input';
SAY	    :   'say';
NOW	    :   'now';
WHILE	:	'while';
PACKAGE_NAME :	'package';
TIMES	:	'times';
REPEAT	:	'repeat';
ELSE 	:	'else';
RETURNS :	'returns';
RETURN 	:	'return';
AND	    :	'and';
OR 	    :	'or';
NULL	:	'undefined';
STATIC  :   'shared';
ACTION  :	'action';
COLON	:	':';
INTEGER_KEYWORD	:	'integer';
NUMBER_KEYWORD	:	'number';
TEXT	:	'text';
BOOLEAN_KEYWORD	:	'boolean';
USE 	:	'use';
NOT	    :	'not' | 'Not';
NOTEQUALS :	('n' | 'N' ) 'ot=';
PERIOD	:	'.';
COMMA	:	',';
EQUALITY:	'=';
GREATER	:	'>';
GREATER_EQUAL :	'>=';
LESS	:	'<';
LESS_EQUAL :	'<=';
PLUS	:	'+';
MINUS	:	'-';
MULTIPLY:	'*';
DIVIDE	:	'/';
MODULO	:	'mod';
LEFT_SQR_BRACE :	'[';
RIGHT_SQR_BRACE:	']';
LEFT_PAREN:	'(';
RIGHT_PAREN:	')';
DOUBLE_QUOTE:	'"';
IF	:	'if';
END	:	'end';
CLASS	:	'class';
BOOLEAN	:	'true' | 'false';
INT 	:	'0'..'9'+;
DECIMAL	:	'0'..'9'+ (PERIOD ('0'..'9')*)?;
ID 	: 	('a'..'z'|'A'..'Z')('a'..'z'|'A'..'Z'|'0'..'9' | '_')*;
STRING	:	DOUBLE_QUOTE .*? DOUBLE_QUOTE;

WS	:	(' '|'\t'|'\n'|'\r')+ -> skip;

COMMENTS
    :   ('//' ~('\n'|'\r')* (('\r'? '\n') | EOF)
    |   '/*' .*? '*/') -> skip
    ;
