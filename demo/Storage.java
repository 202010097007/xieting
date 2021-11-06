import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

public class Storage {

    /**
     * 数据保存的文件路径
     */
    private static final String FILE_PATH = "/Users/liubing/test.txt";

    private static int NEXT_ID;

    private static final List<Person> PERSONS = new LinkedList<>();

    public static int getNextId() {
        return NEXT_ID++;
    }

    public static void store(Person person) {
        PERSONS.add(person);
        storeData();
    }

    public static Person getBy(String username) {
        if (username == null) {
            return null;
        }
        return PERSONS.stream().filter(person -> username.equals(person.getUsername()))
                .findAny().orElse(null);
    }

    public static Person getBy(int id) {
        return PERSONS.stream().filter(person -> person.getId() == id)
                .findAny().orElse(null);
    }

    public static Stream<Person> getAll() {
        return PERSONS.stream();
    }

    public static Stream<Person> getAll(Role role) {
        return PERSONS.stream().filter(person -> person.getRole() == Role.STUDENT);
    }

    public static void deleteBy(Integer id) {
        PERSONS.removeIf(person -> person.getId().equals(id));
        storeData();
    }

    public static Person getByName(String name) {
        if (name == null) {
            return null;
        }
        return PERSONS.stream().filter(person -> name.equals(person.getName()))
                .findAny().orElse(null);
    }

    public static void storeData() {
        try (FileOutputStream fos = new FileOutputStream(FILE_PATH);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            for (Person person : PERSONS) {
                oos.writeObject(person);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void initManager() {
        if (PERSONS.isEmpty()) {
            store(new Manager().setRole(Role.MANAGER).setUsername("admin").setPassword("admin"));
        }
    }

    private static void loadData() {
        File file = new File(FILE_PATH);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try (FileInputStream fis = new FileInputStream(file);
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            for (Person person; (person = (Person) ois.readObject()) != null; ) {
                PERSONS.add(person);
            }
        } catch (IOException | ClassNotFoundException e) {
            if (e instanceof EOFException) {
            } else {
                e.printStackTrace();
            }
        }
    }

    private static void initNextId() {
        NEXT_ID = PERSONS.stream().mapToInt(Person::getId).max().orElse(0) + 1;
    }

    static {
        loadData();
        initNextId();
        Storage.getAll().forEach(System.out::println);
    }
}
