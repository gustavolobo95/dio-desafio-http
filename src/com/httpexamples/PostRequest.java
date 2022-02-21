package com.httpexamples;

import java.io.FileNotFoundException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Path;
import java.time.Duration;

@SuppressWarnings("unused")
public class PostRequest {
	
public static void main(String[] args) throws FileNotFoundException {
	
	// Cliente HTTP.
	HttpClient client = HttpClient.newHttpClient();
	
	// Criar requisição.
	HttpRequest request = HttpRequest.newBuilder()
			
			// Metodo .POST() comentado abaixo não tem permissão para enviar o arquivo .json, por isso ele retornara o erro:
			// 405 Method Not Allowed
			// Descomente a proxima linha para visualizar.
			//.POST(HttpRequest.BodyPublishers.ofFile(Path.of("\\Dio-Desafio-Http\\pedido.json\\", args)))
			.timeout(Duration.ofSeconds(10))
			.uri(URI.create("http://httpbin.org/forms/post"))
			.build();
	
	client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
	.thenApply(HttpResponse::body)
	.thenAccept(System.out::println)
	.join();
	
}
}