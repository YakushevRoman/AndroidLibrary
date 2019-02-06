package com.example.user301.androidlibrary.AndroidFragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user301.androidlibrary.PDFImageFragment.PDFImageFragment;
import com.example.user301.androidlibrary.R;

import java.util.ArrayList;
import java.util.List;

public class AndroidFragment extends Fragment {

    private RecyclerView rAndroidRecyclerView;
    private TextView rAndroidTextView;
    private ImageView rAndroidImageView;
    private AndroidAdapter rAndroidAdapter;
    private List <AndroidBox> rAndroidList;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_for_android_list, container, false);

        rAndroidImageView = view.findViewById(R.id.android_image_view);

        rAndroidTextView = view.findViewById(R.id.android_text_view);

        rAndroidList = new ArrayList<>();
        for (String s : getResources().getStringArray(R.array.android_list)) {
            rAndroidList.add(new AndroidBox(R.drawable.ic_android_black_24dp, s));
        }
        rAndroidAdapter = new AndroidAdapter(rAndroidList);

        rAndroidRecyclerView = view.findViewById(R.id.android_recycler_view);
        rAndroidRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        rAndroidRecyclerView.setAdapter(rAndroidAdapter);
        return view;
    }

    private class AndroidAdapter extends RecyclerView.Adapter<AndroidHolder>{

        private List <AndroidBox> rAndroidBoxes;

        public AndroidAdapter(List<AndroidBox> rAndroidBoxes) {
            this.rAndroidBoxes = rAndroidBoxes;
        }

        @NonNull
        @Override
        public AndroidHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            View view = LayoutInflater
                    .from(getContext())
                    .inflate(R.layout.item_for_main_recycler_view, viewGroup, false);
            return new AndroidHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull AndroidHolder androidHolder, int i) {
            AndroidBox androidBox = rAndroidBoxes.get(i);

            androidHolder
                    .rImageView
                    .setImageResource(androidBox.getrAndroidImage());

            androidHolder
                    .rTextView
                    .setText(androidBox.getrAndroidTitle());
        }

        @Override
        public int getItemCount() {
            return rAndroidBoxes.size();
        }
    }

    private class AndroidHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView rTextView;
        private ImageView rImageView;


        public AndroidHolder(@NonNull View itemView) {
            super(itemView);

            rTextView = itemView.findViewById(R.id.text_view_main_recycler_view);

            rImageView = itemView.findViewById(R.id.image_main_recycler_view);
            rTextView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int positiont = getAdapterPosition();
            if (positiont != RecyclerView.NO_POSITION){
                switch (v.getId()){
                    case R.id.text_view_main_recycler_view:
                        itemClick(positiont);
                        break;
                }
            }
        }

        private void itemClick(int positiont) {
            // для нового фрагмента
            Toast.makeText(getContext(),rTextView.getText(),Toast.LENGTH_SHORT ).show();
            FragmentManager fragmentManager = getFragmentManager();
            Fragment fragment = fragmentManager.findFragmentById(R.id.fragment_container);
            if (fragment != null){
                fragment = new PDFImageFragment();
                fragmentManager
                        .beginTransaction()
                        .replace(R.id.fragment_container, fragment)
                        .commit();
            }
        }
    }

}
