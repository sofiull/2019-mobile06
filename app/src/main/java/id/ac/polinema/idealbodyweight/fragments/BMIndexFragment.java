package id.ac.polinema.idealbodyweight.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import id.ac.polinema.idealbodyweight.R;
import id.ac.polinema.idealbodyweight.util.BMIndex;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link BMIndexFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class BMIndexFragment extends Fragment {

    private OnFragmentInteractionListener mListener;

    public BMIndexFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_bmindex, container, false);
        final EditText massText = view.findViewById(R.id.input_mass);
        final EditText heightText = view.findViewById(R.id.input_height);

        Button calculateButton = view.findViewById(R.id.button_calculate);
        calculateButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if (mListener != null) {
                    int massString = Integer.parseInt(massText.getText().toString());
                    int heightString = Integer.parseInt(heightText.getText().toString());
                    BMIndex bmIndex = new BMIndex(massString,heightString);
                    mListener.onCheckBMIndexClicked(bmIndex.getClassification());
                } else {
                    Toast.makeText(getActivity(), "Please select gender and input your height", Toast.LENGTH_SHORT).show();
                }
            }
        });
        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event

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
        void onCheckBMIndexClicked(String classification);
    }
}
