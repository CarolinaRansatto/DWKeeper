package layout;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
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
 * {@link FichaDetalhes.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link FichaDetalhes#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FichaDetalhes extends Fragment {

    public EditText editAlinhamento;
    public EditText editAparencia;
    public EditText editBackground;
    public EditText editVinculos;
    public EditText editRacaText;

    DatabaseHelper bd;
    public FichaHelper ficha;
    private int id;

    private OnFragmentInteractionListener mListener;

    public FichaDetalhes() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment FichaDetalhes.
     */
    // TODO: Rename and change types and number of parameters
    public static FichaDetalhes newInstance() {
        FichaDetalhes fragment = new FichaDetalhes();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
     }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        this.id = getArguments().getInt("ID");
        return inflater.inflate(R.layout.fragment_ficha_detalhes, container, false);
    }

    @Override
    public void onViewCreated(View v, Bundle b){

        bd = new DatabaseHelper(this.getContext());
        ficha = bd.loadFicha(id);

        editAparencia = (EditText) getActivity().findViewById(R.id.editAparencia);
        editBackground = (EditText) getActivity().findViewById(R.id.editBackground);
        editVinculos = (EditText) getActivity().findViewById(R.id.editVinculos);
        editAlinhamento = (EditText) getActivity().findViewById(R.id.editAlinhamento);
        editRacaText = (EditText) getActivity().findViewById(R.id.editRacaText);

        editAlinhamento.setText("" + ficha.getAlinhamento());
        editAparencia.setText("" + ficha.getAparencia());
        editBackground.setText("" + ficha.getBackground());
        editVinculos.setText("" + ficha.getVinculos());
        editRacaText.setText("" + ficha.getRaçaText());

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
}
