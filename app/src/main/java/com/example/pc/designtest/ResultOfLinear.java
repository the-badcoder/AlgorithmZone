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

public class ResultOfLinear extends AppCompatActivity implements View.OnClickListener{

    Button ans;
    int n, target, i = 0;
    private TextView finalans;
    private TextView[] txtnum;
    private TextView[] resultnum;
    private int[] numbers;
    private Handler handler = new Handler();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result_of_linear);

        numbers = new int[9];
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

        ans.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.playbuttonID) {
            linearSearch();
        }
    }

    public void linearSearch()
    {
        ret( 0 );
    }

    public void ret( final int x )
    {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                //txtnum[x].setBackgroundResource(R.drawable.circle_shape_red);
                int value = Integer.valueOf(txtnum[x].getText().toString());

                if( value == target && x == 4 )
                {
                    print( value, target );
                    txtnum[x].setBackgroundResource(R.drawable.circle_shape_red );
                    Toast.makeText(ResultOfLinear.this, "WE FOUND OUR TARGET", Toast.LENGTH_LONG).show();
                }
                else if( x == 4 && value != target ){
                    print( value, target );
                    txtnum[x].setBackgroundResource(R.drawable.circle_shape_red );
                    Toast.makeText( ResultOfLinear.this, "WE FAILED", Toast.LENGTH_LONG ).show();
                }
                else {
                    print( value, target );
                    if (Integer.valueOf(txtnum[x].getText().toString()) != target ) {
                        n = x + 1;
                        ret(n);
                        txtnum[n].setBackgroundResource(R.drawable.circle_shape_orange);
                    } else if (Integer.valueOf(txtnum[x].getText().toString()) == target ) {
                        Toast.makeText(ResultOfLinear.this, "WE FOUND OUR TARGET", Toast.LENGTH_LONG).show();
                    }
                    txtnum[x].setBackgroundResource(R.drawable.circle_shape_red );
                }

            }
        }, 2500 );

        //txtnum[x].setBackgroundResource(R.drawable.circle_shape_blue);
    }

    public void print(int ii, int j ) {
        finalans.append(" " + "Iteration " + i + " :" + "\n" );
        finalans.append(" " + "Now Checking " + "a[" + i + "]" + " Is Equal To " + j + " Or Not" + "\n\n");
        i++;
    }
}
