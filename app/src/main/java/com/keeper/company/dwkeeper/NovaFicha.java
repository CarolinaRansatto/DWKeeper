package com.keeper.company.dwkeeper;

import android.net.Uri;
import android.provider.ContactsContract;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
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
import android.widget.TextView;

import java.net.URI;

import layout.FichaDetalhes;
import layout.FichaStats;
import layout.FichaTech;

public class NovaFicha extends AppCompatActivity
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

    DatabaseHelper bd;
    private FichaStats fichaStats;
    private FichaDetalhes fichaDetalhes;
    private FichaTech fichaTech;

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
    }

    @Override
    public void onPause(){
        //salva ficha

        super.onPause();
        bd = new DatabaseHelper(this);

        if (fichaStats != null){
            Log.d("textTest", "fichaStatsnotnull");
        }else {
            Log.d("textTest", "fichaStatsnulll"); // fichas stats esta setndo null
        }
        FichaHelper ficha = fichaStats.ficha;

        EditText exp = fichaStats.editExp;
        EditText nivel = fichaStats.editNivel;
        EditText nome = fichaStats.editNome;
        EditText dano = fichaStats.editDano;
        EditText armadura = fichaStats.editArmadura;
        EditText pvTotal = fichaStats.editPvTotal;
        EditText pvAtual = fichaStats.editPvAtual;
        EditText carga = fichaStats.editCarga;

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

        // Monta string de atributos pra salvar no BD

        EditText [] editArray = {editFor, editModFor,
                editDes, editModDes,
                editCon, editModCon,
                editInt, editModInt,
                editSab, editModSab,
                editCar, editModCar};

        int [] newAtributos = new int[12];
        for (int i = 0; i < editArray.length; i++){
            newAtributos[i] = Integer.parseInt(editArray[i].getText().toString());
        }


        ficha.setExp(Integer.parseInt(exp.getText().toString()));
        ficha.setNivel(Integer.parseInt(nivel.getText().toString()));
        ficha.setNome(nome.getText().toString());
        ficha.setDano(Integer.parseInt(dano.getText().toString()));
        ficha.setArmadura(Integer.parseInt(armadura.getText().toString()));
        ficha.setPv_atual(Integer.parseInt(pvAtual.getText().toString()));
        ficha.setPv_total(Integer.parseInt(pvTotal.getText().toString()));
        ficha.setCarga(Integer.parseInt(carga.getText().toString()));
        ficha.setAtributos(newAtributos);

        bd.saveFicha(ficha, 1);
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
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

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
            switch (position) {
                case 1:
                    return FichaDetalhes.newInstance();
                case 2:
                    return FichaTech.newInstance();
                default:
                    return FichaStats.newInstance();
            }
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
