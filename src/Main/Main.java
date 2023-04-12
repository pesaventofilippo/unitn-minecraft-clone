package Main;
import ui.*;
import backend.Coordinates;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MainView ui = new MainView();
        ui.display_on_out();

        Scanner myObj = new Scanner(System.in);
        for (int i = 0 ; i < 3 ; i++){
            System.out.print("Enter row and column ('9' and '9' for smelting): ");
            Coordinates coords = new Coordinates(myObj.nextInt(), myObj.nextInt());
            if (coords.equals(new Coordinates(9, 9)))
                ui.smelt();
            else
                ui.move_into_furnace(coords);
            ui.display_on_out();
        }
    }
}
