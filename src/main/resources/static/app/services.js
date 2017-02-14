/**
 * Created by sayem on 2/14/2017.
 */
(function(angular) {
    var module=angular.module("newsApp");

    module.factory("newsService", function($resource)
    {
        return $resource('/rest/news/:id', {id: '@id'}, {
            update: {
                method: 'PUT'
            }
        });
    });
}(angular));