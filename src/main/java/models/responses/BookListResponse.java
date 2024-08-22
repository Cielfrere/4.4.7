package models.responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import entity.Books;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@XmlRootElement
public class BookListResponse {

    @JsonProperty("books")
    private List<BookResponse> books;

    @JsonProperty("errorCode")
    private int errorCode;

    @JsonProperty("errorMessage")
    private String errorMessage;

    @JsonProperty("errorDetails")
    private String errorDetails;
}
