package gps.map.navigator.presenter.impl.listener;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

import gps.map.navigator.model.interfaces.IMapPlace;
import gps.map.navigator.presenter.interfaces.Presenter;
import gps.map.navigator.view.interfaces.IPlaceListener;

public class FindPlaceListener implements IPlaceListener {
    @Nullable
    private Presenter cache;
    @Nullable
    private IPlaceListener listener;

    public FindPlaceListener(@Nullable Presenter cache, @Nullable IPlaceListener listener) {
        this.cache = cache;
        this.listener = listener;
    }

    @Override
    public void onPlaceLocated(@NonNull IMapPlace place) {
        if (cache != null) {
            cache.setLastPlace(place);
        }
        if (listener != null) {
            listener.onPlaceLocated(place);
        }
        invalidate();
    }

    @Override
    public void onPlacesLocated(List<IMapPlace> place) {
        if (listener != null) {
            listener.onPlacesLocated(place);
        }
        invalidate();
    }

    @Override
    public void onPlaceLocationFailed(@NonNull Exception reason) {
        if (listener != null) {
            listener.onPlaceLocationFailed(reason);
        }
        invalidate();
    }

    private void invalidate() {
        cache = null;
        listener = null;
    }
}
