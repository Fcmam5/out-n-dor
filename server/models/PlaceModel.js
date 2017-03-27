var mongoose = require('mongoose');
var Schema   = mongoose.Schema;

var PlaceSchema = new Schema({	'name' : String,	'address' : String,	'urban_adr': String,	'latt': Number,	'long': Number,	'nature': {		type: String,		enum: ['free', 'paid', 'public']	},	'description': String,	'fb': String,	'instagram': String,	'website': String,	'tel': String,	'likes': {type: Number, default: 0}});

module.exports = mongoose.model('Place', PlaceSchema);
