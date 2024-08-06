package Models.Responses;

import Objects.Authors;
import Objects.Books;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class GetBooksXML {
    private List<Books> books;
    private Authors author;
    private  Error error;

}
