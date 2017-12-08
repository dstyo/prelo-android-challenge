package com.dstyo.prelo.adapter;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dstyo.prelo.R;
import com.dstyo.prelo.activity.main.ItemProductViewModel;
import com.dstyo.prelo.databinding.ItemProductBinding;
import com.dstyo.prelo.model.product.Product;
import com.dstyo.prelo.model.product.ProductResponse;

import java.util.List;

/**
 * @author Dwi Setiyono <dwi.setiyono@ovo.id>
 * @since 2017.07.12
 */
public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.MainViewHolder> {
    private List<Product> datas;
    private OnItemClickListener onItemClickListener;

    public ProductAdapter(ProductResponse response, OnItemClickListener onItemClickListener) {
        this.datas = response.getData();
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    public MainViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemProductBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_product, parent, false);

        return new MainViewHolder(binding, onItemClickListener);
    }

    @Override
    public void onBindViewHolder(MainViewHolder holder, int position) {
        holder.binding.setViewModel(new ItemProductViewModel(datas.get(position)));
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    public static class MainViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private ItemProductBinding binding;
        private OnItemClickListener onItemClickListener;

        public MainViewHolder(ItemProductBinding binding, OnItemClickListener listener) {
            super(binding.getRoot());
            this.binding = binding;
            this.onItemClickListener = listener;
            binding.getRoot().setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            onItemClickListener.onItemClick(getAdapterPosition());
        }
    }

    public interface OnItemClickListener {
        void onItemClick(int position);
    }
}
