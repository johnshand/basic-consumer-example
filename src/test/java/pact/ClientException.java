package pact;

public class ClientException extends RuntimeException {

    private final String endpointName;
    private final int statusCode;
    private final String responseBody;

    public ClientException(String endpointName, int statusCode, String responseBody) {
        super("Call to '" + endpointName + "' failed with status " + statusCode);
        this.endpointName = endpointName;
        this.statusCode = statusCode;
        this.responseBody = responseBody;
    }

    public String getEndpointName() {
        return endpointName;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public String getResponseBody() {
        return responseBody;
    }
}
