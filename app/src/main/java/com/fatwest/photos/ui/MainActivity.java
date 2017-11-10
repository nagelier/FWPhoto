package com.fatwest.photos.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.fatwest.photos.ui.adapter.MainAdapter;

import photos.fatwest.com.fwphotos.R;
import recycler.coverflow.CoverFlowLayoutManger;
import recycler.coverflow.RecyclerCoverFlow;

public class MainActivity extends AppCompatActivity {

    private RecyclerCoverFlow mRecyclerCoverFlow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initListView();
    }

    private void initListView(){
        mRecyclerCoverFlow = (RecyclerCoverFlow)findViewById(R.id.photos_list);
        mRecyclerCoverFlow.setFlatFlow(true); //平面滚动
        mRecyclerCoverFlow.setAdapter(new MainAdapter(this));
        mRecyclerCoverFlow.setOnItemSelectedListener(new CoverFlowLayoutManger.OnSelected() {
            @Override
            public void onItemSelected(int position) {
                int itemCount = mRecyclerCoverFlow.getLayoutManager().getItemCount();
            }
        });
    }
}
