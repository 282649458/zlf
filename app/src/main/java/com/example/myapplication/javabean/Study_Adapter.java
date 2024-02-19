package com.example.myapplication.javabean;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;

/**
 * TODO：设置adapter
 * author：zwt
 * email：1987901354@qq.com
 * data：2024.2.19
 */

public class Study_Adapter {


    public static class LinearCourseFinishAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
        @NonNull
        private Context mContext;
        private OnItemClickListener mListener;
        //private List<String> list;

        public LinearCourseFinishAdapter(Context context, OnItemClickListener listener) {
            this.mContext = context;
            this.mListener = listener;
        }

        //展示，传输item
        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new LinearViewHolder(LayoutInflater.from(mContext).inflate(R.layout.study_item, parent, false));
        }

        @Override
        //通过getItemViewType的返回值来选择具体的item显示
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, @SuppressLint("RecyclerView") final int position) {
            ((LinearViewHolder) holder).textView.setText("学习任务");
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //Toast.makeText(mContext,"click..."+position,Toast.LENGTH_SHORT).show();
                    mListener.onClick(position);
                }
            });
        }

        //rv的数量
        @Override
        public int getItemCount() {
            return 20;
        }

        class LinearViewHolder extends RecyclerView.ViewHolder {
            private TextView textView;

            public LinearViewHolder(View itemView) {
                super(itemView);
                textView = itemView.findViewById(R.id.study_titlle);
            }
        }


        //接口
        public interface OnItemClickListener {
            void onClick(int pos);
        }
    }

}

