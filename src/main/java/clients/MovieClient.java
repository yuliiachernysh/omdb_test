package clients;

import models.RequestParameters;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.IOException;

public class MovieClient {
    private String baseUrl;
    private CloseableHttpClient httpClient;

    public MovieClient(String baseUrl, String apiKey) {
        this.baseUrl = baseUrl + "?apikey=" + apiKey;
        httpClient = HttpClientBuilder.create().build();
    }

    public HttpResponse getMovieResponse(RequestParameters requestParameters) throws IOException {
        HttpGet request = new HttpGet(baseUrl + requestParameters.buildQuery());

        HttpResponse httpResponse = httpClient.execute(request);
        return httpResponse;
    }

    public void Close() throws IOException {
        if(httpClient != null){
            httpClient.close();
        }
    }
}
