package GenricExcise_;

import org.junit.jupiter.api.Test;

import java.util.*;

public class Homework01 {
    public static void main(String[] args) {

    }

    @Test
    public void testList() {
        DAO<User> dao = new DAO<>();
        dao.save("001",new User(1,10,"jack"));
        dao.save("002",new User(2,18,"king"));
        dao.save("003",new User(3,38,"smith"));

        List<User> list = dao.list();
        System.out.println("list = " + list);

        dao.update("003",new User(3,58,"milan"));
        dao.delete("001");
        System.out.println("======修改后=======：");
        list = dao.list();
        System.out.println("list = " + list);


    }
}

class DAO<T> {
    private Map<String,T> n = new HashMap<>();

    public void save(String id,T entity){
        n.put(id,entity);
    }

    public T get(String id) {
        return n.get(id);
    }

    public void update(String id,T entity) {
        n.put(id,entity);
    }

    public List<T> list() {
        List<T> list = new ArrayList<>();

        Set<String> keySet = n.keySet();
        for (String key : keySet){
            list.add(n.get(key));
        }
        return list;
    }

    public void delete(String id) {
        n.remove(id);
    }

}

class User {
    private int id;
    private int age;
    private String name;

    public User(int id, int age, String name) {
        this.id = id;
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}

