package com.dstyo.prelo.activity.main;

import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.android.databinding.library.baseAdapters.BR;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.dstyo.prelo.model.product.Product;

import java.text.NumberFormat;
import java.util.Locale;

/**
 * @author Dwi Setiyono <dwi.setiyono@ovo.id>
 * @since 2017.07.12
 */
public class ItemProductViewModel extends BaseObservable {

    private Product product;

    public ItemProductViewModel(Product product) {
        this.product = product;
        notifyProperties();
    }

    private void notifyProperties() {
        notifyPropertyChanged(BR.productTitle);
        notifyPropertyChanged(BR.productPrice);
        notifyPropertyChanged(BR.productImageURL);
    }

    @Bindable
    public String getProductTitle() {
        return product.getName();
    }

    @Bindable
    public String getProductPrice() {
        Locale localeID = new Locale("in", "ID");
        NumberFormat formatRupiah = NumberFormat.getCurrencyInstance(localeID);
        return formatRupiah.format((double) product.getPrice());
    }

    @Bindable
    public String getProductImageURL() {
        return product.getDisplayPicts().get(0);
    }

    @BindingAdapter("imageUrl")
    public static void setImageUrl(ImageView imageView, String url) {
        Context context = imageView.getContext();
        Glide.with(context)
                .load(url)
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .skipMemoryCache(true)
                .into(imageView);
    }

}
