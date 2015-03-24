package com.rodrigoreis.moderartui;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SurfaceView;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.content.Intent;
import android.net.Uri;

public class MainActivity extends ActionBarActivity implements OnSeekBarChangeListener{

    private DialogFragment mDialog;
    private SeekBar mSeekBar;
    SurfaceView box1;
    SurfaceView box2;
    SurfaceView box4;
    SurfaceView box5;
    private int box1Color = 0xff6275ff;
    private int box2Color = 0xff6cff67;
    private int box4Color = 0xffff357f;
    private int box5Color = 0xfffffc61;
    private int vSeekBar = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final SurfaceView box1 = (SurfaceView) findViewById(R.id.box1);
        final SurfaceView box2 = (SurfaceView) findViewById(R.id.box2);
        final SurfaceView box4 = (SurfaceView) findViewById(R.id.box4);
        final SurfaceView box5 = (SurfaceView) findViewById(R.id.box5);

        mSeekBar = (SeekBar)findViewById(R.id.seekbar);
        mSeekBar.setOnSeekBarChangeListener(this);

        box1.setBackgroundColor(box1Color);
        box2.setBackgroundColor(box2Color);
        box4.setBackgroundColor(box4Color);
        box5.setBackgroundColor(box5Color);
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
            showDialogFragment();
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        box1 = (SurfaceView) findViewById(R.id.box1);
        box2 = (SurfaceView) findViewById(R.id.box2);
        box4 = (SurfaceView) findViewById(R.id.box4);
        box5 = (SurfaceView) findViewById(R.id.box5);
        Double tmpValue = mSeekBar.getProgress()*0.050;

        if (mSeekBar.getProgress() > vSeekBar){
            box1Color = box1Color + tmpValue.intValue();
            box2Color = box2Color + tmpValue.intValue();
            box4Color = box4Color + tmpValue.intValue();
            box5Color = box5Color + tmpValue.intValue();
        }
        else{
            box1Color = box1Color - tmpValue.intValue();
            box2Color = box2Color - tmpValue.intValue();
            box4Color = box4Color - tmpValue.intValue();
            box5Color = box5Color - tmpValue.intValue();
        }
        vSeekBar = mSeekBar.getProgress();
        box1.setBackgroundColor(box1Color);
        box2.setBackgroundColor(box2Color);
        box4.setBackgroundColor(box4Color);
        box5.setBackgroundColor(box5Color);
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
    }

    // Show desired Dialog
    void showDialogFragment() {

        // Create a new AlertDialogFragment
        mDialog = AlertDialogFragment.newInstance();

        // Show AlertDialogFragment
        mDialog.show(getFragmentManager(), "Alert");

    }

    // Class that creates the AlertDialog
    public static class AlertDialogFragment extends DialogFragment {

        public static AlertDialogFragment newInstance() {
            return new AlertDialogFragment();
        }

        // Build AlertDialog using AlertDialog.Builder
        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            return new AlertDialog.Builder(getActivity())
                    .setMessage(R.string.dialog_message)

                            // User cannot dismiss dialog by hitting back button
                    .setCancelable(false)

                    // Set up Yes Button
                    .setPositiveButton(R.string.visit_moma,
                            new DialogInterface.OnClickListener() {
                                public void onClick(
                                        final DialogInterface dialog, int id) {
                                    String url = "http://www.moma.org";
                                    Intent i = new Intent(Intent.ACTION_VIEW);
                                    i.setData(Uri.parse(url));
                                    startActivity(i);
                                }
                            })

                    // Set up No Button
                    .setNegativeButton(R.string.not_now,
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog,
                                                    int id) {
                                    System.out.println("No");
                                }
                            }).create();
        }
    }
}
