const express = require('express')
const bodyParser = require('body-parser')
const cors = require('cors')
const mongoose = require('mongoose')
const port = process.env.PORT || 4000
const api = express()

mongoose.Promise = global.Promise
const uri = 'mongodb://localhost/disco-api'
mongoose.connect(uri, { useNewUrlParser: true })
  .then(() => console.log('Connected to MongoDB'))
  .catch(err => console.log('Error during connect to MongoDB'))

api.use(bodyParser.urlencoded({ extended: true }))
api.use(bodyParser.json())
api.use(cors())

api.get('/', async(req,res) => res.send('Disco API is working'))

api.use('/artists', require('./routes/artist.router'))

api.listen(port, () => console.log(`Listening requests on port ${port}`))
