package com.example.artoy.lab1_;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.database.DataSetObserver;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.MenuAdapter;
import android.text.Layout;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class FirstActivity extends AppCompatActivity {

    private EditText name;
    private EditText email;
    private TextView textView;
    private Button button;
    private Intent intent;

    private Button service;
    private Intent intentCustomIntentService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        name = (EditText) findViewById(R.id.name);
        email = (EditText) findViewById(R.id.email);
        textView = (TextView) findViewById(R.id.textView);
        button = (Button) findViewById(R.id.button);
        service = (Button) findViewById(R.id.service);

        intentCustomIntentService = new Intent(this, MyIntentService.class);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                textView.setText(name.getText()+ " " + email.getText());

                intent.putExtra("name", name.getText().toString());
                intent.putExtra("email", email.getText().toString());
//                intent.putStringArrayListExtra()
//                startActivity(intent);
                startActivityForResult(intent, 666);

//                BroadcastReceiver receiver = new BroadcastReceiver() {
//                    @Override
//                    public void onReceive(Context context, Intent intent) {
//
//                    }
//                }
//                PendingIntent pendingIntent = PendingIntent.getService()


            }
        });
        service.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                startService(intent);


                startService(intentCustomIntentService.putExtra("time", 3).putExtra("label", "Call 1"));
                startService(intentCustomIntentService.putExtra("time", 1).putExtra("label", "Call 2"));
                startService(intentCustomIntentService.putExtra("time", 4).putExtra("label", "Call 3"));
            }
        });
        intent = new Intent(this, TwoActivity.class);

        //ListView
        ListView listView;
//        listView.setAdapter();

//        listView.setChoiceMode(AbsListView.CHOICE_MODE_SINGLE);
        //тип listView
//        listView.getCheckedItemPosition()
//        listView.getCheckedItemPositions()

        //norifyDatasetChanged -  метод
        ListAdapter listAdapter = new ListAdapter() {
            @Override
            public boolean areAllItemsEnabled() {
                return false;
            }

            @Override
            public boolean isEnabled(int position) {
                return false;
            }

            @Override
            public void registerDataSetObserver(DataSetObserver observer) {

            }

            @Override
            public void unregisterDataSetObserver(DataSetObserver observer) {

            }

            @Override
            public int getCount() {
                return 0;
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
            public boolean hasStableIds() {
                return false;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                //если concertView не null то юзаем его
                //parent можно не юзать
                return null;
            }

            @Override
            public int getItemViewType(int position) {
                return 0;
            }

            @Override
            public int getViewTypeCount() {
                return 0;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }
        };
//        ArrayAdapter arrayAdapter = new ArrayAdapter();

//        ListView listView = new ListView();
//        listView.setAdapter(listAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        String name = data.getStringExtra("name");
        textView.setText(name);
    }

//

/**
 * lab3 - 3 сервиса
 * service
 * intentservice
 *
 * aidl
 * broadcast receiver  -  для передачи данных му сервисом
 * pendingIntent
 *
 *
 *
 * lab4 listview с загрузкой по требованиею
 */
}
