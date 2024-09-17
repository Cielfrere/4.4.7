package assertion;

import entity.Authors;
import entity.Books;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static utils.DataHelper.getBooks;

public class AuthorAssertions {
    public static void matchAssertion(List<Books> actualBooks, Authors expectedAuthor) {
        assertNotNull(actualBooks);
        assertFalse(actualBooks.isEmpty());
        for (Books actualBook : actualBooks) {
            assertNotNull(actualBook);
            assertNotNull(actualBook.getId());
            Authors authorId = actualBook.getAuthor();
            assertNotNull(authorId);
            assertEquals(expectedAuthor.getId(), authorId.getId());
            Books expectedBook = getBooks(actualBook);
            assertEquals(expectedBook.getBookTitle(), actualBook.getBookTitle());
        }
    }
}
