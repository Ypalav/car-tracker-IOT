/**
 * Created by Yogesh on 6/25/2017.
 */
(function() {
    'use strict';

    angular.module('tracker')
        .service('readingService', readingService);

    readingService.$inject = ['$http', '$q', 'CONFIG'];

    function readingService($http, $q, CONFIG) {

        var self = this;

        self.getReadings = getReadings;

        function getReadings(id, filter) {
            return $http.get(CONFIG.API_HOST+'/readings/' + id +'?filter='+filter)
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