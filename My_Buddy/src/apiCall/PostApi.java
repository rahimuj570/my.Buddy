package apiCall;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class PostApi {

	public static void main(String[] args) throws IOException, InterruptedException {
		String requestBody = "{\"name\": \"Example\", \"data\": {\"Attribute 1\": 123, \"Attribute 2\": \"POST Request in Java\"}}";

		HttpRequest request = HttpRequest.newBuilder()
			.POST(HttpRequest.BodyPublishers.ofString(requestBody))
			.uri(URI.create("http://localhost:8080"))
			.header("Content-Type", "application/json")
			// .setHeader("Authorization", "Bearer 123token")
			.build();
		
		HttpResponse<String> response = HttpClient.newHttpClient()
				.send(request, HttpResponse.BodyHandlers.ofString());
		
			System.out.println(response.statusCode());
			System.out.println(response.body());

	}

}
