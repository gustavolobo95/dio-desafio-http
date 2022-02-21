package com.httpexamples;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.io.IOException;
public class GetRequest {
public static void main(String[] args) throws IOException, InterruptedException {

// Cliente HTTP.	
HttpClient client = HttpClient.newHttpClient();

// Criar Requisição.
HttpRequest request = HttpRequest.newBuilder()
.GET()
.timeout(Duration.ofSeconds(10))
.uri(URI.create("http://httpbin.org/get"))
.build();

// Enviando uma solicitação.
HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

// Imprimir o conteudo recebido.
System.out.println(response.statusCode());
System.out.println(response.body());
}
}
