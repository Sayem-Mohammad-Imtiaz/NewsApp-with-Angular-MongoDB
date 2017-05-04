/**
 * Created by sayem on 2/14/2017.
 */
(function(angular) {

    angular.module("newsApp.controllers", []);
    angular.module("newsApp.services", []);
    var module=angular.module("newsApp", ["ngResource", 'ngRoute', "newsApp.controllers", "newsApp.services"]);

    module.config(function ($routeProvider,$locationProvider) {
        $routeProvider.when('/',{
            templateUrl: 'templates/pages/view_story.html',
            controller: 'newsController'
        })
        .when('/addStory', {
            templateUrl : 'templates/pages/add_story.html',
            controller  : 'newsController'
        });
        $locationProvider.html5Mode(true);
    });

}(angular));