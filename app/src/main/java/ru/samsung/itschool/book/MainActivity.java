package ru.samsung.itschool.book;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText A = findViewById(R.id.et_a);
    EditText B = findViewById(R.id.et_b);
    Button bmultiply = findViewById(R.id.btn_mult);
    Button bminus = findViewById(R.id.btn_minus);
    Button bplus = findViewById(R.id.btn_plus);
    Button bdivide = findViewById(R.id.btn_div);
    TextView tvResult = findViewById(R.id.tv_result);

    double firstNum = Double.parseDouble(A.toString());
    double secondNum = Double.parseDouble(B.toString());
    double result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v){
                switch(v.getId()){
                    case (R.id.btn_div):
                        result =  firstNum / secondNum;
                        break;
                    case (R.id.btn_mult):
                        result =  firstNum * secondNum;
                        break;
                    case (R.id.btn_minus):
                        result =  firstNum - secondNum;
                        break;
                    case (R.id.btn_plus):
                        result =  firstNum + secondNum;
                        break;
                }
            }
        };
        bplus.setOnClickListener(listener);
        bminus.setOnClickListener(listener);
        bdivide.setOnClickListener(listener);
        bmultiply.setOnClickListener(listener);
        tvResult.setText(Double.toString(result));
    }

}
