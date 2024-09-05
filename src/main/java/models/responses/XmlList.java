package models.responses;

import entity.Books;
import lombok.Data;

import javax.xml.bind.annotation.*;
import java.util.List;

@Data
@XmlRootElement(name = "authors_books")
@XmlAccessorType(XmlAccessType.NONE)
public class XmlList {

    @XmlElementWrapper
    @XmlElement(name = "book")
    private List<Books> books;
}
