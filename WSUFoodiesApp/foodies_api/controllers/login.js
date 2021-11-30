const sql = require("../mysqlconnections.js");

// constructor
const  Login = function(login) {
    this.username = login.username;
    this.password = login.password;
  };

  Login.autenicate = (req, resp) => {
    let query = "SELECT id, email , `name`, active FROM customers";
    if(req.body.name != undefined){
     query += " where name = '"+req.body.name+"'";
    }
    sql.query(query, (err, res) => {
      if (err) {
        console.log("error: ", err);
        resp.json(err);
        return;
      }
  
      console.log("customers: ", res);
      resp.json(res);
    });
  };

  module.exports = Login;