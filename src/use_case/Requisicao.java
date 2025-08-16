package use_case;

import com.google.gson.*;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


public class Requisicao{

    public void buscarTaxaMoeda(String moedaBase, String moedaDestino, double valor) throws IOException, InterruptedException {
        URI endereco = URI.create("https://v6.exchangerate-api.com/v6/8bb7e89e9055577f200e9fec/latest/" + moedaBase);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(endereco)
                .build();

        HttpResponse<String> response = HttpClient
                .newHttpClient()
                .send(request, HttpResponse.BodyHandlers.ofString());

        JsonObject json = JsonParser.parseString(response.body()).getAsJsonObject();

        try {
            JsonObject taxas = json.getAsJsonObject("conversion_rates");

            double taxaMoeda = taxas.get(moedaDestino).getAsDouble();

            double valorConvertido = valor * taxaMoeda;

            System.out.printf("Valor %.2f %s corresponde ao valor final de =>>>> %.2f %s%n", valor, moedaBase, valorConvertido, moedaDestino);
        } catch (NullPointerException e) {
        throw new RuntimeException("Erro: A moeda informada não foi encontrada na resposta da API.", e);

        } catch (IllegalStateException e) {
            throw new RuntimeException("Erro: O valor retornado pela API não está em formato numérico esperado.", e);

        }catch (Exception e) {
            throw new RuntimeException("Não foi possível obter os dados das taxas e realizar a conversão");
        }

    }
}
