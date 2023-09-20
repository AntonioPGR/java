package currency_converter.api;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class CurrencyApiHandler {
	HttpClient client = HttpClient.newHttpClient();
	String API_KEY = "npmvaSu4uGAcfU9EYX7SweKJDnswe7";
	String base_url = "https://www.amdoren.com/api/currency.php?api_key=" + API_KEY + "&";

	public String convertAmountFromTo(float amount, String from, String to){
		URI request_uri = createUrl(amount, from, to);
		HttpRequest request = createRequest(request_uri);
		HttpResponse<String> response = sendRequest(request);
		if(response != null) return response.body();
		return null;
	}

	private URI createUrl(float amount, String from, String to){
		return URI.create(base_url + "from=" + from + "&to=" + to + "&amount=" + amount);
	}

	private  HttpRequest createRequest(URI uri){
		return HttpRequest.newBuilder().uri(uri).build();
	}

	private HttpResponse<String> sendRequest(HttpRequest request){
		try{
			return client.send(request, HttpResponse.BodyHandlers.ofString());
		} catch (IOException | InterruptedException ioException){
			System.out.println(ioException.getMessage());
			return null;
		}
	}

}
