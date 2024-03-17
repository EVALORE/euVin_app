import { db } from "../db/connect.js"
//import jwt from "jsonwebtoken";

export const getUser = (req, res) => {
  const userId = req.params.userId;
  const q = "SELECT * FROM organizer WHERE id=?";

  db.query(q, [userId], (err, data) => {
    if (err) return res.status(500).json(err);
    //const { password, ...info } = data[0];
    return res.json(data[0]);
  });
};

export const getAllUser = (req, res) => {
    const q = "SELECT * FROM organizer";
  
    db.query(q,(err, data) => {
      if (err) return res.status(500).json(err);
      const { password, ...info } = data[0];
      return res.json(data);
    });
  };