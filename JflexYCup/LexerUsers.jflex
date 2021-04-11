package analizadores;
import java_cup.runtime.*; 
import analizadores.symC.*;
import objetos.ErrorCom;
import estructuras.ListaEnlSim;

%%

//Configuracion JFLEX
%public
%class LexerUsers
%standalone
%line
%column
%cup

//Expresiones Regulares

//Complementos de solicitud

num = [0-9]+
nombreUsuario = [a-zA-Z]+
blancos = [ \r\t\b\f\n]+



//Codigo Incrustado
%{          
    ListaEnlSim<ErrorCom> erroresCom;

    private void error(String lexeme) {
        erroresCom.add(erroresCom,new ErrorCom("Lexico","Simbolo no existe en el lenguaje",String.valueOf(yyline+1),String.valueOf(yycolumn+1),lexeme));
    }    

    public ListaEnlSim<ErrorCom> getErroresCom() {
        return erroresCom;
    }
    

%}

%init{
    erroresCom = new ListaEnlSim<>();
%init}

%%


//Reglas Lexicas
<YYINITIAL> {
    
    "," {return new Symbol(symU.COMA,yyline+1,yycolumn+1, yytext());}
    ";" {return new Symbol(symU.PUNT_COMA,yyline+1,yycolumn+1, yytext());} 
    ":" {return new Symbol(symU.DOS_PUNT,yyline+1,yycolumn+1, yytext());}           
    {num} {return new Symbol(symU.NUM,yyline+1,yycolumn+1, yytext());}  
    {nombreUsuario} {return new Symbol(symU.NOMU,yyline+1,yycolumn+1, yytext());}                           
    {blancos} {}


    

}

/* Error por cualquier otro simbolo*/
[^]
		{ error(yytext()); new Symbol(sym.error,yyline,yycolumn, yytext());}