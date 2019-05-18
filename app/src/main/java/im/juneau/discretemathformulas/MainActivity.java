package im.juneau.discretemathformulas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
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
        ArrayList numthEqList = new ArrayList<>(Arrays.asList("<b>Divisibility rule for 2</b><br>&emsp;All even numbers.",
                                                              "<b>Divisibility rule for 3</b><br>&emsp;The sum of its digit is divisible by 3.",
                                                              "<b>Divisibility rule for 4</b><br>&emsp;The last two digits form a number divisible by 4.",
                                                              "<b>Divisibility rule for 5</b><br>&emsp;Finishes at 0 or 5.",
                                                              "<b>Divisibility rule for 6</b><br>&emsp;Divisible by 2 and 3 at the same time.",
                                                              "<b>Divisibility rule for 7</b><br>&emsp;The last digit doubled and subtracted from the first part of the number n. Repeat the step as necessary.",
                                                              "<b>Divisibility rule for 8</b><br>&emsp;The last three digits from a number divisible by 8.",
                                                              "<b>Divisibility rule for 9</b><br>&emsp;The sum of its digits is divisible by 9.",
                                                              "<b>Divisibility rule for 10</b><br>&emsp;The number finishes at 0.",
                                                              "<b>Divisibility rule for 11</b><br>&emsp;The alternating sum of its digits is divisible by 11.",
                                                              "$(a-r)\\div=q\\\\" +
                                                                      "\\quad\\enspace a-r=qb\\\\" +
                                                                      "\\qquad\\quad\\, a=qb+r$",
                                                              "If $a\\equiv b\\pmod n$ and $c\\equiv d\\pmod n$ then:<br>" +
                                                                      "$\\quad a+c\\equiv b+d\\enspace\\pmod n\\\\\\\\" +
                                                                      "\\quad a-c\\equiv b-d\\enspace\\pmod n\\\\\\\\" +
                                                                      "\\quad\\enspace a\\cdot c\\equiv b\\cdot d\\enspace\\pmod n$"));
        ArrayList numthUrlList = new ArrayList<>(Arrays.asList("Df9h5t64NlQ",
                                                               "Df9h5t64NlQ",
                                                               "Df9h5t64NlQ",
                                                               "Df9h5t64NlQ",
                                                               "Df9h5t64NlQ",
                                                               "Df9h5t64NlQ",
                                                               "Df9h5t64NlQ",
                                                               "Df9h5t64NlQ",
                                                               "Df9h5t64NlQ",
                                                               "Df9h5t64NlQ",
                                                               "6dZLq77gSGU",
                                                               "aAVR1MhR-bs"));

        ArrayList seqEqList = new ArrayList<>(Arrays.asList("Binet's fomula: $n^{th}$ Fibonacci Number<br>" +
                                                                       "$\\quad f_n={\\big({1+\\sqrt{5} \\over 2}\\big)^n - \\big(-{1+\\sqrt{5} \\over 2}\\big)^{-n} \\over \\sqrt{5}}$",
                                                               "Arithmetic Sequences - General term<br>" +
                                                                       "$\\quad a_n=a_1+(n-1)d$",
                                                               "Arithmetic Sequences - Sum of first n terms<br>" +
                                                                       "$\\quad S_n={n\\over 2}[2a_1+(n-1)d]$",
                                                               "Geometric Sequences: General term<br>" +
                                                                       "$\\quad a_s=a_1\\cdot r^{n-1}$",
                                                               "Geometric Sequences: Sum of first n terms<br>" +
                                                                       "$\\quad S_n=a_1{1-r^n \\over 1-r}$",
                                                               "Sum of all Geometric Infinite Series<br>" +
                                                                       "$\\quad T={a_1 \\over 1-r}$"));
        ArrayList seqUrlList = new ArrayList<>(Arrays.asList("ZiGW6PbB8wA",
                                                               "_cooC3yG_p0",
                                                               "xWHfQGBzgbc",
                                                               "dIGLhLMsy2U",
                                                               "mLew1MkobMQ",
                                                               "b-7kCymoUpg"));

        ArrayList countEqList = new ArrayList<>(Arrays.asList("Tournament Scheduling<br>" +
                                                                        "$\\quad T_{m,r}\\equiv r-m\\pmod N\\\\" +
                                                                        "\\qquad\\quad \\equiv round-team\\pmod N$",
                                                                "When N is odd and $T_{m,r}\\equiv m$<br>" +
                                                                        "$\\quad$ The team is assigned a bye.",
                                                                "When N is even, $\\pmod {N-1}$<br>" +
                                                                        "$\\quad$ and if $T_{m,r}\\equiv m$,<br>" +
                                                                        "$\\qquad$ The team is assigned with N team.",
                                                                "The permutations<br>" +
                                                                        "$\\quad n\\raisebox{0.25em}{P}r={n! \\over (n-r)!}$\n",
                                                                "The combinations<br>" +
                                                                        "$\\quad n\\raisebox{0.25em}{C}r={n! \\over r!(n-r)!}$"));
        ArrayList countUrlList = new ArrayList<>(Arrays.asList("us2nQccKwXQ",
                                                                "us2nQccKwXQ",
                                                                "us2nQccKwXQ",
                                                                "XqQTXW7XfYA",
                                                                "iKy-d5_erhI"));
        ArrayList proEqList = new ArrayList<>(Arrays.asList(""));
        ArrayList proUrlList = new ArrayList<>(Arrays.asList(""));
        ArrayList dataEqList = new ArrayList<>(Arrays.asList(""));
        ArrayList dataUrlList = new ArrayList<>(Arrays.asList(""));
        ArrayList meanEqList = new ArrayList<>(Arrays.asList(""));
        ArrayList meanUrlList = new ArrayList<>(Arrays.asList(""));

        eqMap.put("Number Theory", numthEqList);
        urlMap.put("Number Theory", numthUrlList);
        eqMap.put("Number Patterns and Sequences", seqEqList);
        urlMap.put("Number Patterns and Sequences", seqUrlList);
        eqMap.put("Counting Methods", countEqList);
        urlMap.put("Counting Methods", countUrlList);
        eqMap.put("Probability and Probability Distributions", proEqList);
        urlMap.put("Probability and Probability Distributions", proUrlList);
        eqMap.put("Organizing and Summarizing Data", dataEqList);
        urlMap.put("Organizing and Summarizing Data", dataUrlList);
        eqMap.put("Inference for Means", meanEqList);
        urlMap.put("Inference for Means", meanUrlList);

        // list of topics
        final ArrayList<String> topics = new ArrayList<>();
        topics.addAll(Arrays.asList("Number Theory",
                                    "Number Patterns and Sequences",
                                    "Counting Methods",
                                    "Probability and Probability Distributions",
                                    "Organizing and Summarizing Data",
                                    "Inference for Means"));

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
                Log.i("sent eqList size", Integer.toString(eqMap.get(topicClicked).size()));
                intent.putStringArrayListExtra("eqList", eqMap.get(topicClicked));
                intent.putStringArrayListExtra("urlList", urlMap.get(topicClicked));
//                Log.i("topic sent", topicClicked);
                startActivity(intent);
            }
        });

    }
}
