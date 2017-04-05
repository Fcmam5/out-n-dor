var mongoose = require('mongoose');
var Schema   = mongoose.Schema;

var PlaceSchema = new Schema({	'name' : String,	'address' : String,	'urban_adr': String,	'type': { type: String, enum: ['sport', 'park', 'tourism', 'library']}, 	/* TODO: Add this */	'nature': { type: String, enum: ['free', 'paid', 'public']},						 /* TODO: Add this */	'city' : { type: String, default: ""}, 																	/* TODO: Add this */	'img': { type: String, default: ""},																	 /* TODO: Add this */	'description': String,	'latt': Number,	'long': Number,	'fb': String,	'instagram': String,	'website': String,	'tel': String,	'likes': {type: Number, default: 0}});

module.exports = mongoose.model('Place', PlaceSchema);
