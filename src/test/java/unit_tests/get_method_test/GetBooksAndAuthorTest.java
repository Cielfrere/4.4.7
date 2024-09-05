package unit_tests.get_method_test;

import entity.Authors;
import entity.Books;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import io.restassured.response.Response;
import models.request.GetBooks;
import models.request.GetBooksXML;
import models.responses.BookListResponse;
import models.responses.XmlList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import assertion.BooksAssertions;
import configuration.ApiRequestLogic;
import utils.DataHelper;

import java.util.List;

import static assertion.StatusCodeAssertions.checkStatusCode;
import static configuration.ApiRequestLogic.listIsEmpty;

@Epic("Запрос на получение книг")
@Story("Получение книг автора")
public class GetBooksAndAuthorTest {

    @DisplayName("Получение книг автора")
    @Test
    @Description("Книги автора успешно получены")
    public void testGetBooks() {
        GetBooks requestGetBooks = new GetBooks();
        requestGetBooks.setAuthorId("2");

        List<Books> books = ApiRequestLogic.getBooksJson(requestGetBooks);

        BooksAssertions.bookListAssertion(books);
        System.out.println(books);
    }

    @DisplayName("Получение книг в формате XML")
    @Test
    @Description("Получены книги в формате XML")
    public void testGetBooksXML() {
        GetBooksXML getBooksXML = new GetBooksXML();
        Authors author = new Authors();
        author.setId(22);
        getBooksXML.setAuthor(author);

        XmlList xmlList = ApiRequestLogic.getBooksXml(getBooksXML);
        List<Books> booksList = xmlList.getBooks();

        BooksAssertions.bookListAssertion(booksList);
        System.out.println(booksList);
    }

    @DisplayName("GET запрос к несохраненному автору в json")
    @Test
    @Description("Сервис возвращает ошибку с кодом 400")
    public void GetBookNotSavedAuthorJson() {
        Authors author = DataHelper.notSavedAuthor();
        GetBooks requestGetBooks = new GetBooks();
        requestGetBooks.setAuthorId(String.valueOf(author.getId()));
        Response response = ApiRequestLogic.getBooksResponse(requestGetBooks);
        checkStatusCode(response, 400);
    }

    @DisplayName("GET запрос без id автора в json")
    @Test
    @Description("Сервис возвращает ошибку с кодом 400")
    public void GetBookWithAuthorWithoutId() {
        GetBooks requestGetBooks = new GetBooks();
        Response response = ApiRequestLogic.getBooksResponse(requestGetBooks);
        checkStatusCode(response, 400);
    }

    @DisplayName("GET запрос к автору без сохраненных книг в json")
    @Test
    @Description("Сервис возвращает код 200 и пустой список")
    public void GetBookWithAuthorWithoutJson() {
        Authors authors = DataHelper.withoutBookJson();
        GetBooks requestGetBooks = new GetBooks();
        requestGetBooks.setAuthorId(String.valueOf(authors.getId()));
        List<Books> books = ApiRequestLogic.getBooksJson(requestGetBooks);
        Response response = ApiRequestLogic.getBooksResponse(requestGetBooks);
        checkStatusCode(response, 200);
        listIsEmpty(books);
    }

    @DisplayName("GET запрос к несохраненному автору в xml")
    @Test
    @Description("Сервис возвращает ошибку с кодом 400")
    public void GetBookNotSavedAuthorXml() {
        Authors authors = DataHelper.notSavedAuthor();
        GetBooksXML requestGetBooksXML = new GetBooksXML();
        requestGetBooksXML.setAuthor(authors);
        Response response = ApiRequestLogic.getBooksResponseXml(requestGetBooksXML);
        checkStatusCode(response, 400);
    }

    @DisplayName("GET запрос без id автора в xml")
    @Test
    @Description("Сервис возвращает ошибку с кодом 400")
    public void GetBookWithAuthorWithoutIdXml() {
        GetBooksXML requestGetBooksXML = new GetBooksXML();
        Authors authors = new Authors();
        requestGetBooksXML.setAuthor(authors);
        Response response = ApiRequestLogic.getBooksResponseXml(requestGetBooksXML);
        checkStatusCode(response, 400);
    }

    @DisplayName("GET запрос к автору без сохраненных книг в json")
    @Test
    @Description("Сервис возвращает код 200 и пустой список")
    public void GetBookWithAuthorWithoutXML() {
        Authors authors = DataHelper.withoutBookXml();
        GetBooksXML requestGetBooksXML = new GetBooksXML();
        requestGetBooksXML.setAuthor(authors);
        XmlList xmlList = ApiRequestLogic.getBooksXml(requestGetBooksXML);
        List<Books> books = xmlList.getBooks();
        Response response = ApiRequestLogic.getBooksResponseXml(requestGetBooksXML);
        checkStatusCode(response, 200);
        listIsEmpty(books);
    }

}
