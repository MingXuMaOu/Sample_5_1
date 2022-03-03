package com.example.sample_5_1;

import android.util.Xml;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * @author: liuming
 * @date: 2022/3/3
 */
public class MyThread extends Thread{
    private MainActivity mActivity;
    private URLConnection ucon;
    private BufferedInputStream bin;
    private ByteArrayOutputStream buffer;
    private boolean flag = false;

    public MyThread(MainActivity activity){
        mActivity = activity;
    }

    @Override
    public void run() {
        super.run();
        try{
            URL url = new URL("https://www.baidu.com");
            ucon = url.openConnection();
            flag = true;
        }catch (Exception e){
            e.printStackTrace();
        }
        while (flag){
            try {
                bin = new BufferedInputStream(ucon.getInputStream());
                buffer = new ByteArrayOutputStream();
                byte[] data = new byte[1024];
                int current = 0;

                while ((current = bin.read(data, 0, data.length)) != -1) {
                    buffer.write(data, 0, current);
                }
                if(bin != null){
                    bin.close();
                }
                flag = false;
                mActivity.str = new String(buffer.toByteArray(),"UTF-8");
                mActivity.mHandler.post(mActivity.mRunnable);
            }catch (Exception e){
                e.printStackTrace();
            }

        }
    }
}
