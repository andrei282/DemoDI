package ro.teamnet.andrei.di;

import ro.teamnet.andrei.di.factory.ObjectFactory;

class Application {
    static void run(){
        DIApplication diApplication = ObjectFactory.instantiateApplication();
        diApplication.executeServices();
    }
}
