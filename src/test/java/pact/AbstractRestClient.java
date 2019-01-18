package pact;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Collections;

public class AbstractRestClient {

    private RestTemplate restTemplate = new RestTemplate();

    protected ClientException handleFailedRequest(final String endpointName, final HttpStatusCodeException exception) {
        return new ClientException(endpointName, exception.getRawStatusCode(), exception.getResponseBodyAsString());
    }

    protected <T> T makeRequest(final HttpEntity<?> requestEntity, final UriComponentsBuilder uriBuilder, final HttpMethod httpMethod,
                                final Class<T> responseClass) {
        try {

            ResponseEntity<T> responseEntity = restTemplate.exchange(uriBuilder.build(Collections.emptyMap()), httpMethod, requestEntity,
                    responseClass);
            return responseEntity.getBody();
        } catch (HttpStatusCodeException e) {
            throw handleFailedRequest("Request Failed", e);
        }
    }
}
