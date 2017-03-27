var express = require('express');
var path = require('path');
var favicon = require('serve-favicon');
var logger = require('morgan');
var cookieParser = require('cookie-parser');
var bodyParser = require('body-parser');

var loadEnv = require('dotenv').config;

var index = require('./routes/index');
var Place = require('./routes/PlaceRoutes');

var mongoose = require('mongoose');
var dbHost = process.env.DB_HOST || 'mongodb://localhost/out-n-dor'; // use given DB or create new one on you localhost
var app = express();

if (loadEnv().error)
  {console.error("error loading env");}

// Connect to db:
mongoose.Promise = global.Promise; // For hiding the "deprecated" warning
mongoose.connect(dbHost, function(err, next) {
  if (err) {
    console.error('Faild to load DB');
  } else {
    console.log(dbHost);
    console.log('Your awesome Database is connected');
  }
});
// view engine setup
app.set('views', path.join(__dirname, 'views'));
app.set('view engine', 'ejs');

// uncomment after placing your favicon in /public
//app.use(favicon(path.join(__dirname, 'public', 'favicon.ico')));
app.use(logger('dev'));
app.use(bodyParser.json());
app.use(bodyParser.urlencoded({ extended: false }));
app.use(cookieParser());
app.use(require('node-sass-middleware')({
  src: path.join(__dirname, 'public'),
  dest: path.join(__dirname, 'public'),
  indentedSyntax: true,
  sourceMap: true
}));
app.use(express.static(path.join(__dirname, 'public')));

app.use('/', index);
app.use('/api/v1/', Place);

// catch 404 and forward to error handler
app.use(function(req, res, next) {
  var err = new Error('Not Found');
  err.status = 404;
  next(err);
});

// error handler
app.use(function(err, req, res, next) {
  // set locals, only providing error in development
  res.locals.message = err.message;
  res.locals.error = req.app.get('env') === 'development' ? err : {};

  // render the error page
  res.status(err.status || 500);
  res.render('error');
});

module.exports = app;
