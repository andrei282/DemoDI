package ro.teamnet.andrei.di.context;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="bean")
public class MyBean {
    private String id;
    private String className;

    public String getId() {
        return id;
    }

    public String getClassName() {
        return className;
    }

    @XmlAttribute
    public void setId(String id) {
        this.id = id;
    }

    @XmlAttribute(name="class")
    public void setClassName(String className) {
        this.className = className;
    }
}
