public class Manager extends Person {

    public Manager() {
        super();
    }

    /**
     * ¼����ʦ��Ϣ
     */
    public void addTeacher() {
        Teacher teacher = new Teacher();
        teacher.setRole(Role.TEACHER);
        teacher.scanPerson();
        Storage.store(teacher);

        System.out.println("����ɹ�������");
    }

    @Override
    public void menu() {
        System.out.println("1�޸����룬2�鿴������Ϣ��3¼���ʦ��Ϣ�� 4�鿴��ʦ��Ϣ��5ɾ����ʦ��Ϣ��6�����Ʋ�����ʦ��Ϣ��7�˳����ϲ���");
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
