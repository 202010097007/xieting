public class Demo {

    public static void main(String[] args) {
        Storage.initManager();

        while (true) {
            Person person = Person.login();
            if (person == null) {
                System.out.println("登录失败，请重新登录！！！");
                continue;
            }

            // 开始操作
            person.startOperate();


            System.out.println("退出请输入Y/y，重新登录轻输入N/n");
            if ("Y".equalsIgnoreCase(ScannerUtils.scanString())) {
                break;
            }
        }
    }
}
