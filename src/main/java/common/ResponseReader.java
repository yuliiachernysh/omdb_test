package common;

import com.google.gson.Gson;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.IOException;
import java.io.StringReader;

public class ResponseReader {
    private Gson gson;

    public ResponseReader(){
        gson = new Gson();
    }

    public <T> T Read(HttpResponse response, Class<T> objectClass, String type) throws IOException, JAXBException, XMLStreamException {
        String stringResponse = EntityUtils.toString(response.getEntity());

        if(type.toLowerCase().equals("json")){
            return gson.fromJson(stringResponse, objectClass);
        }else{
            XMLInputFactory xif = XMLInputFactory.newFactory();
            XMLStreamReader xsr = xif.createXMLStreamReader(new StringReader(stringResponse));
            xsr.nextTag();
            if(xsr.getAttributeValue(0).equals("True")){
                xsr.nextTag();
            }

            JAXBContext jaxbContext = JAXBContext.newInstance(objectClass);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

            return  (T) unmarshaller.unmarshal(xsr);
        }
    }
}
