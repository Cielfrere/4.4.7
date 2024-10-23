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
            assertNotNull(actualBook.getAuthor());
            Authors actualAuthor = actualBook.getAuthor();
            assertEquals(expectedAuthor.getId(), actualAuthor.getId());
            Books expectedBook = getBooks(actualBook);
            assertNotNull(expectedBook);
            assertTrue(actualBooks.equals(expectedBook));
            assertEquals(expectedBook.getId(), actualBook.getId());
            assertEquals(expectedBook.getBookTitle(), actualBook.getBookTitle());
            // Я сравниваю то что записано в DataHelper для тестовых данных с тем что содержится по идее в бд
            // В actualBook записываются тестовые данные, а actualBooks остается неизменяемым
        }
    }
}
