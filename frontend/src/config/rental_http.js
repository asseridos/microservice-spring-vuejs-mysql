import axios from 'axios';

// import url from ''
let url
if (process.env.NODE_ENV === 'production') {
  url = process.env.RENT_API
} else {
  url = 'http://192.168.1.40:8081'
}

const http = axios.create({
  baseURL: `${url}`,
  headers: {
    'Accept': 'application/json',
    // 'Content-Type': 'application/json',
  }
})
export default http;
