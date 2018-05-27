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

import java.util.Arrays;
import java.util.Collections;

public class ResultOfBinary extends AppCompatActivity implements View.OnClickListener{

    Button ans, time_complexity, code_button;
    int n, target, i = 0;
    private TextView finalans;
    private TextView[] txtnum;
    private TextView[] resultnum;
    private int[] numbers;
    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result_of_binary);

        numbers = new int[8];
        txtnum = new TextView[10];
        resultnum = new TextView[10];

        txtnum[0] = findViewById(R.id.txt1);
        txtnum[1] = findViewById(R.id.txt2);
        txtnum[2] = findViewById(R.id.txt3);
        txtnum[3] = findViewById(R.id.txt4);
        txtnum[4] = findViewById(R.id.txt5);
        txtnum[5] = findViewById(R.id.txt6);
        txtnum[6] = findViewById(R.id.txt7);
        txtnum[7] = findViewById(R.id.txt8);

        finalans = findViewById(R.id.finaltextID);
        finalans.setMovementMethod(new ScrollingMovementMethod());

        ans = findViewById(R.id.playbuttonID);
        time_complexity = findViewById(R.id.timeComplexitybuttonID);
        code_button = findViewById(R.id.codebuttonID);

        int temp;

        Intent intent = getIntent();
        String t1 = intent.getStringExtra("t1");
        temp = Integer.parseInt( t1 );
        numbers[ 0 ] = temp;
        String t2 = intent.getStringExtra("t2");
        temp = Integer.parseInt( t2 );
        numbers[ 1 ] = temp;
        String t3 = intent.getStringExtra("t3");
        temp = Integer.parseInt( t3 );
        numbers[ 2 ] = temp;
        String t4 = intent.getStringExtra("t4");
        temp = Integer.parseInt( t4 );
        numbers[ 3 ] = temp;
        String t5 = intent.getStringExtra("t5");
        temp = Integer.parseInt( t5 );
        numbers[ 4 ] = temp;
        String t6 = intent.getStringExtra("t6");
        temp = Integer.parseInt( t6 );
        numbers[ 5 ] = temp;
        String t7 = intent.getStringExtra("t7");
        temp = Integer.parseInt( t7 );
        numbers[ 6 ] = temp;
        String t8 = intent.getStringExtra("t8");
        temp = Integer.parseInt( t8 );
        numbers[ 7 ] = temp;
        String t9 = intent.getStringExtra("t9");

        Arrays.sort( numbers );

        target = Integer.valueOf( t9 );

        for( int i = 0; i <= 7; i++ )
        {
            int x = numbers[i];
            String t = Integer.toString( x );
            txtnum[i].setText( t );
        }

        /*txtnum[0].setText( );
        txtnum[1].setText(t2);
        txtnum[2].setText(t3);
        txtnum[3].setText(t4);
        txtnum[4].setText(t5);
        txtnum[5].setText(t6);
        txtnum[6].setText(t7);*/

        ans.setOnClickListener(this);
        //time_complexity.setOnClickListener(this);
        //code_button.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.playbuttonID) {
            binarySearch();
        }
        else if(v.getId() == R.id.timeComplexitybuttonID) {
            Intent intent = new Intent( this, TimeComplexityOfBinary.class);
            startActivity(intent);
        }
    }

    public void binarySearch()
    {
        ret( 0, 7 );
    }

    public void ret( final int x, final int y )
    {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                //txtnum[x].setBackgroundResource(R.drawable.circle_shape_red);

                if( i == 12 )
                {
                    Toast.makeText( ResultOfBinary.this, "WE FAILED", Toast.LENGTH_LONG ).show();
                }

                else {
                    boolean flag = false;
                    int lo = x, hi = y, mid = (lo + hi) / 2;

                    txtnum[ mid ].setBackgroundResource(R.drawable.circle_shape_orange );
                    print(mid, target);
                    int value = Integer.valueOf(txtnum[mid].getText().toString());

                    if (value == target) {
                        Toast.makeText(ResultOfBinary.this, "WE FOUND OUR TARGET", Toast.LENGTH_LONG).show();
                        flag = true;
                        txtnum[ mid ].setBackgroundResource(R.drawable.circle_shape_orange );
                    }
                    else if (value > target) {
                        hi = mid - 1;
                    }
                    else if (value < target) {
                        lo = mid + 1;
                    }

                    if( flag == false ) {
                        ret(lo, hi);
                    }
                    txtnum[ mid ].setBackgroundResource(R.drawable.circle_shape_red );

                }
            }
        }, 3000 );

        //txtnum[x].setBackgroundResource(R.drawable.circle_shape_blue);
    }

    void print( int ii, int jj )
    {
        finalans.append(" " + "Iteration " + i + " :" + "\n" );
        finalans.append(" " + "Now Checking " + "a[" + ii + "]" + " Is Equal To " + jj + " Or Not" + "\n\n");
        i++;
    }
}
