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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class AdvancedLevel extends MainActivity {
    private ImageView imageView1;
    private ImageView imageView2;
    private ImageView imageView3;
    private TextView textView1;
    private TextView textView2;
    private TextView textView3;
    private Button button;
    private int clickCount;
    Dialog dialog;
    private int marks;
   private TextView textMarks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advanced_level);

        //Initializing the imagesVies,button and textView to XML attributes
        imageView1 = (ImageView) findViewById(R.id.imageViewAdvance1);
        imageView2 = (ImageView) findViewById(R.id.imageViewAdvance2);
        imageView3 = (ImageView) findViewById(R.id.imageViewAdvance3);
        textView1=(TextView)findViewById(R.id.textViewAdvanced1);
        textView2=(TextView)findViewById(R.id.textViewAdvanced2);
        textView3=(TextView)findViewById(R.id.textViewAdvanced3);
        textMarks=(TextView)findViewById(R.id.marks);
        dialog=new Dialog(this);

        button=(Button)findViewById(R.id.buttonAdvance);

        showRandom();

        allCorrect();


    }
    //Repeating 3 times allCorrect method

    public void allCorrect() {
      button.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {                                         //testing what answers are corrects
              clickCount=clickCount+1;
              if(clickCount==3) {                               //if all 3 chances left go to lostMethod method
                  lostMethod();
                  return;
              }


              if (textView1.getText().toString().equals(photoArray[0].getData())) {
                  textView1.setTextColor(Color.GREEN);                                              //here checking answers for 1,2,3 chances

                  textView1.setEnabled(false);
              } else textView1.setTextColor(Color.RED);

              //checking 2 question  answers
              if (textView2.getText().toString().equals(photoArray[1].getData())) {
                  textView2.setTextColor(Color.GREEN);

                  textView2.setEnabled(false);
              } else textView2.setTextColor(Color.RED);
              //checking 3 question  answers

              if (textView3.getText().toString().equals(photoArray[2].getData())) {
                  textView3.setTextColor(Color.GREEN);

                  textView3.setEnabled(false);
              } else textView3.setTextColor(Color.RED);
//here checking the all the answers ara corrects or not if yes,
              if (textView1.getText().toString().equals(photoArray[0].getData()) &&
                      textView2.getText().toString().equals(photoArray[1].getData()) &&
                      textView3.getText().toString().equals(photoArray[2].getData())) {

                  marks=3;                                                  //this means all answers are corrects and marks should be 3 also show the answer here
                  textMarks.setText(String.valueOf(marks));
                  textView1.setTextColor(Color.GREEN);                          //if won set colors green and un editable
                  textView1.setEnabled(false);

                  textView2.setTextColor(Color.GREEN);
                  textView2.setEnabled(false);

                  textView3.setTextColor(Color.GREEN);
                  textView3.setEnabled(false);


                  winLayout();
                  button.setText("Next");
                  button.setOnClickListener(new View.OnClickListener() {
                      @Override
                      //if all correct,goest to next one
                      public void onClick(View v) {
                          Intent t = new Intent(AdvancedLevel.this, AdvancedLevel.class);
                          startActivity(t);
                          finish();
                      }
                  });


              }

          }
      });
    }
    public void lostMethod(){         //atleast one or wrong lost method is running

        if (textView1.getText().toString().equals(photoArray[0].getData())) {
            marks=1;
            textMarks.setText(String.valueOf(marks));
        } else
            textView1.setTextColor(Color.YELLOW);                                         //here I add green color for texts and add  next 3 questions
        textView1.setText(photoArray[0].getData());                                         //checking final answers

        //checking 2 question  answers
        if (textView2.getText().toString().equals(photoArray[1].getData())) {
            marks=marks+1;                                                                  //if answer is correct marks increase by 1 and print the answer of textMarks in textView
            textMarks.setText(String.valueOf(marks));
        } else
            textView2.setTextColor(Color.YELLOW);
        textView2.setText(photoArray[1].getData());
        //checking 3 question  answers

        if (textView3.getText().toString().equals(photoArray[2].getData())) {
            marks=marks+1;
            textMarks.setText(String.valueOf(marks));
        } else
            textView3.setTextColor(Color.YELLOW);
        textView3.setText(photoArray[2].getData());
                                         //showing  last marks
        loseLayout();                                             //after lossing the game show lost message
        button.setText("Next");
        button.setOnClickListener(new View.OnClickListener() {
            @Override                                               //generating new questions
            //if all correct,goest to next one
            public void onClick(View v) {
                Intent t = new Intent(AdvancedLevel.this, AdvancedLevel.class);
                startActivity(t);
                finish();
            }
        });




    }




        //Every time we click the advanced level, show random method run, array will sort, array elements will shuffle
        public void showRandom(){
            Collections.shuffle(Arrays.asList(photoArray));

            //arrray elemnts are shuffled the add 1st three elements to three imageViews
            imageView1.setImageResource(photoArray[0].getImage());
            imageView2.setImageResource(photoArray[1].getImage());
            imageView3.setImageResource(photoArray[2].getImage());
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


}