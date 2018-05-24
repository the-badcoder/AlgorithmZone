package com.example.pc.designtest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LinearFragment extends Fragment implements View.OnClickListener{

    EditText et1, et2, et3, et4, et5, et6;
    TextView textView;
    Button result, code_button, time_complexity;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_linear, container, false);

        et1 = v.findViewById(R.id.etextID1);
        et2 = v.findViewById(R.id.etextID2);
        et3 = v.findViewById(R.id.etextID3);
        et4 = v.findViewById(R.id.etextID4);
        et5 = v.findViewById(R.id.etextID5);

        et6 = v.findViewById(R.id.etextID6);

        result = v.findViewById(R.id.resultID1);
        code_button = v.findViewById(R.id.codebuttonID);
        time_complexity = v.findViewById(R.id.timeComplexitybuttonID);

        result.setOnClickListener( this );
        code_button.setOnClickListener(this);
        time_complexity.setOnClickListener(this);

        return v;
    }


    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.resultID1) {
            if ((!et1.getText().toString().isEmpty())
                    && (!et2.getText().toString().isEmpty()) &&
                    (!et3.getText().toString().isEmpty())
                    && (!et4.getText().toString().isEmpty())
                    && (!et5.getText().toString().isEmpty()) && ( !et6.getText().toString().isEmpty() )
                    ) {

                Intent intent = new Intent( getActivity(), ResultOfLinear.class);
                intent.putExtra("t1", et1.getText().toString());
                intent.putExtra("t2", et2.getText().toString());
                intent.putExtra("t3", et3.getText().toString());
                intent.putExtra("t4", et4.getText().toString());
                intent.putExtra("t5", et5.getText().toString());
                intent.putExtra("t6", et6.getText().toString());
                startActivity(intent);
            } else {
                Toast.makeText( getContext(), "Please Give Valid Input", Toast.LENGTH_SHORT).show();
            }
        }
        else if (v.getId() == R.id.codebuttonID){
            Intent intent = new Intent(getActivity(), CodeOfLinear.class); startActivity(intent);
        }
        else if (v.getId() == R.id.timeComplexitybuttonID){
            Intent intent = new Intent(getActivity(), TimeComplexityOfLinear.class); startActivity(intent);
        }
    }
}
