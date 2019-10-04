package br.quixada.ufc.si.analex;

public enum Token {
	PARENTESIS_ESQ('('),
	PARENTESIS_DIR(')'),
	OPERADOR_SOMA('+'),
	OPERADOR_MULT('*'),
	OPERADOR_EXP('*'),
	OPERADOR_DIVI('/'),
	OPERADOR_SUBT('-'),
	LITERAL_FLOAT('.'),
	OPERADOR_ATRIB('='),
	PONTO_VIRGULA(';'),
	PONTO('.'),
	FIM('F'),
	BEGIN_B('b'),
	BEGIN_E('e'),
	BEGIN_G('g'),
	BEGIN_I('i'),
	BEGIN_N('n'),
	
	IDENTIFICADOR('I'),
	LITERAL_INTEIRO('L');
	
	
	private char valor;
	
	Token(char valor) {
		this.valor = valor;
	}
	
	public char getValor() {
		return this.valor;
	}
}
