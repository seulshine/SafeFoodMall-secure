import axios from "axios";
export default axios.create({
    baseURL : "http://localhost:8197/safefoodvue",
    headers:{
        "Content-type" : "application/json",
    }

}); 