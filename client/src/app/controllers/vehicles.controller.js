/**
 * Created by Yogesh on 6/24/2017.
 */
(function(){
    'use strict';

    angular.module('tracker')
        .controller('VehiclesController', VehiclesController);

    VehiclesController.$inject = ['vehicleService'];

    function VehiclesController(vehicleService) {
        var vehiclesVm = this;
        vehiclesVm.changeSort = changeSort;

        init();

        function init(){
            console.log('VehiclesController');
            vehiclesVm.sorter = {
                by: 'make',
                reverse: false
            };

            vehicleService
                .getVehicles()
                .then(function(vehicles) {
                    vehiclesVm.vehicles = vehicles;
                }, function (error) {
                    console.log(error);
                });
        }

        function changeSort(prop) {
            vehiclesVm.sorter.by = prop;
            vehiclesVm.sorter.reverse = !vehiclesVm.sorter.reverse;
        }
    }

})();