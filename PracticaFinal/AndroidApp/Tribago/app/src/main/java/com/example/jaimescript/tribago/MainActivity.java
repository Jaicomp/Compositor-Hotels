package com.example.jaimescript.tribago;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;

import org.w3c.dom.Text;
import org.xml.sax.InputSource;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class MainActivity extends AppCompatActivity {

    private TextView txt;
    private EditText entryDateET;
    private EditText departureDateET;
    private Button searchButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ScrollView scr = new ScrollView(this);
        txt = (TextView) findViewById(R.id.roomsLabel);
        entryDateET = (EditText) findViewById(R.id.entryDateET);
        departureDateET = (EditText) findViewById(R.id.departureDateET);
        searchButton = (Button) findViewById(R.id.searchButton2);

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String entryDateText = entryDateET.getText().toString();
                String departureDateText = departureDateET.getText().toString();
                showRooms(entryDateText, departureDateText);
            }
        });



    }

    private void showRooms(String entryDate, String departureDate) {
        txt.setText("");


        WSA wsa = new WSA();
        ArrayList<Room> rooms = parsear(wsa.getRooms(entryDate, departureDate));
        String hotels = "";
        for (int i = 0; i < rooms.size(); i++) {
            hotels += "---------------\n";
            hotels += "Hotel: "+rooms.get(i).getNameHotel()
                    + " - Tipo de habitación: "+rooms.get(i).getTypeRoom()
                    + " - Número de habitaciones: "+rooms.get(i).getNumRoomsAvailable()
                    + " - Precio: "+rooms.get(i).getPrice();
            hotels += "---------------\n";

        }

        txt.setText(hotels);

    }

    private ArrayList<Room> parsear(String s) {
        ArrayList<Room> rooms = new ArrayList<Room>();
        try {
            InputStream inputStream =
                    new ByteArrayInputStream(s.getBytes("UTF-8"));
            Reader reader = new InputStreamReader(inputStream, "UTF-8");
            InputSource is = new InputSource(reader);
            is.setEncoding("UTF-8");
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            RoomHandler handler = new RoomHandler(rooms);
            saxParser.parse(is, handler);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return rooms;

    }
}
