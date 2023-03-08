package trh;
public class cass {

    static boolean delayedText = true;

    public static void main(String[] args) throws InterruptedException {

        delayedOutput("""
            Delayed text may look nice, but it can
            be tedious to wait for. This setting can
            always be changed later in the Settings app.
            """);

    }

    public static void delayedOutput(String mes) throws InterruptedException {
        if (delayedText) {
            for (int i = 0; i < mes.length(); i++) {
                System.out.print(mes.charAt(i));
                Thread.sleep(35);
            }
            System.out.println();
        } else {
            System.out.println(mes);
        }
    }
}
