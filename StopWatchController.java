package Stopwatch;

//import Stopwatch.Timer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import javafx.scene.control.Button;


public class StopWatchController {
    @FXML
    public TextField hour;
    @FXML
    public TextField minute;
    @FXML
    public TextField second;
    @FXML
    public Button pauseBT;
    @FXML
    public TextArea lapTA;
    Timer timer;
    Thread t;
    int flag=0;




    public void start(ActionEvent actionEvent) {
        timer = new Timer(this);
        t = new Thread(timer);
        t.start();
        System.out.println("Timer thread started");
    }

    public void pause(ActionEvent actionEvent) {
        if(flag==0){
            t.suspend();
            pauseBT.setText("Resume");
            flag = 1;
        }
        else if(flag ==1)
        {
            t.resume();
            pauseBT.setText("Pause");
            flag=0;
        }
    }

    public void lap(ActionEvent actionEvent) {
        String lap = hour.getText()+"H : "+minute.getText()+"M : "+second.getText()+"S\n";
        lapTA.appendText(lap);
    }
    public void setTimer(int hr, int min, int sec){
        hour.setText(""+hr);
        minute.setText(""+min);
        second.setText(""+sec);
    }

    public void stop(ActionEvent actionEvent) {
        timer.stop0();
    }
}
