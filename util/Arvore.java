package util;

public class Arvore {
	private Celula raiz;
	private int size;
	
	private class Celula implements Element{//a classe implementa a interface element pra não acessar os
		private Object data;                //dados diretamente
		private Celula pai;
		private Celula noEsquerda;
		private Celula noDireita;
		
		public Celula(Celula pai, Object data){
			this.pai = pai;
			this.data = data;
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
	
	/*o metodo de inserir tá errado, pq não tá inserindo ordenado, tem que ser tipo isso:
	
	*  public void inserir(Node node, int valor) {
        if(this.root == null){
            this.root = new Node(valor);
        } else {
            if (valor < node.getValor()) {
                if (node.getNoEsquerda() != null) { 
                    inserir(node.getNoEsquerda(), valor); 
                } else { 
                    //Se nodo esquerdo vazio insere o novo no aqui 
                    node.setNoEsquerda(new Node(valor)); 
                } 
                //Verifica se o valor a ser inserido é maior que o no corrente da árvore, se sim vai para subarvore direita 
            } else if (valor > node.getValor()) { 
                //Se tiver elemento no no direito continua a busca 
                if (node.getNoDireita() != null) { 
                    inserir(node.getNoDireita(), valor); 
                } else {
                    //Se nodo direito vazio insere o novo no aqui 
                    node.setNoDireita(new Node(valor)); 
                } 
            }
        }
    } mas eu não sei como faz com objetos, vê se tu consegue fazer*/
	public void addRaiz(Object o){
		if(raiz == null){
			raiz = new Celula(null, o);
		}
	}
	
	public Element getRaiz(){
		return raiz;
	}
	
	public void addNoDireita(Element e, Object o){
		((Celula) e).setNoDireita(new Celula((Celula) e, o));//casting de element para celula nos dois casos
		size++;
	}
	
	public Element getNoDireita(Element e){
		return ((Celula) e).getNoDireita();//mesmo casting aqui
	}
	
	public void addNoEsquerda(Element e, Object o){
		((Celula) e).setNoEsquerda(new Celula((Celula) e, o));//mesmo caso do add direita
		size++;
	}
	
	public Element getNoEsquerda(Element e){
		return ((Celula) e).getNoEsquerda();
	}
	
	public void set(Element e, Object o){//setta um dado em uma celula da arvore, dando casting de element para celula
		((Celula) e).setData(o);
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
