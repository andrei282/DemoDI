package ro.teamnet.andrei.di.factory;

import ro.teamnet.andrei.di.DIApplication;
import ro.teamnet.andrei.di.annotation.DI;
import ro.teamnet.andrei.di.framework.DIFramework;
import ro.teamnet.andrei.di.service.IBaseService;

import java.lang.reflect.Constructor;
import java.util.ArrayList;


import static java.util.Objects.*;

public class ObjectFactory {

    public static IBaseService instantiateMasterServiceClass(){
        try {
            ArrayList<Class<?>> services = (ArrayList<Class<?>>) DIFramework.getServices();

            Constructor<?> constructorApplicationClass = DIFramework.getApplicationConstructor(requireNonNull(DIFramework.getApplicationClass()));

            ArrayList<Constructor<?>> servicesConstructors = (ArrayList<Constructor<?>>) DIFramework.getServicesConstructor(requireNonNull(services));

            ArrayList<IBaseService> servicesInstances = DIFramework.getServicesInstances(requireNonNull(servicesConstructors));

            return (IBaseService) requireNonNull(constructorApplicationClass).newInstance(
                    requireNonNull(servicesInstances).get(0),
                    requireNonNull(servicesInstances).get(1),
                    requireNonNull(servicesInstances).get(2));
        } catch (Exception e) {
            e.getMessage();
            e.printStackTrace();
        }
        return null;
    }

    private static IBaseService instantiateMasterServiceClassAnnotation(){
        try {
            return (IBaseService) requireNonNull(DIFramework.getApplicationConstructor(requireNonNull(DIFramework.getApplicationClass()))).
                    newInstance(
                        Class.forName(
                                Class.forName("ro.teamnet.andrei.di.service.impl.MasterServiceClass").
                                        getDeclaredField("firstServiceClass").
                                        getAnnotation(DI.class).getName()).
                                getDeclaredConstructor().
                                newInstance(),
                        Class.forName(
                                Class.forName("ro.teamnet.andrei.di.service.impl.MasterServiceClass").
                                        getDeclaredField("secondServiceClass").
                                        getAnnotation(DI.class).
                                        getName()).
                                getDeclaredConstructor().
                                newInstance(),
                        Class.forName(
                                Class.forName("ro.teamnet.andrei.di.service.impl.MasterServiceClass").
                                        getDeclaredField("thirdServiceClass").
                                        getAnnotation(DI.class).
                                        getName()).
                                getDeclaredConstructor().
                                newInstance()
            );

        } catch (Exception e){
            e.getMessage();
            e.printStackTrace();
        }
        return null;
    }

    public static DIApplication instantiateApplication() {
        return new DIApplication(ObjectFactory.instantiateMasterServiceClassAnnotation());
    }
}
