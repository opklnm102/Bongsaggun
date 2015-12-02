package io.j2ffrey_2.bongsaggun;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import butterknife.Bind;
import butterknife.ButterKnife;
import io.j2ffrey_2.bongsaggun.homelist.HomeListItem;
import io.j2ffrey_2.bongsaggun.model.Token;
import io.j2ffrey_2.bongsaggun.model.User;
import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

public class SigninActivity extends BaseActivity {

    public static final String TAG = SigninActivity.class.getSimpleName();

    @Bind(R.id.toolbar_signIn)
    Toolbar mToolbar;
    @Bind(R.id.editText_email)
    EditText etEmail;
    @Bind(R.id.editText_password)
    EditText etPassword;
    @Bind(R.id.container_facebook_signIn)
    LinearLayout linearFacebookSignIn;
    @Bind(R.id.button_signIn)
    Button btnSignIn;
    @Bind(R.id.textView_signUp)
    TextView tvSignUp;
    @Bind(R.id.textView_search)
    TextView tvSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
        ButterKnife.bind(this);

        setSupportActionBar(mToolbar);

        final ActionBar ab = getSupportActionBar();
        if (ab != null) {
            ab.setDisplayShowTitleEnabled(false);
            ab.setDisplayHomeAsUpEnabled(true);
        }

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String email = etEmail.getText().toString().trim();
                String password = etPassword.getText().toString().trim();

                doSignin(email, password);
            }
        });

        tvSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Todo: 회원가입 홈페이지로 연결?
            }
        });

        tvSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Todo: 회원가입 홈페이지로 연결?
            }
        });

        linearFacebookSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Todo: facebook 로그인
            }
        });
    }


    public void doSignin(String email, String password) {

        Call<JsonObject> call = requestHelper.doSignIn(email, password);

        call.enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Response<JsonObject> response, Retrofit retrofit) {

                JsonObject jsonObject = response.body();

                if (jsonObject != null) {

                    Log.d(TAG, " jsonObject is " + jsonObject);

                    Token token = new Gson().fromJson(jsonObject.getAsJsonObject("Token"), Token.class);

                    if (token.getStatus() == 200) {  //로그인 성공

                        Toast.makeText(SigninActivity.this, "로그인 성공", Toast.LENGTH_LONG).show();

                        User user = new Gson().fromJson(jsonObject.getAsJsonObject("User"), User.class);

                        //Todo: 유저정보 저장하고 전 액티비티로 돌아가기 + 프로필, 찜목록 갱신
                        putPreferenceUid(user.getId());

                        finish();
                    } else if (token.getStatus() == 403) {  //로그인 실패
                        //로그인 정보 잘못됨
                        Toast.makeText(SigninActivity.this, "Email이나 비밀번호가 잘못되었습니다.", Toast.LENGTH_LONG).show();
                    }
                }
            }

            @Override
            public void onFailure(Throwable t) {
                Log.e(TAG, " Throwable is " + t);
            }
        });
    }

//    private boolean checkEmail(String email)
//
//    {
//
//        String mail = "^[_a-zA-Z0-9-\\.]+@[\\.a-zA-Z0-9-]+\\.[a-zA-Z]+$";
//
//        Pattern p = Pattern.compile(mail);
//
//        Matcher m = p.matcher(email);
//
//        return m.matches();
//
//    }

}
