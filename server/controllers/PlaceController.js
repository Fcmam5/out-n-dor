var PlaceModel = require('../models/PlaceModel.js');

/**
 * PlaceController.js
 *
 * @description :: Server-side logic for managing Places.
 */
module.exports = {

    /**
     * PlaceController.list()
     */
    list: function (req, res) {
        PlaceModel.find(function (err, Places) {
            if (err) {
                return res.status(500).json({
                    message: 'Error when getting Place.',
                    error: err
                });
            }
            return res.json({
              "results": Places
            });
        });
    },

    getByType: function(req, res) {
      var type = req.params.type;
      PlaceModel.find({'type': type}, function(err, Places){
        if (err || !Places) {
          return res.status(404).json("No Places found !");
        }
        return res.json({
          "results": Places
        });
      })
    },

    getRandom: function(req, res) {
      PlaceModel.count().exec(function(err, count){
        var random = Math.floor(Math.random() * count);
        PlaceModel.findOne().skip(random).exec(function (err, Place) {

          if (err || !Place) {
            return res.status(404).json("No Places found !");
          }
          return res.json({
            "results": [Place]
          });

      });

      });
    },

    /**
     * PlaceController.show()
     */
    show: function (req, res) {
        var id = req.params.id;
        PlaceModel.findOne({_id: id}, function (err, Place) {
            if (err) {
                return res.status(500).json({
                    message: 'Error when getting Place.',
                    error: err
                });
            }
            if (!Place) {
                return res.status(404).json({
                    message: 'No such Place'
                });
            }
            return res.json(Place);
        });
    },

    /**
     * PlaceController.create()
     */
    create: function (req, res) {
        var Place = new PlaceModel({
			name : req.body.name,
			address : req.body.address,
      urban_adr: req.body.urban_adr,
      type: req.body.type,
      nature: req.body.nature,
      img: req.body.img,
      city: req.body.city,
      latt : req.body.latt,
      long : req.body.long,
      description : req.body.description,
      fb : req.body.fb,
      instagram : req.body.instagram,
      website : req.body.website,
      tel: req.body.tel
        });

        Place.save(function (err, Place) {
            if (err && !Place) {
                return res.status(500).json({
                    message: 'Error when creating Place',
                    error: err
                });
            }
            console.log(Place);
            return res.status(201).json(Place);
        });

     },

    /**
     * PlaceController.update()
     */
    update: function (req, res) {
        var id = req.params.id;
        PlaceModel.findOne({_id: id}, function (err, Place) {
            if (err) {
                return res.status(500).json({
                    message: 'Error when getting Place',
                    error: err
                });
            }
            if (!Place) {
                return res.status(404).json({
                    message: 'No such Place'
                });
            }

              //TODO fix this
            Place.name = req.body.name ? req.body.name : Place.name;
			Place.address = req.body.address ? req.body.address : Place.address;
      Place.urban_adr= req.body.urban_adr ? req.body.urban_adr: Place.urban_adr
      Place.latt = req.body.latt ? req.body.latt : Place.latt ;
      Place.long = req.body.long ? req.body.long : Place.long;
      Place.nature = req.body.nature ? req.body.nature : Place.nature;
      Place.sum = req.body.price ? req.body.sum : Place.sum;
      Place.period = req.body.period ? req.body.period : Place.period;
      Place.fb = req.body.fb ? req.body.fb : Place.fb;
      Place.instagram = req.body.instagram ? req.body.instagram : Place.instagram;
      Place.website = req.body.website ? req.body.website : Place.website;
      Place.tel = req.body.tel ? req.body.tel : Place.tel;
      Place.likes = req.body.likes ? req.body.likes : Place.likes;

            Place.save(function (err, Place) {
                if (err) {
                    return res.status(500).json({
                        message: 'Error when updating Place.',
                        error: err
                    });
                }
                console.log(Place);
                return res.json(Place);
            });
        });
    },

    /**
     * PlaceController.remove()
     */
    remove: function (req, res) {
        var id = req.params.id;
        PlaceModel.findByIdAndRemove(id, function (err, Place) {
            if (err) {
                return res.status(500).json({
                    message: 'Error when deleting the Place.',
                    error: err
                });
            }
            return res.status(204).json();
        });
    }
};
