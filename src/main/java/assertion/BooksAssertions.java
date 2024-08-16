package assertion;

import entity.Books;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;
import models.responses.SaveBooksResponse;
import org.junit.jupiter.api.Assertions;

public class BooksAssertions {
    public static void BookListAssertion(List<Books> books) {
        assertNotNull(books);
        assertFalse(books.isEmpty());
    }
    public static void SaveBooksAssertion(SaveBooksResponse bookResponses) {
        Assertions.assertTrue(bookResponses.getBooksId() > 0);
        Assertions.assertEquals(0, bookResponses.getErrorCode());
        Assertions.assertNull(bookResponses.getErrorMessage());
    }
}
