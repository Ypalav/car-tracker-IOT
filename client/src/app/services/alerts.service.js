/**
 * Created by Yogesh on 6/25/2017.
 */
(function() {
    'use strict';

    angular.module('tracker')
        .service('alertsService', alertsService);

    alertsService.$inject = ['$http', '$q', 'CONFIG'];

    function alertsService($http, $q, CONFIG) {

        var self = this;

        self.getAlertsById = getAlertsById;

        function getAlertsById(id) {
            return $http.get(CONFIG.API_HOST + '/alerts/' + id)
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