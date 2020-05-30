package com.project.oss6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

import java.util.Random;

public class HomeActivity extends YouTubeBaseActivity {
    private Button btn_Weather;
    Random random;

    {
        random = new Random();
    }

    YouTubePlayerView youtubeView;
    Button button,nextbutton;
    YouTubePlayer.OnInitializedListener listener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        button = (Button) findViewById(R.id.youtubebutton);
        youtubeView = (YouTubePlayerView) findViewById(R.id.youtubeView);
        nextbutton = (Button) findViewById(R.id.nextbutton);

        listener = new YouTubePlayer.OnInitializedListener(){

            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, final YouTubePlayer youTubePlayer, boolean b) {
                youTubePlayer.setPlayerStyle(YouTubePlayer.PlayerStyle.CHROMELESS); //화면 못건드리게
                youTubePlayer.loadPlaylist("PL4fGSI1pDJn6jXS_Tv_N9B8Z0HTRVJE0m",random.nextInt(100),0);//db에 재생목록 아이디와 최대 곡수를 저장시키고 랜덤으로 플레이
                nextbutton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        youTubePlayer.next();
                    }
                });
            }
            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

            }
        };

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                youtubeView.initialize("AIzaSyDKl_NSpIyEdS2WQYp0CDaDCxHCkh_eztM",listener);
            }
        });

        btn_Weather = findViewById(R.id.btn_Weather);
        btn_Weather.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, WeatherActivity.class);
                startActivity(intent);
            }
        });
        // 홈화면
        // 추천목록 띄울예정입니다.
    }
}
