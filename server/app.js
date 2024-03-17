import express from "express";
import path from "path";
import cors from "cors";
import userRoutes from "./routes/users.js";
import authRoutes from "./routes/auth.js";
import eventRoutes from "./routes/events.js";
import cookieParser from "cookie-parser";
import { fileURLToPath } from "url";
// import likeRoutes from "./routes/likes.js";
//import postRoutes from "./routes/posts.js";
const app = express();

const __filename = fileURLToPath(import.meta.url);
const __dirname = path.dirname(__filename);

app.set("views", path.join(__dirname, "views"));
app.set("view engine", "ejs");

app.use(express.json());
app.use(express.urlencoded({ extended: false }));
app.use(cookieParser());

//app.use(express.static(path.join(__dirname, "public")));
app.use(express.static("public"));

app.use(express.json());
app.use(cors());
app.use(cookieParser());

app.use("/api/users/", userRoutes);
// app.use("/api/posts/",postRoutes);
// app.use("/api/likes/",likeRoutes);
app.use("/api/auth/", authRoutes);
app.use("/api/events/", eventRoutes);

app.get("/", (req, res) => {
  res.send("welcome");
});

app.get("/index", (req, res) => {
  res.render("index");
});

app.get("/event", (req, res) => {
  res.render("events");
});

app.get("/organizer", (req, res) => {
  res.render("organizator");
});

app.get("/login", (req, res) => {
  res.render("login");
});

app.get("/register", (req, res) => {
  res.render("register");
});

app.listen(8000, () => {
  console.log("Work");
});

// const express = require('express');
// let path = require("path");
// let createError = require("http-errors");
// let cookieParser = require("cookie-parser");
// let authRoutes = require("./routes/auth.js");
// const port = 3000;
// let indexRouter = require("./routes/index");
// const app = express();

// // view engine setup
// app.set("views", path.join(__dirname, "views"));
// app.set("view engine", "ejs");

// app.use(express.json());
// app.use(express.urlencoded({ extended: false }));
// app.use(cookieParser());
// app.use(express.static(path.join(__dirname, "public")));

// app.use("/api/auth/",authRoutes);

// app.use("/", indexRouter);

// app.listen(port, () => {
//   console.log(`Serverul ascultă la http://localhost:${port}`);
// });
