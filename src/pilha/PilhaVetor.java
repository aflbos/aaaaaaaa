package pilha;
public class PilhaVetor<T> implements Pilha<T> {
    private int limite;
    private int tamanho;
    private T[] info;

    // construtor
    public PilhaVetor(int limite) {
        this.info = (T[]) new Object[limite];
        this.limite = limite;
        this.tamanho = 0;
    }

    // métodos da interface Pilha
    @Override
    public void push(T v) {
        if(limite == tamanho){
            throw new RuntimeException("Capacidade esgotada da pilha");
        }
        info[tamanho] = v;
        tamanho++;
    }

    @Override
    public T pop() {
        T valor;
        valor = peek();
        info[tamanho] = null;
        tamanho--;
        return valor;
    }

    @Override
    public T peek() {
        if(estaVazia()){
            throw new RuntimeException("Pilha está vazia");
        }
        return info[tamanho-1];
    }

    @Override
    public boolean estaVazia() {
        return (tamanho == 0);
    }

    @Override
    public void liberar() {
        for(int i = tamanho; i >= 0; i--){
            info[i] = null;
        }
        tamanho = 0;
    }

    public String toString(){
        String s = peek().toString()+",";
        for(int i = tamanho-2; i >= 0; i--){
            s += ","+info[i].toString();
        }
        return s;
    }
}
