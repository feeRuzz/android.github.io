package com.example.test1;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    private LinearLayout l1, l2, l3;
    private boolean isStop;
    private Button btn1;
    private int cont;

    //constuctor
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        l1 = findViewById(R.id.led1);
        l2 = findViewById(R.id.led2);
        l3 = findViewById(R.id.led3);
        isStop = false;
        btn1 = findViewById(R.id.btnStart);
        cont = 0;
    }


    public void onClickStart(View view) {
        if (!isStop) {
            btn1.setText("STOP");
            isStop = true;

            new Thread(new Runnable() {
                @Override
                public void run() {

                    while (isStop) {
                        cont++;

                        //свич с выбором
                        switch (cont) {
                            //выставляю цвета блокам если условие = 1
                            case 1:
                                l1.setBackgroundColor(getResources().getColor(R.color.Red));
                                l2.setBackgroundColor(getResources().getColor(R.color.Grey));
                                l3.setBackgroundColor(getResources().getColor(R.color.Grey));
                                break;
                            //выставляю цвета блокам если условие = 2
                            case 2:
                                l1.setBackgroundColor(getResources().getColor(R.color.Grey));
                                l2.setBackgroundColor(getResources().getColor(R.color.Yellow));
                                l3.setBackgroundColor(getResources().getColor(R.color.Grey));
                                break;
                            //выставляю цвета блокам если условие = 3
                            case 3:
                                l1.setBackgroundColor(getResources().getColor(R.color.Grey));
                                l2.setBackgroundColor(getResources().getColor(R.color.Grey));
                                l3.setBackgroundColor(getResources().getColor(R.color.Green));

                                cont = 0;
                                break;

                        }
                        //Задержка на 1 секунды
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                    }

                }
            }).start();
        } else {
            isStop = false;
            btn1.setText("START");
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        isStop = false;

    }
}