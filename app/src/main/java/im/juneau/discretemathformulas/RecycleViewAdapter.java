package im.juneau.discretemathformulas;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;

import katex.hourglass.in.mathlib.MathView;

public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.ViewHolder> {

    private static final String TAG = "RecyclerViewAdapter";

    private ArrayList<String> eqList, urlList;
    private Context mContext;

    public RecycleViewAdapter(Context mContext, ArrayList<String> eqList, ArrayList<String> urlList) {
        this.mContext = mContext;
        this.eqList = eqList;
        this.urlList = urlList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_recyclerview, viewGroup, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
//        Log.i(TAG, "onBindViewHolder: called");

        viewHolder.mathView.setDisplayText(eqList.get(i));

        viewHolder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Log.i(TAG, "onClick: clicked on: " + i + "th card");
                Toast.makeText(mContext, urlList.get(i), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(mContext.getApplicationContext(), YoutubePlayerActivity.class);
                intent.putExtra("url", urlList.get(i));
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return eqList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        MathView mathView;
        CardView cardView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mathView = itemView.findViewById(R.id.mathView);
            cardView = itemView.findViewById(R.id.cardView);
        }
    }
}
