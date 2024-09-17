package configuration;

import entity.Books;
import io.restassured.response.Response;
import models.request.GetBooks;
import models.request.GetBooksXML;
import models.request.SaveBooks;
import models.responses.SaveBooksResponse;
import models.responses.XmlList;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ApiRequestLogic {

    public static SaveBooksResponse saveBooks(SaveBooks saveBooks) {
        return given().spec(RequestBuilder.saveBookSpecification(saveBooks))
                .post()
                .as(SaveBooksResponse.class);
    }

    public static List<Books> getBooksJson(GetBooks getBooks) {
        return given().spec(RequestBuilder.getBookSpecification(getBooks))
                .get()
                .then()
                .extract().jsonPath().getList(".", Books.class);
    }

    public static XmlList getBooksXml(GetBooksXML getBooksXML) {
        return given().spec(RequestBuilder.getBookXmlSpecification(getBooksXML))
                .post()
                .then()
                .extract().as(XmlList.class);
    }

    public static Response getBooksResponse(GetBooks requestGetBooks) {
        return given()
                .spec(RequestBuilder.getBookSpecification(requestGetBooks))
                .get();
    }

    public static void listIsEmpty(List<Books> books) {
        assertTrue(books.isEmpty());
    }

    public static Response getBooksResponseXml(GetBooksXML requestGetBooksXML) {
        return given()
                .spec(RequestBuilder.getBookXmlSpecification(requestGetBooksXML))
                .post();
    }

    public static Response saveBookResponse(SaveBooks requestSaveBooks) {
        return given()
                .spec(RequestBuilder.saveBookSpecification(requestSaveBooks))
                .post();
    }

    public static String errorMessage(Response response) {
        return response
                .then()
                .extract()
                .path("errorMessage");
    }

    public static String errorMessageXML(Response response) {
        return response
                .then()
                .extract()
                .xmlPath()
                .getString("errorMessage");
    }
}

