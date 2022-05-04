package src.Startup;

import src.Controller.Controller;
import src.Integration.Printer;
import src.View.View;


/*  
    Start up the needed systems
    Main acts as the startup and starts up the view, controller and the printer.
*/

public class Main {
    public static void main(String[] args){
        Printer printer = new Printer();            //Created new printer
        Controller controller = new Controller(printer); //Creates new controller
        View view = new View(controller);       //Creates new view
        view.dummySale();   //There is a code snippet that runs a test program of this system in the view, we call the method here
    }
}

