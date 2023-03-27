package pilha;

import lineares.ListaEncadeada;

public class PilhaLista<T> implements Pilha<T> {
    private ListaEncadeada<T> lista;

    public PilhaLista(){
        lista = new ListaEncadeada<>();
    }

    // métodos
    @Override
    public void push(T info) {
        lista.inserir(info);
    }

    @Override
    public T pop() {
        T valor;
        valor = peek();
        lista.retirar(valor);
        return valor;
    }

    @Override
    public T peek() {
        if(estaVazia()){
            throw new RuntimeException("Pilha está vazia");
        }
        return lista.primeiro.getInfo();
    }

    @Override
    public boolean estaVazia() {
        return lista.estaVazia();
    }

    @Override
    public void liberar() {
        String s = lista.exibir();
        String valor = "";
        for(int i = 1; i < s.length() - 1; i++){
            if(s.charAt(i) != ','){
                valor += s.charAt(i);
            } else {
                lista.retirar((T) valor);
                valor = "";
                i++;
            }
        }
    }
}
