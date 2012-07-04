package com.wetongji;

import java.util.ArrayList;
import java.util.List;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;

import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.viewpagerindicator.TitlePageIndicator;

public class ActivityMainViewpager extends SherlockFragmentActivity {
    
    private ViewPager mPager;//ҳ������
    private List<View> listViews; // Tabҳ���б�
    
    
    private TitlePageIndicator indicator;
    
    
    
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        
        this.setContentView(R.layout.app_main_viewpager);
                   
        setTitle("΢ͬ��");
        
        InitViewPager();
        
    }


  
    
    
    /**
     * ��ʼ��ViewPager
     */
    private void InitViewPager() {
        mPager = (ViewPager) findViewById(R.id.widget_main_viewpager);
        listViews = new ArrayList<View>();
        LayoutInflater mInflater = getLayoutInflater();
        listViews.add(mInflater.inflate(R.layout.lay1, null));
        listViews.add(mInflater.inflate(R.layout.lay2, null));
        listViews.add(mInflater.inflate(R.layout.lay3, null));
        
        mPager.setAdapter(new WTMainFragmentAdapter(getResources(), getSupportFragmentManager()));
        mPager.setCurrentItem(0);
        //mPager.setOnPageChangeListener(new MyOnPageChangeListener());
        
        //��ʼ��ָʾ��
        indicator = (TitlePageIndicator) findViewById(R.id.widget_viewpager_header);
        indicator.setViewPager(mPager);

    }
    
    
 
    
    
    /**
     * ͷ��������
    */
    public class MyOnClickListener implements View.OnClickListener {
        private int index = 0;

        public MyOnClickListener(int i) {
            index = i;
        }

        public void onClick(View v) {
            mPager.setCurrentItem(index);
        }
    };     
    
    
    
}




