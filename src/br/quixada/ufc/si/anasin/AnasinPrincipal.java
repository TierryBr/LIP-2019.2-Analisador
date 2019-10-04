package br.quixada.ufc.si.anasin;

public class AnasinPrincipal {
	public static void main(String[] args) {
		String exp = "x=m+n+(w/k";
		AnasinSimples anasin = new AnasinSimples(exp);
		anasin.anasint();
	}
}
