package ro.teamnet.andrei.di.framework;

import ro.teamnet.andrei.di.annotation.DI;
import ro.teamnet.andrei.di.context.BeansParser;
import ro.teamnet.andrei.di.context.MyBean;
import ro.teamnet.andrei.di.service.IBaseService;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class DIFramework {

    private static BeansParser getBeanObject() {
        JAXBContext jaxbContext;

        BeansParser beansParser = null;
        try {
            jaxbContext = JAXBContext.newInstance(BeansParser.class, MyBean.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            File xml = new File("D:\\AT_Learn\\Java Projects\\DemoDI\\src\\main\\resources\\applicationContext.xml");
            beansParser = (BeansParser) unmarshaller.unmarshal(xml);
        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

        return beansParser;
    }

    public static void displayBeans() {
        for (MyBean myBean : DIFramework.getBeanObject().getMyBean()) {
            System.out.println("Bean id: " + myBean.getId() + "; Bean class: " + myBean.getClassName());
        }
    }

    public static Class<?> getApplicationClass(){
        try {
            return Class.forName("ro.teamnet.andrei.di.service.impl.MasterServiceClass");
        }
        catch (ClassNotFoundException e){
            e.getMessage();
            e.printStackTrace();
            return null;
        }
    }

    public static List<Class<?>> getServices(){
        List<Class<?>> services = new ArrayList<>();
        try {
            /*for(int i=0; i<getBeanObject().getMyBean().size(); i++) {
                services.add(Class.forName(getBeanObject().getMyBean().get(i).getClassName()));
            }*/
            Class<?> clazz = Class.forName("ro.teamnet.andrei.di.service.impl.MasterServiceClass");

            Field[] fields = clazz.getDeclaredFields();
            for(Field field: fields){
                if(field.isAnnotationPresent(DI.class))
                    services.add(Class.forName(field.getDeclaredAnnotation(DI.class).getName()));
            }
            return services;
        }
        catch(Exception e){
            e.getMessage();
            e.printStackTrace();
            return null;
        }
    }

    public static Constructor<?> getApplicationConstructor(Class<?> applicationClass){
        try {
            return applicationClass.getConstructor(IBaseService.class, IBaseService.class, IBaseService.class);
        }
        catch(NoSuchMethodException e){
            e.getMessage();
            e.printStackTrace();
            return null;
        }
    }

    public static List<Constructor<?>> getServicesConstructor(List<Class<?>> services) {
        List<Constructor<?>> servicesConstructors = new ArrayList<>();
        try {
            for(Class<?> clazz: services) {
                servicesConstructors.add(clazz.getConstructor());
            }
            return servicesConstructors;
        }
        catch(NoSuchMethodException e){
            e.getMessage();
            e.printStackTrace();
            return null;
        }
    }

    public static ArrayList<IBaseService> getServicesInstances(ArrayList<Constructor<?>> servicesConstructors) {
        ArrayList<IBaseService> servicesInstances = new ArrayList<>();
        try{
            for(Constructor<?> constructor: servicesConstructors){
                servicesInstances.add((IBaseService) constructor.newInstance());
            }
            return servicesInstances;
        }
        catch(Exception e) {
            e.getMessage();
            e.printStackTrace();
        }
        return null;
    }
}
