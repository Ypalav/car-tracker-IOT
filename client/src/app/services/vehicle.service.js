/**
 * Created by Yogesh on 6/24/2017.
 */
(function () {
    'use strict';

    angular.module('tracker')
        .service('vehicleService', vehicleService);

    vehicleService.$inject = ['$http', '$q', 'CONFIG'];

    function vehicleService($http, $q, CONFIG){
        var self = this;

        self.getVehicles = getVehicles;

        function getVehicles(){
            return $http.get(CONFIG.API_HOST + '/vehicles')
                .then(successFn, errorFn);
        }

        function successFn(response) {
            return response.data;
        }

        function errorFn(response) {
            return $q.reject('ERROR: ' + response.statusText);
        }

    }

})();