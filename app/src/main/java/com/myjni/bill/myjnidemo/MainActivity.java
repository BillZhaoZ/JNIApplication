package com.myjni.bill.myjnidemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * 主界面
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("JNI开发实例");

        TextView view = (TextView) findViewById(R.id.tv_jni);
        Button btn = (Button) findViewById(R.id.btn_model);

        // 调用C方法
        String s = JniTest.javaCallC("大力牛魔王！");
        final String helloFromC = JniTest.helloFromC();
        view.setText(s);

        // 吐司
        Toast(btn, helloFromC);

        TextView textView = (TextView) findViewById(R.id.ndk_text);
        String str = JniTest.getStringFormC();

        // 加密部分
        encrypt(textView, str);
    }

    /**
     * 吐司
     *
     * @param btn
     * @param helloFromC
     */
    private void Toast(Button btn, final String helloFromC) {
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), helloFromC, Toast.LENGTH_SHORT).show();
            }
        });
    }

    /**
     * 加密
     *
     * @param textView
     * @param str
     */
    private void encrypt(TextView textView, String str) {
        String ming = "13550110110";
        String encrypmi = JniTest.encode(ming);
        String decrypmi = JniTest.decode(encrypmi);

        textView.setText("来自c的string是:" + str + "\n加密前：" + ming + "\n加密后：" + encrypmi + "\n解密后：" + decrypmi);
    }

}
