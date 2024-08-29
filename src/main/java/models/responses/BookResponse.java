package models.responses;

import com.fasterxml.jackson.annotation.JsonInclude;
import entity.Authors;
import lombok.*;

import javax.xml.bind.annotation.XmlRootElement;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@XmlRootElement
public class BookResponse {
    private Authors author;

    private int errorCode;
    private String errorMessage;
    private String errorDetails;
}
