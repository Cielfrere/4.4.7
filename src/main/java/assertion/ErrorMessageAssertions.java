package assertion;

import configuration.ApiRequestLogic;
import io.restassured.response.Response;

import java.nio.charset.StandardCharsets;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class ErrorMessageAssertions {

    public static void errorMessageAssertion(Response response, String expectedMessage) {
        String actualMessage = ApiRequestLogic.errorMessage(response);
        assertThat(actualMessage, equalTo(new String(expectedMessage.getBytes(), StandardCharsets.UTF_8)));
    }

    public static void errorMessageXMLAssertion(Response response, String expectedMessage) {
        String actualMessage = ApiRequestLogic.errorMessageXML(response);
        assertThat(actualMessage, equalTo(new String(expectedMessage.getBytes(), StandardCharsets.UTF_8)));
    }

    public static void errorMessageSaveAssertion(Response response, String expectedMessage) {
        errorMessageAssertion(response, expectedMessage);
    }
}
