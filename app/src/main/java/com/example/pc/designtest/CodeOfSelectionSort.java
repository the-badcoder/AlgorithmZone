package com.example.pc.designtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import thereisnospon.codeview.CodeView;
import thereisnospon.codeview.CodeViewTheme;

public class CodeOfSelectionSort extends AppCompatActivity {

    CodeView codeView;
    String CODE = "// C program for implementation of selection sort\n" +
            "#include <stdio.h>\n" +
            " \n" +
            "void swap(int *xp, int *yp)\n" +
            "{\n" +
            "    int temp = *xp;\n" +
            "    *xp = *yp;\n" +
            "    *yp = temp;\n" +
            "}\n" +
            " \n" +
            "void selectionSort(int arr[], int n)\n" +
            "{\n" +
            "    int i, j, min_idx;\n" +
            " \n" +
            "    // One by one move boundary of unsorted subarray\n" +
            "    for (i = 0; i < n-1; i++)\n" +
            "    {\n" +
            "        // Find the minimum element in unsorted array\n" +
            "        min_idx = i;\n" +
            "        for (j = i+1; j < n; j++)\n" +
            "          if (arr[j] < arr[min_idx])\n" +
            "            min_idx = j;\n" +
            " \n" +
            "        // Swap the found minimum element with the first element\n" +
            "        swap(&arr[min_idx], &arr[i]);\n" +
            "    }\n" +
            "}\n" +
            " \n" +
            "/* Function to print an array */\n" +
            "void printArray(int arr[], int size)\n" +
            "{\n" +
            "    int i;\n" +
            "    for (i=0; i < size; i++)\n" +
            "        printf(\"%d \", arr[i]);\n" +
            "    printf(\"\\n\");\n" +
            "}\n" +
            " \n" +
            "// Driver program to test above functions\n" +
            "int main()\n" +
            "{\n" +
            "    int arr[] = {64, 25, 12, 22, 11};\n" +
            "    int n = sizeof(arr)/sizeof(arr[0]);\n" +
            "    selectionSort(arr, n);\n" +
            "    printf(\"Sorted array: \\n\");\n" +
            "    printArray(arr, n);\n" +
            "    return 0;\n" +
            "}";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_code_of_selection_sort);

        codeView=(CodeView)findViewById(R.id.code_view);
        codeView.setTheme(CodeViewTheme.ANDROIDSTUDIO).fillColor();
        //CODE is your code which  you want to show,type is String
        codeView.showCode(CODE);

    }
}
