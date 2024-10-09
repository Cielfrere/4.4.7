package assertion;

import entity.Authors;
import entity.Books;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static utils.DataHelper.getBooks;

public class AuthorAssertions {
    public static void matchAssertion(List<Books> booksToVerify, Authors existingAuthor, List<Books> expectedBooks) {
        assertNotNull(booksToVerify);
        assertFalse(booksToVerify.isEmpty());
        assertEquals(expectedBooks.size(), booksToVerify.size());
        for (Books bookToVerify : booksToVerify) {
            Books expectedBook = getBooks(bookToVerify);
            assertNotNull(bookToVerify);
            assertNotNull(bookToVerify.getId());
            assertNotNull(bookToVerify.getAuthor());
            Authors authorId = bookToVerify.getAuthor();
            assertEquals(existingAuthor.getId(), authorId.getId());
            assertEquals(expectedBook.getId(), bookToVerify.getId());
            assertEquals(expectedBook.getBookTitle(), bookToVerify.getBookTitle());
            assertEquals(expectedBook.getId(), bookToVerify.getId());
        }
    }
}
