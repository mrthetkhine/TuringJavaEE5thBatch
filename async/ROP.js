Promise.reject(100)
        .then(data=>data+2,err=>{
            throw new Error(err*2)
        })
        .then(console.log, err=>console.log("Error==> ",err))