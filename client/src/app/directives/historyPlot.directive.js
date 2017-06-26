/**
 * Created by Yogesh on 6/26/2017.
 */
(function () {
    "use strict";

    angular.module('tracker')
        .directive('historyPlot', function () {
            return{
                template: '<div></div>',
                transclude: true,
                replace: true,
                scope: '=',
                controller: 'HistoryPlotController',
                controllerAs: 'historyVm',
                bindToController: true,
                link: function (scope, element, attrs) {
                    var opt = {
                        chart: {
                            renderTo: element[0],
                            type: 'line',
                            marginRight: 130,
                            marginBottom: 40
                        },
                        credits: {
                            enabled: false
                        },
                        title: {
                            text: attrs.title,
                            x: -20
                        },
                        subtitle: {
                            text: attrs.subtitle,
                            x: -20
                        },
                        xAxis: {
                            tickInterval: 1,
                            title: {
                                text: 'Date'
                            }
                        },
                        plotOptions: {
                            lineWidth: 0.5
                        },
                        yAxis: {
                            title: {
                                text: 'Reading'
                            },
                            tickInterval: (attrs.yinterval) ? new Number(attrs.yinterval) : null,
                            max: attrs.ymax,
                            min: attrs.ymin
                        },
                        tooltip: {
                            formatter: scope[attrs.formatter] || function () {
                                return '<b>' + this.y + '</b>'
                            }
                        },
                        legend: {
                            layout: 'vertical',
                            align: 'right',
                            verticalAlign: 'top',
                            x: -10,
                            y: 100,
                            borderWidth: 0
                        }
                    }
                }
            }
        })
})();