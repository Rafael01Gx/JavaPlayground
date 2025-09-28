import br.com.rafaelgx.javaplayground.alura.modelos.Titulo;
import br.com.rafaelgx.javaplayground.alura.modelos.TituloOmdb;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;


final String OMDB_URL = "http://www.omdbapi.com";
final String API_KEY = "1d4cac1";

void main() throws IOException, InterruptedException {
    Gson gson = new GsonBuilder()
            .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
            .setPrettyPrinting()
            .create();
    List<Titulo> minhaLista = new ArrayList<Titulo>();

    String filme = "";
    while (!filme.equalsIgnoreCase("sair")) {

        filme = IO.readln("Digite o nome do filme: ");

        if (filme.equalsIgnoreCase("sair")) {
            break;
        }
        try {

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest
                    .newBuilder()
                    .uri(URI.create(OMDB_URL + "/?t=" + filme.replace(" ", "").toLowerCase() + "&apikey=" + API_KEY))
                    .build();
            HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
            IO.println(response.body());

            TituloOmdb omdbTitulo = gson.fromJson(response.body(), TituloOmdb.class);
            IO.println(omdbTitulo);


            Titulo meuTitulo = new Titulo(omdbTitulo);
            IO.println(meuTitulo);
            minhaLista.add(meuTitulo);


        } catch (NumberFormatException e) {
            IO.println("Aconteceu um erro: " + e.getMessage());
        }


    }
    FileWriter fw = new FileWriter("listaFilmes.json");
    fw.write(gson.toJson(minhaLista));
    fw.close();
}