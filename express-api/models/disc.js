const mongoose = require('mongoose')
const discSchema = new mongoose.Schema({
  title: { type: String, required: true },
  year: { type: Number, required: true },
  artist: { type: mongoose.Schema.Types.ObjectId, ref: 'Artist' }
})
module.exports = mongoose.model('Disc', discSchema)
