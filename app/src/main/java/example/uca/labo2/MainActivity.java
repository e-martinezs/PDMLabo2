package example.uca.labo2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int pointsA = 0;
    private int pointsB = 0;
    private boolean deuce = false;
    private TextView textPointsA, textPointsB;
    private Button buttonA, buttonB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textPointsA = findViewById(R.id.textViewPointsA);
        textPointsB = findViewById(R.id.textViewPointsB);
        buttonA = findViewById(R.id.changeTextButtonA);
        buttonB = findViewById(R.id.changeTextButtonB);
    }

    public void addPointA(View v){
        pointsA++;
        checkScore();
    }

    public void addPointB(View v){
        pointsB++;
        checkScore();
    }

    public String getScoreString(int points){
        String pointString = "0";
        switch (points){
            case 0:
                pointString = "0";
                break;
            case 1:
                pointString = "15";
                break;
            case 2:
                pointString = "30";
                break;
            case 3:
                pointString = "40";
                break;
        }
        return pointString;
    }

    public void checkScore(){
        if (!deuce){
            textPointsA.setText(getScoreString(pointsA));
            textPointsB.setText(getScoreString(pointsB));
            if (pointsA == 4 && pointsB < 3){
                setWin(1);
            }
            if (pointsB == 4 && pointsA < 3){
                setWin(2);
            }
            if (pointsA == 3 && pointsB == 3){
                deuce = true;
                textPointsA.setText(R.string.deuce);
                textPointsB.setText(R.string.deuce);
            }
        }
        if (deuce){
            if (pointsA-pointsB == 0){
                textPointsA.setText(R.string.deuce);
                textPointsB.setText(R.string.deuce);
            }
            if (pointsA-pointsB == 1){
                textPointsA.setText(R.string.advantage);
                textPointsB.setText("-");
            }
            if (pointsB-pointsA == 1){
                textPointsA.setText("-");
                textPointsB.setText(R.string.advantage);
            }
            if (pointsA-pointsB == 2){
                setWin(1);
            }
            if (pointsB-pointsA == 2){
                setWin(2);
            }
        }
    }

    public void setWin(int player){
        if (player == 1){
            textPointsA.setText(R.string.win);
            textPointsB.setText("-");
        }else{
            textPointsA.setText("-");
            textPointsB.setText(R.string.win);
        }
        buttonA.setEnabled(false);
        buttonB.setEnabled(false);
    }

    public void resetPoints(View v){
        pointsA = 0;
        pointsB = 0;
        deuce = false;
        buttonA.setEnabled(true);
        buttonB.setEnabled(true);
        checkScore();
    }
}
