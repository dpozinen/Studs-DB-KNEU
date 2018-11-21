<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
	<title>Students App</title>
	<head>
		<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.7.5/angular.min.js"></script>
		<style>
			form {
				margin: auto;
				width: 500;
			}
		</style>
			<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
			<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
			<!-- <link rel="stylesheet" href="app.css"> -->
			<!-- <link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link> -->
		<style>
			.firstName.ng-valid {
				background-color: lightgreen;
			}
			.firstName.ng-dirty.ng-invalid {
				background-color:lightcoral;
			}
			.lastName.ng-valid {
				background-color: lightgreen;
			}
			.lastName.ng-dirty.ng-invalid {
				background-color:lightcoral;
			}
			input[type=number]::-webkit-inner-spin-button,
			input[type=number]::-webkit-outer-spin-button {
				-webkit-appearance: none;
				margin: 0;
			}

		</style>
	</head>
	<body ng-app="App">
		<br>
		<div class="container" ng-controller="AppController as ctrl">
			<div class="card">
				<div class="card-header text-center"><h1>Студенти</h1></span> </div>
				<div class="card-body">
					<form ng-submit="ctrl.submit()" name="studentForm">
						<input type="hidden" ng-model="ctrl.student.id"/>
							<div class="input-group">
								<input type="text" ng-model="ctrl.student.firstName" id="fname" class="firstName form-control" placeholder="Введіть Ім'я" required>
							</div>
							<br>
							<div class="input-group">
								<input type="text" ng-model="ctrl.student.lastName" id="lname" class="lastName form-control" placeholder="Введіть Прізвище" required>
							</div>
							<br>
							<div class="input-group">
								<input type="text" ng-model="ctrl.student.faculty" id="faculty" class="firstName form-control" placeholder="Введіть Факультет" required>
							</div>
							<br>
							<div class="input-group">
								<input type="text" ng-model="ctrl.student.spec" id="spec" class="firstName form-control" placeholder="Введіть Спеціальнісь" required>
							</div>
							<br>
							<div class="input-group">
								<input type="number" ng-model="ctrl.student.studID" id="studID" class="firstName form-control" placeholder="Введіть Номер Залікової Книги" required>
							</div>
							<br>
							<div class="float-left">
								<button type="button" class="btn btn-danger" ng-click="ctr.reset()" ng-disabled="studentForm.$pristine">Стерти</button>
							</div>
							<div class="float-right">
								<input type="submit" value="Зберегти" class="btn btn-primary" ng-disabled="studentForm.$invalid">
							</div>
							<br>
					</form>
				</div>
			</div>

			<div class="card">
				<h2 class="card-title text-center">Студенти в базі даних:</h2>
				<div class="card-body">
					<table class="table table-hover">
						<thead>
							<tr>
								<th>ID</th>
								<th>Ім'я</th>
								<th>Прізвище</th>
								<th>Факультет</th>
								<th>Спеціальнісь</th>
								<th>Номер Залікової Книги</th>
								<th width="100">
							</tr>
						</thead>
						<tbody>
							<tr ng-repeat="student in ctrl.students">
								<td><span ng-bind="student.id"></span></td>
								<td><span ng-bind="student.firstName"></span></td>
								<td><span ng-bind="student.lastName"></span></td>
								<td><span ng-bind="student.faculty"></span></td>
								<td><span ng-bind="student.spec"></span></td>
								<td><span ng-bind="student.studID"></span></td>
								<td>
									<button type="button" class="btn btn-danger btn-sm" ng-click="ctrl.remove(student.studID)">Видалити</button>
								</td>
							</tr>
						</tbody>
					</table>
				</div>
				<div class="card-footer text-muted text-right">
					Підготував Позіненко Дарій
				</div>
			</div>
		</div>
		<script src="<c:url value='/static/js/app.js' />"></script>
		<script src="<c:url value='/static/js/service/StudentService.js' />"></script>
		<script src="<c:url value='/static/js/controller/StudentController.js' />"></script>
	</body>
</html>
