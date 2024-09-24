package assertion;

import entity.Authors;
import entity.Books;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static utils.DataHelper.getBooks;

public class AuthorAssertions {
    public static void matchAssertion(List<Books> booksToVerify, Authors existingAuthor) {
        assertNotNull(booksToVerify);
        assertFalse(booksToVerify.isEmpty());
        for (Books bookToVerify : booksToVerify) {
            assertNotNull(bookToVerify);
            assertNotNull(bookToVerify.getId());
            Authors authorId = bookToVerify.getAuthor();
            assertNotNull(authorId);
            assertEquals(existingAuthor.getId(), authorId.getId());
            Books expectedBook = getBooks(bookToVerify);
            assertEquals(expectedBook.getBookTitle(), bookToVerify.getBookTitle());
        }
    }
}
