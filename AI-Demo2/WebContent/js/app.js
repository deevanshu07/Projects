/**
 * 
 */
var app = angular.module("solr", ["ngRoute"]);
app.config(function($routeProvider) {
    $routeProvider
    .when("/", {
        templateUrl : "index2.html"
    })
    .when("/content/:ID", {
        templateUrl : "content.html",
        controller : "ArticleViewController"
    });
});