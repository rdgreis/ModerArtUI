package com.rodrigoreis.moderartui;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SurfaceView;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;

public class MainActivity extends ActionBarActivity {

    private SeekBar mSeekBar;
    public SurfaceView box1;
    private SurfaceView box2;
    private SurfaceView box3;
    private SurfaceView box4;
    private SurfaceView box5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final SurfaceView box1 = (SurfaceView) findViewById(R.id.box1);
        final SurfaceView box2 = (SurfaceView) findViewById(R.id.box2);
        final SurfaceView box3 = (SurfaceView) findViewById(R.id.box3);
        final SurfaceView box4 = (SurfaceView) findViewById(R.id.box4);
        final SurfaceView box5 = (SurfaceView) findViewById(R.id.box5);

        mSeekBar = (SeekBar)findViewById(R.id.seekbar);
        //mSeekBar.setOnSeekBarChangeListener(this);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
}
