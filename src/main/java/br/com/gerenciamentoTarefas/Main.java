package br.com.gerenciamentoTarefas;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static List<Tarefa> tarefas = new ArrayList<>();
    private static int proximoId = 1;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n=== MENU DE TAREFAS ===");
            System.out.println("1 - Criar tarefa");
            System.out.println("2 - Listar tarefas");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    criarTarefa(scanner);
                    break;
                case 2:
                    listarTarefas();
                    break;
                case 0:
                    System.out.println("Encerrando o sistema...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }

        } while (opcao != 0);

        scanner.close();
    }

    private static void criarTarefa(Scanner scanner) {

        System.out.print("Digite o título da tarefa: ");
        String titulo = scanner.nextLine();

        Tarefa tarefa = new Tarefa(proximoId, titulo, "PENDENTE");
        tarefas.add(tarefa);

        System.out.println("Tarefa criada com sucesso! ID: " + proximoId);
        proximoId++;
    }

    private static void listarTarefas() {

        if (tarefas.isEmpty()) {
            System.out.println("Nenhuma tarefa cadastrada.");
            return;
        }

        System.out.println("\n--- Lista de Tarefas ---");
        for (Tarefa tarefa : tarefas) {
            System.out.println(
                    "ID: " + tarefa.getId() +
                            " | Título: " + tarefa.getTitulo() +
                            " | Status: " + tarefa.getStatus()
            );
        }
    }
}
