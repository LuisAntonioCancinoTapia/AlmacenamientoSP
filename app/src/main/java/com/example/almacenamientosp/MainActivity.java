package com.example.almacenamientosp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.almacenamientosp.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String SHARED_PREF = "sharedPrefs";

    private static final String TAG = "MainActivity";

    private SharedPreferences mPreferences;
    private SharedPreferences.Editor mEditor;

    private EditText mUsuario, mClave;
    private Button btnLogin;
    private CheckBox mCheckBox;
    Button btnGreenColor;

    int defval = 1;
    int Reptheme ;
    public Button button11, button22, button33;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Utils.onActivityCreateSetTheme(this, loadTheme());

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.button1).setOnClickListener(this);
        findViewById(R.id.button2).setOnClickListener(this);
        findViewById(R.id.button3).setOnClickListener(this);

        findViewById(R.id.button4).setOnClickListener(this);
        findViewById(R.id.button5).setOnClickListener(this);
        findViewById(R.id.button6).setOnClickListener(this);

        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREF, MODE_PRIVATE);
        defval = sharedPreferences.getInt("Theme", + defval);


        mUsuario = (EditText) findViewById(R.id.edtUsuario);
        mClave = (EditText) findViewById(R.id.edtClave);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        mCheckBox = (CheckBox) findViewById(R.id.checkbox);

        mPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        mEditor = mPreferences.edit();


        checkSharedPreferences();
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mCheckBox.isChecked()) {
                    mEditor.putString(getString(R.string.checkbox), "True");
                    mEditor.commit();

                    String name = mUsuario.getText().toString();
                    mEditor.putString(getString(R.string.name),name);
                    mEditor.commit();

                    String password = mClave.getText().toString();
                    mEditor.putString(getString
                            (R.string.password), password);
                    mEditor.commit();

                    Intent intent = new Intent(MainActivity.this, segundo_activity.class);
                    startActivity(intent);

                } else {

                    mEditor.putString(getString(R.string.checkbox), "False");

                    mEditor.commit();
                    mEditor.putString(getString
                            (R.string.name), "");
                    mEditor.commit();
                    mEditor.putString(getString(R.string.password), "");
                    mEditor.commit();
                }
            }
        });
    }
    private void checkSharedPreferences(){
        String checkbox = mPreferences.getString(getString(R.string.checkbox), "False");
        String name = mPreferences.getString(getString(R.string.name), "");
        String password = mPreferences.getString(getString(R.string.password), "");

        mUsuario.setText(name);
        mClave.setText(password);

        if(checkbox.equals("True")){
            mCheckBox.setChecked(true);
        }else{
            mCheckBox.setChecked(false);
        }

    }
    @Override
    public void onClick(View v)
    {
        // TODO Auto-generated method stub
        switch (v.getId())
        {
            case R.id.button1:
                Utils.changeToTheme(this, Utils.THEME_DEFAULT);
                defval = 0;
                Reptheme += Utils.THEME_DEFAULT;
                SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREF, MODE_PRIVATE);
                SharedPreferences.Editor prefEditor = sharedPreferences.edit();
                prefEditor.putInt("Theme", Utils.THEME_DEFAULT);
                prefEditor.apply();
                Toast.makeText(this, "SAVETHEMEVAL= 0", Toast.LENGTH_SHORT).show();
                break;
            case R.id.button2:
                Utils.changeToTheme(this, Utils.THEME_WHITE);
                defval = 1;
                Reptheme += Utils.THEME_WHITE;
                SharedPreferences sharedPreferences1 = getSharedPreferences(SHARED_PREF, MODE_PRIVATE);
                SharedPreferences.Editor prefEditor1 = sharedPreferences1.edit();
                prefEditor1.putInt("Theme", Utils.THEME_WHITE);
                prefEditor1.apply();

                Toast.makeText(this, "SAVETHEMEVAL= 1", Toast.LENGTH_SHORT).show();
                break;
            case R.id.button3:
                Utils.changeToTheme(this, Utils.THEME_BLUE);
                defval = 2;
                Reptheme += Utils.THEME_BLUE;
                SharedPreferences sharedPreferences2 = getSharedPreferences(SHARED_PREF, MODE_PRIVATE);
                SharedPreferences.Editor prefEditor2 = sharedPreferences2.edit();
                prefEditor2.putInt("Theme", Utils.THEME_BLUE);
                prefEditor2.apply();
                Toast.makeText(this, "SAVETHEMEVAL= 2", Toast.LENGTH_SHORT).show();
                break;

            case R.id.button4:
                Utils.changeToTheme(this, Utils.LETRA_PEQUEÑA);
                defval = 3;
                Reptheme += Utils.LETRA_PEQUEÑA;
                SharedPreferences sharedPreferences3 = getSharedPreferences(SHARED_PREF, MODE_PRIVATE);
                SharedPreferences.Editor prefEditor3 = sharedPreferences3.edit();
                prefEditor3.putInt("Theme", Utils.LETRA_PEQUEÑA);
                prefEditor3.apply();
                Toast.makeText(this, "SAVETHEMEVAL= 3", Toast.LENGTH_SHORT).show();
                break;

            case R.id.button5:
                Utils.changeToTheme(this, Utils.LETRA_MEDIANA);
                defval = 4;
                Reptheme += Utils.LETRA_MEDIANA;
                SharedPreferences sharedPreferences4 = getSharedPreferences(SHARED_PREF, MODE_PRIVATE);
                SharedPreferences.Editor prefEditor4 = sharedPreferences4.edit();
                prefEditor4.putInt("Theme", Utils.LETRA_MEDIANA);
                prefEditor4.apply();
                Toast.makeText(this, "SAVETHEMEVAL= 4", Toast.LENGTH_SHORT).show();
                break;

            case R.id.button6:
                Utils.changeToTheme(this, Utils.LETRA_GRANDE);
                defval = 5;
                Reptheme += Utils.LETRA_GRANDE;
                SharedPreferences sharedPreferences5 = getSharedPreferences(SHARED_PREF, MODE_PRIVATE);
                SharedPreferences.Editor prefEditor5 = sharedPreferences5.edit();
                prefEditor5.putInt("Theme", Utils.LETRA_GRANDE);
                prefEditor5.apply();
                Toast.makeText(this, "SAVETHEMEVAL= 5", Toast.LENGTH_SHORT).show();
                break;

        }

    }
    public void restartApp() {
        Intent i = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(i);
        finish();
    }
    public int loadTheme(){
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREF, MODE_PRIVATE);

        //Load theme colorfdsfdssdfsdfsfsd
        int theme = sharedPreferences.getInt("Theme",1); //RED is default color, when nothing is saved yet

        return theme;
    }

}