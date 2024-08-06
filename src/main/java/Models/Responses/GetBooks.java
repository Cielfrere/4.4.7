package Models.Responses;

import Objects.Books;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import java.util.List;


@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class GetBooks {
    private List<Books> books;
    private Error error;
}
