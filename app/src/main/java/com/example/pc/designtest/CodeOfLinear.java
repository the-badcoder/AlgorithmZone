package com.example.pc.designtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import thereisnospon.codeview.CodeView;
import thereisnospon.codeview.CodeViewTheme;

public class CodeOfLinear extends AppCompatActivity {

    CodeView codeView;
    String CODE = "#include<iostream>\n" +
            " \n" +
            "using namespace std;\n" +
            " \n" +
            "int main()\n" +
            "{\n" +
            "    int a[20],n,x,i,flag=0;\n" +
            "    cout<<\"How many elements?\";\n" +
            "    cin>>n;\n" +
            "    cout<<\"\\nEnter elements of the array\\n\";\n" +
            "    \n" +
            "    for(i=0;i<n;++i)\n" +
            "        cin>>a[i];\n" +
            "    \n" +
            "    cout<<\"\\nEnter element to search:\";\n" +
            "    cin>>x;\n" +
            "    \n" +
            "    for(i=0;i<n;++i)\n" +
            "    {\n" +
            "        if(a[i]==x)\n" +
            "        {\n" +
            "            flag=1;\n" +
            "            break;\n" +
            "        }\n" +
            "    }\n" +
            "    \n" +
            "    if(flag)\n" +
            "        cout<<\"\\nElement is found\";\n" +
            "    else\n" +
            "        cout<<\"\\nElement not found\";\n" +
            "        \n" +
            "    return 0;\n" +
            "}";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_code_of_linear);

        codeView=(CodeView)findViewById(R.id.code_view);
        codeView.setTheme(CodeViewTheme.ANDROIDSTUDIO).fillColor();
        //CODE is your code which  you want to show,type is String
        codeView.showCode(CODE);


    }
}
