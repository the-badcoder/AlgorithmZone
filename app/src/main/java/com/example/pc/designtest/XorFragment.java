package com.example.pc.designtest;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class XorFragment extends Fragment implements View.OnClickListener{

    EditText et1, et2, et3, et4, et5, et6, et7, et8;
    TextView textView;
    Button result, details;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_xor, container, false);

        et1 = v.findViewById(R.id.etextID1);
        et2 = v.findViewById(R.id.etextID2);
        et3 = v.findViewById(R.id.etextID3);
        et4 = v.findViewById(R.id.etextID4);
        et5 = v.findViewById(R.id.etextID5);
        et6 = v.findViewById(R.id.etextID6);
        et7 = v.findViewById(R.id.etextID7);
        et8 = v.findViewById(R.id.etextID8);
        result = v.findViewById(R.id.resultID1);
        details = v.findViewById(R.id.detailsbuttonID);

        result.setOnClickListener( this );
        details.setOnClickListener( this );

        return v;
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.resultID1) {
            if ((!et1.getText().toString().isEmpty())
                    && (!et2.getText().toString().isEmpty()) &&
                    (!et3.getText().toString().isEmpty())
                    && (!et4.getText().toString().isEmpty())
                    && (!et5.getText().toString().isEmpty())
                    && (!et6.getText().toString().isEmpty())
                    && (!et7.getText().toString().isEmpty())
                    && (!et8.getText().toString().isEmpty())
                    ) {

                Intent intent = new Intent( getActivity(), ResultOfXor.class);
                intent.putExtra("t1", et1.getText().toString());
                intent.putExtra("t2", et2.getText().toString());
                intent.putExtra("t3", et3.getText().toString());
                intent.putExtra("t4", et4.getText().toString());
                intent.putExtra("t5", et5.getText().toString());
                intent.putExtra("t6", et6.getText().toString());
                intent.putExtra("t7", et7.getText().toString());
                intent.putExtra("t8", et8.getText().toString());
                startActivity(intent);
            } else {
                Toast.makeText( getContext(), "Please Give Valid Input", Toast.LENGTH_SHORT).show();
            }
        }
        else if (v.getId() == R.id.detailsbuttonID) {
            Intent intent = new Intent(getActivity(), DetailsXor.class);
            startActivity(intent);
        }
    }
}
