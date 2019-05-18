package im.juneau.discretemathformulas;

import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;

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
        Log.i("recieved eqList Size: ", Integer.toString(eqList.size()));

        // set title
        setTitle(topic);

        // plug adapter
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        RecycleViewAdapter adapter = new RecycleViewAdapter(this, eqList, urlList);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));



        //8dp as px
        int space = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 10,
                getResources().getDisplayMetrics()); // calculated
        //int space = getResources().getDimensionPixelSize(
        //    R.dimen.list_item_padding_vertical); // from resources
        recyclerView.addItemDecoration(new SpacesItemDecoration(space));

    }



    private class SpacesItemDecoration extends RecyclerView.ItemDecoration {
        private int space;

        public SpacesItemDecoration(int space) {
            this.space = space;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            int position = parent.getChildAdapterPosition(view);
            boolean isLast = position == state.getItemCount()-1;
            if(isLast){
                outRect.bottom = space;
                outRect.top = 0; //don't forget about recycling...
            }
            if(position == 0){
                outRect.top = space;
                // don't recycle bottom if first item is also last
                // should keep bottom padding set above
                if(!isLast)
                    outRect.bottom = 0;
            }
        }
    }
}


