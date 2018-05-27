package com.example.pc.designtest;

import android.content.DialogInterface;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

import com.special.ResideMenu.ResideMenu;
import com.special.ResideMenu.ResideMenuItem;



public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ResideMenu resideMenu;
    //private Context mContext;
    private ResideMenuItem itemHome, itemHome1;
    private ResideMenuItem itemProfile;
    private ResideMenuItem itemCalendar;
    private ResideMenuItem itemSettings;
    private ResideMenuItem itemBit;
    private ResideMenuItem itemOperations;
    private ResideMenuItem itemSearching;
    private ResideMenuItem itemAbout;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //mContext = this;
        setUpMenu();
        if (savedInstanceState == null)
            changeFragment(new HomeFragment());

    }

    private void setUpMenu() {

        // attach to current activity;
        resideMenu = new ResideMenu(this);

        resideMenu.setBackground(R.drawable.background_color_05 );
        resideMenu.attachToActivity(this);
        resideMenu.setMenuListener(menuListener);
        //valid scale factor is between 0.0f and 1.0f. leftmenu'width is 150dip.
        resideMenu.setScaleValue(0.6f);

        // create menu items;
        itemHome = new ResideMenuItem(this, R.drawable.icon_home, "Home");
        itemHome1 = new ResideMenuItem(this, R.drawable.icon_home, "Home");
        itemProfile = new ResideMenuItem(this, R.drawable.sorting, "Sorting");
        //itemCalendar = new ResideMenuItem(this, R.drawable.icon_calendar, "Calendar");
        //itemSettings = new ResideMenuItem(this, R.drawable.icon_settings, "Settings");
        itemBit = new ResideMenuItem(this, R.drawable.binary, "Bit Manipulations");
        itemOperations = new ResideMenuItem(this, R.drawable.datastructure, "Data Structure");
        itemSearching = new ResideMenuItem( this, R.drawable.search, "Searching");
        itemAbout = new ResideMenuItem( this, R.drawable.about_logo, "About");

        itemHome.setOnClickListener(this);
        itemHome1.setOnClickListener(this);
        itemProfile.setOnClickListener(this);
        //itemCalendar.setOnClickListener(this);
        //itemSettings.setOnClickListener(this);
        itemBit.setOnClickListener(this);
        itemOperations.setOnClickListener(this);
        itemSearching.setOnClickListener(this);
        itemAbout.setOnClickListener(this);

        resideMenu.addMenuItem(itemHome, ResideMenu.DIRECTION_LEFT);
        resideMenu.addMenuItem(itemHome1, ResideMenu.DIRECTION_RIGHT);
        resideMenu.addMenuItem(itemProfile, ResideMenu.DIRECTION_LEFT);
        //resideMenu.addMenuItem(itemCalendar, ResideMenu.DIRECTION_RIGHT);
        //resideMenu.addMenuItem(itemSettings, ResideMenu.DIRECTION_RIGHT);
        resideMenu.addMenuItem(itemAbout, ResideMenu.DIRECTION_RIGHT);
        resideMenu.addMenuItem(itemBit, ResideMenu.DIRECTION_LEFT);
        resideMenu.addMenuItem(itemOperations, ResideMenu.DIRECTION_LEFT);
        resideMenu.addMenuItem(itemSearching, ResideMenu.DIRECTION_RIGHT);
        // You can disable a direction by setting ->
        // resideMenu.setSwipeDirectionDisable(ResideMenu.DIRECTION_RIGHT);

        findViewById(R.id.title_bar_left_menu).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resideMenu.openMenu(ResideMenu.DIRECTION_LEFT);
            }
        });
        findViewById(R.id.title_bar_right_menu).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resideMenu.openMenu(ResideMenu.DIRECTION_RIGHT);
            }
        });
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        return resideMenu.dispatchTouchEvent( ev );

    }

    @Override
    public void onClick(View view) {

        if (view == itemHome) {
            changeFragment(new HomeFragment());
        }
        else if( view == itemHome1 )
        {
            changeFragment(new HomeFragment() );
        }
        else if (view == itemProfile) {
            changeFragment(new ProfileFragment());
        } else if (view == itemBit) {
            SlideStop();
            changeFragment(new BitsActivity() );
        }else if( view == itemOperations ){
            SlideStop(); // stop slide for this operation
            changeFragment( new DsActivity() );
        }
        else if( view == itemSearching )
        {
            SlideStop();
            changeFragment( new SearchFragment() );
        }else if (view == itemAbout) {
            changeFragment(new AboutFragment());
        }

        resideMenu.closeMenu();
    }

    private ResideMenu.OnMenuListener menuListener = new ResideMenu.OnMenuListener() {
        @Override
        public void openMenu() {
            //Toast.makeText(mContext, "Menu is opened!", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void closeMenu() {
            //Toast.makeText(mContext, "Menu is closed!", Toast.LENGTH_SHORT).show();
        }
    };

    private void changeFragment(Fragment targetFragment) {
        resideMenu.clearIgnoredViewList();
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.main_fragment, targetFragment, "fragment")
                .setTransitionStyle(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .commit();
    }

    // What good method is to access resideMenu？
    public ResideMenu getResideMenu() {
        return resideMenu;
    }

    // Stop Slide
    public void SlideStop()
    {
        resideMenu.setSwipeDirectionDisable(ResideMenu.DIRECTION_RIGHT);
        resideMenu.setSwipeDirectionDisable(ResideMenu.DIRECTION_LEFT);
    }

    @Override
    public void onBackPressed() {

        final AlertDialog.Builder aleartdialog;

        aleartdialog = new AlertDialog.Builder(MainActivity.this);
        aleartdialog.setIcon(R.drawable.check_symbol);
        aleartdialog.setTitle(R.string.exit_text);
        aleartdialog.setCancelable(false);

        aleartdialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        aleartdialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        AlertDialog alertDialog = aleartdialog.create();
        aleartdialog.show();


    }
}
