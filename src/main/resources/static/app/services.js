/**
 * Created by sayem on 2/14/2017.
 */
(function(angular) {
    var module=angular.module("newsApp");

    var newsService=module.factory("newsService", [ '$resource', function($resource)
    {
        return $resource('/news/:id', {id: '@id'}, {
            update: {
                method: 'PUT'
            }
        });
    }]);

   // angular.module("newsApp.services").controller("newsService", newsService);
}(angular));