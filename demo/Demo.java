public class Demo {

    public static void main(String[] args) {
        Storage.initManager();

        while (true) {
            Person person = Person.login();
            if (person == null) {
                System.out.println("��¼ʧ�ܣ������µ�¼������");
                continue;
            }

            // ��ʼ����
            person.startOperate();


            System.out.println("�˳�������Y/y�����µ�¼������N/n");
            if ("Y".equalsIgnoreCase(ScannerUtils.scanString())) {
                break;
            }
        }
    }
}
