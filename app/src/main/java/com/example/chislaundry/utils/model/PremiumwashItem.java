package com.example.chislaundry.utils.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class PremiumwashItem implements Parcelable {
    private String premiumwashName;
    private int premiumwashImage;
    private double premiumwashPrice;

    public PremiumwashItem(String premiumwashName, int premiumwashImage, double premiumwashPrice) {
        this.premiumwashName = premiumwashName;
        this.premiumwashImage = premiumwashImage;
        this.premiumwashPrice = premiumwashPrice;
    }

    protected PremiumwashItem(Parcel in) {
        premiumwashName = in.readString();
        premiumwashImage = in.readInt();
        premiumwashPrice = in.readDouble();
    }

    public static final Creator<PremiumwashItem> CREATOR = new Creator<PremiumwashItem>() {
        @Override
        public PremiumwashItem createFromParcel(Parcel in) {
            return new PremiumwashItem(in);
        }

        @Override
        public PremiumwashItem[] newArray(int size) {
            return new PremiumwashItem[size];
        }
    };

    public String getPremiumwashName() {
        return premiumwashName;
    }

    public void setPremiumwashName(String premiumwashName) {
        this.premiumwashName = premiumwashName;
    }

    public int getPremiumwashImage() {
        return premiumwashImage;
    }

    public void setPremiumwashImage(int premiumwashImage) {
        this.premiumwashImage = premiumwashImage;
    }

    public double getPremiumwashPrice() {
        return premiumwashPrice;
    }

    public void setPremiumwashPrice(double premiumwashPrice) {
        this.premiumwashPrice = premiumwashPrice;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeString(premiumwashName);
        parcel.writeInt(premiumwashImage);
        parcel.writeDouble(premiumwashPrice);
    }
}
