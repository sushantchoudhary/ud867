package com.udacity.gradle.builditbigger;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.udacity.gradle.builditbigger.service.JokeService;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {
    private AdView mAdView;
    private InterstitialAd mInterstitialAd;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);

        if(BuildConfig.FLAVOR.equals("free")) {
            MobileAds.initialize(this.getActivity(),
                    "ca-app-pub-3940256099942544~3347511713");

            mInterstitialAd = new InterstitialAd(this.getActivity());
            mInterstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");

            mInterstitialAd.setAdListener(new AdListener() {
                @Override
                public void onAdClosed() {
                    new JokeService().execute(getActivity());
                }
            });

            Button showJoke = root.findViewById(R.id.show_joke);
            showJoke.setOnClickListener( new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    showInterstitial();
                }
            });


            mInterstitialAd.loadAd(new AdRequest.Builder().build());

        }

        return root;
    }


    private void showInterstitial() {
        if(mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        } else {
            Toast.makeText(this.getActivity(), "Ad wasn't loaded.", Toast.LENGTH_SHORT).show();
            new JokeService().execute(getActivity());
        }
    }

    @Override
    public void onResume() {
        super.onResume();


    }
}
