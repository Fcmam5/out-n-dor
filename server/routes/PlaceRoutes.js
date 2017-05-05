var express = require('express');
var router = express.Router();
var PlaceController = require('../controllers/PlaceController.js');

/*
 * GET
 */
router.get('/', PlaceController.list);

/*
 * GET places by type
 */
router.get('/places/:type', PlaceController.getByType);

/*
 * GET
 */
router.get('/:id', PlaceController.show);

/*
 * POST
 */
router.post('/', PlaceController.create);

/*
 * PUT
 */
router.put('/:id', PlaceController.update);

/*
 * DELETE
 */
router.delete('/:id', PlaceController.remove);

module.exports = router;
