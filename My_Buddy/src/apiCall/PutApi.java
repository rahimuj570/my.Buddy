package apiCall;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class PutApi {

	public static void main(String[] args) throws IOException, InterruptedException {
		String requestBody = "{\"name\": \"Android iPhone 11, 64GB\", \"data\": {\"price\": 400, \"color\": \"Purple\"}}";

		HttpRequest request = HttpRequest.newBuilder()
			.PUT(HttpRequest.BodyPublishers.ofString(requestBody))
			.uri(URI.create("https://api.restful-api.dev/objects/ff8081818a394cb8018a6a1726b137dc"))
			.header("Content-Type", "application/json")
			.build();
		
		HttpResponse<String> response = HttpClient.newHttpClient()
	            .send(request, HttpResponse.BodyHandlers.ofString());

	System.out.println(response.statusCode());
	System.out.println(response.body());

	}

}
