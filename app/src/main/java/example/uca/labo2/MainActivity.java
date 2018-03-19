package example.uca.labo2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView text1,text2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text1 = findViewById(R.id.textViewFirst);
        text2 = findViewById(R.id.textViewSecond);
    }

    public void changeText(View v){
        String aux = text1.getText().toString();
        text1.setText(text2.getText().toString());
        text2.setText(aux);
    }
}
