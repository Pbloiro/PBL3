package util;

public class Arvore {
	private Celula raiz;
	private int size;
	
	private class Celula implements Element{//a classe implementa a interface element pra não acessar os
		private Object data;                //dados diretamente
		private Celula pai;
		private Celula noEsquerda;
		private Celula noDireita;
		
		public Celula(Comparable data, Celula noEsquerda, Celula noDireita){
			this.data = data;
			this.noDireita = noDireita;
			this.noEsquerda = noEsquerda;
		}
		
		public Celula getPai(){
			return pai;
		}
		
		public void setPai(Celula n){
			this.pai = n;
		}
		
		public Celula getNoEsquerda(){
			return noEsquerda;
		}
		
		public void setNoEsquerda(Celula n){
			this.noEsquerda = n;
		}
		
		public Celula getNoDireita(){
			return noDireita;
		}
		
		public void setNoDireita(Celula n){
			this.noDireita = n;
		}
		
		@Override
		public Object getData() {
			return data;
		}
		
		public void setData(Object o){
			this.data = o;
		}
	}
	
	public void addRaiz(Comparable o){
		if(raiz == null){
			raiz = inserir(o, raiz);
		}
	}
	
	public Element getRaiz(){
		return raiz;
	}
	
	public Celula inserir(Comparable o, Celula n){
		if(n == null){
			n = new Celula(o, null, null);
		}else{
			
			if(o.compareTo(n.getData()) < 0){
				if(n.getNoEsquerda() != null){
					inserir(o, n.getNoEsquerda());
				} 
				else{
					n.setNoEsquerda(new Celula(o, n, null));
				}
			}
			
			else if(o.compareTo(n.getData()) > 0){
				if(n.getNoDireita() != null){
					inserir(o, n.getNoDireita());
				}
				else{
					n.setNoEsquerda(new Celula(o, null, n));
				}
			}
		}
		size++;
		return n;
	}
	
	public void remove(Element e){
		Celula n = (Celula) e;
		
		if(n.getNoEsquerda() != null && n.getNoDireita() != null){
			n.setData(n.getNoEsquerda().getData());
			remove(n.getNoEsquerda());
		}
		
		else if(n.getNoEsquerda() != null || n.getNoDireita() != null){
			Celula c = n.getNoEsquerda() != null ? n.getNoEsquerda() : n.getNoDireita();
			replace(n, c);
		}
		
		else{
			replace(n, null);
		}
		
		size--;
	}
	
	private void replace (Celula n, Celula c){
		if(n == raiz){
			raiz  = c;
		}
		else{
			if(n == n.getPai().getNoEsquerda()){
				n.getPai().setNoEsquerda(c);
			}
			else{
				n.getPai().setNoDireita(n);
			}
		}
	}
	
	public class Iterador implements Iterator{// o iterador é usado com fila, pra isso eu implementei ela 
		private IFila fila = new Fila();	//e instanciei através da interface
		
		public Iterador(){
			fila.inserirFinal(raiz);
		}
		
		@Override
		public boolean temProximo() {
			if(fila.estaVazia() == true){
				return false;
			}
			
			return true;
		}

		@Override
		public Object obterProximo() {//esse metodo ele pega os filhos da direita e da esquerda e coloca na fila
			Celula n = (Celula) fila.remover();
			
			if(n.getNoDireita() != null){
				fila.inserirFinal(n.getNoDireita());
			}
			
			if(n.getNoEsquerda() != null){
				fila.inserirFinal(n.getNoEsquerda());
			}
			
			return n.getData();
		}
		
	}
	
	
}


