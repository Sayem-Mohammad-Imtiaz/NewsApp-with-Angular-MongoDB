/**
 * Created by sayem on 2/14/2017.
 */
(function(angular) {

    angular.module("newsApp.controllers", []);
    angular.module("newsApp.services", []);
    angular.module("newsApp", ["ngResource", "newsApp.controllers", "newsApp.services"]);

}(angular));