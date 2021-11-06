import java.io.Serializable;

public abstract class Person implements Serializable {

    private transient boolean isExist;

    private Integer id;

    private Role role;

    private String name;

    private String username;

    private String password;

    /**
     * 登录
     */
    public static Person login() {
        System.out.println("请输入账号：");
        String username = ScannerUtils.scanString();

        System.out.println("请输入密码：");
        String password = ScannerUtils.scanString();

        return Storage.getAll().filter(person -> username.equals(person.getUsername())
                && password.equals(person.getPassword()))
                .findAny().orElse(null);
    }

    /**
     * 开始操作
     */
    public void startOperate() {
        this.isExist = false;
        while (!isExist) {
            menu();
        }
    }

    /**
     * 退出操作
     */
    public void exit() {
        this.isExist = true;
    }

    /**
     * 修改密码
     */
    public void changePassword() {
        System.out.println("输入新密码");
        this.password = ScannerUtils.scanString();
        Storage.storeData();
        System.out.println("密码修改成功！");
    }

    /**
     * 输出个人信息
     */
    public void printInfo() {
        System.out.println(this);
    }

    /**
     * 接收用户信息
     */
    public void scanPerson() {
        System.out.println("开始录入" + this.role.getDescription() + "信息");
        String username = null;
        System.out.println("请输入账号：");
        while (username == null) {
            username = ScannerUtils.scanString();
            if (Storage.getBy(username) != null) {
                System.out.println("账号已被占用，请重新输入：");
                username = null;
            }
        }
        this.username = username;

        System.out.println("请输入密码：");
        this.password = ScannerUtils.scanString();

        System.out.println("请输入名字：");
        this.name = ScannerUtils.scanString();
    }

    public void delete(Role role) {
        System.out.println("请输入" + role.getDescription() + "ID：");
        Person person = Storage.getBy(ScannerUtils.scanInt());
        if (person == null || person.getRole() != role) {
            System.out.println(role.getDescription() + "信息不存在！！！");
            return;
        }

        Storage.deleteBy(person.getId());
        System.out.println("删除成功");
    }

    /**
     * 按名称查找角色
     */
    public void searchByNameFor(Role role) {
        System.out.println("请输入" + role.getDescription() + "名字：");
        Person person = Storage.getByName(ScannerUtils.scanString());
        if (person == null || person.getRole() != role) {
            System.out.println(role.getDescription() + "信息不存在！！！");
            return;
        }

        person.printInfo();
    }

    /**
     * 打印所有角色信息
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


