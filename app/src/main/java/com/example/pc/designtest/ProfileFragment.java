package com.example.pc.designtest;

import android.content.Intent;
import android.icu.text.UnicodeSetSpanner;
import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.sql.BatchUpdateException;

public class ProfileFragment extends Fragment implements View.OnClickListener {

    private Button doneButton, bubbleButton, insertionButton, quickButton, mergeButton, selectionButton;
    private LinearLayout layout;
    EditText et1, et2, et3, et4, et5, et6;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.profile, container, false);

        et1 = v.findViewById(R.id.etextID1);
        et2 = v.findViewById(R.id.etextID2);
        et3 = v.findViewById(R.id.etextID3);
        et4 = v.findViewById(R.id.etextID4);
        et5 = v.findViewById(R.id.etextID5);
        et6 = v.findViewById(R.id.etextID6);


        doneButton = v.findViewById(R.id.CheckID);
        layout = v.findViewById(R.id.layoutID);

        bubbleButton = v.findViewById(R.id.bubbleSortID);
        insertionButton = v.findViewById(R.id.insertionSortID);
        selectionButton = v.findViewById(R.id.selectionSortID);


        doneButton.setOnClickListener(this);
        bubbleButton.setOnClickListener(this);
        insertionButton.setOnClickListener(this);
        selectionButton.setOnClickListener(this);

        return v;
    }

    @Override
    public void onClick(View v) {
        boolean flag = false;
        if (v.getId() == R.id.CheckID) {
            if ((!et1.getText().toString().isEmpty())
                    && (!et2.getText().toString().isEmpty()) &&
                    (!et3.getText().toString().isEmpty())
                    && (!et4.getText().toString().isEmpty())
                    && (!et5.getText().toString().isEmpty()) && (!et6.getText().toString().isEmpty())
                    ) {
                layout.setVisibility(View.VISIBLE);
                Toast.makeText(getContext(), "HELLO THERE", Toast.LENGTH_SHORT).show();
                flag = true;
            } else {
                Toast.makeText(getContext(), "Please Enter Valid Input", Toast.LENGTH_LONG).show();
            }
        }
        else if( v.getId() == R.id.bubbleSortID )
        {
            Intent intent = new Intent( getActivity(), BubbleSort.class);
            intent.putExtra("t1", et1.getText().toString());
            intent.putExtra("t2", et2.getText().toString());
            intent.putExtra("t3", et3.getText().toString());
            intent.putExtra("t4", et4.getText().toString());
            intent.putExtra("t5", et5.getText().toString());
            intent.putExtra("t6", et6.getText().toString());
            startActivity(intent);
        }
        else if( v.getId() == R.id.insertionSortID )
        {
            Intent intent = new Intent( getActivity(), InsertionSort.class);
            intent.putExtra("t1", et1.getText().toString());
            intent.putExtra("t2", et2.getText().toString());
            intent.putExtra("t3", et3.getText().toString());
            intent.putExtra("t4", et4.getText().toString());
            intent.putExtra("t5", et5.getText().toString());
            intent.putExtra("t6", et6.getText().toString());
            startActivity(intent);
        }
        else if( v.getId() == R.id.selectionSortID )
        {
            Intent intent = new Intent( getActivity(), SelectionSort.class);
            intent.putExtra("t1", et1.getText().toString());
            intent.putExtra("t2", et2.getText().toString());
            intent.putExtra("t3", et3.getText().toString());
            intent.putExtra("t4", et4.getText().toString());
            intent.putExtra("t5", et5.getText().toString());
            intent.putExtra("t6", et6.getText().toString());
            startActivity(intent);
        }


    }
}
