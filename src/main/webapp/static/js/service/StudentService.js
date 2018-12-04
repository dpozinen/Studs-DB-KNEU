'use strict'

angular.module('App').factory('StudentService', ['$http', '$q', function($http, $q) {
	var URL = 'https://dpozinenapp.azurewebsites.net/Studs/student/';

	var factory = {
		getAllStudents:getAllStudents,
		addStudent:addStudent,
		deleteStudent:deleteStudent,
		deleteAllStudents:deleteAllStudents
	};

	return factory;

	function getAllStudents() {
		var deffered = $q.defer();
		$http.get(URL).then(
			function(response) {
				deffered.resolve(response.data);
			},
			function(errResponse) {
				console.error('Couldn\'t get All Students');
				deffered.reject(errResponse);
			}
		);
		return deffered.promise;
	}

	function addStudent(student) {
		var deffered = $q.defer();
		$http.post(URL, student).then(
			function(response) {
				deffered.resolve(response.data);
			},
			function(errResponse) {
				console.error('Couldn\'t add student');
				deffered.reject(errResponse);
			}
		);
		return deffered.promise;
	}

	function deleteStudent(id) {
		var deffered = $q.defer();
		$http.delete(URL + id).then(
			function(response) {
				deffered.resolve(response.data);
			},
			function(errResponse) {
				console.error('Couldn\'t delete student');
				deffered.reject(errResponse);
			}
		);
		return deffered.promise;
	}

	function deleteAllStudents() {
		var deffered =  $q.defer();
		$http.delete(URL).then(
			function(response) {
				deffered.resolve(response.data);
			},
			function(errResponse) {
				console.error('Couldn\'t delete all students');
				deffered.reject(errResponse);
			}
		);
		return deffered.promise;
	}

}]);