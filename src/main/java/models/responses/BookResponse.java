package models.responses;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import models.request.SaveAuthors;

import javax.xml.bind.annotation.XmlRootElement;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@XmlRootElement
public class BookResponse {
    private String bookTittle;
    private SaveAuthors authors;
}
