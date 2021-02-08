package com.example.testando_logica;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.util.EventLog;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    LinearLayout layout_princial;
    ImageView caca, cacador;

    TextView moster;

    int cacaX =0;
    int cacaY=0;

    float cacadorX,cacadorY;
    boolean ligar= true;

    Timer timer = new Timer();
    Handler handler = new Handler();








    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        caca = findViewById(R.id.caca);
        cacador = findViewById(R.id.cacador);
        moster = findViewById(R.id.moster);
        layout_princial = findViewById(R.id.layout_princial);

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        cacando();
                        teste();
                        moster.setText(String.valueOf(cacaX+ "\n" + cacaY+ "\n" + "<<<>>>>" + "\n"+ cacadorX+ "\n" + cacadorY));

                    }
                });
            }
        },0,1);



    }

    public void teste(){
        cacador.setBackgroundResource(R.mipmap.ic_launcher);
        caca.setBackgroundResource(R.mipmap.ic_launcher_round);

        caca.setX(cacaX);
        caca.setY(cacaY);

        cacadorX = cacador.getX();
        cacadorY = cacador.getY();


    }
    public void cacando(){

        if (cacadorX <= caca.getX()){
            cacadorX +=1;
            cacador.setX(cacadorX);
        }else {
            cacadorX -= 1;
            cacador.setX(cacadorX);
        }
       if (cacadorY <= caca.getY()){
           cacadorY +=1;
           cacador.setY(cacadorY);
       }else {
           cacadorY -=1;
           cacador.setY(cacadorY);

       }


    }

    public boolean onTouchEvent(MotionEvent event){

        if (event.getAction() == MotionEvent.ACTION_DOWN||event.getAction()==MotionEvent.ACTION_MOVE){
            cacaX = (int) event.getX();
            caca.setX(cacaX);

            cacaY = (int) event.getY();
            caca.setY(cacaY);
        }if (event.getAction()== MotionEvent.ACTION_UP){

            cacaX = cacaX ;
            caca.setX(cacaX);

            cacaY = cacaY ;
            caca.setY(cacaY);

        }

        return true;

    }








}