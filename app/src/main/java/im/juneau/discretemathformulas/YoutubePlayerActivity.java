package im.juneau.discretemathformulas;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class YoutubePlayerActivity extends YouTubeBaseActivity {

    private static final String TAG = "MainActivity";

    YouTubePlayerView youTubePlayerView;
    Button playButton;
    YouTubePlayer.OnInitializedListener onInitializedListener;
    Button ytTosButton;
    Button playerToS;
    AlertDialog.Builder alertBuilder;
    DialogInterface.OnClickListener dialogListener;
    Intent intent;
    String videoId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_youtube_player);
        Log.i(TAG, "onCreate: Starting");

        youTubePlayerView = (YouTubePlayerView)findViewById(R.id.youtubePlayerView);
        playButton = findViewById(R.id.playButton);
        ytTosButton = findViewById(R.id.ytTosButton);
        playerToS = findViewById(R.id.playerToS);
        intent = new Intent();
        videoId = getIntent().getStringExtra("url");

        onInitializedListener = new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                Log.i(TAG, "Done intializing");

                Intent intent = new Intent();
                videoId = getIntent().getStringExtra("url");
                youTubePlayer.loadVideo(videoId);
                Log.i(TAG, "url: " + videoId);
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
                Log.i(TAG, "Failed to intialize");
                Toast.makeText(YoutubePlayerActivity.this, "Unable to load Video. Please try later.", Toast.LENGTH_LONG).show();
            }
        };

        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playButton.setVisibility(View.GONE);
                ytTosButton.setVisibility(View.GONE);
                playerToS.setVisibility(View.GONE);
                Log.i(TAG, "Intializing YouTube Player");
                youTubePlayerView.initialize(YouTubeConfig.getApiKey(), onInitializedListener);
            }
        });

        ytTosButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("https://www.youtube.com/t/terms"));
                startActivity(intent);
            }
        });

        playerToS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView tv = new TextView(youTubePlayerView.getContext());
                tv.setMovementMethod(LinkMovementMethod.getInstance());
                tv.setText(Html.fromHtml(playerTouText));
                alertBuilder = new AlertDialog.Builder(YoutubePlayerActivity.this);
                alertBuilder.setTitle("Player Terms of Usage")
                        .setView(tv)
                        .setPositiveButton("Agree", dialogListener)
                        .setNegativeButton("Disagree", dialogListener).show();
            }
        });

        dialogListener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which){
                    case DialogInterface.BUTTON_POSITIVE:
                        //Yes button clicked
                        dialog.dismiss();
                        break;

                    case DialogInterface.BUTTON_NEGATIVE:
                        //No button clicked
                        dialog.dismiss();
                        intent.setAction(Intent.ACTION_VIEW);
                        intent.addCategory(Intent.CATEGORY_BROWSABLE);
                        intent.setData(Uri.parse("https://www.youtube.com/watch?v=" + videoId));
                        startActivity(intent);
                        YoutubePlayerActivity.this.finish();
                        break;
                }
            }
        };

        TextView tv = new TextView(this);
        tv.setMovementMethod(LinkMovementMethod.getInstance());
        tv.setText(Html.fromHtml(playerTouText));
        alertBuilder = new AlertDialog.Builder(YoutubePlayerActivity.this);
        alertBuilder.setTitle("Player Privacy Policy")
                .setView(tv)
                .setPositiveButton("Agree", dialogListener)
                .setNegativeButton("Disagree", dialogListener).show();
    }

    String playerTouText = "1. This player is using YouTube API Service. By using this player, you are agreeing to be bound by the <a href='https://www.youtube.com/t/terms'>YouTube Terms of Service</a>.<br>" +
            "2. For the Google Privacy Policy, please refer to " +
            "<a href='http://www.google.com/policies/privacy'>http://www.google.com/policies/privacy</a>.<br>" +
            "3. This application is not storing any user information or data usage. However, Youtube might.<br>" +
            "4. No information or data is being shared with external parties except YouTube.<br>" +
            "5. No third party other than YouTube is allowed to access the content including advertisements.<br>" +
            "6. No data or usage is collected or stored by using this player.";
}
