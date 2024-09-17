package assertion;

import io.restassured.response.Response;

public class StatusCodeAssertions {

    public static void checkStatusCode(Response response, int errorCode) {
        response.then().statusCode(errorCode);
    }
}
