public class Manager extends Person {

    public Manager() {
        super();
    }

    /**
     * 录入老师信息
     */
    public void addTeacher() {
        Teacher teacher = new Teacher();
        teacher.setRole(Role.TEACHER);
        teacher.scanPerson();
        Storage.store(teacher);

        System.out.println("保存成功！！！");
    }

    @Override
    public void menu() {
        System.out.println("1修改密码，2查看个人信息，3录入教师信息， 4查看教师信息，5删除教师信息，6按名称查找老师信息，7退出以上操作");
        switch (ScannerUtils.scanInt()) {
            case 1:
                this.changePassword();
                break;
            case 2:
                this.printInfo();
                break;
            case 3:
                this.addTeacher();
                break;
            case 4:
                this.printAll(Role.TEACHER);
                break;
            case 5:
                this.delete(Role.TEACHER);
                break;
            case 6:
                this.searchByNameFor(Role.TEACHER);
                break;
            default:
                exit();
        }
    }
}
