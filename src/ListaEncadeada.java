public class ListaEncadeada<T> {
    private Node<T> inicio;
    private int tamanho;

    public ListaEncadeada() {
        this.inicio = null;
        this.tamanho = 0;
    }

    // Inserção
    public void adicionarNoInicio(T valor) {
        Node<T> novoNo = new Node<>(valor);
        novoNo.setProximo(inicio);
        inicio = novoNo;
        tamanho++;
    }

    public void adicionarNoFim(T valor) {
        Node<T> novoNo = new Node<>(valor);
        if (inicio == null) {
            inicio = novoNo;
        } else {
            Node<T> atual = inicio;
            while (atual.getProximo() != null) {
                atual = atual.getProximo();
            }
            atual.setProximo(novoNo);
        }
        tamanho++;
    }

    public void adicionarNaPosicao(int posicao, T valor) {
        if (posicao < 0 || posicao > tamanho) {
            throw new IndexOutOfBoundsException("Posição inválida");
        }
        if (posicao == 0) {
            adicionarNoInicio(valor);
        } else if (posicao == tamanho) {
            adicionarNoFim(valor);
        } else {
            Node<T> novoNo = new Node<>(valor);
            Node<T> atual = inicio;
            for (int i = 0; i < posicao - 1; i++) {
                atual = atual.getProximo();
            }
            novoNo.setProximo(atual.getProximo());
            atual.setProximo(novoNo);
            tamanho++;
        }
    }

    // Atualiza o valor de um nó em uma posição específica
    public void atualizar(int posicao, T novoValor) {
        if (posicao < 0 || posicao >= tamanho) {
            throw new IndexOutOfBoundsException("Posição inválida");
        }
        Node<T> atual = inicio;
        for (int i = 0; i < posicao; i++) {
            atual = atual.getProximo();
        }
        atual.setValor(novoValor);
    }

    // Remoção
    public T removerDoInicio() {
        if (inicio == null) {
            throw new IndexOutOfBoundsException("Lista vazia");
        }
        T valor = inicio.getValor();
        inicio = inicio.getProximo();
        tamanho--;
        return valor;
    }

    public T removerDoFim() {
        if (inicio == null) {
            throw new IndexOutOfBoundsException("Lista vazia");
        }
        if (inicio.getProximo() == null) {
            T valor = inicio.getValor();
            inicio = null;
            tamanho--;
            return valor;
        }
        Node<T> atual = inicio;
        while (atual.getProximo().getProximo() != null) {
            atual = atual.getProximo();
        }
        T valor = atual.getProximo().getValor();
        atual.setProximo(null);
        tamanho--;
        return valor;
    }

    public T removerDaPosicao(int posicao) {
        if (posicao < 0 || posicao >= tamanho) {
            throw new IndexOutOfBoundsException("Posição inválida");
        }
        if (posicao == 0) {
            return removerDoInicio();
        } else if (posicao == tamanho - 1) {
            return removerDoFim();
        } else {
            Node<T> atual = inicio;
            for (int i = 0; i < posicao - 1; i++) {
                atual = atual.getProximo();
            }
            T valor = atual.getProximo().getValor();
            atual.setProximo(atual.getProximo().getProximo());
            tamanho--;
            return valor;
        }
    }

    public T removerPorValor(T elemento) {
        if (inicio == null) {
            throw new IndexOutOfBoundsException("Lista vazia");
        }
        if (inicio.getValor().equals(elemento)) {
            return removerDoInicio();
        }
        Node<T> atual = inicio;
        while (atual.getProximo() != null) {
            if (atual.getProximo().getValor().equals(elemento)) {
                T valor = atual.getProximo().getValor();
                atual.setProximo(atual.getProximo().getProximo());
                tamanho--;
                return valor;
            }
            atual = atual.getProximo();
        }
        throw new IndexOutOfBoundsException("Elemento não encontrado");
    }

    // Busca
    public T buscar(int posicao) {
        if (posicao < 0 || posicao >= tamanho) {
            throw new IndexOutOfBoundsException("Posição inválida");
        }
        Node<T> atual = inicio;
        for (int i = 0; i < posicao; i++) {
            atual = atual.getProximo();
        }
        return atual.getValor();
    }

    public boolean contem(T elemento) {
        Node<T> atual = inicio;
        while (atual != null) {
            if (atual.getValor().equals(elemento)) {
                return true;
            }
            atual = atual.getProximo();
        }
        return false;
    }

    // Novos Métodos
    public int tamanho() {
        return tamanho;
    }

    public boolean estaVazia() {
        return tamanho == 0;
    }

    public void limpar() {
        inicio = null;
        tamanho = 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node<T> atual = inicio;
        while (atual != null) {
            sb.append(atual.getValor());
            if (atual.getProximo() != null) {
                sb.append(", ");
            }
            atual = atual.getProximo();
        }
        sb.append("]");
        return sb.toString();
    }

    // Classe interna Node
    private static class Node<T> {
        private T valor;
        private Node<T> proximo;

        public Node(T valor) {
            this.valor = valor;
            this.proximo = null;
        }

        public T getValor() {
            return valor;
        }

        public void setValor(T valor) {
            this.valor = valor;
        }

        public Node<T> getProximo() {
            return proximo;
        }

        public void setProximo(Node<T> proximo) {
            this.proximo = proximo;
        }
    }
        public void imprimir() {
            Node<T> atual = inicio;
            while (atual != null) {
                System.out.print(atual.getValor() + " ");
                atual = atual.getProximo();
        }
        System.out.println(); // Para pular linha após a impressão
    }
}
