package models.request;

import entity.Authors;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import javax.xml.bind.annotation.XmlRootElement;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@XmlRootElement
public class SaveBooks {
    private String bookTitle;
    private Authors author;
}
