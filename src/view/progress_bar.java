package view;

public abstract class progress_bar {

    public static void ConsoleProgressBar () {

            char[] animationChars = new char[]{'|', '/', '-', '\\'};

            for (int i = 0; i <= 100; i++) {
                System.out.print("Memproses: " + i + "% " + animationChars[i % 4] + "\r");

                try {
                    Thread.sleep(25);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
    }
}
