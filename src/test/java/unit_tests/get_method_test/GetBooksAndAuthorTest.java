package unit_tests.get_method_test;

import assertion.AuthorAssertions;
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

import static assertion.ErrorMessageAssertions.errorMessageAssertion;
import static assertion.ErrorMessageAssertions.errorMessageXMLAssertion;
import static assertion.StatusCodeAssertions.checkStatusCode;
import static configuration.ApiRequestLogic.listIsEmpty;
import static utils.ErrorMessages.incorrect_parameter;
import static utils.ErrorMessages.unexpected_author;

@Epic("Запрос на получение книг")
@Story("Получение книг автора")
public class GetBooksAndAuthorTest {

    @DisplayName("Получение книг автора")
    @Test
    @Description("Книги автора успешно получены")
    public void testGetBooks() {
        Authors authors = DataHelper.savedAuthor();
        Authors currentAuthor = DataHelper.getAuthor(authors);
        GetBooks requestGetBooks = new GetBooks();
        requestGetBooks.setAuthorId(String.valueOf(authors.getId()));

        List<Books> books = ApiRequestLogic.getBooksJson(requestGetBooks);

        BooksAssertions.bookListAssertion(books);
        AuthorAssertions.matchAssertion(books,currentAuthor);
    }

    @DisplayName("Получение книг в формате XML")
    @Test
    @Description("Получены книги в формате XML")
    public void testGetBooksXML() {
        Authors authors = DataHelper.savedAuthor();
        Authors currentAuthor = DataHelper.getAuthor(authors);
        GetBooksXML getBooksXML = new GetBooksXML();
        getBooksXML.setAuthor(authors);
        Response response = ApiRequestLogic.getBooksResponseXml(getBooksXML);
        BookListResponse bookListResponse = response.as(BookListResponse.class);

        BooksAssertions.bookListAssertion(bookListResponse.getBooks());
        AuthorAssertions.matchAssertion(bookListResponse.getBooks(),currentAuthor);
    }

    @DisplayName("GET запрос к несохраненному автору в json")
    @Test
    @Description("Сервис возвращает ошибку с кодом 409")
    public void getBookNotSavedAuthorJson() {
        Authors author = DataHelper.notSavedAuthor();
        GetBooks requestGetBooks = new GetBooks();
        requestGetBooks.setAuthorId(String.valueOf(author.getId()));
        Response response = ApiRequestLogic.getBooksResponse(requestGetBooks);
        checkStatusCode(response, 409);
        errorMessageAssertion(response, unexpected_author);
    }

    @DisplayName("GET запрос без id автора в json")
    @Test
    @Description("Сервис возвращает ошибку с кодом 409")
    public void getBookWithAuthorWithoutId() {
        GetBooks requestGetBooks = new GetBooks();
        Response response = ApiRequestLogic.getBooksResponse(requestGetBooks);
        checkStatusCode(response, 409);
        errorMessageAssertion(response, incorrect_parameter);
    }

    @DisplayName("GET запрос к автору у которого отсутствуют сохраненные книги в формате json")
    @Test
    @Description("Сервис возвращает код 200 и пустой список")
    public void getBookWithAuthorWithoutJson() {
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
    @Description("Сервис возвращает ошибку с кодом 409")
    public void getBookNotSavedAuthorXml() {
        Authors authors = DataHelper.notSavedAuthor();
        GetBooksXML requestGetBooksXML = new GetBooksXML();
        requestGetBooksXML.setAuthor(authors);
        Response response = ApiRequestLogic.getBooksResponseXml(requestGetBooksXML);
        checkStatusCode(response, 409);
        errorMessageXMLAssertion(response, unexpected_author);
    }

    @DisplayName("GET запрос без id автора в xml")
    @Test
    @Description("Сервис возвращает ошибку с кодом 409")
    public void getBookWithAuthorWithoutIdXml() {
        GetBooksXML requestGetBooksXML = new GetBooksXML();
        Authors authors = new Authors();
        requestGetBooksXML.setAuthor(authors);
        Response response = ApiRequestLogic.getBooksResponseXml(requestGetBooksXML);
        checkStatusCode(response, 409);
        errorMessageXMLAssertion(response, incorrect_parameter);
    }

    @DisplayName("GET запрос к автору у которого отсутствуют сохраненные книги в XML")
    @Test
    @Description("Сервис возвращает код 200 и пустой список")
    public void getBookWithAuthorWithoutXML() {
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
