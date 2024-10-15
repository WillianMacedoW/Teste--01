public class Main {
    public static void main(String[] args){
        ListaEncadeada<Integer> numeros = new ListaEncadeada<>();

        numeros.adicionarNoFim(5);
        numeros.adicionarNoFim(10);
        numeros.adicionarNoFim(15);
        numeros.adicionarNoFim(100);
        numeros.imprimir();
        numeros.adicionarNoInicio(20);
        numeros.imprimir();
        System.out.println(numeros.tamanho());
        numeros.removerDoInicio();
        numeros.imprimir();
        System.out.println(numeros.tamanho());
        numeros.limpar();
        System.out.println(numeros.tamanho());


    }
}