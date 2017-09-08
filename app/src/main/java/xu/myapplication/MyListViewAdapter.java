package xu.myapplication;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lovexujh on 2017/8/11
 */

public class MyListViewAdapter extends BaseAdapter {

    private static final int TYPE_1 = 0;
    private static final int TYPE_2 = 1;
    private Context context;
    private List<String> datas = new ArrayList<>();

    public MyListViewAdapter(List<String> datas, Context context) {
        this.datas.clear();
        this.context = context;
        this.datas.addAll(datas);
    }

    @Override
    public int getCount() {
        return datas.size();
    }

    @Override
    public Object getItem(int position) {
        return datas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {
        if (position % 9 == 0) {
            return TYPE_1;
        } else {
            return TYPE_2;
        }
    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
//        ViewHolder viewHolder;
//        if (convertView == null) {
//            convertView = LayoutInflater.from(context).inflate(R.layout.item_2, null);
//            viewHolder = new ViewHolder();
//            viewHolder.textView = (TextView) convertView.findViewById(R.id.tv);
//            viewHolder.textView2 = (TextView) convertView.findViewById(R.id.tv2);
//            convertView.setTag(viewHolder);
//        }
//        viewHolder = (ViewHolder) convertView.getTag();
//
//        viewHolder.textView2.setText(datas.get(position));
//        if (getItemViewType(position) == TYPE_2) {
//            viewHolder.textView.setText(datas.get(position));
//            ViewHolder
//        }
        return convertView;
    }

    public void setData(ArrayList<String> data) {
        this.datas = data;
        notifyDataSetChanged();
    }

    private class ViewHolder {
        public TextView textView;
        public TextView textView2;
    }
}
