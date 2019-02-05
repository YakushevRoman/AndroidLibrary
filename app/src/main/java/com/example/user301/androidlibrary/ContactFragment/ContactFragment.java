package com.example.user301.androidlibrary.ContactFragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.user301.androidlibrary.ItemsForMyList;
import com.example.user301.androidlibrary.R;

import java.util.ArrayList;
import java.util.List;

public class ContactFragment extends Fragment {

    private ContactsAdapter rContactsAdapter;
    private RecyclerView rContactsRecyclerView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_for_contacts_list, container, false);
        List <ItemsForMyList> rContactsList = new ArrayList<>();
        for (String contacts : getResources().getStringArray(R.array.my_infarmation)){
            rContactsList.add(new ItemsForMyList(R.drawable.ic_android_black_24dp, contacts));
        }
        rContactsAdapter = new ContactsAdapter(rContactsList);
        rContactsRecyclerView = view.findViewById(R.id.contacts_list_recycler_view);
        rContactsRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        rContactsRecyclerView.setAdapter(rContactsAdapter);
        return view;
    }

    private class ContactsAdapter extends RecyclerView.Adapter<ContactsHolder>{
        List <ItemsForMyList> rContactsList;

        public ContactsAdapter(List<ItemsForMyList> rContactsList) {
            this.rContactsList = rContactsList;
        }

        @NonNull
        @Override
        public ContactsHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            LayoutInflater layoutInflater = LayoutInflater.from(getContext());
            View view = layoutInflater.inflate(R.layout.item_for_main_recycler_view, viewGroup, false);
            return new ContactsHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull ContactsHolder contactsHolder, int i) {
            ItemsForMyList rItemsForMyList = rContactsList.get(i);
            contactsHolder.rTextView.setText(rItemsForMyList.getrTitle());
            contactsHolder.rImageView.setImageResource(rItemsForMyList.getrImage());
        }

        @Override
        public int getItemCount() {
            return rContactsList.size();
        }
    }

    private class ContactsHolder extends RecyclerView.ViewHolder{
        private TextView rTextView;
        private ImageView rImageView;

        public ContactsHolder(@NonNull View itemView) {
            super(itemView);
            rImageView = itemView.findViewById(R.id.image_main_recycler_view);
            rTextView = itemView.findViewById(R.id.text_view_main_recycler_view);
        }
    }

}
