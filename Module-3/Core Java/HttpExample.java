import java.net.http.*;
import java.net.URI;
import java.io.IOException;

public class HttpExample {
public static void main(String[] args) {
HttpClient client = HttpClient.newHttpClient();
    HttpRequest request = HttpRequest.newBuilder()
        .uri(URI.create("https://api.github.com/users/octocat"))
        .GET()
        .build();

    try {
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println("Status Code: " + response.statusCode());
        System.out.println("Response Body:\n" + response.body());
    } catch (IOException | InterruptedException e) {
        e.printStackTrace();
    }
}
}
