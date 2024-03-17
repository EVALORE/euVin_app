import  express from "express";
const router = express.Router();
import { postEvents,getAllEvents,getEvent} from "../controllers/events.js";

router.get("/event:eventId",getEvent);
router.get("/get",getAllEvents);
router.post("/post",postEvents);


export default router;

