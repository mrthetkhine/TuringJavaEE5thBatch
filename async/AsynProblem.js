const fs = require('fs');
console.log('Start');
fs.readFile('ReadSync.js','utf8',(err,data)=>{
  if(!err)
  {
    console.log('data completed >>'+data.toString());
  }
});
console.log('End');