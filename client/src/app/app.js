/**
 * Created by Yogesh on 6/22/2017.
 */
(function () {
    'use strict';

    angular
        .module('tracker', ['ngRoute', 'uiGmapgoogle-maps'])
        .config(moduleConfig);

    function moduleConfig($routeProvider){
        $routeProvider
            .when('/vehicles',{
                templateUrl: 'app/views/vehicles.tmpl.html',
                controller: 'VehiclesController',
                controllerAs: 'vehiclesVm'
            })
            .when('/alerts/:id', {
                templateUrl: '/app/views/alerts.tmpl.html',
                controller: 'AlertsController',
                controllerAs: 'alertsVm'
            })
            .when('location/:id', {
                templateUrl: '/app/views/location.tmpl.html',
                controller: 'LocationController',
                controllerAs: 'locationVm'
            })
            .when('/plot/:id', {
                templateUrl: '/app/views/historyPlot.tmpl.html',
                controller: 'HistoryPlotController',
                controllerAs: 'historyVm'
            })
            .otherwise({
               redirectTo:'/vehicles'
            });
    }
})();