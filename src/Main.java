import java.io.IOException;

public class Main {
    public static void main (String[] args) throws IOException {
        UserInterface ui = new UserInterface();
        boolean close = false;
        while(!close) {
            close = ui.DisplayIn();
            if (!close) {

                ui.DisplayOut();
            } else {

                //close garage
                ui.closeGarage();
            }
        } // end of while

    }
}
