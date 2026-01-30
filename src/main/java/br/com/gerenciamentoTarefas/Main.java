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
            System.out.println("3 - Buscar tarefa por ID");
            System.out.println("4 - Atualizar tarefa");
            System.out.println("5 - Remover tarefa");
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
                case 3:
                    buscarTarefaPorId(scanner);
                    break;
                case 4:
                    atualizarTarefa(scanner);
                    break;
                case 5:
                    removerTarefa(scanner);
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

    private static void buscarTarefaPorId(Scanner scanner) {

        System.out.print("Digite o ID da tarefa: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        for (Tarefa tarefa : tarefas) {
            if (tarefa.getId() == id) {
                System.out.println(
                        "ID: " + tarefa.getId() +
                                " | Título: " + tarefa.getTitulo() +
                                " | Status: " + tarefa.getStatus()
                );
                return;
            }
        }

        System.out.println("Tarefa não encontrada.");
    }

    private static void atualizarTarefa(Scanner scanner) {

        System.out.print("Digite o ID da tarefa a ser atualizada: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        for (Tarefa tarefa : tarefas) {
            if (tarefa.getId() == id) {

                System.out.print("Novo título: ");
                String novoTitulo = scanner.nextLine();

                System.out.print("Novo status (PENDENTE / CONCLUIDA): ");
                String novoStatus = scanner.nextLine().toUpperCase();

                if (!novoStatus.equals("PENDENTE") && !novoStatus.equals("CONCLUIDA")) {
                    System.out.println("Status inválido.");
                    return;
                }

                tarefa.setTitulo(novoTitulo);
                tarefa.setStatus(novoStatus);

                System.out.println("Tarefa atualizada com sucesso!");
                return;
            }
        }

        System.out.println("Tarefa não encontrada.");
    }

    private static void removerTarefa(Scanner scanner) {

        System.out.print("Digite o ID da tarefa a ser removida: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        for (Tarefa tarefa : tarefas) {
            if (tarefa.getId() == id) {
                tarefas.remove(tarefa);
                System.out.println("Tarefa removida com sucesso!");
                return;
            }
        }

        System.out.println("Tarefa não encontrada.");
    }
}
