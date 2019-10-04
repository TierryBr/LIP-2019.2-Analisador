//x=(2.2-3.334444444)-n/m+w*m-(2**n)/33.33+x*55+a**b
//n=((a-b)+c**d/(2.6-2)*1-e)/(f+g)
//

package br.quixada.ufc.si.anasin;

import java.util.ArrayList;
import java.util.List;

import br.quixada.ufc.si.analex.AnalexSimples;
import br.quixada.ufc.si.analex.Token;
import br.quixada.ufc.si.analex.TokenLexema;

public class AnasinSimples {
	private List<TokenLexema> tokenLexemaList;
	private ArrayList<String> print;
	private int contador = 0;
	
	
	
	public AnasinSimples(String cadeia) {
		AnalexSimples analex = new AnalexSimples(cadeia);
		this.tokenLexemaList = analex.analex();
		this.print = new ArrayList<>();
	}
	
	
	public void anasint() {
		if(this.tokenLexemaList!=null) {
			this.program();
			if(this.contador != tokenLexemaList.size()) {
				//ERRO NO ANALISADOR SINTÃ�TICO
				this.msg("ERRO NO ANALISADOR SINTÁTICO");
			}
		}
		else {
			//ERRO NO ANALISADOR LÃ‰XICO
			this.msg("ERRO NO ANALISADOR LEXICO");
		}
		
	}
	
	private void  program() {
		this.msg("Entrou program()");
		this.msg("Begin");
		this.stmt_list();
		this.msg("End");
		this.msg("Saiu program() teste id, token: " + this.nextToken());
	}
	
	public void stmt_list() {
		this.msg("Entrou no stmt_list");
		this.stmt();
		if(this.nextToken().getToken() == Token.PONTO_VIRGULA) {
			this.msg("stmt_list, "+ this.nextToken());
			this.lex();
			this.stmt_list();
		}
		this.msg("Saiu do stmt_list");

	}
	
	public void stmt() {
		this.msg("Entrou no stmt, token: " + this.nextToken());
		if(this.nextToken().getToken() == Token.IDENTIFICADOR) {
			this.msg("id: " + this.nextToken());
			this.lex();
			if(this.nextToken().getToken() == Token.OPERADOR_ATRIB) {
				this.msg("token: " + this.nextToken());
				this.lex();
				this.expression();
			}
		}
		this.msg("Saiu do stmt teste id, token: " + this.nextToken());

	}
	
	public void expression() {
		this.msg("Entrou expression(), token: " + this.nextToken());
		this.term();
		while(this.nextToken().getToken() == Token.OPERADOR_SOMA ||
			  this.nextToken().getToken() == Token.OPERADOR_SUBT) {
			this.lex();
			if(this.nextToken().getToken() == Token.OPERADOR_SOMA || this.nextToken().getToken() == Token.OPERADOR_SUBT) {
				this.msg("ERRO: OPERADOR: SOMA OU SUBTRAÇÃO REPETIDOS");
			}else{
				this.term();
			}
		}
		this.msg("Saiu expr(), token: " + this.nextToken());
		
	}
	
	private void term() {
		this.msg("Entrou term(), token: " + this.nextToken());
		this.factor();
		while(this.nextToken().getToken() == Token.OPERADOR_MULT ||
			  this.nextToken().getToken() == Token.OPERADOR_DIVI) {
			this.lex();
			
		if(this.nextToken().getToken() == Token.OPERADOR_MULT || this.nextToken().getToken() == Token.OPERADOR_DIVI) {
			this.msg("ERRO: OPERADOR: MULTIPLICAÇÃO OU DIVISÃO REPETIDOS");
		}else{
			this.factor();
			}
		}
		
		
		this.msg("Saiu term(), token: " + this.nextToken());
	}
	
	
	private void factor() {
		this.msg("Entrou factor(), token: " + this.nextToken());
		this.expr();
		if(this.nextToken().getToken() == Token.OPERADOR_EXP) {
			this.lex();
			
			if(this.nextToken().getToken() == Token.OPERADOR_MULT) {
				this.msg("ERRO: OPERADOR *** NÃO FAZ PARTE DA LINGUAGEM");
			}else {
				this.msg("Operador de Exponenciação, Token: **");
				this.factor();
			}
			
		}
		if(this.nextToken().getToken() == Token.OPERADOR_MULT){
			this.msg(""+this.nextToken());
			this.lex();
			this.factor();
		}
		this.msg("Saiu factor(), token: " + this.nextToken());
	}
	
	
	private void expr() {
		this.msg("Entrou expr(), token: " + this.nextToken());
		if(this.nextToken().getToken() == Token.IDENTIFICADOR){
			this.msg("id: " + this.nextToken());
			this.lex();
		}
		else if(this.nextToken().getToken() == Token.LITERAL_FLOAT) {
			this.msg("expr(), "+this.nextToken());
			this.lex();
		}
		else if(this.nextToken().getToken() == Token.LITERAL_INTEIRO) {
			this.msg("expr(), "+this.nextToken());
			this.lex();
		}
		else if(this.nextToken().getToken() == Token.PARENTESIS_ESQ) {
			this.msg("" + this.nextToken());
			this.lex();
			this.expression();
			if(this.nextToken().getToken() == Token.PARENTESIS_DIR) {
				this.msg("" + this.nextToken());
				this.lex();
			}
			else this.msg("ERRO: PARENTESIS DIREITO FALTANDO ");
		}else {
			this.msg("id, lit, float ou ( esperados");
		}

		this.msg("Saiu expr(), token: " + this.nextToken());
	}
	
	public void msg(String cadeia) {
		System.out.println(cadeia);
		this.print.add(cadeia);
	}
	
	private void lex() {
		if(this.contador==this.tokenLexemaList.size()) return;
		this.contador++;
	}
	
	private TokenLexema nextToken() {
		if(this.contador==this.tokenLexemaList.size()) return new TokenLexema(Token.FIM, Token.FIM.getValor()+"");
		return this.tokenLexemaList.get(this.contador);
	}
	
	public String toString() {
		String res = "";
		for (String tl : this.print) {
			res += tl;
			res += "\n";
		}
		return res;
	}
}
