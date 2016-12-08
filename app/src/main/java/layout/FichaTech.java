package layout;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.keeper.company.dwkeeper.DatabaseHelper;
import com.keeper.company.dwkeeper.FichaHelper;
import com.keeper.company.dwkeeper.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link FichaTech.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link FichaTech#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FichaTech extends Fragment {

    public EditText editMovimentos;
    public EditText editEquipamentos;

    private OnFragmentInteractionListener mListener;

    DatabaseHelper bd;
    public FichaHelper ficha;
    private int id;

    public FichaTech() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     //* @param param1 Parameter 1.
     //* @param param2 Parameter 2.
     * @return A new instance of fragment FichaTech.
     */
    // TODO: Rename and change types and number of parameters
    public static FichaTech newInstance() {
        FichaTech fragment = new FichaTech();
        Bundle args = new Bundle();
        //args.putString(ARG_PARAM1, param1);
        //args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            //mParam1 = getArguments().getString(ARG_PARAM1);
            //mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        this.id = getArguments().getInt("ID");
        return inflater.inflate(R.layout.fragment_ficha_tech, container, false);
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
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


    @Override
    public void onViewCreated(View v, Bundle b){

        Log.d("teste", "estáa chegando aqui");

        bd = new DatabaseHelper(this.getContext());
        ficha = bd.loadFicha(id);

        editMovimentos = (EditText) getActivity().findViewById(R.id.editMovimentos);
        editEquipamentos = (EditText) getActivity().findViewById(R.id.editEquipamento);

        editMovimentos.setText("" + ficha.getMovimentos());
        editEquipamentos.setText("" + ficha.getEquipamentos());

    }
}
