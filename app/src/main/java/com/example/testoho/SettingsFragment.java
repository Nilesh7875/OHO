package com.example.testoho;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;


public class SettingsFragment extends Fragment {
    private ListView listView;
    private String maincontent[]={"Account","Privacy","Notification Settings","Sign Out","About App","FAQ"};
    private String subcontent[]={"Manage Account","Manage Privacy","Manage Notifications","","v1.0.0","Queries"};
    int images[]={R.drawable.accountlogo,R.drawable.privacy,R.drawable.notification,R.drawable.signout,R.drawable.aboutapp,R.drawable.faq};
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_settings,container,false);
        listView=view.findViewById(R.id.settings_listview);
        MyAdapter myAdapter=new MyAdapter();
        listView.setAdapter(myAdapter);

        return view;
    }
    public class MyAdapter extends BaseAdapter {
        Context context;
        String rTitle[];
        String rDescription[];
        int rImage[];


        @Override
        public int getCount() {
            return maincontent.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = getLayoutInflater().inflate(R.layout.listviewcontent,null);
            ImageView mImageView=view.findViewById(R.id.listviewimage);
            TextView main=view.findViewById(R.id.maincontent);
            TextView sub=view.findViewById(R.id.subcontent);
            mImageView.setImageResource(images[position]);
            main.setText(maincontent[position]);
            sub.setText(subcontent[position]);
            return view;
        }
    }
}
