package com.kamal.tugassensor10120170;

/*
NIM     : 10120170
Nama    : Moch. Kamaludin Ichsan
Kelas   : IF5
 */

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MakanFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Initialize view
        View view = inflater.inflate(R.layout.fragment_lokasi, container, false);

        SupportMapFragment mapFragment=(SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.google_map);

        // check condition
        if (ContextCompat.checkSelfPermission(getActivity(), android.Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED && ContextCompat.checkSelfPermission(getActivity(),
                android.Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED) {

            mapFragment.getMapAsync(googleMap -> {
                //Lokasi 1
                LatLng lokasi1 = new LatLng(-6.888108018266617, 107.62089733868233);
                MarkerOptions options1 = new MarkerOptions().position(lokasi1).title("Warteg Bu Tatang");
                //Lokasi 2
                LatLng lokasi2 = new LatLng(-6.888689111322898, 107.61842152391347);
                MarkerOptions options2 = new MarkerOptions().position(lokasi2).title("Warkop ADD");
                //Lokasi 3
                LatLng lokasi3 = new LatLng(-6.889955509274657, 107.61631278528796);
                MarkerOptions options3 = new MarkerOptions().position(lokasi3).title("Waroeng Steak Dipatiukur");
                //Lokasi 4
                LatLng lokasi4 = new LatLng(-6.894386965513256, 107.6173616797339);
                MarkerOptions options4 = new MarkerOptions().position(lokasi4).title("Bebek Om Aris");
                //Lokasi 5
                LatLng lokasi5 = new LatLng(-6.888629662672997, 107.61876295274917);
                MarkerOptions options5 = new MarkerOptions().position(lokasi5).title("Warkop Jago Rasa");

                googleMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
                googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(lokasi3,17));
                googleMap.addMarker(options1);
                googleMap.addMarker(options2);
                googleMap.addMarker(options3);
                googleMap.addMarker(options4);
                googleMap.addMarker(options5);


            });
        }
        else {
            // When permission is not granted
            // Call method
            requestPermissions(new String[] {android.Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION }, 100);
        }
        // Return view
        return view;
    }

}