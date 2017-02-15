/**
 * Created by sayem on 2/14/2017.
 */
(function (angular) {

    var module = angular.module("newsApp");

    var newsController = module.controller("newsController", function ($scope, newsService) {
        $scope.service = new newsService;
        $scope.isNewsAdded = false;
        $scope.isNewsSaveFailed = false;

        $scope.addNews = function (news) {
            $scope.service.$save(news, function () {
                $scope.isNewsAdded = true;
            }, function (err) {
                $scope.isNewsSaveFailed = true;
            });
        }
    });

   // newsController.$inject = ['$scope', 'newsService'];
    //angular.module("newsApp.controllers").controller("newsController", newsController);
}(angular));