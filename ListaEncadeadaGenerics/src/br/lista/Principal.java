package br.lista;

public class Principal {
	public static <T> void main(String[] args) {
        ListaEncadeada<String> lista = new ListaEncadeada<>();
        String s1 = "Brazil";
        String s2 = "Germany";
        String s3 = "EUA";

        lista.add(s1);
        lista.add(s2);
        lista.add(s3);

        Object dados[] = lista.getArrayDeObjetos();
        for (Object string : dados) {
            System.out.println(string);
        }

    }
}
