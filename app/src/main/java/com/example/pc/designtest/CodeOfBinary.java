package com.example.pc.designtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import thereisnospon.codeview.CodeView;
import thereisnospon.codeview.CodeViewTheme;

public class CodeOfBinary extends AppCompatActivity {

    CodeView codeView;
    String CODE = "// C program to implement iterative Binary Search\n" +
            "#include <stdio.h>\n" +
            " \n" +
            "// A iterative binary search function. It returns\n" +
            "// location of x in given array arr[l..r] if present,\n" +
            "// otherwise -1\n" +
            "int binarySearch(int arr[], int l, int r, int x)\n" +
            "{\n" +
            "    while (l <= r)\n" +
            "    {\n" +
            "        int m = l + (r-l)/2;\n" +
            " \n" +
            "        // Check if x is present at mid\n" +
            "        if (arr[m] == x)\n" +
            "            return m;\n" +
            " \n" +
            "        // If x greater, ignore left half\n" +
            "        if (arr[m] < x)\n" +
            "            l = m + 1;\n" +
            " \n" +
            "        // If x is smaller, ignore right half\n" +
            "        else\n" +
            "            r = m - 1;\n" +
            "    }\n" +
            " \n" +
            "    // if we reach here, then element was\n" +
            "    // not present\n" +
            "    return -1;\n" +
            "}\n" +
            " \n" +
            "int main(void)\n" +
            "{\n" +
            "    int arr[] = {2, 3, 4, 10, 40};\n" +
            "    int n = sizeof(arr)/ sizeof(arr[0]);\n" +
            "    int x = 10;\n" +
            "    int result = binarySearch(arr, 0, n-1, x);\n" +
            "    (result == -1)? printf(\"Element is not present\"\n" +
            "                                       \" in array\")\n" +
            "               : printf(\"Element is present at \"\n" +
            "                                \"index %d\", result);\n" +
            "  ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_code_of_binary);

        codeView=(CodeView)findViewById(R.id.code_view);
        codeView.setTheme(CodeViewTheme.ANDROIDSTUDIO).fillColor();
        //CODE is your code which  you want to show,type is String
        codeView.showCode(CODE);

    }
}
