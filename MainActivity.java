package com.example.shij2.bhdconvert;

import android.graphics.Color;
import android.provider.Telephony;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TextView Title;
    private TextView TDec;
    private TextView TBi;
    private TextView THex;

    private EditText InDec;
    private EditText InBi;
    private EditText InHex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Title = (TextView) findViewById(R.id.Title);
        TDec = (TextView) findViewById(R.id.TDec);
        TBi = (TextView) findViewById(R.id.TBi);
        THex = (TextView) findViewById(R.id.THex);

        InDec = (EditText) findViewById(R.id.InDec);
        InBi = (EditText) findViewById(R.id.InBi);
        InHex = (EditText) findViewById(R.id.InHex);

        //Decimal >> Binary and Hex
        InDec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (InDec.getText().toString().matches("(.*)\\d(.*)") ) {
                    InDec.setTextColor(Color.parseColor("#000000"));
                    InBi.setTextColor(Color.parseColor("#FFFAF0"));
                    InHex.setTextColor(Color.parseColor("#FFFAF0"));
                    //bi
                    int DecBiValue = Integer.parseInt(InDec.getText().toString(),10);
                    InBi.setText(Integer.toBinaryString(DecBiValue));
                    //hex
                    InHex.setText(Integer.toHexString(DecBiValue));
                }
                else {
                        Toast toast = Toast.makeText(MainActivity.this, "Not a Binary.", Toast.LENGTH_SHORT);
                        toast.show();
                }
                }

        });

        //Binary >> Decimal and Hex
        InBi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (InBi.getText().toString().matches("(.*)[0-1](.*)")) {
                    InBi.setTextColor(Color.parseColor("#000000"));
                    InDec.setTextColor(Color.parseColor("#FFFAF0"));
                    InHex.setTextColor(Color.parseColor("#FFFAF0"));
                    //decimal
                    int BiDecValue = Integer.parseInt(InBi.getText().toString(), 2);
                    InDec.setText(Integer.toString(BiDecValue));
                    //hex
                    InHex.setText(Integer.toHexString(BiDecValue));
                }
                else {
                    Toast toast = Toast.makeText(MainActivity.this, "Not a Binary.", Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });

        //Hex >> Decimal and Binary
        InHex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (InHex.getText().toString().matches("(.*)\\p{XDigit}(.*)")) {
                    InHex.setTextColor(Color.parseColor("#000000"));
                    InDec.setTextColor(Color.parseColor("#FFFAF0"));
                    InBi.setTextColor(Color.parseColor("#FFFAF0"));
                    //decimal
                    int HexDecValue = Integer.parseInt(InHex.getText().toString(), 16);
                    InDec.setText(Integer.toString(HexDecValue));
                    //bi
                    InBi.setText(Integer.toBinaryString(HexDecValue));
                }
                else {
                    Toast toast = Toast.makeText(MainActivity.this, "Not a Hexadecimal", Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });
    }
}
