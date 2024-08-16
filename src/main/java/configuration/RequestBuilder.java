package configuration;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import models.request.GetBooks;
import models.request.GetBooksXML;
import models.request.SaveBooks;

public class RequestBuilder {
    private static final String URL = "http://localhost:8080/";

    private static RequestSpecBuilder baseSpecificationBuilder() {
        return new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .setBaseUri(URL);
    }

    public static RequestSpecification saveBookSpecification(SaveBooks saveBooks) {
        return baseSpecificationBuilder()
                .setBasePath("books/save")
                .setBody(saveBooks)
                .build();
    }

    public static RequestSpecification getBookSpecification(GetBooks getBooks) {
        return baseSpecificationBuilder()
                .setBasePath(String.format("authors/books/%d", getBooks.getAuthorsId()))
                .build();
    }
    public static RequestSpecification getBookXmlSpecification(GetBooksXML getBooksXML) {
        return baseSpecificationBuilder()
                .setBasePath("authors/books")
                .setContentType(ContentType.XML)
                .setAccept(ContentType.XML)
                .setBody(getBooksXML)
                .build();
    }
}
