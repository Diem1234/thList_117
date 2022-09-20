package com.example.th_list_117;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lvta;
    ArrayList<ThucAn> arrayThucan;
    ThucanAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AnhXa();
        adapter = new ThucanAdapter(this, R.layout.layout_listview,arrayThucan);
        lvta.setAdapter(adapter);
        lvta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doOpenMainActivity2();

            }
        });
        lvta.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                XacNhanXoa(i);

                return false;
            }
        });

    }
    private void AnhXa() {
        lvta = (ListView) findViewById(R.id.lvThucan);
        arrayThucan = new ArrayList<>();
        arrayThucan.add(new ThucAn("Bánh Khọt_ Nguyễn Đặng Kiều Diểm","bánh ngon giòn thơm_2050531200117",R.drawable.banhkhot));
        arrayThucan.add(new ThucAn("Bánh Rán","bánh mềm hấp dẫn",R.drawable.banhran));
        arrayThucan.add(new ThucAn("Cơm cuộn","siêu thơm ngon",R.drawable.comcuon));
        arrayThucan.add(new ThucAn("hamberger","bánh theo hướng tai",R.drawable.hamberger));

    }
    private void XacNhanXoa(final int position){

        AlertDialog.Builder alerDiaLog = new AlertDialog.Builder(this);
        alerDiaLog.setTitle("Thong bao !");
        alerDiaLog.setIcon(R.mipmap.ic_launcher);
        alerDiaLog.setMessage("Bạn có muốn xóa hay không?");

        alerDiaLog.setPositiveButton("Có", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                arrayThucan.remove(position);
                adapter.notifyDataSetChanged();

            }
        });
        alerDiaLog.setNegativeButton("Không", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });

        alerDiaLog.show();
    }
    public void doOpenMainActivity2()
    {
        Intent myIntent=new Intent(this, MainActivity2.class);
        startActivity(myIntent);
    }
}