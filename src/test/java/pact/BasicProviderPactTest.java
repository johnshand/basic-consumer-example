package pact;

import au.com.dius.pact.consumer.MockServer;
import au.com.dius.pact.consumer.Pact;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.consumer.junit5.PactConsumerTestExt;
import au.com.dius.pact.consumer.junit5.PactTestFor;
import au.com.dius.pact.model.RequestResponsePact;
import com.example.basic.ConsumerOfProvider;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.util.UriComponentsBuilder;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.MatcherAssert.assertThat;
import static io.pactfoundation.consumer.dsl.LambdaDsl.newJsonBody;


import java.util.HashMap;
import java.util.Map;

@ExtendWith(PactConsumerTestExt.class)
@PactTestFor(providerName = "BasicProvider", port = "1222")
public class BasicProviderPactTest extends AbstractRestClient {

    private static final String providerPath = "/provider";

    private static final Map<String, String> headers = new HashMap<String, String>() {{
        put("Content-Type", "application/json");
    }};

    private static final HttpHeaders httpHeaders = new HttpHeaders() {{
        add("Content-Type", "application/json");
    }};

    @Pact(provider = "BasicProvider", consumer = "BasicConsumer")
    public RequestResponsePact consumeGetRequestTest(PactDslWithProvider builder) {

        return builder
                .given("A GET request is sent to the Basic Provider")
                .uponReceiving("A Response")
                .path(providerPath)
                .method("GET")
                .headers(headers)
                .willRespondWith()
                .status(200)
                .headers(headers)
                .body(newJsonBody((b) ->
                        b.numberType("someInt"))
                .build())
                .toPact();
    }

    @Test
    @PactTestFor(pactMethod = "consumeGetRequestTest")
    void testGetDualAlertResponseIsValid(MockServer ms) {
        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromUriString(ms.getUrl()).path(providerPath);
        ConsumerOfProvider providerResponse = makeRequest(new HttpEntity<>(httpHeaders), uriBuilder, HttpMethod.GET, ConsumerOfProvider.class);
        assertThat(providerResponse.getSomeInt(), instanceOf(Integer.TYPE));
    }
}
