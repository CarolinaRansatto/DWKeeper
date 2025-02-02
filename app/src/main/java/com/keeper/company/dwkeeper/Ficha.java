package com.keeper.company.dwkeeper;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.ShareActionProvider;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.net.URI;

import layout.FichaDetalhes;
import layout.FichaStats;
import layout.FichaTech;

public class Ficha extends AppCompatActivity
        implements FichaDetalhes.OnFragmentInteractionListener,
                   FichaStats.OnFragmentInteractionListener,
                   FichaTech.OnFragmentInteractionListener {

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;
    public final int PICK_IMAGE = 0;
    DatabaseHelper bd;
    private FichaStats fichaStats;
    private FichaDetalhes fichaDetalhes;
    private FichaTech fichaTech;
    private ShareActionProvider mShareActionProvider;
    private int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nova_ficha);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        Intent intent = getIntent();
        id = intent.getIntExtra("ID", 1);
    }

    @Override
    public void onPause(){
        //salva ficha
        super.onPause();
        if(id != 0){
            saveFicha();
            FichaHelper aux = bd.loadFicha(id);
        }

        //ImageView img = fichaStats.img;

        //if (aux.getImagePath() != null) {
        //    img.setImageURI(Uri.parse(aux.getImagePath()));
        //}


    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, SelecaoFicha.class);
        startActivity(intent);
    }

    private void saveFicha() {
        bd = new DatabaseHelper(this);
        FichaHelper ficha = fichaStats.ficha;

        EditText exp = fichaStats.editExp;
        EditText nivel = fichaStats.editNivel;
        EditText nome = fichaStats.editNome;
        EditText dano = fichaStats.editDano;
        EditText armadura = fichaStats.editArmadura;
        EditText pvTotal = fichaStats.editPvTotal;
        EditText pvAtual = fichaStats.editPvAtual;
        EditText carga = fichaStats.editCarga;
        EditText raca = fichaStats.editRaca;
        EditText classe = fichaStats.editClasse;

        EditText editModFor = fichaStats.editModFor;
        EditText editFor =  fichaStats.editFor;
        EditText editModDes =  fichaStats.editModDes;
        EditText editDes =  fichaStats.editDes;
        EditText editModCon =  fichaStats.editModCon;
        EditText editCon =  fichaStats.editCon;
        EditText editModInt =  fichaStats.editModInt;
        EditText editInt =  fichaStats.editInt;
        EditText editModSab =  fichaStats.editModSab;
        EditText editSab =  fichaStats.editSab;
        EditText editModCar =  fichaStats.editModCar;
        EditText editCar =  fichaStats.editCar;

        ImageView img = fichaStats.img;

        EditText editAparencia = fichaDetalhes.editAparencia;
        EditText editBackground = fichaDetalhes.editBackground;
        EditText editVinculos = fichaDetalhes.editVinculos;
        EditText editAlinhamento = fichaDetalhes.editAlinhamento;
        EditText editRacaText = fichaDetalhes.editRacaText;
        EditText editMovimentos;
        EditText editEquipamentos;


        // Ficha tech talvez não tenha sido inicializada
        if (fichaTech != null){
             editMovimentos = fichaTech.editMovimentos;
             editEquipamentos = fichaTech.editEquipamentos;
            ficha.setMovimentos(editMovimentos.getText().toString());
            ficha.setEquipamentos(editEquipamentos.getText().toString());
        }

        // Monta string de atributos pra salvar no BD

        EditText [] editArray = {
                editFor, editModFor,
                editDes, editModDes,
                editCon, editModCon,
                editInt, editModInt,
                editSab, editModSab,
                editCar, editModCar};

        int [] newAtributos = new int[12];
        for (int i = 0; i < editArray.length; i++){
            newAtributos[i] = Integer.parseInt(editArray[i].getText().toString());
        }

        ficha.setAlinhamento(editAlinhamento.getText().toString());
        ficha.setAparencia(editAparencia.getText().toString());
        ficha.setBackground(editBackground.getText().toString());
        ficha.setVinculos(editVinculos.getText().toString());
        ficha.setExp(Integer.parseInt(exp.getText().toString()));
        ficha.setNivel(Integer.parseInt(nivel.getText().toString()));
        ficha.setNome(nome.getText().toString());
        ficha.setDano(Integer.parseInt(dano.getText().toString()));
        ficha.setArmadura(Integer.parseInt(armadura.getText().toString()));
        ficha.setPv_atual(Integer.parseInt(pvAtual.getText().toString()));
        ficha.setPv_total(Integer.parseInt(pvTotal.getText().toString()));
        ficha.setCarga(Integer.parseInt(carga.getText().toString()));
        ficha.setAtributos(newAtributos);
        ficha.setClasse(classe.getText().toString());
        ficha.setRaça(raca.getText().toString());
        ficha.setRaçaText(editRacaText.getText().toString());


        if (img.getTag() != null){
            ficha.setImagePath(img.getTag().toString());
            //   Log.d("imagem", "Path on save: " + img.getTag().toString());

        }

        bd.saveFicha(ficha, ficha.getId());
    }

    public void removeFicha(View view) {
        bd = new DatabaseHelper(this);
        bd.removeFicha(id);
        id = 0;
        fichaStats.id = 0;
        Intent intent = new Intent(this, SelecaoFicha.class);
        startActivity(intent);
    }

    public void pickImage(View v){
        Intent getIntent = new Intent(Intent.ACTION_GET_CONTENT);
        getIntent.setType("image/*");

        Intent pickIntent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        pickIntent.setType("image/*");

        Intent chooserIntent = Intent.createChooser(getIntent, "Select Image");
        chooserIntent.putExtra(Intent.EXTRA_INITIAL_INTENTS, new Intent[] {pickIntent});

        startActivityForResult(chooserIntent, PICK_IMAGE);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_IMAGE && resultCode == Activity.RESULT_OK) {
            if (data == null) {
                return;
            }
            String s = data.getData().toString();
            Uri aux = Uri.parse(s);
            fichaStats.img.setImageURI(aux);
            fichaStats.img.setTag(s);
            Log.d("imagem", "Path on set: " + s);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_nova_ficha, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement

        return super.onOptionsItemSelected(item);
    }

//    public void onClickShare(View v) {
//        Intent sendIntent = new Intent();
//        sendIntent.setAction(Intent.ACTION_SEND);
//        sendIntent.putExtra(Intent.EXTRA_TEXT, "Testando");
//        sendIntent.setType("text/plain");
//        startActivity(Intent.createChooser(sendIntent, "Enviar para"));
//    }

    @Override
    public void onFragmentInteraction (Uri uri) {

    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            Fragment f;
            switch (position) {
                case 0:
                    f = FichaStats.newInstance();
                    break;
                case 1:
                    f = FichaDetalhes.newInstance();
                    break;
                case 2:
                    f = FichaTech.newInstance();
                    break;
                default:
                    return null;
            }
            Bundle b = new Bundle();
            b.putInt("ID", id);
            f.setArguments(b);
            return f;
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 3;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            Fragment createdFragment = (Fragment) super.instantiateItem(container, position);
            switch (position) {
                case 0:
                    fichaStats = (FichaStats) createdFragment;
                    break;
                case 1:
                    fichaDetalhes = (FichaDetalhes) createdFragment;
                    break;
                case 2:
                    fichaTech = (FichaTech) createdFragment;
                    break;
            }
            return createdFragment;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "SECTION 1";
                case 1:
                    return "SECTION 2";
                case 2:
                    return "SECTION 3";
            }
            return null;
        }
    }
}
