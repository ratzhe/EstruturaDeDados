package br.lista;

public class ListaEncadeada<T> {//lista generica
	private Nodo inicio;//guarda o inicio 
	private Nodo fim;//e o fim
	private int tamanho = 0;
	private int capacidade = 100;

	public class Nodo {
		Nodo nodoProximo;//aponto para o proximo elemento
		private T info; // a informacao que ele carrega

		public Nodo(T obj) {//get e sets
			this.info = obj;
		}

		public void setProximo(Nodo proximo) {
			this.nodoProximo = proximo;
		}

		public Nodo getProximo() {
			return nodoProximo;
		}

		public T getInfo() {
			return this.info;
		}

		public void setInfo(T info) {
			this.info = info;
		}
	}

	public void add(T obj) {
		if (this.inicio == null) {
			Nodo nodo = new Nodo(obj);
			this.inicio = nodo;
			this.tamanho += 1;
		} else if (this.fim == null) {
			Nodo nodo = new Nodo(obj);
			this.inicio.setProximo(nodo);
			this.fim = nodo;
			this.tamanho += 1;
		} else {
			Nodo nodo = new Nodo(obj);
			this.fim.setProximo(nodo);
			this.fim = nodo;
			this.tamanho += 1;
		}
	}

	public void remove(T obj) {
		Nodo nodoTest;
		if (inicio.getInfo() == obj) { // se for no inicio
			inicio = inicio.getProximo();

		} else if (fim.getInfo() == obj) { // se for no fim
			for (int i = 0; i < this.tamanho; i++) {
				nodoTest = inicio;
				if (nodoTest.getProximo() == fim) {
					nodoTest.getProximo().setInfo(null);
					nodoTest.setProximo(nodoTest.getProximo().getProximo());
				}
			}
		} else { // se for no meio
			if (inicio.getProximo() == fim) { // se tem somente 2 objetos
				fim = inicio;
				inicio.setProximo(null);
			} else {
				for (int i = 0; i < this.tamanho; i++) {
					nodoTest = inicio;
					if (nodoTest.getProximo().getInfo() == obj) {
						nodoTest.getProximo().setInfo(null);
						nodoTest.setProximo(nodoTest.getProximo().getProximo());
					}
					nodoTest = nodoTest.getProximo();
				}
			}
		}
	}

	public Object[] getArrayDeObjetos() {//imprime
		Object[] retorno = new Object[this.tamanho];

		Nodo nodo = this.inicio;

		for (int i = 0; i < this.tamanho; i++) {
			retorno[i] = nodo.getInfo();
			nodo = nodo.getProximo();
		}

		return retorno;
	}
}