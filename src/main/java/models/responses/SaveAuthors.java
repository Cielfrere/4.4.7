package models.responses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class SaveAuthors {
    private long authorId;
    private int errorCode;
    private String errorMessage;
    private String errorDetails;
}
