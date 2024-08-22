package models.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import entity.Authors;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@XmlRootElement
public class GetBooksXML {

    @JsonProperty("author")
    private Authors author;

    @XmlElement(name = "author_id")
    public long getAuthorId() {
        return author.getId();
    }
}
