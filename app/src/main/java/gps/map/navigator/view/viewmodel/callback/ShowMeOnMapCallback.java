package gps.map.navigator.view.viewmodel.callback;

import androidx.annotation.NonNull;

import gps.map.navigator.model.interfaces.IMapPlace;
import gps.map.navigator.view.interfaces.IPlaceListener;

public class ShowMeOnMapCallback implements IPlaceListener {
    @Override
    public void onPlaceLocated(@NonNull IMapPlace place) {

    }

    @Override
    public void onPlaceLocationFailed(@NonNull Exception reason) {

    }
}
