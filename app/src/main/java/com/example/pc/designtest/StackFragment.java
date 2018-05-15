package com.example.pc.designtest;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;


public class StackFragment extends Fragment implements View.OnClickListener{

    EditText et;
    TextView textView, textView1;
    Button pushButton, popButton, randomButton;
    ListView lv;
    ArrayList<String> myList = new ArrayList<>();
    ArrayAdapter arrayAdapter;

    public StackFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_stack, container, false);


        textView = view.findViewById( R.id.opNameID );
        textView1 = view.findViewById( R.id.opTypeID );
        et =  view.findViewById(R.id.numberInput);
        pushButton =  view.findViewById(R.id.push);
        popButton =  view.findViewById(R.id.pop);
        randomButton =  view.findViewById(R.id.randomInput);
        lv = view.findViewById(R.id.listView);
        pushButton.setOnClickListener(this);
        popButton.setOnClickListener(this);
        randomButton.setOnClickListener(this);

        arrayAdapter = new ArrayAdapter(getContext(), android.R.layout.simple_list_item_1, myList);
        this.lv.setAdapter((ListAdapter)arrayAdapter);

        //return inflater.inflate(R.layout.fragment_stack, container, false);
        return view;
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.push) {
            String input = et.getText().toString().trim();

            if(input.equals("") || input.equals(null)) {
                Toast.makeText(getContext(), "Invalid or empty input given.", Toast.LENGTH_LONG).show();
            }

            else {
                InputMethodManager imm = (InputMethodManager)getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(view.getWindowToken(), 0);

                textView1.setText("Operation - PUSH " + input );
                textView.setText("" + input + " Is Now On Top\n");

                lv.smoothScrollToPosition(0);
                myList.add(0, input);
                et.getText().clear();
                arrayAdapter.notifyDataSetChanged();
            }
        }

        if(view.getId() == R.id.pop) {
            if (myList.size() != 0) {
                textView1.setText("Operation - POP from the stack" );
                textView.setText("" + myList.get( 0 ) + " Removed From Top\n");
                lv.smoothScrollToPosition(0);
                myList.remove(0);
                arrayAdapter.notifyDataSetChanged();
                return;
            }
            Toast.makeText(getContext(), "No Items remaining", Toast.LENGTH_SHORT).show();
        }

        if(view.getId() == R.id.randomInput) {
            et.getText().clear();
            arrayAdapter.clear();
            Random random = new Random();
            for (int i = 0; i < 50; ++i) {
                int n = random.nextInt(100);
                String input = Integer.toString((int)n);
                myList.add(i, input);
            }
            arrayAdapter.notifyDataSetChanged();
        }
    }
}
