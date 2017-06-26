/**
 * Created by Yogesh on 6/26/2017.
 */
(function () {
    'use strict';

    angular.module('tracker')
        .controller('HistoryPlotController', HistoryPlotController);

    HistoryPlotController.$inject = ['readingService', '$routeParams'];

    function HistoryPlotController(readingService, $routeParams) {
        var historyVm = this;
        historyVm.changeFilter = changeFilter;
        init();

        function init() {
            historyVm.filter = {"name": "last1d"};
            historyVm.showChart = false;
            historyVm.showError = false;
            readingService
                .getReadings($routeParams.id, historyVm.filter.name)
                .then(function (readings) {
                    var xData = [],
                        yData = [{"name": "Fuel Volume", "data": []},
                            {"name": "Speed", "data": []},
                            {"name": "Engine Horse Power", "data": []},
                            {"name": "Engine Rpm", "data": []},
                            {"name": "Is Engine Coolant Low", "data": []}];
                    setReadingsData(readings, xData, yData);
                }, function (error) {
                    console.log(error);
                });
        }

        function changeFilter(filter) {
            readingService
                .getReadings($routeParams.id, filter)
                .then(function (readings) {
                    var xData = [],
                        yData = [{"name": "Fuel Volume", "data": []},
                            {"name": "Speed", "data": []},
                            {"name": "Engine Horse Power", "data": []},
                            {"name": "Engine Rpm", "data": []},
                            {"name": "Is Engine Coolant Low", "data": []}];
                    setReadingsData(readings, xData, yData);
                }, function (error) {
                    console.log(error);
                });
        }

        function setReadingsData(readings, xData, yData) {
            angular.forEach(readings, function (reading) {
                xData.push(convertDate(reading.timestamp));
                yData[0].data.push(reading.fuelVolume);
                yData[1].data.push(reading.speed);
                yData[2].data.push(reading.engineHp);
                yData[3].data.push(reading.engineRpm);
                yData[3].data.push(reading.engineCoolantLow);
            });

            historyVm.lineChartYData = yData;
            historyVm.lineChartXData = xData;

            if (xData.length > 0) {
                historyVm.showChart = true;
                historyVm.showError = false;
            } else {
                historyVm.showChart = false;
                historyVm.showError = true;
            }
        }

        function convertDate(input) {
            var date = new Date(input);
            var hours = date.getHours();
            var minutes = "0" + date.getMinutes();
            var seconds = "0" + date.getSeconds();
            var day = date.getDate();
            var month = date.getMonth() + 1;
            var year = date.getUTCFullYear();
            return month + '/' + day + '/' + year + ' ' + hours + ':' + minutes.substr(-2) + ':' + seconds.substr(-2);
        }
    }
})();