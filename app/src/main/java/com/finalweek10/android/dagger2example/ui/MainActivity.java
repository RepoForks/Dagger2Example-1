package com.finalweek10.android.dagger2example.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.finalweek10.android.dagger2example.ExampleApplication;
import com.finalweek10.android.dagger2example.R;
import com.finalweek10.android.dagger2example.data.SaveLocationHelper;
import com.finalweek10.android.dagger2example.data.model.IssNow;
import com.finalweek10.android.dagger2example.data.model.IssService;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.text_view)
    TextView mTextView;

    @Inject
    SaveLocationHelper mSaveLocationHelper;
    @Inject
    IssService mIssService;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        ExampleApplication.getApplication(this).getDataComponent().inject(this);

        mTextView.setText(mSaveLocationHelper.get("Not available now"));

        mIssService.getIssNow()
                .enqueue(new Callback<IssNow>() {
                             @Override
                             public void onResponse(Call<IssNow> call, Response<IssNow> response) {
                                 String location = response.body().getIssPosition().getLatitude() +
                                         ", " +
                                         response.body().getIssPosition().getLongitude();
                                 mSaveLocationHelper.put(location);
                                 mTextView.setText(location);
                             }

                             @Override
                             public void onFailure(Call<IssNow> call, Throwable t) {

                             }
                         }
                );

//        Bad practice
//        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
//        mTextView.setText(preferences.getString("iss_loc", "No available data"));
//
//        new Retrofit.Builder()
//                .addConverterFactory(GsonConverterFactory.create())
//                .baseUrl("http://api.open-notify.org")
//                .build()
//                .create(IssService.class)
//                .getIssNow()
//                .enqueue(new Callback<IssNow>() {
//                             @Override
//                             public void onResponse(Call<IssNow> call, Response<IssNow> response) {
//                                 String location = response.body().getIssPosition().getLatitude() +
//                                         ", " +
//                                         response.body().getIssPosition().getLongitude();
//                                 mSaveLocationHelper.put(location);
//                                 mTextView.setText(location);
//                             }
//
//                             @Override
//                             public void onFailure(Call<IssNow> call, Throwable t) {
//
//                             }
//                         }
//                );
    }
}
