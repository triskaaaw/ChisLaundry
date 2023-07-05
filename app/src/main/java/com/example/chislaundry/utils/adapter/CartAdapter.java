package com.example.chislaundry.utils.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.chislaundry.R;
import com.example.chislaundry.utils.model.PremiumwashCart;

import java.util.List;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.CartViewHodler> {
    private CartClickedListeners cartClickedListeners;
    private List<PremiumwashCart> premiumwashCartList;

    public CartAdapter(CartClickedListeners cartClickedListeners){
        this.cartClickedListeners = cartClickedListeners;
    }
    public void setPremiumwashCartList(List<PremiumwashCart> premiumwashCartList) {
        this.premiumwashCartList = premiumwashCartList;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public CartViewHodler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.each_cart_item, parent, false);
        return new CartViewHodler(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CartViewHodler holder, int position) {
        PremiumwashCart premiumwashCart = premiumwashCartList.get(position);
        holder.premiumwashImageView.setImageResource(premiumwashCart.getPremiumwashImage());
        holder.premiumwashName.setText(premiumwashCart.getPremiumwashName());
        holder.premiumwashQuantity.setText(premiumwashCart.getQuantity() + "");
        holder.premiumwashPrice.setText(premiumwashCart.getTotalItemPrice() + "");

        holder.deletePremiumwashBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cartClickedListeners.onDeleteClicked(premiumwashCart);
            }
        });

        holder.addQuantityBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cartClickedListeners.onPlusClicked(premiumwashCart);
            }
        });

        holder.minusQuantityBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cartClickedListeners.onMinusClicked(premiumwashCart);
            }
        });
    }

    @Override
    public int getItemCount() {
        if(premiumwashCartList == null){
            return 0;
        }else{
            return premiumwashCartList.size();
        }
    }

    public class CartViewHodler extends RecyclerView.ViewHolder{

        private TextView premiumwashName, premiumwashPrice, premiumwashQuantity;
        private ImageView deletePremiumwashBtn;
        private ImageView premiumwashImageView;
        private ImageButton addQuantityBtn, minusQuantityBtn;

        public CartViewHodler(@NonNull View itemView){
            super(itemView);

            premiumwashName = itemView.findViewById(R.id.eachCartItemName);
            premiumwashPrice = itemView.findViewById(R.id.eachCartItemPriceTv);
            deletePremiumwashBtn = itemView.findViewById(R.id.eachCartItemDeleteBtn);
            premiumwashImageView= itemView.findViewById(R.id.eachCartItemIV);
            premiumwashQuantity = itemView.findViewById(R.id.eachCartItemQuantityTV);
            addQuantityBtn = itemView.findViewById(R.id.eachCartItemAddQuantityBtn);
            minusQuantityBtn = itemView.findViewById(R.id.eachCartItemMinusQuantityBtn);
        }
    }

    public interface CartClickedListeners{
        void onDeleteClicked(PremiumwashCart premiumwashCart);
        void onPlusClicked(PremiumwashCart premiumwashCart);
        void onMinusClicked(PremiumwashCart premiumwashCart);
    }
}
