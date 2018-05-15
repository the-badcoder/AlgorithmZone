package com.example.pc.designtest;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultOfXor extends AppCompatActivity implements View.OnClickListener {

    Button ans;
    private TextView finalans;
    private TextView[] txtnum;
    private TextView[] resultnum;
    private int[] numbers;
    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_of_xor);

        numbers = new int[9];
        txtnum = new TextView[9];
        resultnum = new TextView[9];

        txtnum[0] = findViewById(R.id.txt1);
        txtnum[1] = findViewById(R.id.txt2);
        txtnum[2] = findViewById(R.id.txt3);
        txtnum[3] = findViewById(R.id.txt4);
        txtnum[4] = findViewById(R.id.txt5);
        txtnum[5] = findViewById(R.id.txt6);
        txtnum[6] = findViewById(R.id.txt7);
        txtnum[7] = findViewById(R.id.txt8);

        resultnum[0] = findViewById(R.id.ftxt1);
        resultnum[1] = findViewById(R.id.ftxt2);
        resultnum[2] = findViewById(R.id.ftxt3);
        resultnum[3] = findViewById(R.id.ftxt4);

        finalans = findViewById(R.id.finaltextID);
        finalans.setMovementMethod(new ScrollingMovementMethod());

        ans = findViewById(R.id.playbuttonID);

        Intent intent = getIntent();
        String t1 = intent.getStringExtra("t1");
        String t2 = intent.getStringExtra("t2");
        String t3 = intent.getStringExtra("t3");
        String t4 = intent.getStringExtra("t4");
        String t5 = intent.getStringExtra("t5");
        String t6 = intent.getStringExtra("t6");
        String t7 = intent.getStringExtra("t7");
        String t8 = intent.getStringExtra("t8");


        txtnum[0].setText(t1);
        txtnum[1].setText(t2);
        txtnum[2].setText(t3);
        txtnum[3].setText(t4);
        txtnum[4].setText(t5);
        txtnum[5].setText(t6);
        txtnum[6].setText(t7);
        txtnum[7].setText(t8);

        ans.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.playbuttonID) {
            bitXor();
        }
    }

    public void bitXor() {
        rec(3, 7);
    }

    public void rec(final int x, final int y) {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                int l = Integer.valueOf(txtnum[x].getText().toString());
                int r = Integer.valueOf(txtnum[y].getText().toString());

                int o = 1, z = 0;

                print(l, r, (((l == 1 && r == 1) || (l == 0 && r == 0)) ? z : 1));

                txtnum[x].setBackgroundResource(R.drawable.circle_shape_orange);
                txtnum[y].setBackgroundResource(R.drawable.circle_shape_orange);

                int i = x;
                int j = y;
                String one = "1";
                String zero = "0";

                if ((l == 1 && r == 1)) {
                    resultnum[i].setText(one);
                    resultnum[i].setBackgroundResource(R.drawable.circle_shape_red);
                } else {
                    resultnum[i].setText(zero);
                    resultnum[i].setBackgroundResource(R.drawable.circle_shape_red);
                }
                i = x - 1;
                j = y - 1;

                if (i >= 0 && y >= 4) {
                    rec(i, j);
                }
            }
        }, 2000);
    }

    public void print(int i, int j, int ans) {
        finalans.append("           " + "Now Checking " + "( " + i + " ^ " + j + " )" + " is = " + ans + "\n");
    }
}
