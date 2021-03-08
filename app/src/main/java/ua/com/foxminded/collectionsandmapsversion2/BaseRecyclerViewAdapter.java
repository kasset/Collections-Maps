package ua.com.foxminded.collectionsandmapsversion2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import ua.com.foxminded.collectionsandmapsversion2.databinding.BaseListItemBinding;


public class BaseRecyclerViewAdapter extends RecyclerView.Adapter<BaseRecyclerViewAdapter.BaseViewHolder> {

    private ArrayList<CalculatedOperation> listData;

    public BaseRecyclerViewAdapter(ArrayList<CalculatedOperation> listData) {
        this.listData = listData;
    }

    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        BaseListItemBinding binding;
        binding = BaseListItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new BaseViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder holder, int position) {
        CalculatedOperation operation = listData.get(position);
        holder.bind(operation.getDurationOfOperation(), operation.getProgressBarVisibility());
    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

    public class BaseViewHolder extends RecyclerView.ViewHolder {

        private BaseListItemBinding binding;

        public BaseViewHolder(BaseListItemBinding itemBinding) {
            super(itemBinding.getRoot());
            binding = itemBinding;
        }

        public void bind(int duration, boolean progressBarVisibility) {
            binding.textViewItem.setText(String.valueOf(duration));
            if (progressBarVisibility) {
                binding.progressBarItem.setVisibility(View.VISIBLE);
            } else {
                binding.progressBarItem.setVisibility(View.INVISIBLE);
            }

        }
    }

    public void updateOperationResult(int position, int result, boolean progressVisibility) {
        listData.set(position, new CalculatedOperation(result, progressVisibility));
        notifyItemChanged(position);
    }

}

