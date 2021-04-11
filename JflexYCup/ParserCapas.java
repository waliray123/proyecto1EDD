
//----------------------------------------------------
// The following code was generated by CUP v0.11b 20160615 (GIT 4ac7450)
//----------------------------------------------------

package analizadores;

import java_cup.runtime.*;
import objetos.ErrorCom;
import estructuras.ListaEnlSim;
import objetos.Capa;
import objetos.Pixel;
import java_cup.runtime.XMLElement;

/** CUP v0.11b 20160615 (GIT 4ac7450) generated parser.
  */
@SuppressWarnings({"rawtypes"})
public class ParserCapas extends java_cup.runtime.lr_parser {

 public final Class getSymbolContainer() {
    return symC.class;
}

  /** Default constructor. */
  @Deprecated
  public ParserCapas() {super();}

  /** Constructor which sets the default scanner. */
  @Deprecated
  public ParserCapas(java_cup.runtime.Scanner s) {super(s);}

  /** Constructor which sets the default scanner. */
  public ParserCapas(java_cup.runtime.Scanner s, java_cup.runtime.SymbolFactory sf) {super(s,sf);}

  /** Production table. */
  protected static final short _production_table[][] = 
    unpackFromStrings(new String[] {
    "\000\016\000\002\002\004\000\002\004\002\000\002\005" +
    "\002\000\002\002\011\000\002\002\004\000\002\002\002" +
    "\000\002\006\002\000\002\007\002\000\002\010\002\000" +
    "\002\011\002\000\002\012\002\000\002\003\016\000\002" +
    "\003\004\000\002\003\002" });

  /** Access to production table. */
  public short[][] production_table() {return _production_table;}

  /** Parse-action table. */
  protected static final short[][] _action_table = 
    unpackFromStrings(new String[] {
    "\000\032\000\010\002\ufffc\003\005\004\004\001\002\000" +
    "\004\010\011\001\002\000\010\002\ufffc\003\005\004\004" +
    "\001\002\000\004\002\007\001\002\000\004\002\001\001" +
    "\002\000\004\002\ufffd\001\002\000\010\003\000\004\000" +
    "\011\000\001\002\000\010\003\015\004\ufffb\011\ufff4\001" +
    "\002\000\004\004\022\001\002\000\004\011\017\001\002" +
    "\000\010\003\015\004\ufffb\011\ufff4\001\002\000\004\011" +
    "\ufff5\001\002\000\010\002\uffff\003\uffff\004\uffff\001\002" +
    "\000\010\002\ufffc\003\005\004\004\001\002\000\004\002" +
    "\ufffe\001\002\000\004\006\ufffa\001\002\000\004\006\024" +
    "\001\002\000\004\004\025\001\002\000\004\006\ufff9\001" +
    "\002\000\004\006\027\001\002\000\004\005\030\001\002" +
    "\000\004\007\ufff8\001\002\000\004\007\032\001\002\000" +
    "\010\003\ufff7\004\ufff7\011\ufff7\001\002\000\010\003\015" +
    "\004\ufffb\011\ufff4\001\002\000\004\011\ufff6\001\002" });

  /** Access to parse-action table. */
  public short[][] action_table() {return _action_table;}

  /** <code>reduce_goto</code> table. */
  protected static final short[][] _reduce_table = 
    unpackFromStrings(new String[] {
    "\000\032\000\004\002\005\001\001\000\002\001\001\000" +
    "\004\002\007\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001\000\004\004\011\001\001\000\006\003" +
    "\013\006\012\001\001\000\002\001\001\000\002\001\001" +
    "\000\006\003\015\006\012\001\001\000\002\001\001\000" +
    "\004\005\017\001\001\000\004\002\020\001\001\000\002" +
    "\001\001\000\004\007\022\001\001\000\002\001\001\000" +
    "\002\001\001\000\004\010\025\001\001\000\002\001\001" +
    "\000\002\001\001\000\004\011\030\001\001\000\002\001" +
    "\001\000\004\012\032\001\001\000\006\003\033\006\012" +
    "\001\001\000\002\001\001" });

  /** Access to <code>reduce_goto</code> table. */
  public short[][] reduce_table() {return _reduce_table;}

  /** Instance of action encapsulation class. */
  protected CUP$ParserCapas$actions action_obj;

  /** Action encapsulation object initializer. */
  protected void init_actions()
    {
      action_obj = new CUP$ParserCapas$actions(this);
    }

