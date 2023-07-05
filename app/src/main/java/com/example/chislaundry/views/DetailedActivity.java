package com.example.chislaundry.views;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.chislaundry.R;
import com.example.chislaundry.utils.model.PremiumwashCart;
import com.example.chislaundry.utils.model.PremiumwashItem;
import com.example.chislaundry.viewmodel.CartViewModel;

import java.util.ArrayList;
import java.util.List;


public class DetailedActivity extends AppCompatActivity {

    private ImageView premiumwashImageView;
    private TextView premiumwashName, premiumwashPrice;
    private AppCompatButton addToCartBtn;
    private PremiumwashItem premiumwashItem;
    private CartViewModel viewModel;
    private List<PremiumwashCart> premiumwashCartList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed);

        premiumwashItem = getIntent().getParcelableExtra("premiumwashItem");
        initializeVariables();

        viewModel.getAllCartItems().observe(this, new Observer<List<PremiumwashCart>>() {
            @Override
            public void onChanged(List<PremiumwashCart> premiumwashCarts) {
                premiumwashCartList.addAll(premiumwashCarts);
            }
        });

        if (premiumwashItem!=null){
            setDataToWidgets();
        }

        addToCartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insertToRoom();
            }
        });
    }
    private void insertToRoom(){
        PremiumwashCart premiumwashCart = new PremiumwashCart();
        premiumwashCart.setPremiumwashName(premiumwashItem.getPremiumwashName());
        premiumwashCart.setPremiumwashPrice(premiumwashItem.getPremiumwashPrice());
        premiumwashCart.setPremiumwashImage(premiumwashItem.getPremiumwashImage());

        final int[] quantity = {1};
        final int[] id = new int[1];

        if(!premiumwashCartList.isEmpty()){
            for(int i=0;i<premiumwashCartList.size();i++){
                if(premiumwashCart.getPremiumwashName().equals(premiumwashCartList.get(i).getPremiumwashName())){
                    quantity[0] = premiumwashCartList.get(i).getQuantity();
                    quantity[0]++;
                    id[0] = premiumwashCartList.get(i).getId();
                }
            }
        }

        if(quantity[0]==1){
            premiumwashCart.setQuantity(quantity[0]);
            premiumwashCart.setTotalItemPrice(quantity[0]*premiumwashCart.getPremiumwashPrice());
            viewModel.insertCartItem(premiumwashCart);
        }else{
            viewModel.updateQuantity(id[0],quantity[0]);
            viewModel.updatePrice(id[0],quantity[0]*premiumwashCart.getPremiumwashPrice());
        }
        startActivity(new Intent(DetailedActivity.this, CartActivity.class));
    }
    private void setDataToWidgets(){
        premiumwashName.setText(premiumwashItem.getPremiumwashName());
        premiumwashPrice.setText(String.valueOf(premiumwashItem.getPremiumwashPrice()));
        premiumwashImageView.setImageResource(premiumwashItem.getPremiumwashImage());

    }
    private void initializeVariables(){
        premiumwashCartList = new ArrayList<>();

        premiumwashImageView = findViewById(R.id.detailActivityImageView);
        premiumwashName = findViewById(R.id.detailActivityPremiumwashName);
        premiumwashPrice = findViewById(R.id.detailActivityPremiumwashPrice);
        addToCartBtn = findViewById(R.id.detailActivityAddToCartBtn);

        viewModel = new ViewModelProvider(this).get(CartViewModel.class);
    }

}