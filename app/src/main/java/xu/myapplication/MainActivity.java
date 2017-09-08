package xu.myapplication;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.util.Log;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class MainActivity extends FragmentActivity {

    private ViewPager viewPager;
    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private Observable<Integer> observable = Observable.create(new ObservableOnSubscribe<Integer>() {
        @Override
        public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
            emitter.onNext(1);
            emitter.onNext(2);
            emitter.onNext(3);
//            emitter.onComplete();
            emitter.onError(new Throwable("错误"));
            emitter.onNext(4);
        }
    });

    private Observer<Integer> observer = new Observer<Integer>() {
        @Override
        public void onSubscribe(Disposable d) {
            Log.e(TAG, "onSubscribe");
        }

        @Override
        public void onNext(Integer value) {
            Log.e(TAG, "onNext VALUE = " + value);

        }

        @Override
        public void onError(Throwable e) {
            Log.e(TAG, "onError" + e.toString());

        }

        @Override
        public void onComplete() {
            Log.e(TAG, "onComplete");

        }
    };

    private void init() {
        observable.subscribe(observer);
    }


}
