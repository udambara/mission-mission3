package com.example.android.ex3_readurl;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity implements TextView.OnEditorActionListener {
    ImageView ivoutput;
    TextView tvoutput;
    EditText etinput;
    EditText etinputurl;
    Button btnsave;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }
    void init(){
        ivoutput = (ImageView)findViewById(R.id.iv_output);
        tvoutput = (TextView)findViewById(R.id.tv_output);
        etinput = (EditText)findViewById(R.id.et_input);
        etinputurl = (EditText)findViewById(R.id.et_inputurl);
        btnsave = (Button)findViewById(R.id.btn_save);

        etinput.setOnEditorActionListener(this);
        etinputurl.setOnEditorActionListener(this);
    }

    public void onClickSave(View view){
        String input = etinput.getText().toString();

        tvoutput.setText(input);
//        try {
//            URL url = new URL(inputurl);
//            Bitmap bm = BitmapFactory.decodeStream(url.openStream());
//            ivoutput.setImageBitmap(bm);
//
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        URL url = null;
//        url = new URL("http://goo.gl/NlcLl4");
//        HttpURLConnection conn = (HttpURLConnection)url.openConnection();
//        conn.setDoInput(true);
//        conn.connect();
//        BufferedInputStream bis = new BufferedInputStream(conn.getInputStream());
//        Bitmap bm = BitmapFactory.decodeStream(bis);
//        bis.close();
//        ivoutput.setImageBitmap(bm);

        String inputurl = etinputurl.getText().toString();
        new LoadImagefromUrl().execute(ivoutput,inputurl);

        //키보드 내리기
        view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager)getSystemService(this.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    @Override
    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        if(textView.getId()==R.id.et_input && i== EditorInfo.IME_ACTION_NEXT){ // 뷰의 id를 식별, 키보드의 완료 키 입력 검출
//            String input = etinput.getText().toString();
//            tvoutput.setText(input);
        }
        if(textView.getId()==R.id.et_inputurl && i== EditorInfo.IME_ACTION_SEND){
            View view = this.getCurrentFocus();
            onClickSave(view);

        }

        return false;
    }


}
