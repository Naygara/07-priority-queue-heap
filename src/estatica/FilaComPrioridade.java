package hospital;

public class FilaPrioridadeHeap<T extends Comparable<T>> {

    private Object[] heap;
    private int tamanho;
    private int capacidade;

    public FilaPrioridadeHeap(int capacidade) {
        this.capacidade = capacidad;
        this.heap = new Object[capacidade + 1]; // índice 0 não utilizado
        this.tamanho = 0;
    }

    public void enfileirar(T elemento) {
        if (tamanho >= capacidade) {
            throw new IllegalStateException("Heap cheio!");
        }
        tamanho++;
        heap[tamanho] = elemento;
        sobeHeap(tamanho);
    }

    @SuppressWarnings("unchecked")
    public T desenfileirar() {
        if (estaVazio()) {
            throw new IllegalStateException("Heap vazio!");
        }
        T raiz = (T) heap[1];
        heap[1] = heap[tamanho];
        heap[tamanho] = null;
        tamanho--;
        
        if (!estaVazio()) {
            desceHeap(1);
        }
        return raiz;
    }

    @SuppressWarnings("unchecked")
    public T espiar() {
        if (estaVazio()) {
            throw new IllegalStateException("Heap vazio!");
        }
        return (T) heap[1];
    }

    public boolean estaVazio() {
        return tamanho == 0;
    }

    public int getTamanho() {
        return tamanho;
    }

    @SuppressWarnings("unchecked")
    private void sobeHeap(int i) {
        while (i > 1) {
            int pai = i / 2;
            T atual = (T) heap[i];
            T elementoPai = (T) heap[pai];
            
            if (atual.compareTo(elementoPai) > 0) {
                trocar(i, pai);
                i = pai;
            } else {
                break;
            }
        }
    }

    @SuppressWarnings("unchecked")
    private void desceHeap(int i) {
        while (2 * i <= tamanho) {
            int filhoEsq = 2 * i;
            int filhoDir = filhoEsq + 1;
            int maiorFilho = filhoEsq;

            T esq = (T) heap[filhoEsq];
            T atual = (T) heap[i];

            if (filhoDir <= tamanho) {
                T dir = (T) heap[filhoDir];
                if (dir.compareTo(esq) > 0) {
                    maiorFilho = filhoDir;
                }
            }

            T itemMaiorFilho = (T) heap[maiorFilho];
            if (itemMaiorFilho.compareTo(atual) > 0) {
                trocar(i, maiorFilho);
                i = maiorFilho;
            } else {
                break;
            }
        }
    }

    private void trocar(int a, int b) {
        Object temp = heap[a];
        heap[a] = heap[b];
        heap[b] = temp;
    }

    @SuppressWarnings("unchecked")
    @Override
    public String toString() {
        if (estaVazio()) {
            return "Heap: []";
        }
        StringBuilder sb = new StringBuilder("Heap: [");
        for (int i = 1; i <= tamanho; i++) {
            sb.append(((T) heap[i]).toString());
            if (i < tamanho) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
