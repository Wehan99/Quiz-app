package uk.ac.westminster.mobilecw;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void IdentifyTheCarMake(View view){
        Intent intent = new Intent(this, IdentifyTheCarMake.class);
        startActivity(intent);

        //creating a object of the IdentifytheCarMake class and calling the showrandom method
//        IdentifyTheCarMake identifyTheCarMake=new IdentifyTheCarMake();
//        identifyTheCarMake.showRandom();

    }

    public void IdentifyTheCar(View view){
        Intent intent = new Intent(this, IdentifyTheCar.class);
        startActivity(intent);

    }

    public void Hints(View view){
        Intent intent = new Intent(this, Hints.class);
        startActivity(intent);

    }

    public void AdvancedLevel(View view){
        Intent intent = new Intent(this, AdvancedLevel.class);
        startActivity(intent);

    }
//creating 36 objects for photos
    Photos p1=new Photos(R.drawable.ferrari1,"Ferrari");
    Photos p2=new Photos(R.drawable.ferrari2,"Ferrari");
    Photos p3=new Photos(R.drawable.ferrari3,"Ferrari");
    Photos p4=new Photos(R.drawable.ferrari4,"Ferrari");
    Photos p5=new Photos(R.drawable.ferrari5,"Ferrari");
    Photos p6=new Photos(R.drawable.ferrari6,"Ferrari");

    Photos p7=new Photos(R.drawable.ford1,"Ford");
    Photos p8=new Photos(R.drawable.ford2,"Ford");
    Photos p9=new Photos(R.drawable.ford3,"Ford");
    Photos p10=new Photos(R.drawable.ford4,"Ford");
    Photos p11=new Photos(R.drawable.ford5,"Ford");
    Photos p12=new Photos(R.drawable.ford6,"Ford");

    Photos p13=new Photos(R.drawable.mazda1,"Mazda");
    Photos p14=new Photos(R.drawable.mazda2,"Mazda");
    Photos p15=new Photos(R.drawable.mazda3,"Mazda");
    Photos p16=new Photos(R.drawable.mazda4,"Mazda");
    Photos p17=new Photos(R.drawable.mazda5,"Mazda");
    Photos p18=new Photos(R.drawable.mazda6,"Mazda");

    Photos p19=new Photos(R.drawable.volvo1,"Volvo");
    Photos p20=new Photos(R.drawable.volvo2,"Volvo");
    Photos p21=new Photos(R.drawable.volvo3,"Volvo");
    Photos p22=new Photos(R.drawable.volvo4,"Volvo");
    Photos p23=new Photos(R.drawable.volvo5,"Volvo");
    Photos p24=new Photos(R.drawable.volvo6,"Volvo");

    Photos p25=new Photos(R.drawable.honda1,"Honda");
    Photos p26=new Photos(R.drawable.honda2,"Honda");
    Photos p27=new Photos(R.drawable.honda3,"Honda");
    Photos p28=new Photos(R.drawable.honda4,"Honda");
    Photos p29=new Photos(R.drawable.honda5,"Honda");
    Photos p30=new Photos(R.drawable.honda6,"Honda");

    Photos p31=new Photos(R.drawable.toyota1,"Toyota");
    Photos p32=new Photos(R.drawable.toyota2,"Toyota");
    Photos p33=new Photos(R.drawable.toyota3,"Toyota");
    Photos p34=new Photos(R.drawable.toyota4,"Toyota");
    Photos p35=new Photos(R.drawable.toyota5,"Toyota");
    Photos p36=new Photos(R.drawable.toyota6,"Toyota");

    //creating the array
    Photos [] photoArray=new Photos[]{
            p1,p2,p3,p4,p5,p6,p7,p8,p9,p10,p11,p12,p13,p14,p15,p16,p17,p18,p19,p20,
            p21,p22,p23,p24,p25,p26,p27,p28,p29,p30,p31,p32,p33,p34,p35,p36
    };
}