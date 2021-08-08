package uk.ac.westminster.mobilecw;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class IdentifyTheCarMake extends MainActivity implements AdapterView.OnItemSelectedListener {
private ImageView imageView;
private Button button;
public int i;
private Spinner sp;
public String text;
Dialog dialog;
private TextView correctAns;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_identify_the_car_make);

        //identify the imageview and button to xml imageView and button
        imageView=(ImageView)findViewById(R.id.imageView);
        button=(Button)findViewById(R.id.identifyCarMake);
        correctAns=(TextView)findViewById(R.id.textViewAnswer);
        dialog=new Dialog(this);


        showRandom();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {                                       //showing results using a msg


                if (text.equals(photoArray[i].getData())) {
                    winLayout();
                    button.setText("Next");
                   button.setOnClickListener(new View.OnClickListener() {       //second click action for next model identify
                       @Override
                       public void onClick(View v) {
                           Intent t =new Intent(IdentifyTheCarMake.this,IdentifyTheCarMake.class);
                           startActivity(t);
                           finish();

                       }
                   });

                }else {
                    correctAns.setText(photoArray[i].getData());
                    loseLayout();
                    button.setText("Next");                                                 //second click action for next model identify
                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent t =new Intent(IdentifyTheCarMake.this,IdentifyTheCarMake.class);
                            startActivity(t);
                            finish();



                        }
                    });
                }
            }
        });

//creating dropdown list for sppinnerMake array

        Spinner spinner=findViewById(R.id.spinnerMake);
        ArrayAdapter<CharSequence> adapter= ArrayAdapter.createFromResource(this,R.array.brands, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
         text=parent.getItemAtPosition(position).toString();          //getting sppinner value to text var


    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
    //generating a random number
    //showing results in image view
    public void showRandom(){
        Random r = new Random();
        i = r.nextInt(35 - 0) + 0;
        imageView.setImageResource(photoArray[i].getImage());
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



//    //shuffeling objects in array
//    public void shufflePhotos(){
//        Collections.shuffle(Arrays.asList(photoArray));
//    }

}