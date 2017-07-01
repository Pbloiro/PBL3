package util;

public interface IFila {
    public boolean estaVazia();

    public int obterTamanho();

    public void inserirFinal(Object o);

    public Object remover();

    public Object recuperarInicio();   
}
