package listaLigadas;

public class ListaLigada {
	
	private Celula primeira = null;
	private Celula ultima = null;
	private int total = 0;
	
	public void adicionaNoComeco(Object elemento) {
		
		Celula nova = new Celula(elemento, this.primeira);
		
		this.primeira = nova;
		
		if(this.total == 0) {
			this.ultima = this.primeira;		
		}
		this.total++;
	}
	
	public void adicionaNoFinal(Object elemento) { //Met�do para adicionar no Final da lista
		
		if(this.total == 0) {
			adicionaNoComeco(elemento);
		}
		else {
		Celula nova = new Celula(elemento, null);	
			
		this.ultima.setProximo(nova);
		this.ultima = nova;
		this.total++;
		}
	}
	
	public void adiciona(int posicao, Object elemento) {
		if(posicao == 0) {
			//Se a posi��o desejda for igual a 0, ent�o seria a mesma coisa que adicionar no come�o 
			this.adicionaNoComeco(elemento);
		}
		else if(posicao == this.total) {
			//Se a posi��o desejda for igual ao total de elementos, ent�o adicionamos no final
			this.adicionaNoFinal(elemento);
		}
		else {
			Celula anterior = this.pegaCelula(posicao -1);
			//pego a celula anterior a posi��o que desejo adicionar uma nova celula; 
			Celula nova = new Celula(elemento, anterior.getProximo());
			anterior.setProximo(nova);
			this.total++;
		}
	}
	
	private Celula pegaCelula(int posicao) {
		
		Celula atual = this.primeira;
		if(posicao >= 0 && posicao < total) {
			for(int i = 0; i < posicao; i++ ) {
				atual = atual.getProximo();		
			}
		}
		else {
			System.out.println("Posi��o invalida!");
		}
		return  atual;
	}
	
	public Object pegaElemento(int posicao) { // Met�do para acessar os elementos da lista
		return this.pegaCelula(posicao).getElemento();
	}
	
	public void removeNoComeco() { // Metodo para remover no come�o
		if (this.total > 0) {
			this.primeira = this.primeira.getProximo();
			this.total--;
			if(this.total == 0) {
				this.ultima = null;
			}
		}
		else {
			System.out.println("N�o existe nada nesta posi��o!");
		}
	}
	
	public void remove() { // Metodo para remover no Final
		if (this.total == 1) {
			this.removeNoComeco();
		}
		else if (this.total > 1){
			Celula penultima = pegaCelula(this.total -2);
			penultima.setProximo(null);
			this.ultima = penultima;
			this.total --;
		}
		else {
			System.out.println("N�o existe nada nesta posi��o!");
		}
	}
	
	public void removePorPosicao(int posicao) {
		if (this.total == 1 && posicao ==1) {
			removeNoComeco();
		}
		else if(posicao == this.total -1 && this.total > 1) {
			remove();
		}
		else if(this.total > 1) {
			Celula anterior = pegaCelula(posicao -1);
			anterior.setProximo(anterior.getProximo().getProximo());
			this.total --;
		}
		else if(posicao > this.total){
			System.out.println("Posi��o n�o existe");
		}
		else {
			System.out.println("Posi��o n�o existe");
		}
	}

		
	/*public int size() { //Retorna o tamanho da Lista
		return total;
	}
	
	public boolean isEmpty() { //Verifica se a Lista est� vazia
		return (total == 0);
	}
	private boolean posicaoOcupada(int posicao) {
		return posicao >= 0 && posicao < this.total; 
	}*/
	
	
	@Override
	public String toString() {
		
		//Fiz o String Builder para formatar a sa�da
		
		if(total == 0) {
			return "[]";
		}
		Celula atual = primeira;
		StringBuilder builder = new StringBuilder("[Inicio --> ");
		
		for(int i = 0; i < total; i++) {
			
			builder.append(atual.getElemento());
			builder.append(", ");
			
			atual = atual.getProximo();
		}
		builder.append(" <-- Fim]");
	
	return builder.toString();
	}
}
