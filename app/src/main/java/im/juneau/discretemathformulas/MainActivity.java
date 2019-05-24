package im.juneau.discretemathformulas;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.github.chrisbanes.photoview.PhotoView;

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
        ArrayList numthEqList = new ArrayList<>(Arrays.asList("<b>Divisibility rule for 2</b><br>" +
                                                                      "&emsp;All even numbers.",
                                                              "<b>Divisibility rule for 3</b><br>" +
                                                                      "&emsp;The sum of its digit is divisible by 3.",
                                                              "<b>Divisibility rule for 4</b><br>" +
                                                                      "&emsp;The last two digits form a number divisible by 4.",
                                                              "<b>Divisibility rule for 5</b><br>" +
                                                                      "&emsp;Finishes at 0 or 5.",
                                                              "<b>Divisibility rule for 6</b><br>" +
                                                                      "&emsp;Divisible by 2 and 3 at the same time.",
                                                              "<b>Divisibility rule for 7</b><br>" +
                                                                      "&emsp;The last digit doubled and subtracted from the first part of the number n. Repeat the step as necessary.",
                                                              "<b>Divisibility rule for 8</b><br>" +
                                                                      "&emsp;The last three digits from a number divisible by 8.",
                                                              "<b>Divisibility rule for 9</b><br>" +
                                                                      "&emsp;The sum of its digits is divisible by 9.",
                                                              "<b>Divisibility rule for 10</b><br>" +
                                                                      "&emsp;The number finishes at 0.",
                                                              "<b>Divisibility rule for 11</b><br>" +
                                                                      "&emsp;The alternating sum of its digits is divisible by 11.",
                                                              "$\\begin{aligned}" +
                                                                      "(a-r)\\div b&=q\\\\" +
                                                                      "a-r&=qb\\\\a&=qb+r" +
                                                                      "\\end{aligned}$",
                                                              "If $a\\equiv b\\pmod n$ and $c\\equiv d\\pmod n$ then:<br>" +
                                                                      "$\\begin{aligned}" +
                                                                      "\\quad a+c&\\equiv b+d\\pmod n\\\\\\\\" +
                                                                      "\\quad a-c&\\equiv b-d\\pmod n\\\\\\\\" +
                                                                      "\\quad a\\cdot c&\\equiv b\\cdot d\\pmod n" +
                                                                      "\\end{aligned}$",
                                                              "<b>Airline Tickets</b>:<br>" +
                                                                      "&emsp;main part $\\equiv$ check digit$\\pmod 7$",
                                                              "<b>SIN</b>: Double the even position digits and add their digits, sum the rest of the digits<br>" +
                                                                      "&emsp;-sum $\\equiv$ check digit$\\pmod {10}$",
                                                              "<b>UPC</b>:<br>" +
                                                                      "&emsp;check digit $\\equiv -(3a_{11}+a_{10}+3a_9+a_8+3a_7+a_6+3a_5+a_4+3a_3+a_2+3a_1)\\pmod {10}$",
                                                              "<b>ISBN</b>:<br>" +
                                                                      "&emsp;check digit $\\equiv a_9+2a_8+3a_7+4a_6+6a_4+7a_3+8a_2+9a_1\\pmod {11}$"));
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
                                                               "aAVR1MhR-bs",
                                                               "JZp88Nbhki0",
                                                               "wDcgUsh1Zks",
                                                               "lCFI-kRWOOw",
                                                               "5qcrDnJg-98"));

        ArrayList seqEqList = new ArrayList<>(Arrays.asList("Binet's fomula: $n^{th}$ Fibonacci Number<br>" +
                                                                       "$\\quad f_n={\\big({1+\\sqrt{5} \\over 2}\\big)^n - \\big(-{1+\\sqrt{5} \\over 2}\\big)^{-n} \\over \\sqrt{5}}$",
                                                               "Arithmetic Sequences - General term<br>" +
                                                                       "$\\quad a_n=a_1+(n-1)d$",
                                                               "Arithmetic Sequences - Sum of first n terms<br>" +
                                                                       "$\\quad S_n={n\\over 2}[2a_1+(n-1)d]$",
                                                               "Geometric Sequences: General term<br>" +
                                                                       "$\\quad a_s=a_1\\cdot r^{n-1}$",
                                                               "Geometric Sequences: Sum of first n terms<br>" +
                                                                       "$\\quad S_n=a_1\\cdot {1-r^n \\over 1-r}$",
                                                               "Sum of all Geometric Infinite Series<br>" +
                                                                       "$\\quad T={a_1 \\over 1-r}$"));
        ArrayList seqUrlList = new ArrayList<>(Arrays.asList("ZiGW6PbB8wA",
                                                               "_cooC3yG_p0",
                                                               "xWHfQGBzgbc",
                                                               "dIGLhLMsy2U",
                                                               "mLew1MkobMQ",
                                                               "b-7kCymoUpg"));

        ArrayList countEqList = new ArrayList<>(Arrays.asList("Tournament Scheduling<br>" +
                                                                        "$\\begin{aligned}" +
                                                                        "\\quad T_{m,r}&\\equiv r-m\\pmod N\\\\" +
                                                                        "&\\equiv round-team\\pmod N" +
                                                                        "\\end{aligned}$",
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

        ArrayList proEqList = new ArrayList<>(Arrays.asList("The probability of an event<br>" +
                                                                    "$\\quad P(A) = {\\#\\,of\\,outcomes\\,in\\,A \\over \\#\\,of\\,all\\,possible\\,outcomes}$\n",
                                                            "The General Additional Rule<br>" +
                                                                    "$\\quad P(A\\lor B)\\\\" +
                                                                    "\\qquad=P(A)+P(B)-P(A\\land B)$",
                                                            "The Conditional Probability<br>" +
                                                                    "$\\quad P(B\\mid A)={P(A\\land B) \\over P(A)}$",
                                                            "The Binomial Distribution Model<br>" +
                                                                    "$\\quad P(X=x)=n\\raisebox{0.25em}{C}x\\cdot p^x\\cdot q^{n-x}$"));
        ArrayList proUrlList = new ArrayList<>(Arrays.asList("fw-dGViD8w4",
                                                            "jDnU3-jX4GA",
                                                            "H02B3aMNKzE",
                                                            "WWv0RUxDfbs"));

        ArrayList dataEqList = new ArrayList<>(Arrays.asList("The mean: $\\bar{x}={{\\Sigma x_i} \\over n}$",
                                                            "The median($Q_2$):<br>" +
                                                                    "$\\quad odd)({{n+1} \\over 2})_{th}\\quad even){{({n \\over 2})_{th}+({n \\over  2}+1)_{th}  } \\over 2}$",
                                                            "The mode: the most frequent value",
                                                            "Measure of Position from persentiles of data:<br>" +
                                                                    "$\\quad P_n=(int)(\\% \\cdot n)+1$",
                                                            "$\\begin{aligned}" +
                                                                    "Q_1=odd)&({{n+1}\\over 4})_{th}\\\\" +
                                                                    "even)&(A+0.25\\cdot (B-A))_{th}" +
                                                                    "\\end{aligned}$",
                                                            "$\\begin{aligned}" +
                                                                    "Q_3=odd)&({3({n+1})\\over 4})_{th}\\\\" +
                                                                    "even)&(C+0.75\\cdot (D-C))_{th}" +
                                                                    "\\end{aligned}$",
                                                            "$IQR=Q_3-Q_1=75\\%_{th}-25\\%_{th}$",
                                                            "$Outliers < Q_1-0.25\\cdot IQR\\\\" +
                                                                    "\\qquad\\lor Q_3+0.75\\cdot IQR < Outliers$",
                                                            "The standard deviation: $s=\\sqrt{\\Sigma(x-\\bar{x})^2 \\over{n-1}}$",
                                                            "The Coefficient of Variation: $V={s\\over{\\bar{x}}}\\cdot 100\\%$",
                                                            "Skewness of a Distribution: $SK={{3(\\bar{x}-Q_2)}\\over s}$",
                                                            "Measures of Position: $z={{x-\\bar{x}}\\over s}$",
                                                            "Describing a distribution:<br>" +
                                                                    "$\\quad\\def\\arraystretch{1.5}\n" +
                                                                    "   \\begin{array}{c|c:c}\n" +
                                                                    "   shape & Symmetric & skewed \\\\ \\hline\n" +
                                                                    "   centre & \\bar{x} & Q_2 \\\\\n" +
                                                                    "   \\hdashline\n" +
                                                                    "   spread & s & IQR\n" +
                                                                    "\\end{array}$",
                                                            "Empirical Rule(68-95-99.2)$\\quad s={{range} \\over 6}$"));
        ArrayList dataUrlList = new ArrayList<>(Arrays.asList("h8EYEJ32oQ8",    // 3m
                                                            "h8EYEJ32oQ8",
                                                            "h8EYEJ32oQ8",
                                                            "Snf6Wpn-L4c",  // Measure of Position from persentiles of data
                                                            "K3wsOqIqA6k",  // q & IQR
                                                            "K3wsOqIqA6k",
                                                            "K3wsOqIqA6k",
                                                            "FRlTh5HQORA",  // $Outliers
                                                            "HvDqbzu0i0E",  // sd
                                                            "4BCVcIyEY5k",  // Coefficient
                                                            "JFesFhraX2M",  // skew
                                                            "E4HAYd0QnRc",  // spread
                                                            "2oJldeE4JcU",  // shapes
                                                            "OhRr26AfFBU"));

        ArrayList meanEqList = new ArrayList<>(Arrays.asList("Binomial Distribution:<br>" +
                        "$\\quad \\mu_x=np\\\\" +
                        "\\quad \\sigma_x=\\sqrt{npq}$",
                "Sampling Distribution Model:<br>" +
                        "$\\quad SD(\\bar y)={\\sigma \\over {\\sqrt n}}\\\\" +
                        "\\quad z_y={\\bar y-\\mu \\over s}\\\\" +
                        "\\quad SE(\\bar y)={s \\over {\\sqrt n}}$",
                "Degrees of freedom: $df=n-1$",
                "The standardized sample’s critical value:<br>" +
                        "$\\quad t={{\\bar y -\\mu} \\over {SE(\\bar y)}}$",
                "Margin of Error: $ME=t_{n-1}^*\\cdot {s\\over {\\sqrt n}}$",
                "Minimum sample size: $n=({{t_\\infty^* \\cdot s}\\over {ME}})^2$",
                "The confidence interval:<br>" +
                        "$\\quad CI=\\bar y \\pm t_{n-1}^*\\cdot SE(\\bar y)$"));
        ArrayList meanUrlList = new ArrayList<>(Arrays.asList("SqcxYnNlI3Y",
                "FXZ2O1Lv-KE",
                "VIlVWeUQ0vs",
                "lccjSiVTx7c",
                "OwPSuHXmiPw",
                "DyBMjhWGLoo",
                "hlM7zdf7zwU"));

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
            AlertDialog.Builder mBuilder = new AlertDialog.Builder(MainActivity.this);
            View mView = getLayoutInflater().inflate(R.layout.dialog_custom_layout, null);
            PhotoView photoView = mView.findViewById(R.id.imageView);
            photoView.setImageResource(R.drawable.ztable);
            mBuilder.setView(mView);
            AlertDialog mDialog = mBuilder.create();
            mDialog.show();

        } else if (item.getItemId() == R.id.ttableMenu) {

            AlertDialog.Builder mBuilder = new AlertDialog.Builder(MainActivity.this);
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
