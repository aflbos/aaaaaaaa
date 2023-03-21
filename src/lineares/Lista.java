package lineares;

public interface Lista<T> {

    void inserir(T valor);

    int buscar(T valor);

    void retirar(T valor);

    String exibir();

    Lista<T> copiar();

    int getTamanho();

    T pegar(int pos);

    void concatenar(Lista<T> outra);

    boolean estaVazia();

    Lista<T> dividir();

}