package com.example.chislaundry.views;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.chislaundry.R;
import com.example.chislaundry.utils.adapter.PremiumwashItemAdapter;
import com.example.chislaundry.utils.model.PremiumwashCart;
import com.example.chislaundry.utils.model.PremiumwashItem;
import com.example.chislaundry.viewmodel.CartViewModel;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

public class MainActivity2 extends AppCompatActivity implements PremiumwashItemAdapter.PremiumwashClickedListeners {
    private RecyclerView recyclerView;
    private List<PremiumwashItem> premiumwashItemList;
    private PremiumwashItemAdapter adapter;

    private CartViewModel viewModel;

    private List<PremiumwashCart>premiumwashCartList;

    private CoordinatorLayout coordinatorLayout;

    private ImageView cartImageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeVariables();
        setUpList();

        adapter.setPremiumwashItemList(premiumwashItemList);
        recyclerView.setAdapter(adapter);

        cartImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity2.this, CartActivity.class));
            }
        });
    }
    @Override
    protected void onResume(){
        super.onResume();
        viewModel.getAllCartItems().observe(this, new Observer<List<PremiumwashCart>>() {
            @Override
            public void onChanged(List<PremiumwashCart> premiumwashCarts) {
                premiumwashCartList.addAll(premiumwashCarts);
            }
        });
    }

    private void setUpList() {
        premiumwashItemList.add(new PremiumwashItem("Premium Wash Kebaya", R.drawable.kebaya, 5000));
        premiumwashItemList.add(new PremiumwashItem("Premium Wash Bed Cover", R.drawable.towels, 6000));
        premiumwashItemList.add(new PremiumwashItem("Premium Wash Sprei", R.drawable.blanket, 7000));
        premiumwashItemList.add(new PremiumwashItem("Premium Wash Handuk Mandi", R.drawable.handukmandi, 5000));
        premiumwashItemList.add(new PremiumwashItem("Cuci Setrika Baju Kaos", R.drawable.shirt, 5000));
        premiumwashItemList.add(new PremiumwashItem("Cuci Setrika Kemeja", R.drawable.kemeja, 6000));
        premiumwashItemList.add(new PremiumwashItem("Cuci Setrika Kaos Kaki", R.drawable.socks, 3000));
        premiumwashItemList.add(new PremiumwashItem("Cuci Setrika Pakian Dalam", R.drawable.cd, 3000));
        premiumwashItemList.add(new PremiumwashItem("Cuci Setrika Celana", R.drawable.celanapendek, 5000));
        premiumwashItemList.add(new PremiumwashItem("Cuci Setrika Jeans", R.drawable.celanapanjang, 7000));
        premiumwashItemList.add(new PremiumwashItem("Cuci Setrika Rok", R.drawable.rok, 5000));
        premiumwashItemList.add(new PremiumwashItem("Setrika Baju Kaos", R.drawable.shirt, 3000));
        premiumwashItemList.add(new PremiumwashItem("Setrika Kemeja", R.drawable.kemeja, 4000));
        premiumwashItemList.add(new PremiumwashItem("Setrika Kaos Kaki", R.drawable.socks, 2000));
        premiumwashItemList.add(new PremiumwashItem("Setrika Pakian Dalam", R.drawable.cd, 2000));
        premiumwashItemList.add(new PremiumwashItem("Setrika Celana", R.drawable.celanapendek, 3000));
        premiumwashItemList.add(new PremiumwashItem("Setrika Jeans", R.drawable.celanapanjang, 5000));
        premiumwashItemList.add(new PremiumwashItem("Setrika Rok", R.drawable.rok, 3000));
        premiumwashItemList.add(new PremiumwashItem("Dry Cleaning Kebaya", R.drawable.kebaya, 6000));
        premiumwashItemList.add(new PremiumwashItem("Dry Cleaning Jas", R.drawable.jas, 7000));
        premiumwashItemList.add(new PremiumwashItem("Dry Cleaning Jaket", R.drawable.jaket, 7000));
        premiumwashItemList.add(new PremiumwashItem("Dry Cleaning Gaun", R.drawable.gaun, 10000));

    }

    private void initializeVariables() {

        cartImageView=findViewById(R.id.cartIv);
        coordinatorLayout = findViewById(R.id.coordinatorLayout);
        premiumwashCartList = new ArrayList<>();
        viewModel = new ViewModelProvider(this).get(CartViewModel.class);
        premiumwashItemList = new ArrayList<>();
        recyclerView = findViewById(R.id.mainRecyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));

        adapter = new PremiumwashItemAdapter(this);
    }

    @Override
    public void onCardClicked(PremiumwashItem premiumwashItem) {
        Intent intent = new Intent(MainActivity2.this, DetailedActivity.class);
        intent.putExtra("premiumwashItem", premiumwashItem);
        startActivity(intent);
    }

    @Override
    public void onAddToCartBtnClicked(PremiumwashItem premiumwashItem) {
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
        Log.d("TAG", "onAddToCartBtnClicked:" + quantity[0]);

        if(quantity[0]==1){
            premiumwashCart.setQuantity(quantity[0]);
            premiumwashCart.setTotalItemPrice(quantity[0]*premiumwashCart.getPremiumwashPrice());
            viewModel.insertCartItem(premiumwashCart);
        }else{
            viewModel.updateQuantity(id[0],quantity[0]);
            viewModel.updatePrice(id[0],quantity[0]*premiumwashCart.getPremiumwashPrice());
        }
        makeSnackBar("Item Added To Cart");
    }
    private void makeSnackBar(String msg){
        Snackbar.make(coordinatorLayout, msg, Snackbar.LENGTH_SHORT)
                .setAction("Go to Cart", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        startActivity(new Intent(MainActivity2.this, CartActivity.class));
                    }
                }).show();
    }
}
