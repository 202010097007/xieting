public class Teacher extends Person {

    /**
     * ¼��ѧ����Ϣ
     */
    public void addStudent() {
        Student student = new Student();
        student.setRole(Role.STUDENT);
        student.scanPerson();

        System.out.println("������绰���룺");
        student.setName(ScannerUtils.scanString());

        System.out.println("������༶��");
        student.setGrade(ScannerUtils.scanString());

        System.out.println("����������ţ�");
        student.setDormitory(ScannerUtils.scanString());

        Storage.store(student);
    }

    /**
     * �޸�ѧ���ɼ�
     */
    public void updateStudentScore() {
        System.out.println("������ѧ��ID��");
        int id = ScannerUtils.scanInt();
        Person student = Storage.getAll(Role.STUDENT).filter(person -> person.getId() == id)
                .findAny().orElse(null);
        if(student == null) {
            System.out.println("���޴��ˣ�����");
            return;
        }

        System.out.println("������ѧ���ɼ���");
        ((Student)student).setScore(ScannerUtils.scanInt());
        Storage.storeData();

        System.out.println("����ɹ�������");
    }

    @Override
    public void menu() {
        System.out.println("1�޸����룬2�鿴������Ϣ��3¼��ѧ���ɼ���4�鿴����ѧ����Ϣ��5.�޸�ѧ���ɼ���6�˳����ϲ���");
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
