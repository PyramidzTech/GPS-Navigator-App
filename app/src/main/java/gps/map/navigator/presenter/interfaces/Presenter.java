package gps.map.navigator.presenter.interfaces;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import gps.map.navigator.model.interfaces.IMapPlace;
import gps.map.navigator.model.interfaces.IRoute;
import gps.map.navigator.view.interfaces.IPlaceHistoryListener;
import gps.map.navigator.view.interfaces.IPlaceListener;
import gps.map.navigator.view.interfaces.IPlaceShowListener;
import gps.map.navigator.view.interfaces.IRouteListener;
import gps.map.navigator.view.interfaces.IRouteReadyListener;

public interface Presenter {
    /**
     * Show point on map with own location.
     *
     * @param placeListener - listener.
     */
    void showMeOnMap(@Nullable IPlaceListener placeListener);

    /**
     * Show/hide traffic on map.
     *
     * @param enable - true/false to show/hide.
     */
    void enableTraffic(boolean enable);

    /**
     * Show/hide night map.
     *
     * @param enable - true/false to show/hide.
     */
    void enableNightMode(boolean enable);

    /**
     * Show/hide satellite map.
     *
     * @param enable - true/false to show/hide.
     */
    void enableSatelliteMode(boolean enable);

    /**
     * Get traffic map state.
     *
     * @return true if enabled, false otherwise.
     */
    boolean hasTrafficMode();

    /**
     * Get night map state.
     *
     * @return true if enabled, false otherwise.
     */
    boolean hasNightMode();

    /**
     * Get satellite map state.
     *
     * @return true if enabled, false otherwise.
     */
    boolean hasSatelliteMode();

    /**
     * Open initial map view.
     */
    void showMap();

    /**
     * Show place on map.
     *
     * @param place             - place to be shown.
     * @param placeShowListener - listener to get callback.
     */
    void showPlace(@NonNull IMapPlace place, @Nullable IPlaceShowListener placeShowListener);

    /**
     * Show route on map.
     *
     * @param route              - place to be shown.
     * @param routeReadyListener - listener to get callback.
     */
    void showRoute(@NonNull IRoute route, @Nullable IRouteReadyListener routeReadyListener);

    /**
     * Find place on map.
     *
     * @param query         - query to search.
     * @param placeListener - listener to get callback.
     */
    void findPlace(@NonNull String query, @Nullable IPlaceListener placeListener);

    /**
     * Navigate route.
     *
     * @param route         - route to navigate.
     * @param routeListener - listener to get callback.
     */
    void navigate(@NonNull IRoute route, @Nullable IRouteListener routeListener);

    /**
     * Build route.
     *
     * @param placeHistoryListener - listener to get callback about history places.
     */
    void buildRoute(@Nullable IPlaceHistoryListener placeHistoryListener);
}
