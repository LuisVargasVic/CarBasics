package com.venkonenterprise.carbasics.Main;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;
import com.venkonenterprise.carbasics.Detail.DetailBasic;
import com.venkonenterprise.carbasics.Detail.DetailBrand;
import com.venkonenterprise.carbasics.Detail.DetailModel;
import com.venkonenterprise.carbasics.R;

public class SpecificActivity extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener {

    public static final String API_KEY = "AIzaSyCGQMKGrIQGSlIQ5Pf0u51l1sgEXE_UYE4";
    private ImageView brandImage;
    private TextView modelText;
    private TextView basicText;
    private TextView tutorialText;
    private DetailBrand brand;
    private DetailModel model;
    private DetailBasic basic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_specific);
        brand = (DetailBrand) getIntent().getSerializableExtra("brand");
        model = (DetailModel) getIntent().getSerializableExtra("model");
        basic = (DetailBasic) getIntent().getSerializableExtra("basic");

        brandImage = findViewById(R.id.image_brand_specific);
        Glide.with(this)
                .load(brand.getImageBrand())
                .into(brandImage);
        modelText = findViewById(R.id.model_text_specific);
        modelText.setText(model.getName());
        basicText = findViewById(R.id.basic_text_specific);
        basicText.setText(basic.getName());
        tutorialText = findViewById(R.id.tutorial_text);
        tutorialText.setText(basic.getTutorial());

        /** Initializing YouTube Player View **/
        YouTubePlayerView youTubePlayerView = (YouTubePlayerView) findViewById(R.id.youtube_player);
        youTubePlayerView.initialize(API_KEY, this);
    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
        /** add listeners to YouTubePlayer instance **/
        youTubePlayer.setPlayerStateChangeListener(playerStateChangeListener);
        youTubePlayer.setPlaybackEventListener(playbackEventListener);
        String video = basic.getVideo();
        /** Start buffering **/
        if (!b) {

            youTubePlayer.cueVideo(video);
        }
    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
        Toast.makeText(this, "Failured to Initialize!", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
    private YouTubePlayer.PlaybackEventListener playbackEventListener = new YouTubePlayer.PlaybackEventListener() {
        @Override
        public void onBuffering(boolean arg0) {
        }
        @Override
        public void onPaused() {
        }
        @Override
        public void onPlaying() {
        }
        @Override
        public void onSeekTo(int arg0) {
        }
        @Override
        public void onStopped() {
        }
    };
    private YouTubePlayer.PlayerStateChangeListener playerStateChangeListener = new YouTubePlayer.PlayerStateChangeListener() {
        @Override
        public void onAdStarted() {
        }
        @Override
        public void onError(YouTubePlayer.ErrorReason arg0) {
        }
        @Override
        public void onLoaded(String arg0) {
        }
        @Override
        public void onLoading() {
        }
        @Override
        public void onVideoEnded() {
        }
        @Override
        public void onVideoStarted() {
        }
    };
}
