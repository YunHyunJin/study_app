package com.example.tue_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText ed1,ed2,ed3;
    TextView tv1,tv2,tv3;
    CheckBox cx;
    Button bt;
    private boolean checked = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ed1 = findViewById(R.id.co1);
        ed2 = findViewById(R.id.co2);
        ed3 = findViewById(R.id.co3);
        tv1 = findViewById(R.id.tva);
        tv2 = findViewById(R.id.tvb);
        tv3 = findViewById(R.id.tvc);
        bt = findViewById(R.id.bottom);
        cx = findViewById(R.id.checkBox);


        cx.setOnClickListener(new CheckBox.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(checked == false) {
                    checked = true;
                    Toast.makeText(MainActivity.this, "체크완료", Toast.LENGTH_SHORT).show();

                }
                else if(checked == true) {
                    checked = false;
                    Toast.makeText(MainActivity.this, "체크해제", Toast.LENGTH_SHORT).show();

                }

            }
        });


    }

    public void counting(View view) {
        Toast.makeText(this, "계산 완료", Toast.LENGTH_SHORT).show();
        String n1 = ed1.getText().toString();
        String n2 = ed2.getText().toString();
        String n3 = ed3.getText().toString();

        int pay1 = Integer.parseInt(n1);
        pay1 *= 4500;
        int pay2 = Integer.parseInt(n2);
        pay2 *= 5000;
        int pay3 = Integer.parseInt(n3);
        pay3 *= 5500;
        int sum = pay1+pay2+pay3;

        String original = Integer.toString(sum);
        tv1.setText("원가: "+original+"원");
        int pay=0;
        int discount = sum/10;

        if(checked == true)  {
            pay = (sum*9)/10;
            String discount_s = Integer.toString(discount);
            tv2.setText("할인금액: "+ discount_s+"원");
        }else {
            pay = sum;
            tv2.setText("할인금액: 0원");
        }

        String pay_s = Integer.toString(pay);
        tv3.setText("결제금액: "+ pay_s +"원");


    }

}
