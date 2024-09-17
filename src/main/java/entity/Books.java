package entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@NoArgsConstructor
@AllArgsConstructor
@Data
@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "books")
public class Books {

    @XmlElement(name = "id")
    @JsonProperty("id")
    private long id;

    @XmlElement(name = "book_title")
    @JsonProperty("bookTitle")
    private String bookTitle;

    @XmlElement(name = "author")
    @JsonProperty("author")
    private Authors author;

}
