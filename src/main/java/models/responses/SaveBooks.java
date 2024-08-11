package models.responses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class SaveBooks {
    private long booksId;
    private int errorCode;
    private String errorMessage;
    private String errorDetails;
}
