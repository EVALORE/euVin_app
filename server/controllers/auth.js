import {db} from "../db/connect.js"
import bcrypt from "bcryptjs"
//import jwt from "jsonwebtoken"

export const register=(req,res)=>{

    //check user exist 

    const q ="SELECT *  FROM organizer WHERE Name_organization = ?";

    db.query(q,[req.body.Name_organization],(err,data)=>{

      if(err) return res.status(500).json(err);
      if(data.length) return res.status(409).json("user already registered")
      
          //creat new  users;

          const q = "INSERT INTO organizer (`Name_organization`, `Name`, `Surname`, `Email_organization`, `Phone_number`, `IDNP_person`) VALUES (?)";

          const values = [
              req.body.Name_organization,
              req.body.Name,  
              req.body.Surname, 
              req.body.Email_organization,
              req.body.Phone_number,
              req.body.IDNP_person // Asigură-te că numele coloanei corespunde cu coloana din baza de date
          ];
          
          db.query(q, [values], (err, data) => {
              if (err) return res.status(500).json(err);
              return res.status(201).json("User successfully created");
          });
    });

}


export const login=(req,res)=>{

    const q = "SELECT * FROM users WHERE username = ?";

    db.query(q,[req.body.username],(err,data)=>{
        if(err) return res.status(500).json(err);  // eroare in caz ca nu este asa user 
        if(data.length === 0) return res.status(404).json("user not found");   // daca user este null la input return error
        const checkPassword =  bcrypt.compareSync(req.body.password , data[0].password);  //check passwor din db cu login
        if(!checkPassword) return res.status(400).json("Wrong Password");

        const token = jwt.sign({ id: data[0].id }, "secretkey"); // se creaza token// studieaza 

       const { password, ...others } = data[0]; // se fiseaza datele fara password 
       // sintaxa javascript 

       // se crezza un cookie 
    res.cookie("accessToken", token, {
        httpOnly: true,
      }).status(200).json(others);

    });

}

export const logout=(req,res)=>{
    //check user login 
    res.clearCookie("accessToken",{
        secure:true,
        sameSite:"none"
      }).status(200).json("User has been logged out.")
}