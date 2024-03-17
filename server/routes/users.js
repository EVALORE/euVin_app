import  express from "express";
const router = express.Router();
import { getUser,getAllUser } from "../controllers/users.js";

router.get("/user:userId",getUser);
router.get("/get",getAllUser);


export default router;


