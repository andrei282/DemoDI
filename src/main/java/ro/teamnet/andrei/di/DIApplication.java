package ro.teamnet.andrei.di;

import ro.teamnet.andrei.di.service.IBaseService;
import ro.teamnet.andrei.di.service.impl.MasterServiceClass;


public class DIApplication {

    private MasterServiceClass masterServiceClass;

    public DIApplication(IBaseService masterServiceClass) {
        this.masterServiceClass = (MasterServiceClass) masterServiceClass;
    }

    void executeServices(){
        masterServiceClass.execute();
    }
}
