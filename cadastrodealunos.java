import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class cadastrodealunos {

    static class Usuario {
        int id;
        String nome;
        String email;
        String telefone;

    public Usuario (int id, String nome, String email, String telefone) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
    }

    }
    
    private static List<Usuario>usuarios=new ArrayList<>();
    private static int proximold = 1;

    public static void adicionarUsuario(String nome, String email, String telefone) {
        Usuario usuario = new Usuario(proximold++, nome, email, telefone);
        usuarios.add(usuario);
        System.out.println("Usuario adicionado com sucesso!");
    }

    public static void listarUsuarios() {
        if (usuarios.isEmpty()) {
            System.out.println("Nenhum usuario cadastrado.");
        } else {
            System.out.println("Lista de usuarios: ");
            for (Usuario usuario: usuarios) {
                System.out.println("ID:" + usuario.id + ", Nome: " + usuario.nome +
                 ",Email: " + usuario.email+", Telefone: " + usuario.telefone);

            }
        }
    }

    public static void excluirUsuario(int id) {
        boolean encontrado = false;
        for (Usuario usuario: usuarios) {
            if (usuario.id == id) {
                usuarios.remove(usuario);
                System.out.println("Usuario excluido com sucesso!");
                encontrado = true;
                break;
            }
        }
        if(!encontrado) {
            System.out.println("Usuario nao encontrado.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\nSistema de cadastro de Usuarios");
            System.out.println("1.Adicionar");
            System.out.println("2.Listar Usuario");
            System.out.println("3.Excluir Usuario");
            System.out.println("4.Sair");
            System.out.println("Escolha uma opcao");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch(opcao) {
                case 1:
                System.out.println("Nome: ");
                String nome = scanner.nextLine();
                System.out.println("Email: ");
                String email = scanner.nextLine();
                System.out.println("Telefone: ");
                String telefone = scanner.nextLine();
                adicionarUsuario(nome, email, telefone);
                break;

                case 2:
                listarUsuarios();
                break;

                case 3:
                System.out.println("ID do usuario a excluir: ");
                int id = scanner.nextInt();
                excluirUsuario(id);
                break;

                case 4:
                System.out.println("Saindo...");
                break;

                default:
                System.out.println("Opcao invalida!");

        }
    } while (opcao!=4);
        scanner.close();
    }
    
}