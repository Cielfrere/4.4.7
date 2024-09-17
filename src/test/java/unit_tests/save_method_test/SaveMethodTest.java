package unit_tests.save_method_test;

import configuration.ApiRequestLogic;
import io.qameta.allure.Description;
import io.restassured.response.Response;
import models.request.SaveBooks;
import entity.Authors;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import models.responses.SaveBooksResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import assertion.BooksAssertions;
import utils.DataHelper;

import static assertion.ErrorMessageAssertions.errorMessageSaveAssertion;
import static assertion.StatusCodeAssertions.checkStatusCode;
import static utils.ErrorMessages.*;

@Epic("Запрос на сохранение книг")
@Story("Сохранение книг автора")
public class SaveMethodTest {

    @ParameterizedTest(name = "Сохранение новой книги с bookTitle = {0}")
    @CsvSource({"Преступление и наказание, 3, Фёдор, Михайлович, Достоевский", "Война и мир, 4, Лев, Николаевич, Толстой", "Анна Каренина, 5, Лев, Николаевич, Толстой"})
    @Description("Проверка сохранения книг")
    public void saveBookTest(String bookTitle) {
        Authors author = DataHelper.savedAuthor();

        SaveBooks saveBooks = new SaveBooks();
        saveBooks.setBookTitle(bookTitle);
        saveBooks.setAuthor(author);

        SaveBooksResponse saveBooksResponse = configuration.ApiRequestLogic.saveBooks(saveBooks);

        BooksAssertions.saveBooksAssertion(saveBooksResponse);
    }

    @DisplayName("Сохранение книг без их названия")
    @Test
    @Description("Сервис отправляет код ошибки 400")
    public void saveBooksWithoutBooksTitle() {
        Authors authors = DataHelper.savedAuthor();
        SaveBooks requestSaveBooks = new SaveBooks();
        requestSaveBooks.setBookTitle(null);
        requestSaveBooks.setAuthor(authors);
        Response response = ApiRequestLogic.saveBookResponse(requestSaveBooks);
        checkStatusCode(response, 400);
        errorMessageSaveAssertion(response, incorrect_booktitle);
    }

    @DisplayName("Сохранение книг без автора")
    @Test
    @Description("Сервис отправляет код ошибки 400")
    public void saveBooksWithoutAuthor() {
        SaveBooks requestSaveBooks = new SaveBooks();
        requestSaveBooks.setBookTitle("Название");
        requestSaveBooks.setAuthor(null);
        Response response = ApiRequestLogic.saveBookResponse(requestSaveBooks);
        checkStatusCode(response, 400);
        errorMessageSaveAssertion(response, incorrect_author);
    }

    @DisplayName("Сохранение книг без сохраненного автора")
    @Test
    @Description("Сервис отправляет код ошибки 409")
    public void saveBooksWithoutSavedAuthor() {
        Authors authors = DataHelper.notSavedAuthor();

        SaveBooks requestSaveBooks = new SaveBooks();
        requestSaveBooks.setBookTitle("Название");
        requestSaveBooks.setAuthor(authors);
        Response response = ApiRequestLogic.saveBookResponse(requestSaveBooks);
        checkStatusCode(response, 409);
        errorMessageSaveAssertion(response, unexpected_author);
    }

    @DisplayName("Сохранение книг без id автора")
    @Test
    @Description("Сервис отправляет код ошибки 409")
    public void saveBooksWithoutAuthorsId() {
        SaveBooks requestSaveBooks = DataHelper.withoutAuthorId();
        Response response = ApiRequestLogic.saveBookResponse(requestSaveBooks);
        checkStatusCode(response, 409);
        errorMessageSaveAssertion(response, incorrect_author);
    }
}