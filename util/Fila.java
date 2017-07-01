package util;

public class Fila implements IFila {
    private Celula head;
    private Celula tail;
    
    public class Celula {
        private Object dado;
        private Celula prox;
        
        public Celula(Object dado){
            this.dado = dado;
        }
        
        public Celula getProx(){
            return prox;
        }
        
        public void setProx(Celula prox){
            this.prox = prox;
        }
        
        public Object getDado(){
            return dado;
        }
        
        public void setDado(Object dado){
            this.dado = dado;
        }
        
    }

	public boolean estaVazia() {
		if(head == null){
			return true;
		}
		
		return false;
	}

	public int obterTamanho() {
		int cont = 0;
		
		for(Celula n = head; n!= null; n = n.getProx()){
			cont++;
		}
		
		return cont;
	}
	
	public void inserirFinal(Object o) {
		if(estaVazia()){
			head = new Celula(o);
		}
		
		else{
			Celula n = getNode(obterTamanho() - 1);
			n.setProx(new Celula(o));
		}
		
	}
	
	private Celula getNode(int index){
		if(index >=0 && index < obterTamanho()){
			Celula n = head;
			
			for(int i = 0; i < index; i++){
				n = n.getProx();
			}
			
			return n;
		}
		
		return null;
	}
	
	
	public void remove(int index){
		if (index==0){
			head = head.getProx();
		}
		
		else if(index > 0 && index <= (obterTamanho() - 1)){
			Celula ant = getNode(index - 1);
			Celula rem = ant.getProx();
			ant.setProx(rem.getProx());
		}
	}

	public Object remover() {
		Object rem = null;
		if(estaVazia() == false){
			rem = head.getDado();
			if(head == tail){
				head = tail = null;
			}
			
			else{
				head = head.getProx();
			}
		}
		
		return rem;
	}

	public Object recuperarInicio() {
		return estaVazia() ? null : head.getDado();
	}

}
