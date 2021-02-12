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

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        lstLatitudeLongitude.add(LatitudeLongitude(27.7061949, 85.3300394, "Hamro college"))
        lstLatitudeLongitude.add(LatitudeLongitude(27.704675, 85.329471, "Gopal dai ko chatamari"))

        for (location in lstLatitudeLongitude) {
            mMap.addMarker(
                MarkerOptions().position(LatLng(location.latitude, location.longitude))
                    .title(location.markerName)
            )
        }
        mMap.moveCamera(CameraUpdateFactory.newLatLng(LatLng(27.7061949, 85.3300394)))
        mMap.animateCamera(CameraUpdateFactory.zoomTo(15F))
        mMap.uiSettings.isZoomControlsEnabled = true
    }
}