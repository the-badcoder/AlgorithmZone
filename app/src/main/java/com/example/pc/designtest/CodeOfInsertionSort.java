package com.example.pc.designtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import thereisnospon.codeview.CodeView;
import thereisnospon.codeview.CodeViewTheme;

public class CodeOfInsertionSort extends AppCompatActivity {

    CodeView codeView;
    String CODE = "// C program for insertion sort\n" +
            "#include <stdio.h>\n" +
            "#include <math.h>\n" +
            " \n" +
            "/* Function to sort an array using insertion sort*/\n" +
            "void insertionSort(int arr[], int n)\n" +
            "{\n" +
            "   int i, key, j;\n" +
            "   for (i = 1; i < n; i++)\n" +
            "   {\n" +
            "       key = arr[i];\n" +
            "       j = i-1;\n" +
            " \n" +
            "       /* Move elements of arr[0..i-1], that are\n" +
            "          greater than key, to one position ahead\n" +
            "          of their current position */\n" +
            "       while (j >= 0 && arr[j] > key)\n" +
            "       {\n" +
            "           arr[j+1] = arr[j];\n" +
            "           j = j-1;\n" +
            "       }\n" +
            "       arr[j+1] = key;\n" +
            "   }\n" +
            "}\n" +
            " \n" +
            "// A utility function to print an array of size n\n" +
            "void printArray(int arr[], int n)\n" +
            "{\n" +
            "   int i;\n" +
            "   for (i=0; i < n; i++)\n" +
            "       printf(\"%d \", arr[i]);\n" +
            "   printf(\"\\n\");\n" +
            "}\n" +
            " \n" +
            " \n" +
            " \n" +
            "/* Driver program to test insertion sort */\n" +
            "int main()\n" +
            "{\n" +
            "    int arr[] = {12, 11, 13, 5, 6};\n" +
            "    int n = sizeof(arr)/sizeof(arr[0]);\n" +
            " \n" +
            "    insertionSort(arr, n);\n" +
            "    printArray(arr, n);\n" +
            " \n" +
            "    return 0;\n" +
            "}";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_code_of_insertion_sort);

        codeView=(CodeView)findViewById(R.id.code_view);
        codeView.setTheme(CodeViewTheme.ANDROIDSTUDIO).fillColor();
        //CODE is your code which  you want to show,type is String
        codeView.showCode(CODE);


    }
}
