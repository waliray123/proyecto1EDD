
//----------------------------------------------------
// The following code was generated by CUP v0.11b 20160615 (GIT 4ac7450)
//----------------------------------------------------

package analizadores;

import java_cup.runtime.*;
import objetos.ErrorCom;
import estructuras.ListaEnlSim;
import objetos.Usuario;
import java_cup.runtime.XMLElement;

/** CUP v0.11b 20160615 (GIT 4ac7450) generated parser.
  */
@SuppressWarnings({"rawtypes"})
public class ParserUsers extends java_cup.runtime.lr_parser {

 public final Class getSymbolContainer() {
    return symU.class;
}

  /** Default constructor. */
  @Deprecated
  public ParserUsers() {super();}

  /** Constructor which sets the default scanner. */
  @Deprecated
  public ParserUsers(java_cup.runtime.Scanner s) {super(s);}

  /** Constructor which sets the default scanner. */
  public ParserUsers(java_cup.runtime.Scanner s, java_cup.runtime.SymbolFactory sf) {super(s,sf);}

  /** Production table. */
  protected static final short _production_table[][] = 
    unpackFromStrings(new String[] {
    "\000\015\000\002\002\004\000\002\005\002\000\002\006" +
    "\002\000\002\002\011\000\002\002\004\000\002\002\002" +
    "\000\002\007\002\000\002\003\005\000\002\003\004\000" +
    "\002\003\002\000\002\004\004\000\002\004\004\000\002" +
    "\004\002" });

  /** Access to production table. */
  public short[][] production_table() {return _production_table;}

  /** Parse-action table. */
  protected static final short[][] _action_table = 
    unpackFromStrings(new String[] {
    "\000\025\000\010\002\ufffc\003\005\005\004\001\002\000" +
    "\004\007\011\001\002\000\010\002\ufffc\003\005\005\004" +
    "\001\002\000\004\002\007\001\002\000\004\002\001\001" +
    "\002\000\004\002\ufffd\001\002\000\010\003\000\004\000" +
    "\010\000\001\002\000\010\003\014\004\013\010\ufff8\001" +
    "\002\000\010\003\ufffb\006\ufffb\010\ufffb\001\002\000\010" +
    "\003\014\004\013\010\ufff8\001\002\000\004\010\016\001" +
    "\002\000\010\002\uffff\003\uffff\005\uffff\001\002\000\010" +
    "\002\ufffc\003\005\005\004\001\002\000\004\002\ufffe\001" +
    "\002\000\004\010\ufff9\001\002\000\010\003\024\006\023" +
    "\010\ufff5\001\002\000\010\003\014\004\013\010\ufff8\001" +
    "\002\000\010\003\024\006\023\010\ufff5\001\002\000\004" +
    "\010\ufffa\001\002\000\004\010\ufff6\001\002\000\004\010" +
    "\ufff7\001\002" });

  /** Access to parse-action table. */
  public short[][] action_table() {return _action_table;}

  /** <code>reduce_goto</code> table. */
  protected static final short[][] _reduce_table = 
    unpackFromStrings(new String[] {
    "\000\025\000\004\002\005\001\001\000\002\001\001\000" +
    "\004\002\007\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001\000\004\005\011\001\001\000\004\003" +
    "\014\001\001\000\004\007\021\001\001\000\004\003\020" +
    "\001\001\000\002\001\001\000\004\006\016\001\001\000" +
    "\004\002\017\001\001\000\002\001\001\000\002\001\001" +
    "\000\004\004\024\001\001\000\004\003\026\001\001\000" +
    "\004\004\025\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001" });

  /** Access to <code>reduce_goto</code> table. */
  public short[][] reduce_table() {return _reduce_table;}

  /** Instance of action encapsulation class. */
  protected CUP$ParserUsers$actions action_obj;

