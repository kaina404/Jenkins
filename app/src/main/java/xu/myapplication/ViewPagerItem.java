package xu.myapplication;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by lovexujh on 2017/8/11
 */

public class ViewPagerItem extends LinearLayout implements AbsListView.OnScrollListener {

    private ListView listView;
    private MyListViewAdapter adapter;

    public ViewPagerItem(Context context) {
        this(context, null);
    }

    public ViewPagerItem(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ViewPagerItem(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));
        listView = new ListView(getContext());
        listView.setLayoutParams(new AbsListView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        adapter = new MyListViewAdapter(new ArrayList<String>(), getContext());
        listView.setAdapter(adapter);
        listView.setOnScrollListener(this);
        addView(listView);
    }

    public void setData(ArrayList<String> list) {
        adapter.setData(list);
    }

    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {

    }

    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

    }
}
