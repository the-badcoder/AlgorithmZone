package com.example.pc.designtest;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class QuickSort extends AppCompatActivity implements View.OnClickListener{

    Button ans;
    int n, target, i = 0, loop = 0;
    private TextView finalans;
    private TextView[] txtnum;
    private TextView[] resultnum;
    private int[] numbers;
    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quick_sort );

        numbers = new int[6];
        txtnum = new TextView[9];
        resultnum = new TextView[9];

        txtnum[0] = findViewById(R.id.txt1);
        txtnum[1] = findViewById(R.id.txt2);
        txtnum[2] = findViewById(R.id.txt3);
        txtnum[3] = findViewById(R.id.txt4);
        txtnum[4] = findViewById(R.id.txt5);
        txtnum[5] = findViewById(R.id.txt6);

        //finalans = findViewById(R.id.finaltextID);
        //finalans.setMovementMethod(new ScrollingMovementMethod());

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
        txtnum[5].setText(t6);

        ans.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
         if( v.getId() == R.id.playbuttonID )
         {
             quicksort();
         }
    }

    public  void quicksort()
    {
         ret( 0, 5 );
    }

    public void ret( final int x, final  int y )
    {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                int mid = (x + y) / 2, temp;
                int value = Integer.valueOf(txtnum[mid].getText().toString());
                int pivot = Integer.valueOf(txtnum[mid].getText().toString());
                int i = x, j = y;

                while (i <= j)
                {
                    int ii = Integer.valueOf(txtnum[i].getText().toString());
                    int jj = Integer.valueOf(txtnum[j].getText().toString());
                    while( ii < pivot )
                    {
                        i++;
                    }
                    while( jj > pivot )
                    {
                        j--;
                    }
                    if( i <= j )
                    {
                        temp = ii;
                        txtnum[i].setText( jj );
                        txtnum[j].setText( temp );
                        i++;
                        j--;
                    }
                }

            }
        },2000);
    }
}
