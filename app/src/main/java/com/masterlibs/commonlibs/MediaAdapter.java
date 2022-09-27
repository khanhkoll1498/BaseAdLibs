package com.masterlibs.commonlibs;

import android.content.Context;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.common.control.base.BaseAdapter;
import com.common.control.base.BaseViewHolder;
import com.masterlibs.commonlibs.databinding.ActivityMainBinding;

import java.util.List;

public class MediaAdapter extends BaseAdapter<String> {
    public MediaAdapter(List<String> mList, Context context) {
        super(mList, context);
    }

    @Override
    protected RecyclerView.ViewHolder viewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    protected void onBindView(RecyclerView.ViewHolder viewHolder, int position) {

    }

    class ViewHolder extends BaseViewHolder<ActivityMainBinding> {


        public ViewHolder(ActivityMainBinding viewDataBinding) {
            super(viewDataBinding);
        }

        @Override
        public void loadData(Object item) {

        }
    }

}
