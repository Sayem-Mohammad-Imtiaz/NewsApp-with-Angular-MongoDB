/**
 * Created by sayem on 2/14/2017.
 */
(function(angular) {

    var module=angular.module("newsApp");

    module.controller("newsController", function ($scope,newsService) {
        $scope.isNewsAdded=false;
        $scope.isNewsSaveFailed=false;

        $scope.addNews=function(news)
        {
            news.$save(function()
            {
                $scope.isNewsAdded=true;
            }, function(err)
            {
                $scope.isNewsSaveFailed=true;
            });
        }
    });

}(angular));