package dtos;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "root")
public class ErrorDto {

    @XmlAttribute(name ="response")
    public String Response;

    @XmlElement(name = "error")
    public String Error;
}
