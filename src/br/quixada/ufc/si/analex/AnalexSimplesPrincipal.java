package br.quixada.ufc.si.analex;

public class AnalexSimplesPrincipal {
	public static void main(String[] args) {
		String exp = "x = (soma2 + 34) * (fator1 ** 2);";
		AnalexSimples analexSimples = new AnalexSimples(exp);
		analexSimples.analex();
		System.out.println(analexSimples);
	}
}
