import {db} from "../db/connect.js"
import bcrypt from "bcryptjs"
//import jwt from "jsonwebtoken"

export const postEvents=(req,res)=>{

    //check user exist 

    const q ="SELECT *  FROM Event WHERE name = ?";

    db.query(q,[req.body.name],(err,data)=>{

      if(err) return res.status(500).json(err);
      if(data.length) return res.status(409).json("event already exist")
      

          const q = "INSERT INTO Event (`name`, `description`, `date`, `time_start`, `time_end`, `category`,`location`) VALUES (?)";

          const values = [
              req.body.name,
              req.body.description,  
              req.body.date, 
              req.body.time_start,
              req.body.time_end,
              req.body.category,
              req.body.location 
          ];
          
          db.query(q, [values], (err, data) => {
              if (err) return res.status(500).json(err);
              return res.status(201).json("Event successfully created");
          });
    });

}


export const getAllEvents = (req, res) => {
    const q = "SELECT * FROM Event";
  
    db.query(q,(err, data) => {
      if (err) return res.status(500).json(err);
      const { password, ...info } = data[0];
      return res.json(data);
    });
  };




  export const getEvent = (req, res) => {
    const eventId = req.params.eventId;
    const q = "SELECT * FROM Event WHERE id=?";
  
    db.query(q, [eventId], (err, data) => {
      if (err) return res.status(500).json(err);
      //const { password, ...info } = data[0];
      return res.json(data[0]);
    });
  };
  

