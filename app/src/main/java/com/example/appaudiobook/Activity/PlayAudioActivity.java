package com.example.appaudiobook.Activity;


import android.content.Intent;
import android.graphics.Color;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import com.example.appaudiobook.Adapter.ViewPagerPlayAudio;
import com.example.appaudiobook.Fragment.Fragment_Play_Danh_Sach_Tacpham;
import com.example.appaudiobook.Model.Truyen;
import com.example.appaudiobook.R;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Random;

public class PlayAudioActivity extends AppCompatActivity {
    Toolbar toolbarplaynhac;
    TextView txttimsong,txttotaltimsong;
    SeekBar sktime;
    ImageButton imgplay,imgnext,imgpre;
    ViewPager viewPagerplaynhac;
    public static ArrayList<Truyen> mangtruyen=new ArrayList<>();
    public static ViewPagerPlayAudio adapteraudio;
   // Fragment_Dia_Mp3 fragment_dia_mp3;
    Fragment_Play_Danh_Sach_Tacpham fragment_play_danh_sach_cac_tac_pham;
    MediaPlayer mediaPlayer;
    int position=0;
    boolean repeat=false;
    boolean checkrandom=false;
    boolean next=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_audio);
        StrictMode.ThreadPolicy policy=new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        getDataFromIntent();
        init();
        evenClick();

    }

   private void evenClick() {

        imgplay.setOnClickListener(new View.OnClickListener() {
           @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View view) {
               if (mediaPlayer.isPlaying()){
                   mediaPlayer.pause();
                   imgplay.setImageResource(R.drawable.iconplay);
//
                }else {
                    mediaPlayer.start();
                    imgplay.setImageResource(R.drawable.iconpause);
//
                }


            }

        });

        sktime.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                mediaPlayer.seekTo(seekBar.getProgress());
            }
        });
        imgnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (mangtruyen.size()>0){
                    if(mediaPlayer.isPlaying()||mediaPlayer!=null){
                        mediaPlayer.stop();
                        mediaPlayer.release();
                        mediaPlayer=null;
                    }
                    if (position<(mangtruyen.size())){
                        imgplay.setImageResource(R.drawable.iconpause);
                        position++;
                        if (repeat==true){
                            if (position==0){
                                position=mangtruyen.size();
                            }
                            position-=1;
                        }
                        if (checkrandom==true){
                            Random random=new Random();
                            int index=random.nextInt(mangtruyen.size());
                            if (index == position){
                                position=index-1;
                            }
                            position=index;
                        }
                        if (position> (mangtruyen.size())){
                            position=0;
                        }
                        new PlayMp3().execute(mangtruyen.get(position).getLinktruyen());
                        getSupportActionBar().setTitle(mangtruyen.get(position).getTentruyen());
                        UpdateTime();
                    }
                }
                imgnext.setClickable(false);
                Handler handler1=new Handler();
                handler1.postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        imgnext.setClickable(true);

                    }
                },5000);
            }
        });
        imgpre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mangtruyen.size()>0){
                    if(mediaPlayer.isPlaying()||mediaPlayer!=null){
                        mediaPlayer.stop();
                        mediaPlayer.release();
                        mediaPlayer=null;
                    }
                    if (position<(mangtruyen.size())){
                        imgplay.setImageResource(R.drawable.iconpause);
                        position--;
                        if (position<0){
                            position=mangtruyen.size()-1;
                        }
                        if (repeat==true){
                            position+=1;
                        }
                        if (checkrandom==true){
                            Random random=new Random();
                            int index=random.nextInt(mangtruyen.size());
                            if (index == position){
                                position=index-1;
                            }
                            position=index;
                        }
                        new PlayMp3().execute(mangtruyen.get(position).getLinktruyen());
                        getSupportActionBar().setTitle(mangtruyen.get(position).getTentruyen());
                        UpdateTime();
                    }
                }
                imgnext.setClickable(false);
                Handler handler1=new Handler();
                handler1.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        imgnext.setClickable(true);

                    }
                },5000);
            }
        });
   }

    private void getDataFromIntent() {
        Intent intent=getIntent();
        mangtruyen.clear();
        if (intent!=null){
            if(intent.hasExtra("audio")){
                Truyen truyen=intent.getParcelableExtra("audio");
                mangtruyen.add(truyen);
                Log.d("BBB",mangtruyen.get(0).getLinktruyen());


            }
            if (intent.hasExtra("cacaudio")){
                ArrayList<Truyen> truyenArrayList=intent.getParcelableArrayListExtra("cacaudio");
                mangtruyen=truyenArrayList;

            }
        }

    }

    private void init() {
        toolbarplaynhac=findViewById(R.id.toolbaramthanh);
        txttimsong=findViewById(R.id.textviewtimeaudio);
        txttotaltimsong=findViewById(R.id.textviewtotaltime);
        sktime=findViewById(R.id.seekbaraudio);
        imgplay=findViewById(R.id.imagebuttomplay);
        imgnext=findViewById(R.id.imagebuttomnext);
        imgpre=findViewById(R.id.imagebuttompre);
        viewPagerplaynhac=findViewById(R.id.viewpageramthanh);
        setSupportActionBar(toolbarplaynhac);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbarplaynhac.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                mediaPlayer.stop();
                mangtruyen.clear();
            }
        });
        toolbarplaynhac.setTitleTextColor(Color.WHITE);

        fragment_play_danh_sach_cac_tac_pham=new Fragment_Play_Danh_Sach_Tacpham();

        adapteraudio=new ViewPagerPlayAudio(getSupportFragmentManager());
        adapteraudio.addFragment(fragment_play_danh_sach_cac_tac_pham);
        viewPagerplaynhac.setAdapter(adapteraudio);



        if (mangtruyen.size()>0){
            getSupportActionBar().setTitle(mangtruyen.get(0).getTentruyen());
            new PlayMp3().execute(mangtruyen.get(0).getLinktruyen());
            imgplay.setImageResource(R.drawable.iconpause);
        }
   }
    @SuppressWarnings("deprecation")
    class PlayMp3 extends AsyncTask<String,Void,String> {

        @Override
        protected String doInBackground(String... strings) {

            return strings[0];
        }



        @Override
        protected void onPostExecute(String truyen) {
            super.onPostExecute(truyen);
            try {
                mediaPlayer =new MediaPlayer();
                mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        mediaPlayer.stop();
                        mediaPlayer.reset();
                    }
                });

               mediaPlayer.setDataSource(truyen);
                mediaPlayer.prepare();
            } catch (IOException e) {
                e.printStackTrace();
            }
            mediaPlayer.start();
            TimeSong();
            UpdateTime();
        }
    }

    private void TimeSong() {
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("mm:ss");
        txttotaltimsong.setText(simpleDateFormat.format(mediaPlayer.getDuration()));
        sktime.setMax(mediaPlayer.getDuration());
    }
    private void UpdateTime(){
        final Handler handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if(mediaPlayer!=null){
                    sktime.setProgress(mediaPlayer.getCurrentPosition());
                    SimpleDateFormat simpleDateFormat=new SimpleDateFormat("mm:ss");
                    txttimsong.setText(simpleDateFormat.format(mediaPlayer.getCurrentPosition()));
                    handler.postDelayed(this,300);
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mediaPlayer) {
                            next=true;
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    });
                }
            }
        },300);
        final Handler handler1=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (next==true){
                    if (position<(mangtruyen.size())){
                        imgplay.setImageResource(R.drawable.iconpause);
                        position++;
                        if (repeat==true){
                            if (position==0){
                                position=mangtruyen.size();
                            }
                            position-=1;
                        }
                        if (checkrandom==true){
                            Random random=new Random();
                            int index=random.nextInt(mangtruyen.size());
                            if (index == position){
                                position=index-1;
                            }
                            position=index;
                        }
                        if (position> (mangtruyen.size())){
                            position=0;
                        }
                        new PlayMp3().execute(mangtruyen.get(position).getLinktruyen());
                        getSupportActionBar().setTitle(mangtruyen.get(position).getTentruyen());
                    }
                    imgnext.setClickable(false);
                    Handler handler1=new Handler();
                    handler1.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            imgnext.setClickable(true);

                        }
                    },5000);
                    next=false;
                    handler1.removeCallbacks(this);

                }else {
                    handler1.postDelayed(this,1000);
                }
            }
        },1000);
    }
}
