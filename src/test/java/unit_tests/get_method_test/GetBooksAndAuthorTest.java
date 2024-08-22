package unit_tests.get_method_test;

import entity.Authors;
import entity.Books;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import models.request.GetBooks;
import models.request.GetBooksXML;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import assertion.BooksAssertions;
import configuration.ApiRequestLogic;

import java.util.List;

@Epic("Запрос на получение книг")
@Story("Получение книг автора")
public class GetBooksAndAuthorTest {

    @DisplayName("Получение книг автора")
    @Test
    @Description("Книги автора успешно получены")
    public void testGetBooks() {
        GetBooks requestGetBooks = new GetBooks();
        requestGetBooks.setAuthorsId("2");

        List<Books> books = ApiRequestLogic.getBooksJson(requestGetBooks);

        BooksAssertions.bookListAssertion(books);
    }

    @DisplayName("Получение книг в формате XML")
    @Test
    @Description("Получены книги в формате XML")
    public void testGetBooksXML() {
        GetBooksXML getBooksXML = new GetBooksXML();
        Authors author = new Authors();
        author.setId(22);
        getBooksXML.setAuthor(author);

        List<Books> booksList = ApiRequestLogic.getBooksXml(getBooksXML);

        BooksAssertions.bookListAssertion(booksList);
    }
}
