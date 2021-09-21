package com.cyruswere.playbeat_2.adapter;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.cyruswere.playbeat_2.R;
import com.cyruswere.playbeat_2.models.Result;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ResultDetailFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ResultDetailFragment extends Fragment {

    @BindView(R.id.frtrackImageView)
    ImageView mImageLabel;
    @BindView(R.id.frtrackNameTextView)
    TextView mNameLabel;
    @BindView(R.id.frCollectionName) TextView mCollectionName;
    @BindView(R.id.frCountry) TextView mCountry;
    @BindView(R.id.frGenre) TextView mGenre;
    //    @BindView(R.id.frPreviewUrl) TextView mPreview;
    @BindView(R.id.goToWeb)
    Button goToWeb;
    @BindView(R.id.frReleaseDate) TextView mReleaseDate;
    @BindView(R.id.frTrackDescriptionTextView) TextView martistName;


    private Result mResult;

    public ResultDetailFragment() {
        // Required empty public constructor
    }



    public static ResultDetailFragment newInstance(Result result) {
        ResultDetailFragment restaurantDetailFragment = new ResultDetailFragment();
        Bundle args = new Bundle();
        args.putParcelable("result", Parcels.wrap(result));
        restaurantDetailFragment.setArguments(args);
        return restaurantDetailFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        assert getArguments() != null;
        mResult = Parcels.unwrap(getArguments().getParcelable("result"));
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Inflate the layout for this fragment

        View view =  inflater.inflate(R.layout.fragment_result_detail, container, false);
        ButterKnife.bind(this, view);
        Picasso.get().load(mResult.getArtworkUrl100()).into(mImageLabel);
        mNameLabel.setText(mResult.getTrackName());
        mCollectionName.setText("Collection name :" + mResult.getCollectionName());
        mCountry.setText("Country :" + mResult.getCountry());
        mGenre.setText("Genre :" + mResult.getPrimaryGenreName());
//        mPreview.setText("url :" + mResult.getPreviewUrl());
        mReleaseDate.setText("Release Date :" + mResult.getReleaseDate());
        martistName.setText("Artist Name " + mResult.getArtistName());

        goToWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToUrl(mResult.getCollectionViewUrl());
            }
        });
//        mCategoriesLabel.setText(android.text.TextUtils.join(", ", categories));
//        mRatingLabel.setText(Double.toString(mRestaurant.getRating()) + "/5");
//        mPhoneLabel.setText(mRestaurant.getPhone());
//        mAddressLabel.setText(mRestaurant.getLocation().toString());

        return view;
    }

    private void goToUrl(String s){
        Uri uri = Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW,uri));
    }
}