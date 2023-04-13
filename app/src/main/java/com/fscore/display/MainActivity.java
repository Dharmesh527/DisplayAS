package com.fscore.display;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    public DatabaseReference reff;
    TextView txtTimer,Coach1,Coach2,ts1,ts2,star,win;
    ImageView t11,t12,t13,t21,t22,t23;
    public void onClickTeam1(View v) {
        Intent intent = new Intent(this, Team1.class);
        startActivity(intent);
    }
    public void onClickTeam2(View v) {
        Intent intent = new Intent(this, Team2.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        reff = FirebaseDatabase.getInstance().getReference();
        txtTimer=findViewById(R.id.text_view_countdown);
        Coach1=findViewById(R.id.team1Coach);
        Coach2=findViewById(R.id.team2Coach);
        ts1=findViewById(R.id.team1Score);
        ts2=findViewById(R.id.team2Score);
        star=findViewById(R.id.starPlayer);
        win=findViewById(R.id.winner);
        t11=findViewById(R.id.t1to1);
        t12=findViewById(R.id.t1to2);
        t13=findViewById(R.id.t1to3);
        t21=findViewById(R.id.t2to1);
        t22=findViewById(R.id.t2to2);
        t23=findViewById(R.id.t2to3);
        updateTime();

    }

    private void tout11() {
        reff.child("timeout").child("team1").child("t1").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    if(snapshot.getValue().toString().equals("ON"))
                        t11.setVisibility(View.VISIBLE);
                    else
                        t11.setVisibility(View.INVISIBLE);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
private void tout12() {
        reff.child("timeout").child("team1").child("t2").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    if(snapshot.getValue().toString().equals("ON"))
                        t12.setVisibility(View.VISIBLE);
                    else
                        t12.setVisibility(View.INVISIBLE);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
public void tout13() {
        reff.child("timeout").child("team1").child("t3").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    if(snapshot.getValue().toString().equals("ON"))
                        t13.setVisibility(View.VISIBLE);
                    else
                        t13.setVisibility(View.INVISIBLE);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
public void tout21() {
        reff.child("timeout").child("team2").child("t1").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    if(snapshot.getValue().toString().equals("ON"))
                        t21.setVisibility(View.VISIBLE);
                    else
                        t21.setVisibility(View.INVISIBLE);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
public void tout22() {
        reff.child("timeout").child("team2").child("t2").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    if(snapshot.getValue().toString().equals("ON"))
                        t22.setVisibility(View.VISIBLE);
                    else
                        t22.setVisibility(View.INVISIBLE);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
public void tout23() {
        reff.child("timeout").child("team2").child("t3").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    if(snapshot.getValue().toString().equals("ON"))
                        t23.setVisibility(View.VISIBLE);
                    else
                        t23.setVisibility(View.INVISIBLE);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void upDateCoach1() {
        reff.child("coach").child("coach1").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    Coach1.setText(snapshot.getValue().toString()) ;
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    private void updatets1() {
        reff.child("score").child("team1").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    ts1.setText(snapshot.getValue().toString());
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    private void updatets2() {
        reff.child("score").child("team2").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    ts2.setText(snapshot.getValue().toString());
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    private void upDateCoach2() {
        reff.child("coach").child("coach2").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    Coach2.setText(snapshot.getValue().toString());
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    public void winDetais(){
        reff.child("coach").child("star").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    star.setText(snapshot.getValue().toString());
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    public void winDetai(){
        reff.child("coach").child("winner").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    win.setText(snapshot.getValue().toString());
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    public void updateTime(){
        reff.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot timer : snapshot.getChildren()) {
                    Timer t = new Timer();
                    t.setTime(String.valueOf(timer.getValue()));
                    txtTimer.setText(t.getTime());

                    upDateCoach1();
                    upDateCoach2();
                    updatets1();
                    updatets2();
                    winDetais();
                    winDetai();
                    tout11();
                    tout12();
                    tout13();
                    tout21();
                    tout22();
                    tout23();
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(MainActivity.this, "Connection Error", Toast.LENGTH_SHORT).show();
            }
        });

    }

}