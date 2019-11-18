package ro.teamnet.andrei.di.service.impl;

import ro.teamnet.andrei.di.service.IBaseService;

public class FirstServiceClass implements IBaseService {
    @Override
    public void execute() {
        System.out.println("Executing First Service Class");
    }
}
