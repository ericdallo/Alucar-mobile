package com.alucar.init;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.alucar.R;
import com.github.clans.fab.FloatingActionButton;
import com.github.clans.fab.FloatingActionMenu;

public class AlucarActivity extends AppCompatActivity {

    private FloatingActionMenu menu;
    private FloatingActionButton btRent,btDevolve;
    private Fragment statesFrag,devolutionFrag,welcomeFrag;
    private FragmentManager fm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_alucar);
        fm = getSupportFragmentManager();
        statesFrag = fm.findFragmentById(R.id.states_frag);
        devolutionFrag = fm.findFragmentById(R.id.devolution_frag);
        welcomeFrag = fm.findFragmentById(R.id.welcome_frag);

        menu = (FloatingActionMenu) findViewById(R.id.bt_menu);

        hideFrag(statesFrag);
        hideFrag(devolutionFrag);
        showFrag(welcomeFrag);

        btRent = (FloatingActionButton) findViewById(R.id.bt_rent);
        btRent.setOnClickListener(v -> {
            menu.hideMenu(true);
            hideFrag(welcomeFrag);
            showFrag(statesFrag);
        });

        btDevolve = (FloatingActionButton) findViewById(R.id.bt_devolve);
        btDevolve.setOnClickListener(v -> {
            menu.hideMenu(true);
            hideFrag(welcomeFrag);
            showFrag(devolutionFrag);
        });

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    private void showFrag(Fragment fragment) {
        FragmentTransaction ft = fm.beginTransaction();
        if(menu.isShown()){
            ft.setCustomAnimations(R.anim.slide_in_right, R.anim.slide_out_left);
        }else{
            ft.setCustomAnimations(android.R.anim.slide_in_left, android.R.anim.slide_out_right);

        }

        ft.show(fragment);
        ft.commit();
    }

    private void hideFrag(Fragment fragment) {
        FragmentTransaction ft = fm.beginTransaction();
        if(menu.isShown()){
            ft.setCustomAnimations(R.anim.slide_in_right, R.anim.slide_out_left);
        }else{
            ft.setCustomAnimations(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
        }
        ft.hide(fragment);
        ft.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_alucar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        if(menu.isShown()){
            super.onBackPressed();
            return;
        }
        hideFrag(statesFrag);
        hideFrag(devolutionFrag);
        showFrag(welcomeFrag);

        menu.showMenu(true);
    }

}
