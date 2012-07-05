package com.wetongji;

import java.util.ArrayList;
import java.util.HashMap;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.SimpleAdapter;

public class WTDashboardFragment extends Fragment {

    static  int LAYOUT_ID;
    private GridView grid_dashboard;
    
    public static WTDashboardFragment newInstance(int layout_id){
        WTDashboardFragment f = new WTDashboardFragment();

        // Supply LAYOUT_ID input as an argument.
        Bundle args = new Bundle();
        args.putInt("layout_id", layout_id);
        f.setArguments(args);

        return f;
    }
    
    
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        LAYOUT_ID = getArguments() != null ? getArguments().getInt("layout_id") : R.layout.app_square_fragment;                
        
    }



    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onActivityCreated(savedInstanceState);
        
        
        grid_dashboard = (GridView)getActivity().findViewById(R.id.widget_square_gridview);
        //��̬����
        ArrayList<HashMap<String, Object>> lstImageItem = new ArrayList<HashMap<String, Object>>();
        
        
        // ������Դid����
        Integer[] grid_item_ids = {R.drawable.ic_square_griditem_news,
                                    R.drawable.ic_square_griditem_activity,
                                    R.drawable.ic_square_griditem_favorites,
                                    R.drawable.ic_square_griditem_shedule,
                                    R.drawable.ic_square_griditem_freshman,
                                    R.drawable.ic_square_griditem_personal};
        
        
        for(int i = 0; i < grid_item_ids.length; i++)  
        {  
            HashMap<String, Object> map = new HashMap<String, Object>();
            map.put("ItemImage", grid_item_ids[i]); //���ͼ����Դ��ID  
            lstImageItem.add(map);
        }  
        
        SimpleAdapter saImageItems = new SimpleAdapter(getActivity(), 
                lstImageItem,//������Դ   
                R.layout.square_grid_item,//item��XMLʵ��  
                  
                //��̬������ImageItem��Ӧ������          
                new String[] {"ItemImage"},   
                  
                //ImageItem��XML�ļ������һ��ImageView  
                new int[] {R.id.img_square_grid_item});
        
        grid_dashboard.setAdapter(saImageItems);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        
        View v = inflater.inflate(R.layout.app_square_fragment, container, false); 
        
        return v;
    }

}
