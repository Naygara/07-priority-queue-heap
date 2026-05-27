package hospital;

public class Main {
    public static void main(String[] args) {
        // Criando a Fila de Prioridade para os 6 pacientes de teste
        FilaPrioridadeHeap<Paciente> fila = new FilaPrioridadeHeap<>(6);

        System.out.println("=== INSERINDO PACIENTES NO HEAP ===");
        
        fila.enfileirar(new Paciente("Carlos", 2, 45, false));
        System.out.println(fila);

        fila.enfileirar(new Paciente("Maria", 5, 5, false));
        System.out.println(fila);

        fila.enfileirar(new Paciente("João", 3, 20, false));
        System.out.println(fila);

        fila.enfileirar(new Paciente("Beatriz", 3, 35, true));
        System.out.println(fila);

        fila.enfileirar(new Paciente("Pedro", 5, 2, false));
        System.out.println(fila);

        fila.enfileirar(new Paciente("Helena", 2, 45, true));
        System.out.println(fila);

        System.out.println("\n=== ATENDIMENTO DOS PACIENTES (ORDEM DE PRIORIDADE) ===");
        while (!fila.estaVazio()) {
            Paciente atendido = fila.desenfileirar();
            System.out.println("Chamando: " + atendido);
        }
    }
}
