import mysql from "mysql2"

export const db = mysql.createConnection({
    host:"localhost",
    user:"root",
    password:"armando@",
    database:"Empatia",
    insecureAuth : true
});