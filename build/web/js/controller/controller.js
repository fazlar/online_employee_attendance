'use strict';
var app = angular.module('app');

app.controller('HomeController', function ($scope, $location, $http, $rootScope, LoginService) {
    $rootScope.logout = function () {
        LoginService.ClearCredentials();
        $location.path('/login');
    };

});

app.controller('UserController', function ($scope, $location, $http, $rootScope, LoginService, UserService) {

    $scope.usersList = [];
    $scope.user = {};
    getAllUsers(UserService, $scope);
    $scope.userEdit = function (user) {

        UserService.GetById(user.id)
                .then(function (res) {
                    if (res.status == '200') {
                        console.log(res);
                        $scope.user = res.data;
                    }
                }).catch(function (err) {
            console.log(err);
        });
    };

});

app.controller('ProjectController', function ($scope, $location, $http, $rootScope, LoginService) {

    $scope.createProject = function () {
        $http.post('/api/projects/save', JSON.stringify(this.project))
                .then(function (res) {
                    console.log(res);
                }).catch(function (err) {
            console.log(err);
        });
    };

});

app.controller('IssueController', function ($scope, $location, $http, $rootScope, LoginService) {
    $scope.users = [];
    $scope.projects = [];
    getInitUsers();
    getInitProjects();

    function getInitUsers() {

        $http.get('/api/users/showAll')
                .then(function (res) {
                    $scope.users = res.data;
                }).catch(function (err) {
            console.log(err);
        });
    }
    ;

    function getInitProjects() {

        $http.get('/api/projects/showAll')
                .then(function (res) {
                    $scope.projects = res.data;
                }).catch(function (err) {
            console.log(err);
        });
    }
    ;

    $scope.createIssue = function () {
        console.log(this.issue);
    };

});

function getAllUsers(UserService, $scope) {
    UserService.GetAll()
            .then(function (res) {
                if (res.status == '200') {
                    console.log(res.data);
                    $scope.usersList = res.data;
                }
            }).catch(function (err) {
        console.log(err);
    });
}
app.controller('addempController', function ($scope, $http) {
    showAll();
    showattendance();
    $scope.addemp = function () {
         alert();
        var data = {
            name: this.employee.name,
            email: this.employee.email,
            identifiedDate: this.employee.date,
            jobTitel: this.employee.jobtitel,
            address: this.employee.address,
            salary: this.employee.salary

        };


        console.log(data);
        $http.post('/save', JSON.stringify(data)).then(function (res) {
            console.log(res);
             
              if (res.status == '200') {
                        showAll();
                        data = null;

                        //show message
                        Swal.fire({
                            position: 'center',
                            type: 'success',
                            title: 'add success',
                            showConfirmButton: false,
                            timer: 1500
                        });
                    } else {
                        Swal.fire({
                            position: 'center',
                            type: 'error',
                            title: 'Update failed',
                            showConfirmButton: false,
                            timer: 1500
                        });
                    }
        }).catch(function (err) {
        });
       
    };
    //eidt
    $scope.edit = function (v) {
        
        $scope.employee  = {
            id: v.issueId,
            name: v.name,
            email: v.email,
            date:v.identifiedDate,
            jobtitel: v.jobTitel,
            address: v.address,
            salary:v.salary
        };

    };
    
    $scope.updateEmp = function () {
        alert();
        var THIS = this;
        var employee = {
            issueId: THIS.employee.id,
            name: THIS.employee.name,
            email: THIS.employee.email,
            identifiedDate: THIS.employee.date,
            jobTitel: THIS.employee.jobtitel,
            address: THIS.employee.address,
            salary: THIS.employee.salary
        };
        $http.post('/update', JSON.stringify(employee))
                .then(function (res) {
                    if (res.status == '200') {
                        showAll();
                        $scope.employee = null;

                        //show message
                        Swal.fire({
                            position: 'center',
                            type: 'success',
                            title: 'Update success',
                            showConfirmButton: false,
                            timer: 1500
                        });
                    } else {
                        Swal.fire({
                            position: 'center',
                            type: 'error',
                            title: 'Update failed',
                            showConfirmButton: false,
                            timer: 1500
                        });
                    }


                }).catch(function (err) {
            console.log(err);
        });
    };
    //delet
     $scope.delete = function (data, index) {
        var THIS = this;
        alert();
        $http.get("/delete/" + data.issueId)
                .then(function (res) {
                    if (res.status == '200') {
                        THIS.data.splice(index, 1);
                        Swal.fire({
                            position: 'center',
                            type: 'success',
                            title: 'Delete success',
                            showConfirmButton: false,
                            timer: 1500
                        });
                    }else{
                        Swal.fire({
                            position: 'center',
                            type: 'error',
                            title: 'Delete success',
                            showConfirmButton: false,
                            timer: 1500
                        });
                    }
                }).catch(function (err) {
            console.log(err);
        });
    };
    function showAll() {

        $http.get('/showemp')
                .then(function (res) {
                    console.log(res);
                    if (res.status == '200') {
                        $scope.data = res.data;
                    }
                }).catch(function (err) {
            console.log(err);
        });
    }
    //saveattendance
    $scope.saveatten = function () {
        var atten = {
            name: this.attend.name,
            date: this.attend.date,
            comment: this.attend.comment,
            status: this.attend.status
        };

        $http.post('/saveatt', JSON.stringify(atten)).then(function (res) {
            console.log(res);
            if (res.status == '200') {
                        
                       

                        //show message
                        Swal.fire({
                            position: 'center',
                            type: 'success',
                            title: 'ATTENDANCE COMPLETE',
                            showConfirmButton: false,
                            timer: 1500
                        });
                    } else {
                        Swal.fire({
                            position: 'center',
                            type: 'error',
                            title: 'Update failed',
                            showConfirmButton: false,
                            timer: 1500
                        });
                    }
        }).catch(function (err) {
        });
    };
    function showattendance() {

        $http.get('/showatt')
                .then(function (res) {
                    console.log(res);
                    if (res.status == '200') {
                        $scope.atten = res.data;
                    }
                }).catch(function (err) {
            console.log(err);
        });
    }


});
app.controller('attendanceCtrl', function ($scope, $http) {
    showAll();
    $scope.data = {
        name: '',
        email: '',
        identifiedDate: '',
        jobTitel: ''

    };
    function showAll() {

        $http.get('/showemp')
                .then(function (res) {
                    console.log(res);
                    if (res.status == '200') {
                        $scope.data = res.data;
                    }
                }).catch(function (err) {
            console.log(err);
        });
    }
    $scope.addemp = function () {


    }

});