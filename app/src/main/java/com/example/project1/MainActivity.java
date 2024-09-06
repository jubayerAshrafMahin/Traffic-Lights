package com.example.project1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    int count=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        String yellow_light_rules = "The yellow light is a warning signal that the green light is about to change. It means \"Prepare to Stop.\" You should slow down and be ready to stop if the light turns red before you can safely proceed. If it is safe to do so, you may cautiously proceed through the intersection, but be prepared to stop if necessary.";
        String red_light_rules = "The red light is the most important traffic signal. It means \"Stop.\" When you see a red light, you must bring your vehicle to a complete stop before the white stop line. Do not proceed until the light turns green.";
        String green_light_rules = "The green light indicates \"Go.\" When the light turns green, you may proceed in the direction indicated by the green arrow. However, you must first yield to any vehicles that are already in the intersection or that have not yet cleared the intersection. You should also be aware of pedestrians and bicyclists who may be crossing the street.";
        TextView lightColor = findViewById(R.id.tv_light_color);
        TextView instruction = findViewById(R.id.tv_instruction);
        TextView rules = findViewById(R.id.traffic_light_rules);
        Button previous = findViewById(R.id.btn_previous);
        Button next = findViewById(R.id.btn_next);
        ImageView trafficLight = findViewById(R.id.iv_traffic_light);

        lightColor.setText("Red");
        instruction.setText("STOP!");
        rules.setText(red_light_rules);

            String light_color = lightColor.getText().toString();

            next.setOnClickListener(v -> {
                if(count<=2) {
                    count++;
                }
                if (count==1) {
                    lightColor.setText("Yellow");
                    instruction.setText("WAIT!");
                    rules.setText(yellow_light_rules);
                    trafficLight.setImageResource(R.drawable.traffic_light_yellow);
                } else if (count==2) {
                    lightColor.setText("Green");
                    instruction.setText("GO!");
                    rules.setText(green_light_rules);
                    trafficLight.setImageResource(R.drawable.traffic_light_green);
                } else if(count==3) {
                    Toast.makeText(MainActivity.this, "No more lights!", Toast.LENGTH_SHORT).show();
                    count--;
                }
            });

            previous.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(count>=0){
                        count--;
                    }
                    if (count==0) {
                        lightColor.setText("Red");
                        instruction.setText("STOP!");
                        rules.setText(red_light_rules);
                        trafficLight.setImageResource(R.drawable.traffic_light_red);
                    }
                    else if (count==1) {
                        lightColor.setText("Yellow");
                        instruction.setText("WAIT!");
                        rules.setText(yellow_light_rules);
                        trafficLight.setImageResource(R.drawable.traffic_light_yellow);
                    } else if(count==-1) {
                        Toast.makeText(MainActivity.this, "No more lights!", Toast.LENGTH_SHORT).show();
                        count++;
                    }
                }



            });



    }
}