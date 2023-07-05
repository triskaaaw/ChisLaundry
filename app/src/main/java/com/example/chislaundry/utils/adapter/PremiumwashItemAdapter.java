package com.example.chislaundry.utils.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.chislaundry.R;
import com.example.chislaundry.utils.model.PremiumwashItem;

import java.util.List;

public class PremiumwashItemAdapter extends RecyclerView.Adapter<PremiumwashItemAdapter.PremiumwashItemViewHolder> {
    private List<PremiumwashItem> premiumwashItemList;
    private PremiumwashClickedListeners premiumwashClickedListeners;
    public PremiumwashItemAdapter(PremiumwashClickedListeners premiumwashClickedListeners){
        this.premiumwashClickedListeners = premiumwashClickedListeners;
    }
    public void setPremiumwashItemList(List<PremiumwashItem> premiumwashItemList){
        this.premiumwashItemList = premiumwashItemList;
    }
    @NonNull
    @Override
    public PremiumwashItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.each_premiumwash,parent, false);
        return new PremiumwashItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PremiumwashItemViewHolder holder, int position) {
        PremiumwashItem premiumwashItem = premiumwashItemList.get(position);
        holder.premiumwashName.setText(premiumwashItem.getPremiumwashName());
        holder.premiumwashPrice.setText(String.valueOf(premiumwashItem.getPremiumwashPrice()));
        holder.premiumwashImageView.setImageResource(premiumwashItem.getPremiumwashImage());

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                premiumwashClickedListeners.onCardClicked(premiumwashItem);
            }
        });
        holder.addToCartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                premiumwashClickedListeners.onAddToCartBtnClicked(premiumwashItem);
            }
        });
    }

    @Override
    public int getItemCount() {
        if(premiumwashItemList==null){
            return 0;
        }else{
            return premiumwashItemList.size();
        }
    }

    public class PremiumwashItemViewHolder extends RecyclerView.ViewHolder{
        private ImageView premiumwashImageView, addToCartBtn;
        private TextView premiumwashName, premiumwashPrice;
        private CardView cardView;
        public PremiumwashItemViewHolder(@NonNull View itemView) {
            super(itemView);
            cardView = itemView.findViewById(R.id.eachPremiumwashCardView);
            addToCartBtn = itemView.findViewById(R.id.eachPremiumwashAddToCartBtn);
            premiumwashName = itemView.findViewById(R.id.eachPremiumwashname);
            premiumwashImageView = itemView.findViewById(R.id.eachPremiumwash);
            premiumwashPrice = itemView.findViewById(R.id.eachPremiumwashPrice);
        }
    }
    public interface PremiumwashClickedListeners{
        void onCardClicked(PremiumwashItem premiumwashItem);
        void onAddToCartBtnClicked(PremiumwashItem premiumwashItem);
    }
}
