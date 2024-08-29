package models.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import entity.Authors;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import models.responses.BookResponse;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@XmlRootElement
public class GetBooksXML {

    @JsonProperty("author")
    private Authors author;
    private List<BookResponse> books;

    @XmlElement(name = "author_id")
    public long getAuthorId() {
        return author.getId();
    }
}
