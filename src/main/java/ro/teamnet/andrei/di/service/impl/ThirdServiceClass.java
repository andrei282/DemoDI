package ro.teamnet.andrei.di.service.impl;

import ro.teamnet.andrei.di.service.IBaseService;

public class ThirdServiceClass implements IBaseService {
    @Override
    public void execute() {
        System.out.println("Executing third Service Class");
    }
}
