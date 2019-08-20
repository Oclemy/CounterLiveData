package info.camposha.counterlivedata;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.Timer;
import java.util.TimerTask;


public class MyViewModel extends ViewModel {

    //MutableLiveData is a LiveData which publicly exposes setValue(T) and
    // postValue(T) method.
    private MutableLiveData<Integer> mutableLiveData=new MutableLiveData<>();

    private static int BEGIN_AFTER = 1000, INTERVAL = 1000;
    private static int counter = 0;

    private void startTimer(){
        Timer timer=new Timer();
        //Schedule the specified task for repeated fixed-rate execution,
        // beginning after the specified delay. Subsequent executions
        // take place at approximately regular intervals, separated by
        // the specified period.
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                mutableLiveData.postValue(counter++);
            }
        },BEGIN_AFTER,INTERVAL);
    }
    //Constructor
    public MyViewModel(){
       startTimer();
    }
    public MutableLiveData<Integer> getLiveData() {
        return mutableLiveData;
    }
}
//end
