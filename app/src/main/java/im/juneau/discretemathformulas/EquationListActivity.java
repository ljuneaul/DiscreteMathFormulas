package im.juneau.discretemathformulas;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;

public class EquationListActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_equation_list);

        // intent
        Intent intent = new Intent();
        String topic = getIntent().getStringExtra("topic");
        ArrayList<String> eqList = getIntent().getStringArrayListExtra("eqList");
        ArrayList<String> urlList = getIntent().getStringArrayListExtra("urlList");
        Log.i("topic recieved", topic);

        // set title
        setTitle(topic);

        // plug adapter
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        RecycleViewAdapter adapter = new RecycleViewAdapter(this, eqList, urlList);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
