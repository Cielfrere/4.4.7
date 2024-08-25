package unit_tests.save_method_test;

import io.qameta.allure.Description;
import models.request.SaveBooks;
import entity.Authors;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import models.responses.SaveBooksResponse;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import assertion.BooksAssertions;

@Epic("Запрос на сохранение книг")
@Story("Сохранение книг автора")
public class SaveMethodTest {

    @ParameterizedTest(name = "Сохранение новой книги с bookTitle = {0}")
    @CsvSource({"Преступление и наказание, 3, Фёдор, Михайлович, Достоевский", "Война и мир, 4, Лев, Николаевич, Толстой", "Анна Каренина, 5, Лев, Николаевич, Толстой"})
    @Description("Проверка сохранения книг")
    public void saveBookTest(String bookTitle, int authorId) {
        Authors author = new Authors();
        author.setId(authorId);

        SaveBooks saveBooks = new SaveBooks();
        saveBooks.setBookTitle(bookTitle);
        saveBooks.setAuthor(author);

        SaveBooksResponse saveBooksResponse = configuration.ApiRequestLogic.saveBooks(saveBooks);

        BooksAssertions.saveBooksAssertion(saveBooksResponse);
    }
}
