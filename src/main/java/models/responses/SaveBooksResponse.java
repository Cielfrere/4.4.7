package models.responses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.xml.bind.annotation.XmlRootElement;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@XmlRootElement
public class SaveBooksResponse {
    private long bookId;
    private int errorCode;
    private String errorMessage;
    private String errorDetails;
}
