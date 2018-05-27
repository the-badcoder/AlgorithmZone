package com.example.pc.designtest;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import de.hdodenhof.circleimageview.CircleImageView;


public class AboutFragment extends Fragment {

    TextView one, two, three, four;
    CircleImageView x, y, z, m;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_about, container, false);

        one = v.findViewById( R.id.sir_text );
        two = v.findViewById( R.id.tanvir_text );
        three = v.findViewById( R.id.numan_text );
        four = v.findViewById( R.id.tareq_text );

        x = v.findViewById( R.id.profile_sir );
        y = v.findViewById( R.id.profile_tanvir );
        z = v.findViewById( R.id.profile_numan );
        m = v.findViewById( R.id.profile_tareq );

        return v;

    }


}
