package com.example.sample_5_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class MainActivity extends AppCompatActivity {

    private EditText mEditText;
    private Button mButton;
    private TextView mTextView;
    private ScrollView mScrollView;
    public Handler mHandler;
    public String str;
    private MyThread mThread;
    public Runnable mRunnable = new Runnable() {
        @Override
        public void run() {
            mTextView.setText("服务器发来的消息：" + str);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mTextView = new TextView(this);
        mScrollView = new ScrollView(this);
        mTextView.setText("正在加载__");
        mScrollView.addView(mTextView);
        setContentView(mScrollView);
        mHandler = new Handler();

        mThread = new MyThread(this);
        mThread.start();


//        setContentView(R.layout.activity_main);

//        mEditText = findViewById(R.id.editText);
//        mButton = findViewById(R.id.button1);
//        mTextView = findViewById(R.id.textView);
//        mHandler = new Handler();
//
//        mButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                new Thread(new Runnable() {
//                    @Override
//                    public void run() {
//                        boolean flag = false;
//                        Socket s = null;
//                        DataOutputStream dout = null;
//                        DataInputStream din = null;
//                        try{
//                            s = new Socket("192.168.10.10",8888);
//                            flag = true;
//                        }catch (Exception e){
//                            e.printStackTrace();
//                        }
//                        while (flag){
//                            try{
//                                dout = new DataOutputStream(s.getOutputStream());
//                                din = new DataInputStream(s.getInputStream());
//                                dout.writeUTF(mEditText.getText().toString());
//                                str = din.readUTF();
//                                if(dout != null){
//                                    dout.close();
//                                }
//                                if(din != null){
//                                    din.close();
//                                }
//                                flag = false;
//                                if(s != null){
//                                    s.close();
//                                }
//                                mHandler.post(mRunnable);
//                            }catch (Exception e){
//                                e.printStackTrace();
//                            }
//                        }
//                    }
//                }).start();
//            }
//        });

    }
}