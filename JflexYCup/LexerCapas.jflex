package analizadores;
import java_cup.runtime.*; 
import analizadores.symC.*;
import objetos.ErrorCom;
import estructuras.ListaEnlSim;

%%

//Configuracion JFLEX
%public
%class LexerCapas
%standalone
%line
%column
%cup

//Expresiones Regulares

//Complementos de solicitud

num = [0-9]+
hexa = "#"[0-9a-fA-F]+
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
    
    "," {return new Symbol(symC.COMA,yyline+1,yycolumn+1, yytext());}
    ";" {return new Symbol(symC.PUNT_COMA,yyline+1,yycolumn+1, yytext());} 
    "{" {return new Symbol(symC.CORCHI,yyline+1,yycolumn+1, yytext());} 
    "}" {return new Symbol(symC.CORCHD,yyline+1,yycolumn+1, yytext());}           
    {num} {return new Symbol(symC.NUM,yyline+1,yycolumn+1, yytext());}  
    {hexa} {return new Symbol(symC.HEXA,yyline+1,yycolumn+1, yytext());}                           
    {blancos} {}


    

}

/* Error por cualquier otro simbolo*/
[^]
		{ error(yytext()); new Symbol(sym.error,yyline,yycolumn, yytext());}