  /** Invoke a user supplied parse action. */
  public java_cup.runtime.Symbol do_action(
    int                        act_num,
    java_cup.runtime.lr_parser parser,
    java.util.Stack            stack,
    int                        top)
    throws java.lang.Exception
  {
    /* call code in generated class */
    return action_obj.CUP$ParserCapas$do_action(act_num, parser, stack, top);
  }

  /** Indicates start state. */
  public int start_state() {return 0;}
  /** Indicates start production. */
  public int start_production() {return 0;}

  /** <code>EOF</code> Symbol index. */
  public int EOF_sym() {return 0;}

  /** <code>error</code> Symbol index. */
  public int error_sym() {return 1;}




    ListaEnlSim<ErrorCom> erroresCom;
    ListaEnlSim<Pixel> todosPixelesAct;
    ListaEnlSim<Capa> todasCapas;
    Capa capaAct;
    Pixel pixelAct;

	public ParserCapas(LexerCapas lex) {
		super(lex);
        this.erroresCom = lex.getErroresCom();
        todasCapas = new ListaEnlSim<>();
	}

    /**
     * Método al que se llama automáticamente ante algún error sintactico.
     **/ 
    public void syntax_error(Symbol s){ 
        erroresCom.add(erroresCom,new ErrorCom("Sintactico","No se esperaba Componente",String.valueOf(s.left),String.valueOf(s.right),String.valueOf(s.value)));
    } 

    /**
     * Método al que se llama automáticamente ante algún error sintáctico 
     * en el que ya no es posible una recuperación de errores.
     **/ 
    public void unrecovered_syntax_error(Symbol s) throws java.lang.Exception{ 
        erroresCom.add(erroresCom,new ErrorCom("Sintactico","Error sintactico Irrecuperable",String.valueOf(s.left),String.valueOf(s.right),String.valueOf(s.value)));
    }

    protected int error_sync_size() {
		return 2;
	}
    
    private void crearPixel(){
        pixelAct = new Pixel();        
    }

    private void insPixel(){
        todosPixelesAct.add(todosPixelesAct,pixelAct);
    }

    private void crearCapa(int idCapa){
        capaAct = new Capa();
        capaAct.setIdCapa(idCapa);
        todosPixelesAct = new ListaEnlSim<>();
        capaAct.setPixelesIns(todosPixelesAct);
    }

    private void insCapa(){
        todasCapas.add(todasCapas,capaAct);
    }

    public ListaEnlSim<Capa> getTodasCapas(){
        return todasCapas;
    }

    public ListaEnlSim<ErrorCom> getErroresCom(){
        return this.erroresCom;
    }


/** Cup generated class to encapsulate user supplied action code.*/
@SuppressWarnings({"rawtypes", "unchecked", "unused"})
class CUP$ParserCapas$actions {
  private final ParserCapas parser;

  /** Constructor */
  CUP$ParserCapas$actions(ParserCapas parser) {
    this.parser = parser;
  }

