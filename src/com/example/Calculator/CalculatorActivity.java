package com.example.Calculator;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CalculatorActivity extends Activity {
    /**
     * Called when the activity is first created.
     */

    EditText et1;
    Button n0,n1,n2,n3,n4,n5,n6,n7,n8,n9,ce,c,d,div,mul,minus,add,equal,dot,sqrt,signal,mode,x;
    boolean clear = false;
    boolean dotted = false;
    char operator = 0;
    double op1 = 0;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        n0 = (Button)findViewById(R.id.n0);
        n1 = (Button)findViewById(R.id.n1);
        n2 = (Button)findViewById(R.id.n2);
        n3 = (Button)findViewById(R.id.n3);
        n4 = (Button)findViewById(R.id.n4);
        n5 = (Button)findViewById(R.id.n5);
        n6 = (Button)findViewById(R.id.n6);
        n7 = (Button)findViewById(R.id.n7);
        n8 = (Button)findViewById(R.id.n8);
        n9 = (Button)findViewById(R.id.n9);
        ce = (Button)findViewById(R.id.ce);
        c = (Button)findViewById(R.id.c);
        d = (Button)findViewById(R.id.d);
        div = (Button)findViewById(R.id.div);
        mul = (Button)findViewById(R.id.mul);
        minus = (Button)findViewById(R.id.minus);
        add = (Button)findViewById(R.id.add);
        equal = (Button)findViewById(R.id.equal);
        dot = (Button)findViewById(R.id.dot);
        sqrt = (Button)findViewById(R.id.sqrt);
        signal = (Button)findViewById(R.id.signal);
        mode = (Button)findViewById(R.id.mode);
        x = (Button)findViewById(R.id.x);
        et1 = (EditText) findViewById(R.id.et1);

        n0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insert('0');
            }
        });

        n1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insert('1');
            }
        });

        n2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insert('2');
            }
        });

        n3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insert('3');
            }
        });

        n4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insert('4');
            }
        });

        n5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insert('5');
            }
        });

        n6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insert('6');
            }
        });

        n7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insert('7');
            }
        });

        n8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insert('8');
            }
        });

        n9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insert('9');
            }
        });

        dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!dotted) {
                    insert('.');
                    dotted = true;
                }
            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (operator == 0) op1 = Double.parseDouble(et1.getText().toString());
                else func();
                operator = '+';
                clear = true;
            }
        });
        
        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (operator == 0) op1 = Double.parseDouble(et1.getText().toString());
                else func();
                operator = '-';
                clear = true;
            }
        });
        
        mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (operator == 0) op1 = Double.parseDouble(et1.getText().toString());
                else func();
                operator = '*';
                clear = true;
            }
        });

        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (operator == 0) op1 = Double.parseDouble(et1.getText().toString());
                else func();
                operator = '/';
                clear = true;
            }
        });

        mode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (operator == 0) op1 = Double.parseDouble(et1.getText().toString());
                else func();
                operator = '%';
                clear = true;
            }
        });

        sqrt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (operator == 0) op1 = Double.parseDouble(et1.getText().toString());
                else func();
                operator = 's';
                clear = true;
            }
        });

        x.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (operator == 0) op1 = Double.parseDouble(et1.getText().toString());
                else func();
                operator = 'x';
                clear = true;
            }
        });

        d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (clear){et1.setText("0");}
                String s = et1.getText().toString();
                int len = s.length();
                if (s.charAt(len-1) == '.') dotted = false;
                if (len > 1) et1.setText(et1.getText().delete(len-1, len));
                else et1.setText("0");
            }
        });

        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et1.setText("0");
                dotted = false;
                operator = 0;
                op1 = 0;
            }
        });

        ce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et1.setText("0");
                dotted = false;
                operator = 0;
                op1 = 0;
            }
        });

        signal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (et1.getText().charAt(0) != '-')
                    et1.setText("-" + et1.getText());
                else
                    et1.setText(et1.getText().delete(0 , 1));
            }
        });

        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                func();
                operator = 0;
            }
        });
    }

    void insert(char n){
        String s = et1.getText().toString();
        if ((s.length() == 1 && s.charAt(0) == '0') || clear){
            et1.setText( n + "");
            clear = false;
            dotted = false;
        } else
            et1.setText( s + n );
    }

    void func(){
        switch (operator){
            case '+': op1 = op1 + Double.parseDouble(et1.getText().toString()); break;
            case '-': op1 = op1 - Double.parseDouble(et1.getText().toString()); break;
            case '*': op1 = op1 * Double.parseDouble(et1.getText().toString()); break;
            case '/': op1 = op1 / Double.parseDouble(et1.getText().toString()); break;
            case '%': op1 = op1 % Double.parseDouble(et1.getText().toString()); break;
            case 's': op1 = Math.sqrt(op1);break;
            case 'x': op1 = 1 / op1; break;
        }
        et1.setText(op1+"");
    }


}
