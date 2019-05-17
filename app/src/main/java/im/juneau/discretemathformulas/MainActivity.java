package im.juneau.discretemathformulas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;

public class MainActivity extends AppCompatActivity {

    LinkedHashMap<String, ArrayList<String>> eqMap = new LinkedHashMap<>();
    LinkedHashMap<String, ArrayList<String>> urlMap = new LinkedHashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Discrete Math Formulas");

        // DB of equations & urls
        ArrayList numthEqList = new ArrayList<>(Arrays.asList("$x=\\frac{1+y}{1+2z^2}$", "Number Theory eq 1", "Number Theory eq 2"));
        ArrayList numthUrlList = new ArrayList<>(Arrays.asList("Number Theory URL 0", "Number Theory URL 1", "W4hTJybfU7s"));
        ArrayList seqEqList = new ArrayList<>(Arrays.asList("$x=\\frac{1+y}{1+2z^2}$", "Sequences eq 1", "Sequences eq 2"));
        ArrayList seqUrlList = new ArrayList<>(Arrays.asList("Sequences URL 0", "Sequences URL 1", "W4hTJybfU7s"));
        ArrayList countEqList = new ArrayList<>(Arrays.asList("$x=\\frac{1+y}{1+2z^2}$", "Counting eq 1", "Counting eq 2"));
        ArrayList countUrlList = new ArrayList<>(Arrays.asList("Counting URL 0", "Counting URL 1", "W4hTJybfU7s"));
        eqMap.put("Number Theory", numthEqList);
        urlMap.put("Number Theory", numthUrlList);
        eqMap.put("Number Patterns and Sequences", numthEqList);
        urlMap.put("Number Patterns and Sequences", numthUrlList);
        eqMap.put("Counting Methods", numthEqList);
        urlMap.put("Counting Methods", numthUrlList);

        // list of topics
        final ArrayList<String> topics = new ArrayList<>();
        topics.addAll(Arrays.asList("Number Theory", "Number Patterns and Sequences", "Counting Methods"));

        // plug list view
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, topics);
        ListView topicsListView = (ListView) findViewById(R.id.topicsListView);
        topicsListView.setAdapter(arrayAdapter);

        // onclick -> intent
        topicsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), EquationListActivity.class);

                // intent
                String topicClicked = topics.get(position);
                intent.putExtra("topic", topicClicked);
                intent.putStringArrayListExtra("eqList", eqMap.get(topicClicked));
                intent.putStringArrayListExtra("urlList", urlMap.get(topicClicked));
//                Log.i("topic sent", topicClicked);
                startActivity(intent);
            }
        });

    }
}
