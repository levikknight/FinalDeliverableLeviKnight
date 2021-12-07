package com.example.finaldeliverableleviknight;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.LinkedList;

public class PersonToPersonAdapter extends RecyclerView.Adapter<PersonToPersonAdapter.PersonViewHolder> {

    private LayoutInflater mInflater;
    public LinkedList<String> namesList;

    PersonToPersonAdapter(Context context, LinkedList<String> names) {
        mInflater = LayoutInflater.from(context);
        this.namesList = names;
    };

    @Override
    public PersonViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View mItemView = mInflater.inflate(R.layout.person_to_person_list, parent, false);
        return new PersonViewHolder(mItemView, this);
    }

    @Override
    public void onBindViewHolder(PersonViewHolder holder, int position) {
        String mCurrent = namesList.get(position);
        holder.wordItemView.setText(mCurrent);
    }

    @Override
    public int getItemCount() {
        return namesList.size();
    }

    class PersonViewHolder extends RecyclerView.ViewHolder {

        public final TextView wordItemView;
        final PersonToPersonAdapter mAdapter;

        public PersonViewHolder(View itemView, PersonToPersonAdapter adapter) {
            super(itemView);
            wordItemView = itemView.findViewById(R.id.word);
            this.mAdapter = adapter;

        }
    }
}
