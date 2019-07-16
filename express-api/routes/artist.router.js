const express = require('express')
const router = express.Router()
const Artist = require('../models/artist')

router.get('/', async(req,res) => {
  await Artist.find().then(arts => {
    if(arts)  res.json(arts)
    else      res.json({})
  }).catch(err => {
    res.status(400).send('Error during finding all artists')
    console.log(err)
  })
})

module.exports = router
