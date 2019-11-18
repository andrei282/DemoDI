package ro.teamnet.andrei.di.service.impl;

import ro.teamnet.andrei.di.service.IBaseService;

public class SecondServiceClass implements IBaseService {
    @Override
    public void execute() {
        System.out.println("Executing Second Service Class");
    }
}
