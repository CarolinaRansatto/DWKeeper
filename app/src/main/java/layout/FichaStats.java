package layout;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;

import com.keeper.company.dwkeeper.DatabaseHelper;
import com.keeper.company.dwkeeper.FichaHelper;
import com.keeper.company.dwkeeper.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link FichaStats.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link FichaStats#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FichaStats extends Fragment {

    public EditText editNome;
    public EditText editExp;
    public EditText editNivel;
    public EditText editDano;
    public EditText editArmadura;
    public EditText editPvTotal;
    public EditText editPvAtual;
    public EditText editCarga;
    public EditText editModFor;
    public EditText editFor;
    public EditText editModDes;
    public EditText editDes;
    public EditText editModCon;
    public EditText editCon;
    public EditText editModInt;
    public EditText editInt;
    public EditText editModSab;
    public EditText editSab;
    public EditText editModCar;
    public EditText editCar;
    public EditText editRaca;
    public EditText editClasse;


    public ImageView img;

    DatabaseHelper bd;
    public FichaHelper ficha;
    public int id;

    /// / TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    //private static final String ARG_PARAM1 = "param1";
    //private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    //private String mParam1;
    //private String mParam2;

    private OnFragmentInteractionListener mListener;

    public FichaStats() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     //* @param param1 Parameter 1.
     //* @param param2 Parameter 2.
     * @return A new instance of fragment FichaStats.
     */
    // TODO: Rename and change types and number of parameters
    public static FichaStats newInstance() {
        FichaStats fragment = new FichaStats();
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
        return inflater.inflate(R.layout.fragment_ficha_stats, container, false);
    }

    @Override
    public void onViewCreated(View v, Bundle b) {
        bd = new DatabaseHelper(this.getContext());
        ficha = bd.loadFicha(id);
        img = (ImageView) getView().findViewById(R.id.viewImagem);
        editExp = (EditText) getView().findViewById(R.id.editExp);
        editNivel = (EditText) getView().findViewById(R.id.editNivel);
        editNome = (EditText) getView().findViewById(R.id.editNome);
        editClasse = (EditText) getView().findViewById(R.id.editClasse);
        editRaca = (EditText) getView().findViewById(R.id.editRaca);
        editDano = (EditText) getView().findViewById(R.id.editDano);
        editArmadura = (EditText) getView().findViewById(R.id.editArm);
        editPvAtual = (EditText) getView().findViewById(R.id.editPvAtual);
        editPvTotal = (EditText) getView().findViewById(R.id.editPvTotal);
        editCarga = (EditText) getView().findViewById(R.id.editCarga);


        editModFor = (EditText) getView().findViewById(R.id.editModFor);
        editModCar = (EditText) getView().findViewById(R.id.editModCar);
        editModCon = (EditText) getView().findViewById(R.id.editModCon);
        editModDes = (EditText) getView().findViewById(R.id.editModDes);
        editModInt = (EditText) getView().findViewById(R.id.editModInt);
        editModSab = (EditText) getView().findViewById(R.id.editModSab);

        editFor = (EditText) getView().findViewById(R.id.editFor);
        editCar = (EditText) getView().findViewById(R.id.editCar);
        editCon = (EditText) getView().findViewById(R.id.editCon);
        editDes = (EditText) getView().findViewById(R.id.editDes);
        editInt = (EditText) getView().findViewById(R.id.editInt);
        editSab = (EditText) getView().findViewById(R.id.editSab);

        //
        int permissionCheck = ContextCompat.checkSelfPermission(this.getActivity(),
                Manifest.permission.READ_EXTERNAL_STORAGE);
        if (PackageManager.PERMISSION_GRANTED == permissionCheck) {
            Log.d("permission", "permission granted");
        } else {
            // Should we show an explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale(this.getActivity(),
                    Manifest.permission.READ_EXTERNAL_STORAGE)) {
                Log.d("permission", "shouldShow");
                // Show an explanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.

            } else {

                // No explanation needed, we can request the permission.

                ActivityCompat.requestPermissions(this.getActivity(),
                        new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                        1);

                // MY_PERMISSIONS_REQUEST_READ_CONTACTS is an
                // app-defined int constant. The callback method gets the
                // result of the request.
            }
        Log.d("permission", "permission denied");
    }

        if (PackageManager.PERMISSION_GRANTED == permissionCheck) {
            Log.d("permission", "permission write granted");
        } else {
            // Should we show an explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale(this.getActivity(),
                    Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
                Log.d("permission", "shouldShow write");
                // Show an explanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.

            } else {

                // No explanation needed, we can request the permission.

                ActivityCompat.requestPermissions(this.getActivity(),
                        new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                        1);

                // MY_PERMISSIONS_REQUEST_READ_CONTACTS is an
                // app-defined int constant. The callback method gets the
                // result of the request.
            }
            Log.d("permission", "permission write denied");
        }
        Log.d("permission", "test");
        if (ficha.getImagePath() != null){

            Log.d("imagem", "Path on load: " + ficha.getImagePath());
            img.setImageURI(Uri.parse(ficha.getImagePath()));
            img.setTag(ficha.getImagePath());
        }


        editExp.setText("" + ficha.getExp());
        editNivel.setText("" + ficha.getNivel());
        editNome.setText("" + ficha.getNome());
        editDano.setText("" + ficha.getDano());
        editArmadura.setText("" + ficha.getArmadura());
        editPvAtual.setText("" + ficha.getPv_atual());
        editPvTotal.setText("" + ficha.getPv_total());
        editCarga.setText("" + ficha.getCarga());
        editClasse.setText("" + ficha.getClasse());
        editRaca.setText("" + ficha.getRaça());

        editFor.setText("" + ficha.getAtributo("for")[0]);
        editDes.setText("" + ficha.getAtributo("des")[0]);
        editCar.setText("" + ficha.getAtributo("car")[0]);
        editCon.setText("" + ficha.getAtributo("con")[0]);
        editSab.setText("" + ficha.getAtributo("sab")[0]);
        editInt.setText("" + ficha.getAtributo("int")[0]);

        editModFor.setText("" + ficha.getAtributo("for")[1]);
        editModDes.setText("" + ficha.getAtributo("des")[1]);
        editModCar.setText("" + ficha.getAtributo("car")[1]);
        editModCon.setText("" + ficha.getAtributo("con")[1]);
        editModSab.setText("" + ficha.getAtributo("sab")[1]);
        editModInt.setText("" + ficha.getAtributo("int")[1]);
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

//    public void onClickShare(View v) {
//        Intent sendIntent = new Intent();
//        sendIntent.setAction(Intent.ACTION_SEND);
//        sendIntent.putExtra(Intent.EXTRA_TEXT, "Testando");
//        sendIntent.setType("text/plain");
//        startActivity(Intent.createChooser(sendIntent, "Enviar para"));
//    }

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
