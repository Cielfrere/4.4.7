package unit_tests.save_method_test;

import io.qameta.allure.Description;
import models.request.SaveBooks;
import entity.Authors;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import models.responses.SaveBooksResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import assertion.BooksAssertions;

@Epic("Запрос на сохранение книг")
@Story("Сохранение книг автора")
public class SaveMethodTest {

    @DisplayName("Cохранение книг")
    @ParameterizedTest(name = "{index}")
    @CsvSource({"Преступление и наказание, 3", "Война и мир, 4", "Анна Каренина, 5"})
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
