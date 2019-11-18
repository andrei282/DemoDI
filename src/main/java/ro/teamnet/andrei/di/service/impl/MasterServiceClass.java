package ro.teamnet.andrei.di.service.impl;

import ro.teamnet.andrei.di.annotation.DI;
import ro.teamnet.andrei.di.service.IBaseService;


public class MasterServiceClass implements IBaseService {

    @DI(getName = "ro.teamnet.andrei.di.service.impl.FirstServiceClass")
    private final IBaseService firstServiceClass;
    @DI(getName = "ro.teamnet.andrei.di.service.impl.SecondServiceClass")
    private final IBaseService secondServiceClass;
    @DI(getName = "ro.teamnet.andrei.di.service.impl.ThirdServiceClass")
    private final IBaseService thirdServiceClass;

    public MasterServiceClass(IBaseService firstServiceClass, IBaseService secondServiceClass, IBaseService thirdServiceClass) {
        this.firstServiceClass = firstServiceClass;
        this.secondServiceClass = secondServiceClass;
        this.thirdServiceClass = thirdServiceClass;
    }

    @Override
    public void execute() {
        System.out.println("Application is running registered services: ");
        System.out.print("----> ");
        firstServiceClass.execute();
        System.out.print("----> ");
        secondServiceClass.execute();
        System.out.print("----> ");
        thirdServiceClass.execute();
    }
}
