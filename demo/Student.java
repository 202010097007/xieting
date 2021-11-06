public class Student extends Person {

    private String phone;

    private String grade;

    private String dormitory;

    private Integer score;

    public String getPhone() {
        return phone;
    }

    public Student setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getGrade() {
        return grade;
    }

    public Student setGrade(String grade) {
        this.grade = grade;
        return this;
    }

    public String getDormitory() {
        return dormitory;
    }

    public Student setDormitory(String dormitory) {
        this.dormitory = dormitory;
        return this;
    }

    public Integer getScore() {
        return score;
    }

    public Student setScore(Integer score) {
        this.score = score;
        return this;
    }

    public Student() {
        super();
    }

    @Override
    public void menu() {
        System.out.println("1修改密码，2查看个人信息，3退出以上操作");
        switch (ScannerUtils.scanInt()) {
            case 1:
                this.changePassword();
                break;
            case 2:
                this.printInfo();
                break;
            default:
                exit();
        }
    }
}
