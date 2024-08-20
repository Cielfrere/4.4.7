package assertion;

import entity.Books;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;
import models.responses.SaveBooksResponse;
import org.junit.jupiter.api.Assertions;

public class BooksAssertions {

    public static void bookListAssertion(List<Books> books) {
        assertNotNull(books);
        assertFalse(books.isEmpty());
    }

    public static void saveBooksAssertion(SaveBooksResponse bookResponses) {
        Assertions.assertTrue(bookResponses.getBookId() > 0);
        Assertions.assertEquals(0, bookResponses.getErrorCode());
        Assertions.assertNull(bookResponses.getErrorMessage());
    }
}
