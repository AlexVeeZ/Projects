package com.example.lesson_1;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    private ScrollView sv;
    private TextView text;
    private EditText mail;
    private EditText pass;
    private Button clickShowText;
    private Switch changeLang;
    private ToggleButton flag;
    private CheckBox theme;
    private ImageView iv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addClickListener();
    }

    private void addClickListener(){
        text = (TextView)findViewById(R.id.result);
        mail = (EditText)findViewById(R.id.email);
        pass = (EditText)findViewById(R.id.password);
        clickShowText = (Button)findViewById(R.id.show);
        changeLang = (Switch)findViewById(R.id.changeLang);
        flag = (ToggleButton)findViewById(R.id.on_off);
        theme = (CheckBox)findViewById(R.id.theme);
        sv = (ScrollView) findViewById(R.id.main);
        iv = (ImageView)findViewById(R.id.imageView);

        clickShowText.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        text.setText("Email: "+mail.getText()+" \nPassword: "+pass.getText());
                    }
                }
        );

        changeLang.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(changeLang.isChecked() == false){
                            clickShowText.setText(R.string.setText);
                            theme.setText(R.string.light_dark);
                            if(flag.getText().equals("ON")){
                                flag.setText("ВКЛ.");
                            }else{
                                flag.setText("ВЫКЛ.");
                            }
                            flag.setTextOn("ВКЛ.");
                            flag.setTextOff("ВЫКЛ.");
                        }else if (changeLang.isChecked() == true){
                            clickShowText.setText(R.string.setTextEng);
                            theme.setText(R.string.light_darkEng);
                            if(flag.getText().equals("ВКЛ.")){
                                flag.setText("ON");
                            }else{
                                flag.setText("OFF");
                            }
                            flag.setTextOn("ON");
                            flag.setTextOff("OFF");
                        }
                    }
                }
        );

        flag.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(flag.getText().equals("ON")||flag.getText().equals("ВКЛ.")){
                            sv.setBackgroundColor(Color.WHITE);
                        }else {
                            sv.setBackgroundColor(Color.BLACK);
                        }

                    }
                }
        );

        theme.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(theme.isChecked() == false){
                            iv.setImageResource(R.drawable.pngsleep);
                        }else{
                            iv.setImageResource(R.drawable.pngglasses);
                        }
                    }
                }
        );



    }



}