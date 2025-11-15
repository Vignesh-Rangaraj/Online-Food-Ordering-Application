import axios from "axios";

const getBaseUrl = () => {
  const origin = window.location.origin;
  if (origin.includes("localhost")) return "http://localhost:8080";
  return origin.replace("8081", "8080");
};

export default axios.create({ baseURL: getBaseUrl() });
