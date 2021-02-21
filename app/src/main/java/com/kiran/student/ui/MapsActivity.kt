package com.kiran.student.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.gms.maps.*
import com.google.android.gms.maps.model.BitmapDescriptorFactory

import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.kiran.student.R
import com.kiran.student.model.LatitudeLongitude

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private var lstLatitudeLongitude = ArrayList<LatitudeLongitude>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    // Load single locations

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        mMap.addMarker(
            MarkerOptions().position(LatLng(27.7061949, 85.3300394))
                .title("Hamro College")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_CYAN))
        )

        mMap.animateCamera(
            CameraUpdateFactory.newLatLngZoom(LatLng(27.7061949, 85.3300394), 17F), 5000, null
        )
        mMap.uiSettings.isZoomControlsEnabled = true
    }



    // Load multiple locations
//    override fun onMapReady(googleMap: GoogleMap) {
//        mMap = googleMap
//        lstLatitudeLongitude.add(LatitudeLongitude(27.7061949, 85.3300394, "Hamro college"))
//        lstLatitudeLongitude.add(LatitudeLongitude(27.704675, 85.329471, "Gopal dai ko chatamari"))
//
//        for (location in lstLatitudeLongitude) {
//            mMap.addMarker(
//                MarkerOptions().position(LatLng(location.latitude, location.longitude))
//                    .title(location.markerName)
//                    .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN))
//            )
//        }
////        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(LatLng(27.704675, 85.329471),15F))
////        mMap.animateCamera(CameraUpdateFactory.zoomTo(15F),5000,null);
//
//
//        mMap.animateCamera(
//            CameraUpdateFactory.newLatLngZoom(LatLng(27.7061949, 85.3300394),16F), 4000, null
//
//        )
//        mMap.uiSettings.isZoomControlsEnabled = true
//    }
}