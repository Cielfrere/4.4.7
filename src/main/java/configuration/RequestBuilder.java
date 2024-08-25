package configuration;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import models.request.GetBooks;
import models.request.GetBooksXML;
import models.request.SaveBooks;

public class RequestBuilder {
    private static final String URL = "http://localhost:8080/library";

    private static RequestSpecBuilder baseSpecificationBuilder() {
        return new RequestSpecBuilder()
                .setBaseUri(URL)
                .setContentType(ContentType.JSON)
                .addFilter(new RequestLoggingFilter())
                .addFilter(new ResponseLoggingFilter());
    }

    public static RequestSpecification saveBookSpecification(SaveBooks saveBooks) {
        return baseSpecificationBuilder()
                .setBasePath("books/save")
                .setBody(saveBooks)
                .build();
    }

    public static RequestSpecification getBookSpecification(GetBooks getBooks) {
        return baseSpecificationBuilder()
                .setBasePath(String.format("authors/%s/books", getBooks.getAuthorId()))
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
