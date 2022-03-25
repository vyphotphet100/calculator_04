package hcmute.edu.vn.calculator_04;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9,
            btnDot, btnPlus, btnMinus, btnMultiple, btnDivide, btnEqual, btnC;
    private TextView txtView1, txtView2;

    // flags
    private Boolean checkedPlus = false;
    private Boolean checkedMinus = false;
    private Boolean checkedDivide = false;
    private Boolean checkedMultiple = false;
    private Boolean checkedJustDoOperation = false;

    private Float firstNum = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mapping();
        setListenerForViews();
    }

    private void mapping() {
        btn0 = findViewById(R.id.button0);
        btn1 = findViewById(R.id.button1);
        btn2 = findViewById(R.id.button2);
        btn3 = findViewById(R.id.button3);
        btn4 = findViewById(R.id.button4);
        btn5 = findViewById(R.id.button5);
        btn6 = findViewById(R.id.button6);
        btn7 = findViewById(R.id.button7);
        btn8 = findViewById(R.id.button8);
        btn9 = findViewById(R.id.button9);
        btnDot = findViewById(R.id.buttonDot);
        btnPlus = findViewById(R.id.buttonPlus);
        btnMinus = findViewById(R.id.buttonMinus);
        btnMultiple = findViewById(R.id.buttonMultiple);
        btnDivide = findViewById(R.id.buttonDivide);
        btnC = findViewById(R.id.buttonC);
        btnEqual = findViewById(R.id.buttonEqual);
        txtView1 = findViewById(R.id.textView1);
        txtView2 = findViewById(R.id.textView2);
    }

    private void setListenerForViews() {
        btn0.setOnClickListener(btn0_OnClick);
        btn1.setOnClickListener(btn1_OnClick);
        btn2.setOnClickListener(btn2_OnClick);
        btn3.setOnClickListener(btn3_OnClick);
        btn4.setOnClickListener(btn4_OnClick);
        btn5.setOnClickListener(btn5_OnClick);
        btn6.setOnClickListener(btn6_OnClick);
        btn7.setOnClickListener(btn7_OnClick);
        btn8.setOnClickListener(btn8_OnClick);
        btn9.setOnClickListener(btn9_OnClick);
        btnDot.setOnClickListener(btnDot_OnClick);
        btnPlus.setOnClickListener(btnPlus_OnClick);
        btnMinus.setOnClickListener(btnMinus_OnClick);
        btnDivide.setOnClickListener(btnDivide_OnClick);
        btnMultiple.setOnClickListener(btnMultiple_OnClick);
        btnEqual.setOnClickListener(btnEqual_OnClick);
        btnC.setOnClickListener(btnC_OnClick);
    }

    private View.OnClickListener btn0_OnClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            checkJustDoOperation();

            txtView1.setText(txtView1.getText() + "0");
        }
    };

    private View.OnClickListener btn1_OnClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            checkJustDoOperation();

            txtView1.setText(txtView1.getText() + "1");
        }
    };

    private View.OnClickListener btn2_OnClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            checkJustDoOperation();

            txtView1.setText(txtView1.getText() + "2");
        }
    };

    private View.OnClickListener btn3_OnClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            checkJustDoOperation();

            txtView1.setText(txtView1.getText() + "3");
        }
    };

    private View.OnClickListener btn4_OnClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            checkJustDoOperation();

            txtView1.setText(txtView1.getText() + "4");
        }
    };

    private View.OnClickListener btn5_OnClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            checkJustDoOperation();

            txtView1.setText(txtView1.getText() + "5");
        }
    };

    private View.OnClickListener btn6_OnClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            checkJustDoOperation();

            txtView1.setText(txtView1.getText() + "6");
        }
    };

    private View.OnClickListener btn7_OnClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            checkJustDoOperation();

            txtView1.setText(txtView1.getText() + "7");
        }
    };

    private View.OnClickListener btn8_OnClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            checkJustDoOperation();

            txtView1.setText(txtView1.getText() + "8");
        }
    };

    private View.OnClickListener btn9_OnClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            checkJustDoOperation();

            txtView1.setText(txtView1.getText() + "9");
        }
    };

    private View.OnClickListener btnDot_OnClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            checkJustDoOperation();

            txtView1.setText(txtView1.getText() + ".");
        }
    };

    private View.OnClickListener btnPlus_OnClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (checkOperation())
                btnEqual_OnClick.onClick(null);
            beforePlus();
        }
    };

    private View.OnClickListener btnMinus_OnClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (checkOperation())
                btnEqual_OnClick.onClick(null);
            beforeMinus();
        }
    };

    private View.OnClickListener btnDivide_OnClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (checkOperation())
                btnEqual_OnClick.onClick(null);
            beforeDivide();
        }
    };

    private View.OnClickListener btnMultiple_OnClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (checkOperation())
                btnEqual_OnClick.onClick(null);
            beforeMultiple();
        }
    };

    private View.OnClickListener btnEqual_OnClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (checkedPlus) {
                afterPlus();
            } else if (checkedMinus) {
                afterMinus();
            } else if (checkedDivide) {
                afterDivide();
            } else if (checkedMultiple) {
                afterMultiple();
            } else {
                Toast.makeText(MainActivity.this, "You didn't choose operation!", Toast.LENGTH_SHORT).show();
            }

            checkedJustDoOperation = true;
            resetOperationFlag();
        }
    };

    private View.OnClickListener btnC_OnClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (checkOperation())
                txtView1.setText("");
            else
                reset();
        }
    };

    private void checkJustDoOperation() {
        if (checkedJustDoOperation && !checkOperation()) {
            txtView1.setText("");
            txtView2.setText("");
            checkedJustDoOperation = false;
        }
    }

    private Boolean checkOperation() {
        if (checkedMinus || checkedPlus ||
                checkedDivide || checkedMultiple)
            return true;
        return false;
    }

    private void beforePlus() {
        if (txtView1.getText().toString() == null ||
                txtView1.getText().toString().trim().equals("")) {
            Toast.makeText(MainActivity.this, "Please input number!", Toast.LENGTH_SHORT).show();
            return;
        }

        firstNum = Float.valueOf(txtView1.getText().toString());
        try {
            Integer fNumInt = Integer.valueOf(txtView1.getText().toString());
            txtView2.setText(fNumInt + " + ");
        } catch (Exception e) {
            txtView2.setText(firstNum + " + ");
        }

        txtView1.setText("");
        checkedPlus = true;
        btnPlus.setBackgroundColor(Color.parseColor("#9C27B0"));
    }

    private void afterPlus() {
        Float secondNum = Float.valueOf(txtView1.getText().toString());
        try {
            Integer sNumInt = Integer.valueOf(txtView1.getText().toString());
            txtView2.setText(txtView2.getText().toString() + sNumInt);
        } catch (Exception e) {
            txtView2.setText(txtView2.getText().toString() + secondNum);
        }

        Float res = OperationService.plus(firstNum, secondNum);

        Integer resInt = Math.round(res);
        if (res == (int) resInt)
            txtView1.setText(resInt.toString());
        else
            txtView1.setText(res.toString());


        checkedPlus = false;
        btnPlus.setBackgroundColor(Color.parseColor("#FF8900"));
        checkedJustDoOperation = true;
    }

    private void beforeMinus() {
        if (txtView1.getText().toString() == null ||
                txtView1.getText().toString().trim().equals("")) {
            Toast.makeText(MainActivity.this, "Please input number!", Toast.LENGTH_SHORT).show();
            return;
        }

        firstNum = Float.valueOf(txtView1.getText().toString());
        try {
            Integer fNumInt = Integer.valueOf(txtView1.getText().toString());
            txtView2.setText(fNumInt + " - ");
        } catch (Exception e) {
            txtView2.setText(firstNum + " - ");
        }

        txtView1.setText("");
        checkedMinus = true;
        btnMinus.setBackgroundColor(Color.parseColor("#9C27B0"));
    }

    private void afterMinus() {
        Float secondNum = Float.valueOf(txtView1.getText().toString());
        try {
            Integer sNumInt = Integer.valueOf(txtView1.getText().toString());
            txtView2.setText(txtView2.getText().toString() + sNumInt);
        } catch (Exception e) {
            txtView2.setText(txtView2.getText().toString() + secondNum);
        }

        Float res = OperationService.minus(firstNum, secondNum);

        Integer resInt = Math.round(res);
        if (res == (int) resInt)
            txtView1.setText(resInt.toString());
        else
            txtView1.setText(res.toString());

        checkedMinus = false;
        btnMinus.setBackgroundColor(Color.parseColor("#FF8900"));
        checkedJustDoOperation = true;
    }

    private void beforeMultiple() {
        if (txtView1.getText().toString() == null ||
                txtView1.getText().toString().trim().equals("")) {
            Toast.makeText(MainActivity.this, "Please input number!", Toast.LENGTH_SHORT).show();
            return;
        }

        firstNum = Float.valueOf(txtView1.getText().toString());
        try {
            Integer fNumInt = Integer.valueOf(txtView1.getText().toString());
            txtView2.setText(fNumInt + " x ");
        } catch (Exception e) {
            txtView2.setText(firstNum + " x ");
        }

        txtView1.setText("");
        checkedMultiple = true;
        btnMultiple.setBackgroundColor(Color.parseColor("#9C27B0"));
    }

    private void afterMultiple() {
        Float secondNum = Float.valueOf(txtView1.getText().toString());
        try {
            Integer sNumInt = Integer.valueOf(txtView1.getText().toString());
            txtView2.setText(txtView2.getText().toString() + sNumInt);
        } catch (Exception e) {
            txtView2.setText(txtView2.getText().toString() + secondNum);
        }

        Float res = OperationService.multiple(firstNum, secondNum);

        Integer resInt = Math.round(res);
        if (res == (int) resInt)
            txtView1.setText(resInt.toString());
        else
            txtView1.setText(res.toString());

        checkedMultiple = false;
        btnMultiple.setBackgroundColor(Color.parseColor("#FF8900"));
        checkedJustDoOperation = true;
    }

    private void beforeDivide() {
        if (txtView1.getText().toString() == null ||
                txtView1.getText().toString().trim().equals("")) {
            Toast.makeText(MainActivity.this, "Please input number!", Toast.LENGTH_SHORT).show();
            return;
        }

        firstNum = Float.valueOf(txtView1.getText().toString());
        try {
            Integer fNumInt = Integer.valueOf(txtView1.getText().toString());
            txtView2.setText(fNumInt + " / ");
        } catch (Exception e) {
            txtView2.setText(firstNum + " / ");
        }

        txtView1.setText("");
        checkedDivide = true;
        btnDivide.setBackgroundColor(Color.parseColor("#9C27B0"));
    }

    private void afterDivide() {
        Float secondNum = Float.valueOf(txtView1.getText().toString());
        try {
            Integer sNumInt = Integer.valueOf(txtView1.getText().toString());
            txtView2.setText(txtView2.getText().toString() + sNumInt);
        } catch (Exception e) {
            txtView2.setText(txtView2.getText().toString() + secondNum);
        }

        Float res = OperationService.divide(firstNum, secondNum);

        Integer resInt = Math.round(res);
        if (res == (int) resInt)
            txtView1.setText(resInt.toString());
        else
            txtView1.setText(res.toString());

        checkedDivide = false;
        btnDivide.setBackgroundColor(Color.parseColor("#FF8900"));
        checkedJustDoOperation = true;
    }

    private void reset() {
        txtView1.setText("");
        txtView2.setText("");
        checkedJustDoOperation = false;
        checkedMinus = false;
        checkedPlus = false;
        checkedDivide = false;
        checkedMultiple = false;

        btnPlus.setBackgroundColor(Color.parseColor("#FF8900"));
        btnMinus.setBackgroundColor(Color.parseColor("#FF8900"));
        btnDivide.setBackgroundColor(Color.parseColor("#FF8900"));
        btnMultiple.setBackgroundColor(Color.parseColor("#FF8900"));
    }

    private void resetOperationFlag() {
        checkedMinus = false;
        checkedPlus = false;
        checkedDivide = false;
        checkedMultiple = false;

        btnPlus.setBackgroundColor(Color.parseColor("#FF8900"));
        btnMinus.setBackgroundColor(Color.parseColor("#FF8900"));
        btnDivide.setBackgroundColor(Color.parseColor("#FF8900"));
        btnMultiple.setBackgroundColor(Color.parseColor("#FF8900"));

    }

}