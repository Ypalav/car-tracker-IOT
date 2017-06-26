/**
 * Created by Yogesh on 6/25/2017.
 */
(function () {
    "use strict";
    angular.module("tracker")
        .controller("LocationController", LocationController);

    LocationController.$inject = ['readingService', '$routeParams'];

    function LocationController(readingService, $routeParams) {
        var locationVm = this;
        init();

        function init() {
            locationVm.map = {
                center: {
                    latitude: 41.8460142,
                    longitude:-87.6482463
                },
                zoom: 11,
                markers: []
            };

            readingService
                .getReadings($routeParams.id, 'last30min')
                .then(function (readings) {

                    var xData = [];
                    angular.forEach(readings, function (reading, key) {
                        xData.push({
                            coords: {
                                latitude: reading.latitude,
                                longitude: reading.longitude
                            },
                            id: key,
                            icon: 'https://maps.google.com/mapfiles/ms/icons/green-dot.png'
                        });
                    });
                    if (xData.length > 0) {
                        locationVm.showMap = true;
                        locationVm.showError = false;
                    } else {
                        locationVm.showMap = false;
                        locationVm.showError = true;
                    }
                    locationVm.map.markers = xData;
                }, function (error) {
                    console.log(error);
                });
        }

    }
})();