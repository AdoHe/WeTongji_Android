package com.wetongji;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextPaint;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ViewFlipper;

import com.actionbarsherlock.app.SherlockActivity;

public class ActivitySignin extends SherlockActivity {

    private ViewFlipper viewflipper;
    private Button btn_back, btn_next;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app_signin);
        
        setTitle(getResources().getString(R.string.register_new_account));
        
        initWidget();
    }
    
    private void initWidget() {
        viewflipper = (ViewFlipper) findViewById(R.id.widget_rg_viewflipper);
        
        btn_back = (Button) findViewById(R.id.btn_back);
        btn_back.setOnClickListener(btnOnClickListener);
        btn_next = (Button) findViewById(R.id.btn_ok);
        btn_next.setOnClickListener(btnOnClickListener);
        
        
        // ���ı������óɴ���
        TextView tv_user_protocol_title = (TextView) findViewById(R.id.tv_user_protocol_title);
        TextPaint tp = tv_user_protocol_title.getPaint();
        tp.setFakeBoldText(true);
        
    }
    
    private OnClickListener btnOnClickListener = new OnClickListener() {

        @Override
        public void onClick(View view) {
            // TODO Auto-generated method stub
            switch(view.getId()) {
            case R.id.btn_back:
                
                if(viewflipper.indexOfChild(viewflipper.getCurrentView()) != 0) {
                    // ��һ��
                    viewflipper.showPrevious();                    
                }
                else {
                    finish();
                }
                break;
            case R.id.btn_ok:
                if(viewflipper.indexOfChild(viewflipper.getCurrentView()) == 1) {
                    // ��һ��
                    viewflipper.showNext();
                }
                else if(viewflipper.indexOfChild(viewflipper.getCurrentView()) == 0) {
                    // ȷ��ͬ���û�Э��
                    
                    new AlertDialog.Builder(ActivitySignin.this)
                    .setTitle(R.string.ensure_agree_user_protocol)
                    .setMessage(R.string.ensure_user_protocol_dialog_message)
                    .setPositiveButton(R.string.ensure,
                            new DialogInterface.OnClickListener() {
                                
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    // TODO Auto-generated method stub
                                    viewflipper.showNext();
                                }
                            })
                    .setNegativeButton(R.string.cancle, null).show();
                }
                else {
                    // ע��
                }
                break;
            }
        }

    };

}
