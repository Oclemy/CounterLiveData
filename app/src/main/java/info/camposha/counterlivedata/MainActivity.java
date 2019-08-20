package info.camposha.counterlivedata;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

public class MainActivity extends AppCompatActivity {

    private void renderUpdates(){
        final TextView timerTV=findViewById(R.id.tvCounter);
        MyViewModel myViewModel = ViewModelProviders.of(this).get(MyViewModel.class);

        Observer<Integer> liveDataObserver=new Observer<Integer>() {
            @Override
            public void onChanged(@Nullable Integer integer) {
                timerTV.setText("Elapsed : "+integer+ " s");
            }
        };
        myViewModel.getLiveData().observe(this,liveDataObserver);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.renderUpdates();
    }
}