package com.udacity.jokey;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link JokeyFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link JokeyFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class JokeyFragment extends Fragment {
    private static final String JOKE_KEY = "joke";

    private String joke;

    private OnFragmentInteractionListener mListener;

    public JokeyFragment() {
    }
    public static JokeyFragment newInstance(String param1) {
        JokeyFragment fragment = new JokeyFragment();
        Bundle args = new Bundle();
        args.putString(JOKE_KEY, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            joke = getArguments().getString(JOKE_KEY);
        }


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root =  inflater.inflate(R.layout.fragment_jokey, container, false);
        TextView textView = root.findViewById(R.id.joke_container);

        if(joke != null && joke.length() != 0) {
            textView.setText(joke);

        }
        return  root;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
