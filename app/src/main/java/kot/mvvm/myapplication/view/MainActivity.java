package kot.mvvm.myapplication.view;

import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Surface;
import android.view.View;
import android.view.WindowManager;
import android.widget.MediaController;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.PopupMenu;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;

import java.util.ArrayList;

import kot.mvvm.myapplication.R;
import kot.mvvm.myapplication.data.Video_model;
import kot.mvvm.myapplication.databinding.ActivityMainBinding;
import kot.mvvm.myapplication.utils.ItemClickListener;
import kot.mvvm.myapplication.viewmodel.VideoViewModel;

public class MainActivity extends AppCompatActivity implements ItemClickListener, PopupMenu.OnMenuItemClickListener {

    ActivityMainBinding activityMainBinding;
    VideoViewModel videoViewModel;
    ArrayList<Video_model> itemList;
    private MediaController mediaController;

    String tag="MainActivity";

    String titlename="Full screen";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        activityMainBinding= DataBindingUtil.setContentView(this,R.layout.activity_main);
        videoViewModel= ViewModelProviders.of(this).get(VideoViewModel.class);
        videoViewModel.getdata();
        itemList = new ArrayList();


        String fullScreen =  getIntent().getStringExtra("fullScreenInd");
        if("y".equals(fullScreen)) {
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                    WindowManager.LayoutParams.FLAG_FULLSCREEN);
            getSupportActionBar().hide();
        }


        displayresult();


        activityMainBinding.btnHD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popup = new PopupMenu(MainActivity.this, v);
                popup.setOnMenuItemClickListener(MainActivity.this);
                popup.inflate(R.menu.menu);
                Menu menu=popup.getMenu();
                menu.getItem(0).setTitle(titlename);
                popup.show();
            }
        });
    }

    public void initRecyclerView(ArrayList<Video_model> itemList){
        ItemArrayAdapter itemArrayAdapter = new ItemArrayAdapter(R.layout.item_list, itemList,this);
        activityMainBinding.recyclerview.setAdapter(itemArrayAdapter);
        activityMainBinding.recyclerview.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        activityMainBinding.recyclerview.setLayoutManager(new LinearLayoutManager(this));
        activityMainBinding.recyclerview.setItemAnimator(new DefaultItemAnimator());
    }
    public void displayresult(){

        videoViewModel.getdata().observe(this, new Observer<ArrayList<Video_model>>() {
            @Override
            public void onChanged(ArrayList<Video_model> video_models) {
                itemList=video_models;
                initRecyclerView(itemList);
            }
        });

    }
    @Override
    public void onClick(int position) {
        setupplayer(itemList.get(position).getVideo_url());

    }
    public void setupplayer(String url){
        activityMainBinding.vdVw.setVideoURI(Uri.parse(url));
        activityMainBinding.vdVw.requestFocus();


        mediaController = new MediaController(this);
        mediaController.setAnchorView(activityMainBinding.vdVw);
        activityMainBinding.vdVw.setMediaController(mediaController);
        activityMainBinding.vdVw.start();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("TAG","onDestroy");
    }

    public void fullscreen(){
        int orientation = this.getResources().getConfiguration().orientation;
        if (orientation == Configuration.ORIENTATION_PORTRAIT) {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
            titlename="Exit";


        } else {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
            titlename="Full screen";

        }
    }
    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_settings:
                fullscreen();
                return true;
            default:
                return false;
        }
    }
    public void onStart()
    {
        super.onStart();
        String first_path = "android.resource://" + getPackageName() + "/" + R.raw.test2;
        setupplayer(first_path);
        Log.d(tag, "In the onStart() event");

    }
    public void onRestart()
    {
        super.onRestart();
        Log.d(tag, "In the onRestart() event");
    }
    public void onResume()
    {
        super.onResume();
        Log.d(tag, "In the onResume() event");
    }
    public void onPause()
    {
        super.onPause();
        Log.d(tag, "In the onPause() event");
    }
    public void onStop()
    {
        super.onStop();
        Log.d(tag, "In the onStop() event");
    }
}