  /** Action encapsulation object initializer. */
  protected void init_actions()
    {
      action_obj = new CUP$ParserUsers$actions(this);
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
    return action_obj.CUP$ParserUsers$do_action(act_num, parser, stack, top);
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
    ListaEnlSim<Usuario> todosUsuarios;    
    Usuario usuarioAct;

	public ParserUsers(LexerUsers lex) {
		super(lex);
        this.erroresCom = lex.getErroresCom();
        todosUsuarios = new ListaEnlSim<>();
        usuarioAct = new Usuario();        
	}

    /**
     * M??todo al que se llama autom??ticamente ante alg??n error sintactico.
     **/ 
    public void syntax_error(Symbol s){ 
        erroresCom.add(erroresCom,new ErrorCom("Sintactico","No se esperaba Componente",String.valueOf(s.left),String.valueOf(s.right),String.valueOf(s.value)));
    } 

    /**
     * M??todo al que se llama autom??ticamente ante alg??n error sint??ctico 
     * en el que ya no es posible una recuperaci??n de errores.
     **/ 
    public void unrecovered_syntax_error(Symbol s) throws java.lang.Exception{ 
        erroresCom.add(erroresCom,new ErrorCom("Sintactico","Error sintactico Irrecuperable",String.valueOf(s.left),String.valueOf(s.right),String.valueOf(s.value)));
    }

    protected int error_sync_size() {
		return 2;
	}

    private void crearUsuario(String nombreU){
        usuarioAct = new Usuario();  
        usuarioAct.setNombreUsuario(nombreU);                
    }

    private void insUsuario(){
        todosUsuarios.add(todosUsuarios,usuarioAct);
    }

    public ListaEnlSim<Usuario> getTodosUsuarios(){
        return todosUsuarios;
    }

    public ListaEnlSim<ErrorCom> getErroresCom(){
        return this.erroresCom;
    }


/** Cup generated class to encapsulate user supplied action code.*/
@SuppressWarnings({"rawtypes", "unchecked", "unused"})
class CUP$ParserUsers$actions {
  private final ParserUsers parser;

  /** Constructor */
  CUP$ParserUsers$actions(ParserUsers parser) {
    this.parser = parser;
  }

  /** Method 0 with the actual generated action code for actions 0 to 300. */
  public final java_cup.runtime.Symbol CUP$ParserUsers$do_action_part00000000(
    int                        CUP$ParserUsers$act_num,
    java_cup.runtime.lr_parser CUP$ParserUsers$parser,
    java.util.Stack            CUP$ParserUsers$stack,
    int                        CUP$ParserUsers$top)
    throws java.lang.Exception
    {
      /* Symbol object for return from actions */
      java_cup.runtime.Symbol CUP$ParserUsers$result;

      /* select the action based on the action number */
      switch (CUP$ParserUsers$act_num)
        {
          /*. . . . . . . . . . . . . . . . . . . .*/
          case 0: // $START ::= inicio EOF 
            {
              Object RESULT =null;
		int start_valleft = ((java_cup.runtime.Symbol)CUP$ParserUsers$stack.elementAt(CUP$ParserUsers$top-1)).left;
		int start_valright = ((java_cup.runtime.Symbol)CUP$ParserUsers$stack.elementAt(CUP$ParserUsers$top-1)).right;
		Object start_val = (Object)((java_cup.runtime.Symbol) CUP$ParserUsers$stack.elementAt(CUP$ParserUsers$top-1)).value;
		RESULT = start_val;
              CUP$ParserUsers$result = parser.getSymbolFactory().newSymbol("$START",0, ((java_cup.runtime.Symbol)CUP$ParserUsers$stack.elementAt(CUP$ParserUsers$top-1)), ((java_cup.runtime.Symbol)CUP$ParserUsers$stack.peek()), RESULT);
            }
          /* ACCEPT */
          CUP$ParserUsers$parser.done_parsing();
          return CUP$ParserUsers$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 1: // NT$0 ::= 
            {
              Object RESULT =null;
		int nombleft = ((java_cup.runtime.Symbol)CUP$ParserUsers$stack.elementAt(CUP$ParserUsers$top-1)).left;
		int nombright = ((java_cup.runtime.Symbol)CUP$ParserUsers$stack.elementAt(CUP$ParserUsers$top-1)).right;
		String nomb = (String)((java_cup.runtime.Symbol) CUP$ParserUsers$stack.elementAt(CUP$ParserUsers$top-1)).value;
crearUsuario(nomb);
              CUP$ParserUsers$result = parser.getSymbolFactory().newSymbol("NT$0",3, ((java_cup.runtime.Symbol)CUP$ParserUsers$stack.peek()), RESULT);
            }
          return CUP$ParserUsers$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 2: // NT$1 ::= 
            {
              Object RESULT =(Object) ((java_cup.runtime.Symbol) CUP$ParserUsers$stack.elementAt(CUP$ParserUsers$top-2)).value;
		int nombleft = ((java_cup.runtime.Symbol)CUP$ParserUsers$stack.elementAt(CUP$ParserUsers$top-4)).left;
		int nombright = ((java_cup.runtime.Symbol)CUP$ParserUsers$stack.elementAt(CUP$ParserUsers$top-4)).right;
		String nomb = (String)((java_cup.runtime.Symbol) CUP$ParserUsers$stack.elementAt(CUP$ParserUsers$top-4)).value;
insUsuario();
              CUP$ParserUsers$result = parser.getSymbolFactory().newSymbol("NT$1",4, ((java_cup.runtime.Symbol)CUP$ParserUsers$stack.peek()), RESULT);
            }
          return CUP$ParserUsers$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 3: // inicio ::= NOMU DOS_PUNT NT$0 sig PUNT_COMA NT$1 inicio 
            {
              Object RESULT =null;
              // propagate RESULT from NT$1
                RESULT = (Object) ((java_cup.runtime.Symbol) CUP$ParserUsers$stack.elementAt(CUP$ParserUsers$top-1)).value;
		int nombleft = ((java_cup.runtime.Symbol)CUP$ParserUsers$stack.elementAt(CUP$ParserUsers$top-6)).left;
		int nombright = ((java_cup.runtime.Symbol)CUP$ParserUsers$stack.elementAt(CUP$ParserUsers$top-6)).right;
		String nomb = (String)((java_cup.runtime.Symbol) CUP$ParserUsers$stack.elementAt(CUP$ParserUsers$top-6)).value;

              CUP$ParserUsers$result = parser.getSymbolFactory().newSymbol("inicio",0, ((java_cup.runtime.Symbol)CUP$ParserUsers$stack.elementAt(CUP$ParserUsers$top-6)), ((java_cup.runtime.Symbol)CUP$ParserUsers$stack.peek()), RESULT);
            }
          return CUP$ParserUsers$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 4: // inicio ::= error inicio 
            {
              Object RESULT =null;

              CUP$ParserUsers$result = parser.getSymbolFactory().newSymbol("inicio",0, ((java_cup.runtime.Symbol)CUP$ParserUsers$stack.elementAt(CUP$ParserUsers$top-1)), ((java_cup.runtime.Symbol)CUP$ParserUsers$stack.peek()), RESULT);
            }
          return CUP$ParserUsers$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 5: // inicio ::= 
            {
              Object RESULT =null;

              CUP$ParserUsers$result = parser.getSymbolFactory().newSymbol("inicio",0, ((java_cup.runtime.Symbol)CUP$ParserUsers$stack.peek()), RESULT);
            }
          return CUP$ParserUsers$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 6: // NT$2 ::= 
            {
              Object RESULT =null;
		int idImgleft = ((java_cup.runtime.Symbol)CUP$ParserUsers$stack.peek()).left;
		int idImgright = ((java_cup.runtime.Symbol)CUP$ParserUsers$stack.peek()).right;
		String idImg = (String)((java_cup.runtime.Symbol) CUP$ParserUsers$stack.peek()).value;
usuarioAct.insertarNuevoIdImagenIns(idImg);
              CUP$ParserUsers$result = parser.getSymbolFactory().newSymbol("NT$2",5, ((java_cup.runtime.Symbol)CUP$ParserUsers$stack.peek()), RESULT);
            }
          return CUP$ParserUsers$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 7: // sig ::= NUM NT$2 sigp 
            {
              Object RESULT =null;
              // propagate RESULT from NT$2
                RESULT = (Object) ((java_cup.runtime.Symbol) CUP$ParserUsers$stack.elementAt(CUP$ParserUsers$top-1)).value;
		int idImgleft = ((java_cup.runtime.Symbol)CUP$ParserUsers$stack.elementAt(CUP$ParserUsers$top-2)).left;
		int idImgright = ((java_cup.runtime.Symbol)CUP$ParserUsers$stack.elementAt(CUP$ParserUsers$top-2)).right;
		String idImg = (String)((java_cup.runtime.Symbol) CUP$ParserUsers$stack.elementAt(CUP$ParserUsers$top-2)).value;

              CUP$ParserUsers$result = parser.getSymbolFactory().newSymbol("sig",1, ((java_cup.runtime.Symbol)CUP$ParserUsers$stack.elementAt(CUP$ParserUsers$top-2)), ((java_cup.runtime.Symbol)CUP$ParserUsers$stack.peek()), RESULT);
            }
          return CUP$ParserUsers$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 8: // sig ::= error sig 
            {
              Object RESULT =null;

              CUP$ParserUsers$result = parser.getSymbolFactory().newSymbol("sig",1, ((java_cup.runtime.Symbol)CUP$ParserUsers$stack.elementAt(CUP$ParserUsers$top-1)), ((java_cup.runtime.Symbol)CUP$ParserUsers$stack.peek()), RESULT);
            }
          return CUP$ParserUsers$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 9: // sig ::= 
            {
              Object RESULT =null;

              CUP$ParserUsers$result = parser.getSymbolFactory().newSymbol("sig",1, ((java_cup.runtime.Symbol)CUP$ParserUsers$stack.peek()), RESULT);
            }
          return CUP$ParserUsers$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 10: // sigp ::= COMA sig 
            {
              Object RESULT =null;

              CUP$ParserUsers$result = parser.getSymbolFactory().newSymbol("sigp",2, ((java_cup.runtime.Symbol)CUP$ParserUsers$stack.elementAt(CUP$ParserUsers$top-1)), ((java_cup.runtime.Symbol)CUP$ParserUsers$stack.peek()), RESULT);
            }
          return CUP$ParserUsers$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 11: // sigp ::= error sigp 
            {
              Object RESULT =null;

              CUP$ParserUsers$result = parser.getSymbolFactory().newSymbol("sigp",2, ((java_cup.runtime.Symbol)CUP$ParserUsers$stack.elementAt(CUP$ParserUsers$top-1)), ((java_cup.runtime.Symbol)CUP$ParserUsers$stack.peek()), RESULT);
            }
          return CUP$ParserUsers$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 12: // sigp ::= 
            {
              Object RESULT =null;

              CUP$ParserUsers$result = parser.getSymbolFactory().newSymbol("sigp",2, ((java_cup.runtime.Symbol)CUP$ParserUsers$stack.peek()), RESULT);
            }
          return CUP$ParserUsers$result;

          /* . . . . . .*/
          default:
            throw new Exception(
               "Invalid action number "+CUP$ParserUsers$act_num+"found in internal parse table");

        }
    } /* end of method */

  /** Method splitting the generated action code into several parts. */
  public final java_cup.runtime.Symbol CUP$ParserUsers$do_action(
    int                        CUP$ParserUsers$act_num,
    java_cup.runtime.lr_parser CUP$ParserUsers$parser,
    java.util.Stack            CUP$ParserUsers$stack,
    int                        CUP$ParserUsers$top)
    throws java.lang.Exception
    {
              return CUP$ParserUsers$do_action_part00000000(
                               CUP$ParserUsers$act_num,
                               CUP$ParserUsers$parser,
                               CUP$ParserUsers$stack,
                               CUP$ParserUsers$top);
    }
}

}
