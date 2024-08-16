package unit_tests.get_method_test;

import entity.Authors;
import entity.Books;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import models.request.GetBooks;
import models.request.GetBooksXML;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import assertion.BooksAssertions;
import configuration.ApiRequestLogic;

import java.util.List;

@Epic("Запрос на получение книг")
@Story("Получение книг автора")
public class GetBooksAndAuthorTest {

    @ParameterizedTest
    @DisplayName("Получение книг автора")
    @Description("Книги автора успешно получены")
    @CsvSource({"01", "02"})
    public void testGetBooksByAuthor(String authorId) {
        GetBooks requestGetBooks = new GetBooks();
        requestGetBooks.setAuthorsId(authorId);

        List<Books> books = ApiRequestLogic.getBooksJson(requestGetBooks);

        BooksAssertions.BookListAssertion(books);
    }

    @ParameterizedTest
    @DisplayName("Получение книг в формате XML")
    @Description("Получены книги в формате XML")
    @CsvSource({"02"})
    public void testBooksByAuthorPostXML(int authorId) {
        GetBooksXML getBooksXML = new GetBooksXML();
        Authors author = new Authors();
        author.setId(authorId);
        getBooksXML.setAuthor(author);

        List<Books> booksList = ApiRequestLogic.getBooksXml(getBooksXML);

        BooksAssertions.BookListAssertion(booksList);
    }
}
