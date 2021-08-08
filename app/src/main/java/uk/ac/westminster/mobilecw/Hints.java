package uk.ac.westminster.mobilecw;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextClock;
import android.widget.TextView;

import java.util.Random;

public class Hints extends MainActivity {
    private ImageView imageView;
    private Button button;
    private TextView textView;
    private int i;
    private TextView hintKey;
    private int clickCount;
    private TextView key1,key2,key3, key4, key5, key6, key7;
    Dialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hints);

        //identify the imageview and button,textViews to xml imageView and button
        imageView=(ImageView)findViewById(R.id.imageViewHints);
        button=(Button)findViewById(R.id.buttonHint);
        hintKey=(TextView)findViewById(R.id.editTextCarHint);
        key1=(TextView)findViewById(R.id.textViewKey1);
        key2=(TextView)findViewById(R.id.textViewKey2);
        key3=(TextView)findViewById(R.id.textViewKey3);
        key4=(TextView)findViewById(R.id.textViewKey4);
        key5=(TextView)findViewById(R.id.textViewKey5);
        key6=(TextView)findViewById(R.id.textViewKey6);
        key7=(TextView)findViewById(R.id.textViewKey7);
        dialog=new Dialog(this);


        //calling the show random method
        showRandom();

        //checking whats the image car manufacturer
        if(photoArray[i].getData().toString().toUpperCase().equals("FERRARI")){
            carFerrari();
        }
        if(photoArray[i].getData().toString().toUpperCase().equals("FORD")){
            carFord();
        }
        if(photoArray[i].getData().toString().toUpperCase().equals("MAZDA")){
            carMazda();
        }
        if(photoArray[i].getData().toString().toUpperCase().equals("TOYOTA")){
            carToyota();
        }
        if(photoArray[i].getData().toString().toUpperCase().equals("VOLVO")){
            carVolvo();
        }
        if(photoArray[i].getData().toString().toUpperCase().equals("HONDA")){
            carHonda();
        }

    }
    //if showing answer is honda goes to carFerrari method
    private void carHonda() {
        key1.setText("");                           // removing _ for design
        key7.setText("");

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (clickCount == 2) {
                    loseMethod();                   //if all 3 chances left and all are wrong here show the answer

                    key2.setText("H");
                    key3.setText("O");
                    key4.setText("N");
                    key5.setText("D");
                    key6.setText("A");

                    return;
                }
                //if car is Honda, checking userinputs right or wrong
                    //if  its right, place correct letters

                if (hintKey.getText().toString().equals("H")) {
                    key2.setText("H");
                } else if (hintKey.getText().toString().equals("O")) {
                    key3.setText("O");
                } else if (hintKey.getText().toString().equals("N")) {
                    key4.setText("N");
                } else if (hintKey.getText().toString().equals("D")) {
                    key5.setText("D");
                } else if (hintKey.getText().toString().equals("A")) {
                    key6.setText("A");  //here I check all (key1,key2...) variable not equal to _ its mean ur answer is correct
                } else if ( key2.getText().toString().equals("_") ||
                        key3.getText().toString().equals("_") || key4.getText().toString().equals("_") ||
                        key5.getText().toString().equals("_") || key6.getText().toString().equals("_")
                ) {
                    clickCount = clickCount + 1;
                } else{
                    winMethod();}
                hintKey.setText("");
            }
        });
    }
    //if showing answer is volvo goes to carFerrari method
    private void carVolvo() {
        key1.setText("");                                     // removing _ for design
        key7.setText("");

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (clickCount == 2) {
                    loseMethod();                   //if all 3 chances left and all are wrong here show the answer and calling losemethod

                    key2.setText("V");
                    key3.setText("O");
                    key4.setText("L");
                    key5.setText("V");
                    key6.setText("O");

                    return;
                }
                //if car is Volvo, checking userinputs right or wrong
                //if  its right, place correct letters

                if (hintKey.getText().toString().equals("V")) {
                    key2.setText("V");
                    key5.setText("V");
                } else if (hintKey.getText().toString().equals("O")) {
                    key3.setText("O");
                    key6.setText("O");
                } else if (hintKey.getText().toString().equals("L")) {
                    key4.setText("L");
                 //here I check all (key1,key2...) variable not equal to _ its mean ur answer is correct
                } else if ( key2.getText().toString().equals("_") ||
                        key3.getText().toString().equals("_") || key4.getText().toString().equals("_") ||
                        key5.getText().toString().equals("_") || key6.getText().toString().equals("_")
                ) {
                    clickCount = clickCount + 1;
                } else{
                    winMethod();}
                hintKey.setText("");
            }
        });

    }
    //if showing answer is toyota goes to carFerrari method
    private void carToyota() {
        key7.setText("");                                     // removing _ for design


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (clickCount == 2) {
                    loseMethod();                   //if all 3 chances left and all are wrong here show the answer and calling losemethod

                    key1.setText("T");
                    key2.setText("O");
                    key3.setText("Y");
                    key4.setText("O");
                    key5.setText("T");
                    key6.setText("A");

                    return;
                }
                //if car is Toyota, checking userinputs right or wrong
                //if  its right, place correct letters

                if (hintKey.getText().toString().equals("T")) {
                    key1.setText("T");
                    key5.setText("T");
                } else if (hintKey.getText().toString().equals("O")) {
                    key2.setText("O");
                    key4.setText("O");
                } else if (hintKey.getText().toString().equals("Y")) {
                    key3.setText("Y");
                } else if (hintKey.getText().toString().equals("A")) {
                    key6.setText("A");
                    //here I check all (key1,key2...) variable not equal to _ its mean ur answer is correct
                } else if ( key1.getText().toString().equals("_")||key2.getText().toString().equals("_") ||
                        key3.getText().toString().equals("_") || key4.getText().toString().equals("_") ||
                        key5.getText().toString().equals("_") || key6.getText().toString().equals("_")
                ) {
                    clickCount = clickCount + 1;
                } else{
                    winMethod();}
                hintKey.setText("");
            }
        });

    }
    //if showing answer is mazda goes to carFerrari method
    private void carMazda() {
        key1.setText("");                                 // removing _ for design
        key7.setText("");

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (clickCount == 2) {
                    loseMethod();                   //if all 3 chances left and all are wrong here show the answer and calling losemethod

                    key2.setText("M");
                    key3.setText("A");
                    key4.setText("Z");
                    key5.setText("D");
                    key6.setText("A");

                    return;
                }
                //if car is Mazda, checking userinputs right or wrong
                //if  its right, place correct letters

                if (hintKey.getText().toString().equals("M")) {
                    key2.setText("M");
                } else if (hintKey.getText().toString().equals("A")) {
                    key3.setText("A");
                    key6.setText("A");
                } else if (hintKey.getText().toString().equals("Z")) {
                    key4.setText("Z");
                } else if (hintKey.getText().toString().equals("D")) {
                    key5.setText("D");
                      //here I check all (key1,key2...) variable not equal to _ its mean ur answer is correct
                } else if ( key2.getText().toString().equals("_") ||
                        key3.getText().toString().equals("_") || key4.getText().toString().equals("_") ||
                        key5.getText().toString().equals("_") || key6.getText().toString().equals("_")
                ) {

                    clickCount = clickCount + 1;
                } else{
                    winMethod();}
                hintKey.setText("");
            }
        });

    }
    //if showing answer is Ford goes to carFerrari method
    private void carFord() {
        key1.setText("");                                         // removing _ for design
        key6.setText("");
        key7.setText("");

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (clickCount == 2) {
                    loseMethod();                   //if all 3 chances left and all are wrong here show the answer and calling losemethod

                    key2.setText("F");
                    key3.setText("O");
                    key4.setText("R");
                    key5.setText("D");


                    return;
                }
                //if car is Ford, checking userinputs right or wrong
                //if  its right, place correct letters

                if (hintKey.getText().toString().equals("F")) {
                    key2.setText("F");
                } else if (hintKey.getText().toString().equals("O")) {
                    key3.setText("O");
                } else if (hintKey.getText().toString().equals("R")) {
                    key4.setText("R");
                } else if (hintKey.getText().toString().equals("D")) {
                    key5.setText("D");
                    //here I check all (key1,key2...) variable not equal to _ its mean ur answer is correct
                } else if ( key2.getText().toString().equals("_") ||
                        key3.getText().toString().equals("_") || key4.getText().toString().equals("_") ||
                        key5.getText().toString().equals("_")) {
                    clickCount = clickCount + 1;
                } else{
                    winMethod();}
                hintKey.setText("");
            }
        });


    }


    //if showing answer is ferrari goes to carFerrari method
    private void carFerrari() {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (clickCount == 2) {
                    loseMethod();                   //if all 3 chances left and all are wrong here show the answer
                    key1.setText("F");
                    key2.setText("E");
                    key3.setText("R");
                    key4.setText("R");
                    key5.setText("A");
                    key6.setText("R");
                    key7.setText("I");
                    return;
                }
                if (hintKey.getText().toString().equals("F")) {                           //if car is ferrari, checking userinputs right or wrong
                    //if right place correct letters
                    key1.setText("F");
                } else if (hintKey.getText().toString().equals("E")) {
                    key2.setText("E");
                } else if (hintKey.getText().toString().equals("R")) {
                    key3.setText("R");
                    key4.setText("R");
                    key6.setText("R");
                } else if (hintKey.getText().toString().equals("A")) {
                    key5.setText("A");
                } else if (hintKey.getText().toString().equals("I")) {
                    key7.setText("I");                                                                      //here I check all (key1,key2...) variable not equal to _ its mean ur answer is correct
                } else if (key1.getText().toString().equals("_") || key2.getText().toString().equals("_") ||
                        key3.getText().toString().equals("_") || key4.getText().toString().equals("_") ||
                        key5.getText().toString().equals("_") || key6.getText().toString().equals("_") ||
                        key7.getText().toString().equals("_")) {
                    clickCount = clickCount + 1;
                } else{
                    winMethod();}
                hintKey.setText("");
            }
        });

    }


    //creating random number and adding a image to the imageView from photoArray according to the random number
    public void showRandom(){
        Random r = new Random();
         i = r.nextInt(35 - 0) + 0;
        imageView.setImageResource(photoArray[i].getImage());
    }

    private void loseMethod() {
                                                       //losing layout
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
            nextQustion();


    }
        private void winMethod() {                                      //winning layout
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
            nextQustion();
        }

        private void nextQustion(){
            button.setText("Next");                                                 //second click action for next model identify
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent t =new Intent(Hints.this,Hints.class);
                    startActivity(t);
                    finish();



                }
            });

        }
}