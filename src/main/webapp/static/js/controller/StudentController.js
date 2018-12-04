'use strict'

angular.module('App').controller('StudentController', ['StudentService', '$scope', function(StudentService, $scope) {
	var self = this;
	self.students = [];
	self.student = {id:null, firstName:'', lastName:'', faculty:'', avgGrade:'', cardID:''};

	self.reset = reset;
	self.remove = remove;
	self.submit = submit;

	$scope.sortType = 'avgGrade';
	$scope.sortReverse = false;

	getAllStudents();

	function getAllStudents() {
		StudentService.getAllStudents().then(
			function(students) {
				self.students = students;
			},
			function(errResponse) {
				console.error('Couldn\'t get all Students');
			}
		);
	}

	function addStudent(student) {
		StudentService.addStudent(student).then(
			getAllStudents,
			function(errResponse) {
				console.error('Couldn\'t add student', student);
			}
		);
	}

	function deleteStudent(id) {
		StudentService.deleteStudent(id).then(
			getAllStudents,
			function() {
				console.error('Couldn\'t delete student', student);
			}
		);
	}

	function reset() {
		self.student = {id:null, firstName:'', lastName:'', faculty:'', avgGrade:'', cardID:''};
		$scope.studentForm.$setPristine();
	}

	function submit() {
		console.log('Saving New student', self.student);
		addStudent(self.student);
		reset();
	}

	function remove(id) {
		deleteStudent(id);
	}

}]);