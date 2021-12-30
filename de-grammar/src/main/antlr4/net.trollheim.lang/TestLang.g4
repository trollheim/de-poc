grammar TestLang;

root : predicate;

predicate
 : statement
 | LB predicate RB
 | predicate e predicate
 | predicate OR predicate;


statement
    : value
    | value operation value;

operation : IN | EQ | LT | GT | GE | LE;

value
    : field
    | number
    | array

    | STRING_VALUE;

field : STATE LSB ID RSB;



array : LSB value* RSB;

number : MINUS ? DIGIT+ ;


DIGIT : [0-9];
STATE : 'state';
AND : 'and';
OR : 'or';

LB : '(';
RB : ')';

LSB : '[';
RSB : ']';

MINUS : '-';
IN : 'in';
EQ : '=';
GT : '>';
LT : '<';
GE : '>=';
LE : '<=';

ID : [a-zA-Z_] [a-zA-Z_0-9]*;
STRING_VALUE   :   '\'' ('\'\'' | ~ ('\''))*   '\'' ;

WS : [ \t\r\n]+ -> skip ; // skip spaces, tabs, newlines
