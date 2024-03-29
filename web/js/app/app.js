(function () {
    'use strict';

    angular
        .module('app', ['ngRoute', 'ngCookies'])
        .config(config)
        .run(run);

    config.$inject = ['$routeProvider', '$locationProvider'];
    function config($routeProvider, $locationProvider) {
        $routeProvider
            .when('/', {
                controller: 'HomeController',
                templateUrl: 'views/dashboard.html',
                controllerAs: 'vm'
            })

            .when('/login', {
                controller: 'LoginController',
                templateUrl: 'views/login.html',
                controllerAs: 'vm'
            })

            .when('/register', {
                controller: 'RegisterController',
                templateUrl: 'views/register.html',
                controllerAs: 'vm'
            })
            .when('/users', {
                controller: 'UserController',
                templateUrl: 'views/users.html',
                controllerAs: 'vm'
            })
            .when('/project', {
                controller: 'ProjectController',
                templateUrl: 'views/project.html',
                controllerAs: 'vm'
            })
            .when('/issue', {
                controller: 'addempController',
                templateUrl: 'views/issue.html',
                controllerAs: 'vm'
            })
            .when('/eidtemp', {
                controller: 'addempController',
                templateUrl: 'views/editemp.html',
                controllerAs: 'vm'
            })
            .when('/attendance', {
                controller: 'addempController',
                templateUrl: 'views/attendance.html',
                controllerAs: 'vm'
            })
             .when('/attendanceLIst', {
                controller: 'addempController',
                templateUrl: 'views/attendanceLIst.html',
                controllerAs: 'vm'
            })
             .when('/contact', {
                controller: 'addempController',
                templateUrl: 'views/contact.html',
                controllerAs: 'vm'
            })

            .otherwise({ redirectTo: '/login' });
    }

    run.$inject = ['$rootScope', '$location', '$cookies', '$http'];
    function run($rootScope, $location, $cookies, $http) {
        // keep user logged in after page refresh
        $rootScope.globals = $cookies.getObject('globals') || {};
        if ($rootScope.globals.currentUser) {
            $http.defaults.headers.common['Authorization'] = 'Basic ' + $rootScope.globals.currentUser.authdata;
        }

        $rootScope.$on('$locationChangeStart', function (event, next, current) {
            // redirect to login page if not logged in and trying to access a restricted page
            var restrictedPage = $.inArray($location.path(), ['/login', '/register']) === -1;
            var loggedIn = $rootScope.globals.currentUser;
            if (restrictedPage && !loggedIn) {
                $location.path('/login');
            }
        });
    }

})();