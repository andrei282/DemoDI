package ro.teamnet.andrei.di.context;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;

@XmlRootElement(name="beans")
public class BeansParser {

    private ArrayList<MyBean> myBean;

    @XmlElement(name="bean")
    public void setMyBean(ArrayList<MyBean> myBean) {
        this.myBean = myBean;
    }

    public ArrayList<MyBean> getMyBean() {
        return myBean;
    }
}
