package configuration;

import entity.Books;
import models.request.GetBooks;
import models.request.GetBooksXML;
import models.request.SaveBooks;
import models.responses.SaveBooksResponse;

import java.util.List;

import static io.restassured.RestAssured.given;

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

    public static List<Books> getBooksXml(GetBooksXML getBooksXML) {
        return given().spec(RequestBuilder.getBookXmlSpecification(getBooksXML))
                .post()
                .then()
                .extract().xmlPath().getList(".", Books.class);
    }
}

