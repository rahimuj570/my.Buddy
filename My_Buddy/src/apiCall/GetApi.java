package apiCall;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class GetApi {
	public static void main(String args[]) throws IOException, InterruptedException {
		HttpRequest request = HttpRequest.newBuilder()
				.GET()
				.uri(URI.create("https://api.restful-api.dev/objects/ff8081818a394cb8018a6a1726b137dc"))
	            // .setHeader("Authorization", "Bearer 123token")
				.build();
		
		HttpResponse<String> response = HttpClient.newHttpClient()
				.send(request, HttpResponse.BodyHandlers.ofString());

			System.out.println(response.statusCode());
			System.out.println(response.body());
	}
}
