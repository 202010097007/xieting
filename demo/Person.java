import java.io.Serializable;

public abstract class Person implements Serializable {

    private transient boolean isExist;

    private Integer id;

    private Role role;

    private String name;

    private String username;

    private String password;

    /**
     * ��¼
     */
    public static Person login() {
        System.out.println("�������˺ţ�");
        String username = ScannerUtils.scanString();

        System.out.println("���������룺");
        String password = ScannerUtils.scanString();

        return Storage.getAll().filter(person -> username.equals(person.getUsername())
                && password.equals(person.getPassword()))
                .findAny().orElse(null);
    }

    /**
     * ��ʼ����
     */
    public void startOperate() {
        this.isExist = false;
        while (!isExist) {
            menu();
        }
    }

    /**
     * �˳�����
     */
    public void exit() {
        this.isExist = true;
    }

    /**
     * �޸�����
     */
    public void changePassword() {
        System.out.println("����������");
        this.password = ScannerUtils.scanString();
        Storage.storeData();
        System.out.println("�����޸ĳɹ���");
    }

    /**
     * ���������Ϣ
     */
    public void printInfo() {
        System.out.println(this);
    }

    /**
     * �����û���Ϣ
     */
    public void scanPerson() {
        System.out.println("��ʼ¼��" + this.role.getDescription() + "��Ϣ");
        String username = null;
        System.out.println("�������˺ţ�");
        while (username == null) {
            username = ScannerUtils.scanString();
            if (Storage.getBy(username) != null) {
                System.out.println("�˺��ѱ�ռ�ã����������룺");
                username = null;
            }
        }
        this.username = username;

        System.out.println("���������룺");
        this.password = ScannerUtils.scanString();

        System.out.println("���������֣�");
        this.name = ScannerUtils.scanString();
    }

    public void delete(Role role) {
        System.out.println("������" + role.getDescription() + "ID��");
        Person person = Storage.getBy(ScannerUtils.scanInt());
        if (person == null || person.getRole() != role) {
            System.out.println(role.getDescription() + "��Ϣ�����ڣ�����");
            return;
        }

        Storage.deleteBy(person.getId());
        System.out.println("ɾ���ɹ�");
    }

    /**
     * �����Ʋ��ҽ�ɫ
     */
    public void searchByNameFor(Role role) {
        System.out.println("������" + role.getDescription() + "���֣�");
        Person person = Storage.getByName(ScannerUtils.scanString());
        if (person == null || person.getRole() != role) {
            System.out.println(role.getDescription() + "��Ϣ�����ڣ�����");
            return;
        }

        person.printInfo();
    }

    /**
     * ��ӡ���н�ɫ��Ϣ
     */
    public void printAll(Role role) {
        Storage.getAll(role).forEach(System.out::println);
    }

    public abstract void menu();

    public Integer getId() {
        return id;
    }

    public Person setId(Integer id) {
        this.id = id;
        return this;
    }

    public Role getRole() {
        return role;
    }

    public Person setRole(Role role) {
        this.role = role;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public Person setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public Person setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getName() {
        return name;
    }

    public Person setName(String name) {
        this.name = name;
        return this;
    }

    public Person() {
        this.id = Storage.getNextId();
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", role=" + role.getDescription() +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}


