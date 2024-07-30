package entities;

import java.util.HashMap;
import java.util.Map;
/*
Lines for use the container
1. IoCContainer ioc = IoCContainer.getInstance();
2. ioc.Register(Entitie_name,new Entitie_name());
3. Entitie_name any_name = (Entitie_name)ioc.Resolve("Entitie_name");
4. Now you can use the name used in any_name for to the methodes of the entitie
 */
public class IoCContainer<T> {

    //Singleton to instantiate the IoCContainer only once
    private static IoCContainer ioc;
    private IoCContainer(){}
    public static IoCContainer getInstance(){
        if(ioc == null){
            ioc = new IoCContainer();
        }return ioc;
    }

    //IoCContainer structure
    private final Map<String, T> map = new HashMap<String,T>();

    public void register(String s, T t) throws Exception {
        if(s == null){
            throw new Exception("Name can not be null");
        }
        if(map.containsKey(s)){
            throw new Exception(s + "Already exist");
        }
        map.put(s,t);
    }

    public T resolve(String s) throws Exception {
        if (s == null){
            throw new Exception(s + "does not exists");
        }
        if (!map.containsKey(s)){
            throw new Exception(s + "does not exists");
        }
        return (T)map.get(s);
    }

}
