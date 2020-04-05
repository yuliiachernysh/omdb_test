package dtos;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "movie")
public class MovieDto {

    @XmlAttribute(name = "title")
    public String Title;

    @XmlAttribute(name = "year")
    public String Year;

    @XmlAttribute(name = "imdbID")
    public String imdbID;

    @XmlAttribute(name = "plot")
    public String Plot;
}
