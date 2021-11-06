public class Teacher extends Person {

    /**
     * 录入学生信息
     */
    public void addStudent() {
        Student student = new Student();
        student.setRole(Role.STUDENT);
        student.scanPerson();

        System.out.println("请输入电话号码：");
        student.setName(ScannerUtils.scanString());

        System.out.println("请输入班级：");
        student.setGrade(ScannerUtils.scanString());

        System.out.println("请输入宿舍号：");
        student.setDormitory(ScannerUtils.scanString());

        Storage.store(student);
    }

    /**
     * 修改学生成绩
     */
    public void updateStudentScore() {
        System.out.println("请输入学生ID：");
        int id = ScannerUtils.scanInt();
        Person student = Storage.getAll(Role.STUDENT).filter(person -> person.getId() == id)
                .findAny().orElse(null);
        if(student == null) {
            System.out.println("查无此人！！！");
            return;
        }

        System.out.println("请输入学生成绩：");
        ((Student)student).setScore(ScannerUtils.scanInt());
        Storage.storeData();

        System.out.println("保存成功！！！");
    }

    @Override
    public void menu() {
        System.out.println("1修改密码，2查看个人信息，3录入学生成绩，4查看所有学生信息，5.修改学生成绩，6退出以上操作");
        switch (ScannerUtils.scanInt()) {
            case 1:
                this.changePassword();
                break;
            case 2:
                this.printInfo();
                break;
            case 3:
                this.addStudent();
                break;
            case 4:
                this.printAll(Role.STUDENT);
                break;
            case 5:
                this.updateStudentScore();
            default:
                exit();
        }
    }
}
