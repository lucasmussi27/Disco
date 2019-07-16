const mongoose = require('mongoose')
const artSchema = new mongoose.Schema({
  name: { type: String, unique: true, required: true },
  genre: { type: String, required: true }
})
module.exports = mongoose.model('Artist', artSchema)
