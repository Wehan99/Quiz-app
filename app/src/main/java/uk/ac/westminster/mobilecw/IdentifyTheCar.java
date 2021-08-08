package uk.ac.westminster.mobilecw;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class IdentifyTheCar extends MainActivity {
    private TextView textView;
    private ImageView imageView1;
    private ImageView imageView2;
    private ImageView imageView3;
    private int j;
    private int k;
    private int l;
    private int m;
    Dialog dialog;
    private Button button;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_identify_the_car);

        //Introducing the imagesVies to XML imageViews
        textView =(TextView)findViewById(R.id.textViewRndBrand);
        imageView1 = (ImageView) findViewById(R.id.imageViewCar1);
        imageView2 = (ImageView) findViewById(R.id.imageViewCar2);
        imageView3 = (ImageView) findViewById(R.id.imageViewCar3);
        button=(Button)findViewById(R.id.buttonIdentify);
        dialog=new Dialog(this);
        randomBrand();

    }

    public  void randomBrand(){
        //defining array
        String[] brands=new String[]{"Ferrari","Ford","Volvo","Mazda","Honda","Toyota"};
        //shuffeling array and get the first element to text view

       //crating 3 random numbers for e imageViews

        Random random1 = new Random();
        j = random1.nextInt(11 - 0) + 0;                        //adding e images from array according to the random generated number
        imageView1.setImageResource(photoArray[j].getImage());

        Random random2 = new Random();
        k = random2.nextInt(23 - 11) + 11;
        imageView2.setImageResource(photoArray[k].getImage());

        Random random3 = new Random();
        l = random3.nextInt( 35 - 23) + 23;
        imageView3.setImageResource(photoArray[l].getImage());

        Integer[] brandName=new Integer[]{j,k,l};                       //generating a random brand name
        Collections.shuffle(Arrays.asList(brandName));
        m=brandName[0];
        textView.setText( photoArray[m].getData());

    }


//these are the methods run after a clicking a image
    public void checkImage1(View view) {                                                            //checking is this right or wrong
        if(photoArray[j].getData().equals(photoArray[m].getData())){
            winLayout();                                                                            //if right or wrong calling theese methods

        }else {
            loseLayout();


        }nextQuestion();
    }

    public void checkImage2(View view) {                                                 //checking is this right or wrong
        if(photoArray[k].getData().equals(photoArray[m].getData())){
            winLayout();                                                                 //if right or wrong calling theese methods
        }else {
            loseLayout();
        }
        nextQuestion();
    }

    public void checkImage3(View view) {
        if(photoArray[l].getData().equals(photoArray[m].getData())){                         //checking is this right or wrong
            winLayout();
        }else {
            loseLayout();
        }
        nextQuestion();                             //if right or wrong calling theese methods
    }

    private void loseLayout() {                                                 //losing layout
        dialog.setContentView(R.layout.lose_layout);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        Button buttonOk=dialog.findViewById(R.id.buttonOK);
        dialog.show();

        buttonOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dialog.dismiss();
            }
        });


    }
    private void winLayout() {                                      //winning layout
        dialog.setContentView(R.layout.win_layout);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        Button buttonOk=dialog.findViewById(R.id.buttonOK);
        dialog.show();

        buttonOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dialog.dismiss();
            }
        });
    }
    public void nextQuestion(){                                         //after right or wrong answer getting next question
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent t =new Intent(IdentifyTheCar.this,IdentifyTheCar.class);
                startActivity(t);
                finish();



            }
        });
    }
}