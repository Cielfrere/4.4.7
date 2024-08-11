package models.responses;

import entity.Books;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class BookListResponse {
    private List<Books> books;
    private int errorCode;
    private String errorMessage;
    private String errorDetails;
}
