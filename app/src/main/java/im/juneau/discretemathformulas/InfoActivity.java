package im.juneau.discretemathformulas;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.util.Linkify;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.github.chrisbanes.photoview.PhotoView;

public class InfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        setTitle("About Discrete Math Formulas");

        ImageView khanImageView = findViewById(R.id.khanImageView);
        khanImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLink("https://www.khanacademy.org/math/statistics-probability");
            }
        });

        final TextView emailTextView = findViewById(R.id.emailTextView);
        emailTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendEmail();
            }
        });

        ImageView mailImageView = findViewById(R.id.mailImageView);
        mailImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendEmail();
                emailTextView.setVisibility(View.VISIBLE);
            }
        });

        ImageView linkedinImageView = findViewById(R.id.linkedinImageView);
        linkedinImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLink("https://www.linkedin.com/in/jungwon-lim/");
            }
        });

        ImageView mohawkImageView = findViewById(R.id.mohawkImageView);
        mohawkImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLink("https://www.mohawkcollege.ca/");
            }
        });
    }

    public void openLink(String url) {
        Uri uriUrl = Uri.parse(url);
        Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
        startActivity(launchBrowser);
    }

    public void sendEmail() {
        // retrieved from https://medium.com/@cketti/android-sending-email-using-intents-3da63662c58f
        String mailto = "mailto:jungwon.limm@gmail.com" +
                "&subject=" + Uri.encode("Inquiry about Discrete Math Formulas.");

        Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
        emailIntent.setData(Uri.parse(mailto));

        try {
            startActivity(emailIntent);
        } catch (ActivityNotFoundException e) {
            Toast.makeText(InfoActivity.this, "No mail app availible.", Toast.LENGTH_LONG);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.infoButton) {
            Intent intent = new Intent(getApplicationContext(), InfoActivity.class);
            startActivity(intent);
        } else if (item.getItemId() == R.id.ztableMenu) {

            // retrieved from https://www.codingdemos.com/pinch-to-zoom-android-imageview-tutorial/
            AlertDialog.Builder mBuilder = new AlertDialog.Builder(InfoActivity.this);
            View mView = getLayoutInflater().inflate(R.layout.dialog_custom_layout, null);
            PhotoView photoView = mView.findViewById(R.id.imageView);
            photoView.setImageResource(R.drawable.ztable);
            mBuilder.setView(mView);
            AlertDialog mDialog = mBuilder.create();
            mDialog.show();

        } else if (item.getItemId() == R.id.ttableMenu) {

            AlertDialog.Builder mBuilder = new AlertDialog.Builder(InfoActivity.this);
            View mView = getLayoutInflater().inflate(R.layout.dialog_custom_layout, null);
            PhotoView photoView = mView.findViewById(R.id.imageView);
            photoView.setImageResource(R.drawable.ttable);
            mBuilder.setView(mView);
            AlertDialog mDialog = mBuilder.create();
            mDialog.show();

        }
        return super.onOptionsItemSelected(item);
    }
}
