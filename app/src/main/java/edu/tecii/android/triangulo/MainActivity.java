package edu.tecii.android.triangulo;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    @Bind(R.id.inputCat1)
    EditText inputCat1;
    @Bind(R.id.inputCat2)
    EditText inputCat2;
    @Bind(R.id.btnSumbit)
    Button btnSumbit;
    @Bind(R.id.Resu)
    TextView Resu;
    @Bind(R.id.Resu1)
    TextView Resu1;
    @Bind(R.id.Resu2)
    TextView Resu2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btnSumbit)
    public void handleClickSubmit() {
        hideKeyboard();
        String cat1 = inputCat1.getText().toString().trim();
        double cat01 = Double.parseDouble(cat1);
        String cat2 = inputCat2.getText().toString().trim();
        double cat02 = Double.parseDouble(cat2);

        if (!cat1.isEmpty()) {
            //double hip = Math.sqrt(Math.pow(cat01, 2) + Math.pow(cat02, 2));
            double hip = Math.hypot(cat01,cat02);
            double per = cat01+cat02+hip;
            double area = (cat01*cat02)/2;

            String Resul = "Hipotenusa: " +hip;
            String Resul1 = "Perímetro: "+per;
            String Resul2 = "Área:"+area;

            Resu.setVisibility(View.VISIBLE);
            Resu.setText(Resul);
            Resu1.setVisibility(View.VISIBLE);
            Resu1.setText(Resul1);
            Resu2.setVisibility(View.VISIBLE);
            Resu2.setText(Resul2);
        }
    }

    private void hideKeyboard() {
        InputMethodManager inputManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);

        try {
            inputManager.hideSoftInputFromInputMethod(getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_IMPLICIT_ONLY);
        } catch (NullPointerException npe) {
            Log.e(getLocalClassName(), Log.getStackTraceString(npe));
        }
    }
}
