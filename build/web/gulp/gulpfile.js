var gulp = require('gulp');
var less = require('gulp-less');


gulp.task('default', function() {

	gulp.watch('../assets/styles/less/*.less',['less']);
	gulp.watch('../assets/styles/less/*/*.less',['less']);

});

gulp.task('less', function() {
	return gulp.src(['../assets/styles/less/landing.less',
	'../assets/styles/less/main.less',
	'../assets/styles/less/marketing.less',
	'../assets/styles/less/reservation.less',
	'../assets/styles/less/reception.less',
	'../assets/styles/less/tribago.less'
	])
		.pipe(less())
		.pipe(gulp.dest('../assets/styles/css'));
});
