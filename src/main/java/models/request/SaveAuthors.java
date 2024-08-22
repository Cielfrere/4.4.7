package models.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import javax.xml.bind.annotation.XmlRootElement;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@XmlRootElement
public class SaveAuthors {
    private long id;
    private String firstName;
    private String secondName;
    private String familyName;
}
