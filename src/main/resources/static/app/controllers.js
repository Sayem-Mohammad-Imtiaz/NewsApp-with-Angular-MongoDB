/**
 * Created by sayem on 2/14/2017.
 */
(function (angular) {

    var module = angular.module("newsApp");

    var newsController = module.controller("newsController", function ($scope,$log, newsService) {
        $scope.isNewsAdded = false;
        $scope.isNewsSaveFailed = false;
        $scope.newsList=[];

        $scope.addNews = function (news) {
            new newsService(news).$save(function () {
                $scope.isNewsAdded = true;
            }, function (err) {
                $scope.isNewsSaveFailed = true;
            });
        }

        $scope.query=function()
        {
            $log.log("Query called");
            newsService.query(function(response) {
                $scope.newsList = response ? response : [];
            });
        }
    });

   // newsController.$inject = ['$scope', 'newsService'];
    //angular.module("newsApp.controllers").controller("newsController", newsController);
}(angular));