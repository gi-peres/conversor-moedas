
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import use_case.Requisicao;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        Requisicao reqTaxa = new Requisicao();
        
        do {
            System.out.println("*********************************************");
            System.out.println("Seja bem-vindo/a ao Conversor de Moeda =]");
            System.out.println("1) Dólar >> Peso argentino");
            System.out.println("2) Peso argentino >> Dólar");
            System.out.println("3) Dólar >> Real brasileiro");
            System.out.println("4) Real brasileiro >> Dólar");
            System.out.println("5) Dólar >> Peso colombiano");
            System.out.println("6) Peso colombiano >> Dólar");
            System.out.println("7) Sair");
            System.out.println("Escolha uma opção válida: ");
            System.out.println("*********************************************");

            opcao = scanner.nextInt();
            int valorParaConverter;
            switch (opcao) {
                case 1:
                    System.out.println("Digite o valor que deseja converter");
                    valorParaConverter = scanner.nextInt();
                    reqTaxa.buscarTaxaMoeda("USD", "ARS", valorParaConverter);
                    break;
                case 2:
                    System.out.println("Digite o valor que deseja converter");
                    valorParaConverter = scanner.nextInt();
                    reqTaxa.buscarTaxaMoeda("ARS", "USD", valorParaConverter);
                    break;
                case 3:
                    System.out.println("Digite o valor que deseja converter");
                    valorParaConverter = scanner.nextInt();
                    reqTaxa.buscarTaxaMoeda("USD", "BRL", valorParaConverter);
                    break;
                case 4:
                    System.out.println("Digite o valor que deseja converter");
                    valorParaConverter = scanner.nextInt();
                    reqTaxa.buscarTaxaMoeda("BRL", "USD", valorParaConverter);
                    break;
                case 5:
                    System.out.println("Digite o valor que deseja converter");
                    valorParaConverter = scanner.nextInt();
                    reqTaxa.buscarTaxaMoeda("USD", "COP", valorParaConverter);
                    break;
                case 6:
                    System.out.println("Digite o valor que deseja converter");
                    valorParaConverter = scanner.nextInt();
                    reqTaxa.buscarTaxaMoeda("COP", "USD", valorParaConverter);
                    break;
                case 7:
                    System.out.println("Saindo...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Digite o valor que deseja converter");
                    break;
            }
            System.out.println();

        } while (opcao != 7);

        scanner.close();
    }
}

