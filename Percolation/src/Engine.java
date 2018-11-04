public class Engine {
    public static void main(String[] args) {

        Logic first = new Logic(10,0,0);
        first.initGridGUI();
        boolean keepGoing = true;
        do
        {

            first.update();
            first.printGridGUI();
            sleepMethod(1000);

        }
        while (keepGoing);
    }





    /*You do not need to modify any of the below code!*/

    public static void sleepMethod(int duration){
        try {
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            e.getMessage();
        }
    }


}
