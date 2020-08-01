package com.laioffer.tinnews.ui.detail;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.laioffer.tinnews.R;
import com.laioffer.tinnews.databinding.FragmentSavedNewsDetailBinding;
import com.laioffer.tinnews.model.Article;
import com.squareup.picasso.Picasso;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SavedNewsDetailFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SavedNewsDetailFragment extends Fragment {
    private FragmentSavedNewsDetailBinding binding;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public SavedNewsDetailFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SavedNewsDetailFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SavedNewsDetailFragment newInstance(String param1, String param2) {
        SavedNewsDetailFragment fragment = new SavedNewsDetailFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentSavedNewsDetailBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        if (getArguments() == null) {
            return;
        }
        Article article = SavedNewsDetailFragmentArgs.fromBundle(getArguments()).getArticle();
        if (article == null) {
            return;
        }
        Log.d("SaveNewsDetailFragment", article.toString());

        binding.title.setText(article.title);
        binding.author.setText(article.author);
        binding.timeStamp.setText(article.publishedAt);
        if (article.urlToImage != null) {
            Picasso.get().load(article.urlToImage).into(binding.image);
        } else {
            binding.image.setImageResource(R.drawable.ic_empty_image);
        }
        binding.description.setText(article.description);
        binding.content.setText(article.content);

    }


}