package com.example.pc.designtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import thereisnospon.codeview.CodeView;
import thereisnospon.codeview.CodeViewTheme;

public class CodeOfBubbleSort extends AppCompatActivity {

    CodeView codeView;
    String CODE =
            "#include <stdio.h>\n" +
                    " \n" +
                    "void swap(int *xp, int *yp)\n" +
                    "{\n" +
                    "    int temp = *xp;\n" +
                    "    *xp = *yp;\n" +
                    "    *yp = temp;\n" +
                    "}\n" +
                    " \n" +
                    "// An optimized version of Bubble Sort\n" +
                    "void bubbleSort(int arr[], int n)\n" +
                    "{\n" +
                    "   int i, j;\n" +
                    "   bool swapped;\n" +
                    "   for (i = 0; i < n-1; i++)\n" +
                    "   {\n" +
                    "     swapped = false;\n" +
                    "     for (j = 0; j < n-i-1; j++)\n" +
                    "     {\n" +
                    "        if (arr[j] > arr[j+1])\n" +
                    "        {\n" +
                    "           swap(&arr[j], &arr[j+1]);\n" +
                    "           swapped = true;\n" +
                    "        }\n" +
                    "     }\n" +
                    " \n" +
                    "     // IF no two elements were swapped by inner loop, then break\n" +
                    "     if (swapped == false)\n" +
                    "        break;\n" +
                    "   }\n" +
                    "}\n" +
                    " \n" +
                    "/* Function to print an array */\n" +
                    "void printArray(int arr[], int size)\n" +
                    "{\n" +
                    "    int i;\n" +
                    "    for (i=0; i < size; i++)\n" +
                    "        printf(\"%d \", arr[i]);\n" +
                    "    printf(\"n\");\n" +
                    "}\n" +
                    " \n" +
                    "// Driver program to test above functions\n" +
                    "int main()\n" +
                    "{\n" +
                    "    int arr[] = {64, 34, 25, 12, 22, 11, 90};\n" +
                    "    int n = sizeof(arr)/sizeof(arr[0]);\n" +
                    "    bubbleSort(arr, n);\n" +
                    "    printf(\"Sorted array: \\n\");\n" +
                    "    printArray(arr, n);\n" +
                    "    return 0;\n" +
                    "}";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_code_of_bubble_sort);

        codeView=(CodeView)findViewById(R.id.code_view);
        codeView.setTheme(CodeViewTheme.ANDROIDSTUDIO).fillColor();
        //CODE is your code which  you want to show,type is String
        codeView.showCode(CODE);

    }
}
