package com.atguigu.java11;

import static org.junit.Assert.*;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandler;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.concurrent.CompletableFuture;

import org.junit.Test;

public class HTTPClientTest {
	
	@Test
	public void testName2() throws Exception {
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder(URI.create("http://127.0.0.1:8080/test/")).build();
		BodyHandler<String> responseBodyHandler = BodyHandlers.ofString();
		CompletableFuture<HttpResponse<String>> sendAsync = client.sendAsync(request, responseBodyHandler);
		sendAsync.thenApply(t -> t.body()).thenAccept(System.out::println);
		//HttpResponse<String> response = sendAsync.get();
		//String body = response.body();
		//System.out.println(body);
		
	}
	
	@Test
	public void testName() throws Exception {
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder(URI.create("http://127.0.0.1:8080/test/")).build();
		BodyHandler<String> responseBodyHandler = BodyHandlers.ofString();
		HttpResponse<String> response = client.send(request, responseBodyHandler);
		String body = response.body();
		System.out.println(body);
	}
}