  /** Method 0 with the actual generated action code for actions 0 to 300. */
  public final java_cup.runtime.Symbol CUP$ParserCapas$do_action_part00000000(
    int                        CUP$ParserCapas$act_num,
    java_cup.runtime.lr_parser CUP$ParserCapas$parser,
    java.util.Stack            CUP$ParserCapas$stack,
    int                        CUP$ParserCapas$top)
    throws java.lang.Exception
    {
      /* Symbol object for return from actions */
      java_cup.runtime.Symbol CUP$ParserCapas$result;

      /* select the action based on the action number */
      switch (CUP$ParserCapas$act_num)
        {
          /*. . . . . . . . . . . . . . . . . . . .*/
          case 0: // $START ::= inicio EOF 
            {
              Object RESULT =null;
		int start_valleft = ((java_cup.runtime.Symbol)CUP$ParserCapas$stack.elementAt(CUP$ParserCapas$top-1)).left;
		int start_valright = ((java_cup.runtime.Symbol)CUP$ParserCapas$stack.elementAt(CUP$ParserCapas$top-1)).right;
		Object start_val = (Object)((java_cup.runtime.Symbol) CUP$ParserCapas$stack.elementAt(CUP$ParserCapas$top-1)).value;
		RESULT = start_val;
              CUP$ParserCapas$result = parser.getSymbolFactory().newSymbol("$START",0, ((java_cup.runtime.Symbol)CUP$ParserCapas$stack.elementAt(CUP$ParserCapas$top-1)), ((java_cup.runtime.Symbol)CUP$ParserCapas$stack.peek()), RESULT);
            }
          /* ACCEPT */
          CUP$ParserCapas$parser.done_parsing();
          return CUP$ParserCapas$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 1: // NT$0 ::= 
            {
              Object RESULT =null;
		int idCapaleft = ((java_cup.runtime.Symbol)CUP$ParserCapas$stack.elementAt(CUP$ParserCapas$top-1)).left;
		int idCaparight = ((java_cup.runtime.Symbol)CUP$ParserCapas$stack.elementAt(CUP$ParserCapas$top-1)).right;
		String idCapa = (String)((java_cup.runtime.Symbol) CUP$ParserCapas$stack.elementAt(CUP$ParserCapas$top-1)).value;
crearCapa(Integer.valueOf(idCapa));
              CUP$ParserCapas$result = parser.getSymbolFactory().newSymbol("NT$0",2, ((java_cup.runtime.Symbol)CUP$ParserCapas$stack.peek()), RESULT);
            }
          return CUP$ParserCapas$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 2: // NT$1 ::= 
            {
              Object RESULT =(Object) ((java_cup.runtime.Symbol) CUP$ParserCapas$stack.elementAt(CUP$ParserCapas$top-2)).value;
		int idCapaleft = ((java_cup.runtime.Symbol)CUP$ParserCapas$stack.elementAt(CUP$ParserCapas$top-4)).left;
		int idCaparight = ((java_cup.runtime.Symbol)CUP$ParserCapas$stack.elementAt(CUP$ParserCapas$top-4)).right;
		String idCapa = (String)((java_cup.runtime.Symbol) CUP$ParserCapas$stack.elementAt(CUP$ParserCapas$top-4)).value;
insCapa();
              CUP$ParserCapas$result = parser.getSymbolFactory().newSymbol("NT$1",3, ((java_cup.runtime.Symbol)CUP$ParserCapas$stack.peek()), RESULT);
            }
          return CUP$ParserCapas$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 3: // inicio ::= NUM CORCHI NT$0 pixl CORCHD NT$1 inicio 
            {
              Object RESULT =null;
              // propagate RESULT from NT$1
                RESULT = (Object) ((java_cup.runtime.Symbol) CUP$ParserCapas$stack.elementAt(CUP$ParserCapas$top-1)).value;
		int idCapaleft = ((java_cup.runtime.Symbol)CUP$ParserCapas$stack.elementAt(CUP$ParserCapas$top-6)).left;
		int idCaparight = ((java_cup.runtime.Symbol)CUP$ParserCapas$stack.elementAt(CUP$ParserCapas$top-6)).right;
		String idCapa = (String)((java_cup.runtime.Symbol) CUP$ParserCapas$stack.elementAt(CUP$ParserCapas$top-6)).value;

              CUP$ParserCapas$result = parser.getSymbolFactory().newSymbol("inicio",0, ((java_cup.runtime.Symbol)CUP$ParserCapas$stack.elementAt(CUP$ParserCapas$top-6)), ((java_cup.runtime.Symbol)CUP$ParserCapas$stack.peek()), RESULT);
            }
          return CUP$ParserCapas$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 4: // inicio ::= error inicio 
            {
              Object RESULT =null;

              CUP$ParserCapas$result = parser.getSymbolFactory().newSymbol("inicio",0, ((java_cup.runtime.Symbol)CUP$ParserCapas$stack.elementAt(CUP$ParserCapas$top-1)), ((java_cup.runtime.Symbol)CUP$ParserCapas$stack.peek()), RESULT);
            }
          return CUP$ParserCapas$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 5: // inicio ::= 
            {
              Object RESULT =null;

              CUP$ParserCapas$result = parser.getSymbolFactory().newSymbol("inicio",0, ((java_cup.runtime.Symbol)CUP$ParserCapas$stack.peek()), RESULT);
            }
          return CUP$ParserCapas$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 6: // NT$2 ::= 
            {
              Object RESULT =null;
crearPixel();
              CUP$ParserCapas$result = parser.getSymbolFactory().newSymbol("NT$2",4, ((java_cup.runtime.Symbol)CUP$ParserCapas$stack.peek()), RESULT);
            }
          return CUP$ParserCapas$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 7: // NT$3 ::= 
            {
              Object RESULT =(Object) ((java_cup.runtime.Symbol) CUP$ParserCapas$stack.elementAt(CUP$ParserCapas$top-1)).value;
		int filleft = ((java_cup.runtime.Symbol)CUP$ParserCapas$stack.peek()).left;
		int filright = ((java_cup.runtime.Symbol)CUP$ParserCapas$stack.peek()).right;
		String fil = (String)((java_cup.runtime.Symbol) CUP$ParserCapas$stack.peek()).value;
pixelAct.setFila(Integer.valueOf(fil));
              CUP$ParserCapas$result = parser.getSymbolFactory().newSymbol("NT$3",5, ((java_cup.runtime.Symbol)CUP$ParserCapas$stack.peek()), RESULT);
            }
          return CUP$ParserCapas$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 8: // NT$4 ::= 
            {
              Object RESULT =(Object) ((java_cup.runtime.Symbol) CUP$ParserCapas$stack.elementAt(CUP$ParserCapas$top-2)).value;
		int filleft = ((java_cup.runtime.Symbol)CUP$ParserCapas$stack.elementAt(CUP$ParserCapas$top-3)).left;
		int filright = ((java_cup.runtime.Symbol)CUP$ParserCapas$stack.elementAt(CUP$ParserCapas$top-3)).right;
		String fil = (String)((java_cup.runtime.Symbol) CUP$ParserCapas$stack.elementAt(CUP$ParserCapas$top-3)).value;
		int colleft = ((java_cup.runtime.Symbol)CUP$ParserCapas$stack.peek()).left;
		int colright = ((java_cup.runtime.Symbol)CUP$ParserCapas$stack.peek()).right;
		String col = (String)((java_cup.runtime.Symbol) CUP$ParserCapas$stack.peek()).value;
pixelAct.setColumna(Integer.valueOf(col));
              CUP$ParserCapas$result = parser.getSymbolFactory().newSymbol("NT$4",6, ((java_cup.runtime.Symbol)CUP$ParserCapas$stack.peek()), RESULT);
            }
          return CUP$ParserCapas$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 9: // NT$5 ::= 
            {
              Object RESULT =(Object) ((java_cup.runtime.Symbol) CUP$ParserCapas$stack.elementAt(CUP$ParserCapas$top-2)).value;
		int filleft = ((java_cup.runtime.Symbol)CUP$ParserCapas$stack.elementAt(CUP$ParserCapas$top-6)).left;
		int filright = ((java_cup.runtime.Symbol)CUP$ParserCapas$stack.elementAt(CUP$ParserCapas$top-6)).right;
		String fil = (String)((java_cup.runtime.Symbol) CUP$ParserCapas$stack.elementAt(CUP$ParserCapas$top-6)).value;
		int colleft = ((java_cup.runtime.Symbol)CUP$ParserCapas$stack.elementAt(CUP$ParserCapas$top-3)).left;
		int colright = ((java_cup.runtime.Symbol)CUP$ParserCapas$stack.elementAt(CUP$ParserCapas$top-3)).right;
		String col = (String)((java_cup.runtime.Symbol) CUP$ParserCapas$stack.elementAt(CUP$ParserCapas$top-3)).value;
		int colorleft = ((java_cup.runtime.Symbol)CUP$ParserCapas$stack.peek()).left;
		int colorright = ((java_cup.runtime.Symbol)CUP$ParserCapas$stack.peek()).right;
		String color = (String)((java_cup.runtime.Symbol) CUP$ParserCapas$stack.peek()).value;
pixelAct.setColor(color);
              CUP$ParserCapas$result = parser.getSymbolFactory().newSymbol("NT$5",7, ((java_cup.runtime.Symbol)CUP$ParserCapas$stack.peek()), RESULT);
            }
          return CUP$ParserCapas$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 10: // NT$6 ::= 
            {
              Object RESULT =(Object) ((java_cup.runtime.Symbol) CUP$ParserCapas$stack.elementAt(CUP$ParserCapas$top-1)).value;
		int filleft = ((java_cup.runtime.Symbol)CUP$ParserCapas$stack.elementAt(CUP$ParserCapas$top-8)).left;
		int filright = ((java_cup.runtime.Symbol)CUP$ParserCapas$stack.elementAt(CUP$ParserCapas$top-8)).right;
		String fil = (String)((java_cup.runtime.Symbol) CUP$ParserCapas$stack.elementAt(CUP$ParserCapas$top-8)).value;
		int colleft = ((java_cup.runtime.Symbol)CUP$ParserCapas$stack.elementAt(CUP$ParserCapas$top-5)).left;
		int colright = ((java_cup.runtime.Symbol)CUP$ParserCapas$stack.elementAt(CUP$ParserCapas$top-5)).right;
		String col = (String)((java_cup.runtime.Symbol) CUP$ParserCapas$stack.elementAt(CUP$ParserCapas$top-5)).value;
		int colorleft = ((java_cup.runtime.Symbol)CUP$ParserCapas$stack.elementAt(CUP$ParserCapas$top-2)).left;
		int colorright = ((java_cup.runtime.Symbol)CUP$ParserCapas$stack.elementAt(CUP$ParserCapas$top-2)).right;
		String color = (String)((java_cup.runtime.Symbol) CUP$ParserCapas$stack.elementAt(CUP$ParserCapas$top-2)).value;
insPixel();
              CUP$ParserCapas$result = parser.getSymbolFactory().newSymbol("NT$6",8, ((java_cup.runtime.Symbol)CUP$ParserCapas$stack.peek()), RESULT);
            }
          return CUP$ParserCapas$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 11: // pixl ::= NT$2 NUM NT$3 COMA NUM NT$4 COMA HEXA NT$5 PUNT_COMA NT$6 pixl 
            {
              Object RESULT =null;
              // propagate RESULT from NT$6
                RESULT = (Object) ((java_cup.runtime.Symbol) CUP$ParserCapas$stack.elementAt(CUP$ParserCapas$top-1)).value;
		int filleft = ((java_cup.runtime.Symbol)CUP$ParserCapas$stack.elementAt(CUP$ParserCapas$top-10)).left;
		int filright = ((java_cup.runtime.Symbol)CUP$ParserCapas$stack.elementAt(CUP$ParserCapas$top-10)).right;
		String fil = (String)((java_cup.runtime.Symbol) CUP$ParserCapas$stack.elementAt(CUP$ParserCapas$top-10)).value;
		int colleft = ((java_cup.runtime.Symbol)CUP$ParserCapas$stack.elementAt(CUP$ParserCapas$top-7)).left;
		int colright = ((java_cup.runtime.Symbol)CUP$ParserCapas$stack.elementAt(CUP$ParserCapas$top-7)).right;
		String col = (String)((java_cup.runtime.Symbol) CUP$ParserCapas$stack.elementAt(CUP$ParserCapas$top-7)).value;
		int colorleft = ((java_cup.runtime.Symbol)CUP$ParserCapas$stack.elementAt(CUP$ParserCapas$top-4)).left;
		int colorright = ((java_cup.runtime.Symbol)CUP$ParserCapas$stack.elementAt(CUP$ParserCapas$top-4)).right;
		String color = (String)((java_cup.runtime.Symbol) CUP$ParserCapas$stack.elementAt(CUP$ParserCapas$top-4)).value;

              CUP$ParserCapas$result = parser.getSymbolFactory().newSymbol("pixl",1, ((java_cup.runtime.Symbol)CUP$ParserCapas$stack.elementAt(CUP$ParserCapas$top-11)), ((java_cup.runtime.Symbol)CUP$ParserCapas$stack.peek()), RESULT);
            }
          return CUP$ParserCapas$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 12: // pixl ::= error pixl 
            {
              Object RESULT =null;

              CUP$ParserCapas$result = parser.getSymbolFactory().newSymbol("pixl",1, ((java_cup.runtime.Symbol)CUP$ParserCapas$stack.elementAt(CUP$ParserCapas$top-1)), ((java_cup.runtime.Symbol)CUP$ParserCapas$stack.peek()), RESULT);
            }
          return CUP$ParserCapas$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 13: // pixl ::= 
            {
              Object RESULT =null;

              CUP$ParserCapas$result = parser.getSymbolFactory().newSymbol("pixl",1, ((java_cup.runtime.Symbol)CUP$ParserCapas$stack.peek()), RESULT);
            }
          return CUP$ParserCapas$result;

          /* . . . . . .*/
          default:
            throw new Exception(
               "Invalid action number "+CUP$ParserCapas$act_num+"found in internal parse table");

        }
    } /* end of method */

  /** Method splitting the generated action code into several parts. */
  public final java_cup.runtime.Symbol CUP$ParserCapas$do_action(
    int                        CUP$ParserCapas$act_num,
    java_cup.runtime.lr_parser CUP$ParserCapas$parser,
    java.util.Stack            CUP$ParserCapas$stack,
    int                        CUP$ParserCapas$top)
    throws java.lang.Exception
    {
              return CUP$ParserCapas$do_action_part00000000(
                               CUP$ParserCapas$act_num,
                               CUP$ParserCapas$parser,
                               CUP$ParserCapas$stack,
                               CUP$ParserCapas$top);
    }
}

}
