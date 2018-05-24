package com.example.pc.designtest;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class InsertionSort extends AppCompatActivity implements View.OnClickListener{

    Button ans, code_button, time_complexity;
    int n, target, i = 0, loop = 0;
    private TextView finalans;
    private TextView[] txtnum;
    private TextView[] resultnum;
    private int[] numbers;
    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insertion_sort);

        numbers = new int[6];
        txtnum = new TextView[9];
        resultnum = new TextView[9];

        txtnum[0] = findViewById(R.id.txt1);
        txtnum[1] = findViewById(R.id.txt2);
        txtnum[2] = findViewById(R.id.txt3);
        txtnum[3] = findViewById(R.id.txt4);
        txtnum[4] = findViewById(R.id.txt5);
        txtnum[5] = findViewById(R.id.txt6);

        finalans = findViewById(R.id.finaltextID);
        finalans.setMovementMethod(new ScrollingMovementMethod());

        ans = findViewById(R.id.playbuttonID);
        code_button = findViewById(R.id.codebuttonID);
        time_complexity = findViewById(R.id.timeComplexitybuttonID);

        Intent intent = getIntent();
        String t1 = intent.getStringExtra("t1");
        String t2 = intent.getStringExtra("t2");
        String t3 = intent.getStringExtra("t3");
        String t4 = intent.getStringExtra("t4");
        String t5 = intent.getStringExtra("t5");
        String t6 = intent.getStringExtra("t6");

        target = Integer.valueOf( t6 );

        txtnum[0].setText(t1);
        txtnum[1].setText(t2);
        txtnum[2].setText(t3);
        txtnum[3].setText(t4);
        txtnum[4].setText(t5);
        txtnum[5].setText(t6);

        ans.setOnClickListener(this);
        code_button.setOnClickListener(this);
        time_complexity.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.playbuttonID) {
            insertionsort();
        }
        else if (v.getId() == R.id.codebuttonID){
            Intent intent = new Intent(this, CodeOfInsertionSort.class); startActivity(intent);
        }
        else if (v.getId() == R.id.timeComplexitybuttonID){
            Intent intent = new Intent(this, TimeComplexityOfInsetionSort.class); startActivity(intent);
        }
    }

    public void insertionsort() {
        animateInsertion(1);
    }

    public void animateInsertion(final int m) {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                change( n, m );
                if (m != n) {
                    String temp = txtnum[m].getText().toString();
                    for (int k = m; k > n; k--) {
                        txtnum[k].setText(txtnum[k - 1].getText().toString());
                    }
                    txtnum[n].setText(temp);
                }

                txtnum[m].setBackgroundResource(R.drawable.circle_shape_blue);
                txtnum[n].setBackgroundResource(R.drawable.circle_shape_blue);

                int it = m + 1;
                if (it < numbers.length) {
                    animateInsertion(it);
                }

            }
        }, 3000);

        txtnum[m].setBackgroundResource(R.drawable.circle_shape_orange);
        n = findInsertMin(m);
        txtnum[n].setBackgroundResource(R.drawable.circle_shape_orange);
    }

    int findInsertMin(int v) {
        int mi = v;
        for (int k = 0; k <= mi; k++) {
            if (Integer.valueOf(txtnum[k].getText().toString()) > Integer.valueOf(txtnum[mi].getText().toString())) {
                mi = k;
            }

        }
        return mi;
    }

    void change( int ii, int jj )
    {
        finalans.append(" " + "Iteration " + i + " :" + "\n" );
        finalans.append(" " + "Swapping " + "a[" + ii + "]" + " And " + "a[" +  jj + "]" + "\n\n");
        i++;
    }

    void nochange( int ii, int jj )
    {
        finalans.append(" " + "Iteration " + i + " :" + "\n" );
        finalans.append(" " + "No Swapping Between " + "a[" + ii + "]" + " And " + "a[" +  jj + "]" + "\n\n");
        i++;
    }
}
