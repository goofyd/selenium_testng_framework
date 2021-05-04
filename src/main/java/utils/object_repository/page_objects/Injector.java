package utils.object_repository.page_objects;

import org.openqa.selenium.SearchContext;

import java.lang.reflect.Field;

public class Injector {
    private static SearchContext context;

    public static void init(Object instance){
        Field[] fields = instance.getClass().getDeclaredFields();
        for (Field field : fields){
            if(field.isAnnotationPresent(SetVal.class)){
                SetVal set = field.getAnnotation(SetVal.class);
                field.setAccessible(true);
                try{
                    field.set(instance, set.name());
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
    }
}
